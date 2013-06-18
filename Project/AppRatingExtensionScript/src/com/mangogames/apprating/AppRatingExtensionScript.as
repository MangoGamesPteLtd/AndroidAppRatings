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
package com.mangogames.apprating
{
	import flash.external.ExtensionContext;
	/*
	* @author pankaj
	*/
	public class AppRatingExtensionScript
	{
		private var extContext : ExtensionContext;
		
		public function AppRatingExtensionScript()
		{
				trace("in AppRatingExtensionScript Constructor");
				//give the package name of Android project
				extContext = ExtensionContext.createExtensionContext("com.mangogames.apprating","");
				if(!extContext)
				{
					throw new Error("App Rating extension is not supported on this platform.");
				}
			
		}
		public function showRateDialogScript():void 
		{
			extContext.call("showRateDialog");
		}
	}
}