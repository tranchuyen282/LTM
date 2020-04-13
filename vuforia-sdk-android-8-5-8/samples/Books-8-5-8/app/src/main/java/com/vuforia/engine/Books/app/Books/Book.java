/*===============================================================================
Copyright (c) 2019 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.vuforia.engine.Books.app.Books;

import android.graphics.Bitmap;


// A support class encapsulating the info for one book
@SuppressWarnings("unused")
class Book
{
    private String title;
    private String author;
    private String ratingAvg;
    private String ratingTotal;
    private String priceList;
    private String priceYour;
    private String targetId;
    private Bitmap thumb;
    private String bookUrl;
    
    
    Book()
    {
        
    }
    
    
    String getTitle()
    {
        return title;
    }
    
    
    void setTitle(String title)
    {
        this.title = title;
    }
    
    
    String getAuthor()
    {
        return author;
    }
    
    
    void setAuthor(String author)
    {
        this.author = author;
    }
    
    
    String getRatingAvg()
    {
        return ratingAvg;
    }
    
    
    void setRatingAvg(String ratingAvg)
    {
        this.ratingAvg = ratingAvg;
    }
    
    
    String getRatingTotal()
    {
        return ratingTotal;
    }
    
    
    void setRatingTotal(String ratingTotal)
    {
        this.ratingTotal = ratingTotal;
    }
    
    
    String getPriceList()
    {
        return priceList;
    }
    
    
    void setPriceList(String priceList)
    {
        this.priceList = priceList;
    }
    
    
    String getPriceYour()
    {
        return priceYour;
    }
    
    
    void setPriceYour(String priceYour)
    {
        this.priceYour = priceYour;
    }
    
    
    public String getTargetId()
    {
        return targetId;
    }
    
    
    public void setTargetId(String targetId)
    {
        this.targetId = targetId;
    }
    
    
    Bitmap getThumb()
    {
        return thumb;
    }
    
    
    void setThumb(Bitmap thumb)
    {
        this.thumb = thumb;
    }
    
    
    String getBookUrl()
    {
        return bookUrl;
    }
    
    
    void setBookUrl(String bookUrl)
    {
        this.bookUrl = bookUrl;
    }
    
    
    public void recycle()
    {
        // Cleans the Thumb bitmap variable
        thumb.recycle();
        thumb = null;
    }
}
