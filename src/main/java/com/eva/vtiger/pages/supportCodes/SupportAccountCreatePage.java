package com.eva.vtiger.pages.supportCodes;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class SupportAccountCreatePage extends SupportAccountCreatePageOR {
     private WebUtil wt;
     
   public SupportAccountCreatePage(WebUtil wu) {
	   super(wu);
	  this.wt=wu;
	  
}  
  
   public void gotofillSupportAccountDetal() {
	   wt.sendKeys(getSupportAccountNameTB(), "satya");
	   wt.sendKeys(getSupportAccountPhoneTB(), "9834234567");
	   wt.sendKeys(getSupportEmailTB(), "sattu@12gmail.com");
   }
     
     
}
