/*===============================================================================
Copyright (c) 2019 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.vuforia.engine.Books.app.Books;

import android.content.res.Configuration;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import com.vuforia.Matrix34F;
import com.vuforia.Renderer;
import com.vuforia.State;
import com.vuforia.Tool;
import com.vuforia.TrackableResult;
import com.vuforia.Vuforia;
import com.vuforia.engine.SampleApplication.SampleAppRenderer;
import com.vuforia.engine.SampleApplication.SampleAppRendererControl;
import com.vuforia.engine.SampleApplication.SampleApplicationSession;
import com.vuforia.engine.SampleApplication.utils.SampleUtils;
import com.vuforia.engine.SampleApplication.utils.Texture;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


// The renderer class for the Books sample.
@SuppressWarnings("unused")
public class BooksRenderer implements GLSurfaceView.Renderer, SampleAppRendererControl
{
    private final SampleAppRenderer mSampleAppRenderer;

    // Texture is Generated and Target is Acquired - Rendering Book Data
    static final int RS_NORMAL = 0;
    
    // Target has been lost - Rendering transition to 2D Overlay
    private static final int RS_TRANSITION_TO_2D = 1;
    
    // Target has been reacquired - Rendering transition to 3D
    private static final int RS_TRANSITION_TO_3D = 2;
    
    // New Target has been found - Loading book data and generating OpenGL
    // Textures
    static final int RS_LOADING = 3;
    
    // Texture with book data has been generated in Java - Ready to be generated
    // in OpenGL in the renderFrame thread
    static final int RS_TEXTURE_GENERATED = 4;
    
    // Books is active and scanning - Searching for targets.
    static final int RS_SCANNING = 5;

    // Reference to main activity
    WeakReference<Books> mActivityRef;
    
    private boolean mScanningMode = false;
    
    private boolean mShowAnimation3Dto2D = true;
    
    private boolean mStartAnimation3Dto2D = false;
    
    private boolean mStartAnimation2Dto3D = false;
    
    // Initialize RenderState
    private int renderState = RS_SCANNING;
    
    private Transition3Dto2D transition3Dto2D;
    private Transition3Dto2D transition2Dto3D;
    
    private float transitionDuration = 0.5f;
    private boolean mIsShowing2DOverlay = false;
    
    // ----------------------------------------------------------------------------
    // Flag for deleting current product texture in the renderFrame Thread
    // ----------------------------------------------------------------------------
    private boolean deleteCurrentProductTexture = false;
    
    private int mScreenHeight;
    
    private int mScreenWidth;
    
    private Texture mProductTexture;
    
    private float mDPIScaleIndicator;
    
    private float mScaleFactor;
    
    private final AtomicInteger framesToSkipBeforeRenderingTransition = new AtomicInteger(
        10);
    
    private boolean mTrackingStarted = false;
    
    private int shaderProgramID;
    
    private int vertexHandle;
    
    private int textureCoordHandle;
    
    private int mvpMatrixHandle;
    
    private float[] modelViewMatrix;
    
    private Matrix34F pose;
    
    private Plane mPlane;
    
    
    BooksRenderer(Books activity, SampleApplicationSession appSession)
    {
        mActivityRef = new WeakReference<>(activity);

        // SampleAppRenderer used to encapsulate the use of RenderingPrimitives setting
        // the device mode AR/VR and stereo mode
        mSampleAppRenderer = new SampleAppRenderer(this, mActivityRef.get(),
                appSession.getVideMode(), 0.010f, 5f);
    }
    
    
    void setFramesToSkipBeforeRenderingTransition(int framesToSkip)
    {
        framesToSkipBeforeRenderingTransition.set(framesToSkip);
    }


    void updateRenderingPrimitives()
    {
        mSampleAppRenderer.updateRenderingPrimitives();
    }


    @SuppressWarnings("SameParameterValue")
    void setActive(boolean active)
    {
        mSampleAppRenderer.setActive(active);
    }


    @Override
    // Function for initializing the renderer.
    public void initRendering()
    {
        
        // Define clear color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, Vuforia.requiresAlpha() ? 0.0f
            : 1.0f);
        
        // OpenGL setup for 3D model
        shaderProgramID = SampleUtils.createProgramFromShaderSrc(
            Shaders.cubeMeshVertexShader, Shaders.cubeFragmentShader);
        
        vertexHandle = GLES20.glGetAttribLocation(shaderProgramID,
            "vertexPosition");
        textureCoordHandle = GLES20.glGetAttribLocation(shaderProgramID,
            "vertexTexCoord");
        mvpMatrixHandle = GLES20.glGetUniformLocation(shaderProgramID,
            "modelViewProjectionMatrix");
        
        mPlane = new Plane();
        
    }
    
    
    // Function to update the renderer.
    private void updateRendering(int width, int height)
    {
        // Update screen dimensions
        mScreenWidth = width;
        mScreenHeight = height;
        
        // get the current orientation
        Configuration config = mActivityRef.get().getResources().getConfiguration();
        
        boolean isActivityInPortraitMode = config.orientation != Configuration.ORIENTATION_LANDSCAPE;
        
        // Initialize the 3D to 2D Transition
        transition3Dto2D = new Transition3Dto2D(mScreenWidth, mScreenHeight,
            isActivityInPortraitMode, mDPIScaleIndicator, mScaleFactor, mPlane);
        transition3Dto2D.initializeGL(shaderProgramID);
        
        // Initialize the 2D to 3D Transition
        transition2Dto3D = new Transition3Dto2D(mScreenWidth, mScreenHeight,
            isActivityInPortraitMode, mDPIScaleIndicator, mScaleFactor, mPlane);
        transition2Dto3D.initializeGL(shaderProgramID);
    }


    // Function to update the video background
    void updateVideoBackground()
    {
        Vuforia.onSurfaceChanged(mScreenWidth, mScreenHeight);
        mSampleAppRenderer.onConfigurationChanged();
    }

    @Override
    // Called when the surface is created or recreated.
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        // Call Vuforia Engine function to (re)initialize rendering after first use
        // or after OpenGL ES context was lost (e.g. after onPause/onResume):
        Vuforia.onSurfaceCreated();

        mSampleAppRenderer.onSurfaceCreated();

        // Call function to initialize rendering:
        initRendering();
    }
    
    @Override
    // Called when the surface changed size.
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        mScreenHeight = height;
        mScreenWidth = width;

        // Call function to update rendering when render surface
        // parameters have changed:
        updateRendering(width, height);
        
        // Call Vuforia Engine function to handle render surface size changes:
        Vuforia.onSurfaceChanged(width, height);

        // RenderingPrimitives to be updated when some rendering change is done
        mSampleAppRenderer.onConfigurationChanged();
    }


    // The render function called from SampleAppRendering by using RenderingPrimitives views.
    // The state is owned by SampleAppRenderer which is controlling it's lifecycle.
    // State should not be cached outside this method.
    public void renderFrame(State state, float[] projectionMatrix)
    {
        // Renders video background replacing Renderer.DrawVideoBackground()
        mSampleAppRenderer.renderVideoBackground();
        
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glEnable(GLES20.GL_CULL_FACE);

        if (deleteCurrentProductTexture)
        {
            // Deletes the product texture if necessary
            if (mProductTexture != null)
            {
                GLES20.glDeleteTextures(1, mProductTexture.mTextureID, 0);
                mProductTexture = null;
            }
            
            deleteCurrentProductTexture = false;
        }
        
        // If the render state indicates that the texture is generated it
        // generates
        // the OpenGL texture for start drawing the plane with the book data
        if (renderState == RS_TEXTURE_GENERATED)
        {
            generateProductTextureInOpenGL();
        }
        
        // Did we find any trackables this frame?
        if (!state.getTrackableResults().empty())
        {
            mTrackingStarted = true;

            // Handles target re-acquisition - Checks if the overlay2D is shown
            if (renderState == RS_TRANSITION_TO_2D)
            {
                // Initialize the Animation to 3d variables
                mStartAnimation2Dto3D = true;
                mIsShowing2DOverlay = false;

                // Updates renderState
                renderState = RS_TRANSITION_TO_3D;

                renderTransitionTo3D(projectionMatrix);
            }


            // If we are already tracking something we don't need
            // to wait any frame before starting the 2D transition
            // when the target gets lost
            framesToSkipBeforeRenderingTransition.set(0);
            
            // Gets current trackable result
            TrackableResult trackableResult = state.getTrackableResults().at(0);
            
            if (trackableResult == null)
            {
                return;
            }
            
            modelViewMatrix = Tool.convertPose2GLMatrix(
                trackableResult.getPose()).getData();
            
            // Renders the Augmentation View with the 3D Book data Panel
            renderAugmentation(trackableResult, projectionMatrix);
            
        } else
        {
            // Manages the 3D to 2D Transition initialization
            if (!mScanningMode && mShowAnimation3Dto2D
                && renderState == RS_NORMAL
                && framesToSkipBeforeRenderingTransition.get() == 0)
            {
                startTransitionTo2D();
            }
            
            // Reduces the number of frames to wait before triggering
            // the transition by 1
            if (framesToSkipBeforeRenderingTransition.get() > 0
                && renderState == RS_NORMAL)
            {
                framesToSkipBeforeRenderingTransition.decrementAndGet();
            }
            
        }
        
        // Logic for rendering Transition to 2D
        if (renderState == RS_TRANSITION_TO_2D && mShowAnimation3Dto2D)
        {
            renderTransitionTo2D(projectionMatrix);
        }
        
        // Logic for rendering Transition to 3D
        if (renderState == RS_TRANSITION_TO_3D)
        {
            renderTransitionTo3D(projectionMatrix);
        }
        
        // Renders the current state - User process Feedback
        if (mScanningMode)
        {
            // Requesting State - Show Requesting text in Status Bar
            mActivityRef.get().setStatusBarText("Requesting");
            mActivityRef.get().showStatusBar();
        } else
        {
            // Hiding Status Bar
            mActivityRef.get().hideStatusBar();
        }
        
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        
        Renderer.getInstance().end();
    }
    
    
    private void renderTransitionTo3D(float[] projectionMatrix)
    {
        if (mStartAnimation2Dto3D)
        {
            transitionDuration = 0.5f;
            
            // Starts the Transition
            transition2Dto3D.startTransition(transitionDuration, true);
            
            // Initialize control state variables
            mStartAnimation2Dto3D = false;
            
        } else
        {
            
            if (mProductTexture != null)
            {
                if( pose == null)
                {
                    pose = transition2Dto3D.getFinalPositionMatrix34F();
                }
                
               // Renders the transition
               transition2Dto3D.render(projectionMatrix, pose, mProductTexture.mTextureID[0]);
                
                // check if transition is finished
                if (transition2Dto3D.transitionFinished())
                {
                    // Updates state values
                    mIsShowing2DOverlay = false;
                    mShowAnimation3Dto2D = true;
                    
                    // Updates current renderState when the transition is
                    // finished to go back to normal rendering
                    renderState = RS_NORMAL;
                }
            }
        }
        
    }
    
    
    private void renderTransitionTo2D(float[] projectionMatrix)
    {
        if (mStartAnimation3Dto2D)
        {
            // Starts the Transition
            transition3Dto2D.startTransition(transitionDuration, false);
            
            // Initialize control state variables
            mStartAnimation3Dto2D = false;
            
        } else
        {
            
            if (mProductTexture != null)
            {
                if( pose == null)
                {
                    pose = transition2Dto3D.getFinalPositionMatrix34F();
                }
                
                transition3Dto2D.render(projectionMatrix, pose, mProductTexture.mTextureID[0]);
                
                // check if transition is finished
                if (transition3Dto2D.transitionFinished())
                {
                    mIsShowing2DOverlay = true;
                    
                }
            }
        }
    }
    
    
    // private method, actually start the transition
    private void startTransitionTo2D()
    {
        // Initialize the animation values when the book data
        // is displayed normally
        if (renderState == RS_NORMAL && mTrackingStarted)
        {
            transitionDuration = 0.5f;
            
            // Updates Render State
            renderState = RS_TRANSITION_TO_2D;
            mStartAnimation3Dto2D = true;
        }
        else if (renderState == RS_NORMAL && mProductTexture != null)
        {
            // Triggers the transition in case you loose the target while the
            // loading process
            transitionDuration = 0.0f;
            
            // Updates RenderState
            renderState = RS_TRANSITION_TO_2D;
            mStartAnimation3Dto2D = true;
        }
    }
    
    
    private void renderAugmentation(TrackableResult trackableResult, float[] projectionMatrix)
    {
        float[] modelViewProjection = new float[16];
        
        // Scales the plane relative to the target
        Matrix.scaleM(modelViewMatrix, 0, 0.430f * mScaleFactor,
            0.430f * mScaleFactor, 1.0f);
        
        // Applies 3d Transformations to the plane
        Matrix.multiplyMM(modelViewProjection, 0, projectionMatrix, 0, modelViewMatrix, 0);
        
        // Moves the trackable current position to a global variable used for
        // the 3d to 2D animation
        pose = trackableResult.getPose();
        
        // Shader Program for drawing
        GLES20.glUseProgram(shaderProgramID);
        
        // The 3D Plane is only drawn when the texture is loaded and generated
        if (renderState == RS_NORMAL)
        {
            GLES20.glVertexAttribPointer(vertexHandle, 3, GLES20.GL_FLOAT,
                false, 0, mPlane.getVertices());
            GLES20.glVertexAttribPointer(textureCoordHandle, 2,
                GLES20.GL_FLOAT, false, 0, mPlane.getTexCoords());
            
            GLES20.glEnableVertexAttribArray(vertexHandle);
            GLES20.glEnableVertexAttribArray(textureCoordHandle);
            
            // Enables Blending State
            GLES20.glEnable(GLES20.GL_BLEND);
            GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
            
            // Drawing Textured Plane
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D,
                mProductTexture.mTextureID[0]);
            GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false,
                modelViewProjection, 0);
            GLES20.glDrawElements(GLES20.GL_TRIANGLES, 6,
                GLES20.GL_UNSIGNED_SHORT, mPlane.getIndices());
            
            GLES20.glDisableVertexAttribArray(vertexHandle);
            GLES20.glDisableVertexAttribArray(textureCoordHandle);
            
            // Disables Blending State - Its important to disable the blending
            // state after using it for preventing bugs with the Camera Video
            // Background
            GLES20.glDisable(GLES20.GL_BLEND);

        }
        
        SampleUtils.checkGLError("Books renderFrame");
        
    }
    
    
    private void generateProductTextureInOpenGL()
    {
        Texture textureObject = mActivityRef.get().getProductTexture();
        
        if (textureObject != null)
        {
            mProductTexture = textureObject;
        }
        
        // Generates the Texture in OpenGL
        GLES20.glGenTextures(1, mProductTexture.mTextureID, 0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D,
            mProductTexture.mTextureID[0]);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
            GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
            GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        
        // We create an empty power of two texture and upload a sub image.
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, 1024,
            1024, 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, null);
        
        GLES20.glTexSubImage2D(GLES20.GL_TEXTURE_2D, 0, 0, 0,
            mProductTexture.mWidth, mProductTexture.mHeight, GLES20.GL_RGBA,
            GLES20.GL_UNSIGNED_BYTE, mProductTexture.mData);
        
        // Updates the current Render State
        renderState = RS_NORMAL;
    }
    
    
    // Called to draw the current frame.
    public void onDrawFrame(GL10 gl)
    {
        // Call our function to render content from SampleAppRenderer class
        mSampleAppRenderer.render();
    }
    
    
    void setScanningMode(boolean scanningMode)
    {
        mScanningMode = scanningMode;
        
    }
    
    
    void showAnimation3Dto2D(boolean b)
    {
        mShowAnimation3Dto2D = b;
        
    }
    
    
    void isShowing2DOverlay(boolean b)
    {
        mIsShowing2DOverlay = b;
        
    }
    
    
    void setRenderState(int state)
    {
        renderState = state;
        
    }
    
    
    public int getRenderState()
    {
        return renderState;
    }
    
    
    public void startTransition2Dto3D()
    {
        mStartAnimation2Dto3D = true;
    }
    
    
    public void startTransition3Dto2D()
    {
        mStartAnimation3Dto2D = true;
    }
    
    
    void stopTransition2Dto3D()
    {
        mStartAnimation2Dto3D = true;
    }
    
    
    void stopTransition3Dto2D()
    {
        mStartAnimation3Dto2D = true;
    }
    
    
    void deleteCurrentProductTexture()
    {
        deleteCurrentProductTexture = true;
    }
    
    
    void setProductTexture(Texture texture)
    {
        mProductTexture = texture;
    }
    
    
    boolean getScanningMode()
    {
        return mScanningMode;
    }
    
    
    void setDPIScaleIndicator(float dpiSIndicator)
    {
        mDPIScaleIndicator = dpiSIndicator;
        
    }
    
    
    void setScaleFactor(float f)
    {
        mScaleFactor = f;
        
    }
    
    
    void resetTrackingStarted()
    {
        mTrackingStarted = false;
        
    }
}
