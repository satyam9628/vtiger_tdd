package com.eva.vtiger.pages.supportCodes;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class SupportAccountLandingPage extends supportAccountLandingPageOR {
 
	private WebUtil wt;
   public SupportAccountLandingPage(WebUtil wu) {
	   super(wu);
	 this.wt=wu;
	 
} 
   public void clickSupportAccountCreateIcon() {
	wt=WebUtil.getObject();
	wt.myClick(getSupportAccountCreateBT());
	}
	 
}
