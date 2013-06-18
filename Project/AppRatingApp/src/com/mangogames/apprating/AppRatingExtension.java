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

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
/*
 * @author pankaj
 */
public class AppRatingExtension implements FREExtension 
{
	
	@Override
	public FREContext createContext(String arg0)
	{
		return new AppRatingExtensionContext();
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
