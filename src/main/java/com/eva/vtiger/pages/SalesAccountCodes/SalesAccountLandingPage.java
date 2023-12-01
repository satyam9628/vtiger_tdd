package com.eva.vtiger.pages.SalesAccountCodes;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class SalesAccountLandingPage extends SalesAccountLandingpageOr {
  private WebUtil wt;
  
  public SalesAccountLandingPage(WebUtil wu) {
	  super(wu);
	  this.wt=wu;
	  
}
  public void goToClickCreateIcon() {
	  wt.myClick(salesAccountCreateBT);
}
}
