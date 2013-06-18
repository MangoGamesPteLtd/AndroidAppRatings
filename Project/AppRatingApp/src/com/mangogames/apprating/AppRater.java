/*******************************************************************************
Copyright (c) 2013 Mango Games Interactive Pte Ltd
 
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
 
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
*******************************************************************************/
package com.mangogames.apprating;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/*
 * @author pankaj
 */
public class AppRater 
{
    private final static String APP_TITLE = "APP_TITLE";//name
    private final static String APP_PNAME = "APP_PNAME";//package name
    
    private final static int DAYS_UNTIL_PROMPT = 3;
    private final static int LAUNCHES_UNTIL_PROMPT = 2;
    
    private Context _con;
    
    public AppRater(Context mContext) {
    	_con = mContext;
    	
	}

	public  void app_launched() 
	{
        SharedPreferences prefs = _con.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }
        
        SharedPreferences.Editor editor = prefs.edit();
        
        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) 
		{
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }      
        
        showRateDialog(_con, editor);
      
        editor.commit();
    }   
    
    
	public  void showRateDialog( final Context mContext,  final SharedPreferences.Editor editor)
    {
        final Dialog dialog = new Dialog(mContext); 
        dialog.setTitle("Rate " + APP_TITLE);
        LinearLayout ll = new LinearLayout(mContext);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        TextView tv = new TextView(mContext);
        tv.setText("If you enjoy using " + APP_TITLE + ", please take a moment to rate it. Thanks for your support!");
        tv.setWidth(240);
        tv.setPadding(4, 0, 4, 10);
        ll.addView(tv);
        
        Button b1 = new Button(mContext);
        b1.setText("Rate " + APP_TITLE);
        b1.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
            	Intent goToMarket4 = null;
                goToMarket4 = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+APP_PNAME));
            	mContext.startActivity(goToMarket4);
                dialog.dismiss();
            }
        });        
        ll.addView(b1);

        Button b2 = new Button(mContext);
        b2.setText("Remind me later");
        b2.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
                dialog.dismiss();
            }
        });
        ll.addView(b2);

        Button b3 = new Button(mContext);
        b3.setText("No, thanks");
        b3.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ll.addView(b3);
        dialog.setContentView(ll);        
        dialog.show();    
    
    }
}
// see http://androidsnippets.com/prompt-engaged-users-to-rate-your-app-in-the-android-market-appirater