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

import android.content.Context;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/*
 * @author pankaj
 */
public class ShowRateDialogClass implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] arg1) 
	{
		Context mContext= context.getActivity();

		AppRater app = new AppRater(mContext);
		//calling the function
		app.app_launched();
		
		return null;
	}

}
