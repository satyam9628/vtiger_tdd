package com.eva.vtiger.pages.supportCodes;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class SupportAccountDetailPage extends SupportAccountDetailPageOR {

	private WebUtil wt;
	public SupportAccountDetailPage(WebUtil wu)  {
		super(wu);
		this.wt=wu;
	}
	public String gotoGetTextOfSupportAccNo() {
		String accNumberText=wt.findText(getSupportAccountNumberTB());
		 String actualAccNuText=  accNumberText.trim();
		 return actualAccNuText;
	}
	
}
