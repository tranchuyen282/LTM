/*===============================================================================
Copyright (c) 2019 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.vuforia.engine.Books.ui.ActivityList;

import com.vuforia.engine.Books.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;


public class ActivitySplashScreen extends Activity
{
    
    private static final long SPLASH_MILLIS = 450;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        RelativeLayout layout = (RelativeLayout) View.inflate(this, R.layout.splash_screen, null);
        
        addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT));
        
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            
            @Override
            public void run()
            {
                
                Intent intent = new Intent(ActivitySplashScreen.this,
                    AboutScreen.class);
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                    "app.Books.Books");
                intent.putExtra("ABOUT_TEXT_TITLE", "Books");
                intent.putExtra("ABOUT_TEXT", "Books/CR_about.html");
                startActivity(intent);
                
            }
            
        }, SPLASH_MILLIS);
    }
    
}
