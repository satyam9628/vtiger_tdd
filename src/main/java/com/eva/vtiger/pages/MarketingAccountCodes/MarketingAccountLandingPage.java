package com.eva.vtiger.pages.MarketingAccountCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingAccountLandingPage extends MarketingAccountLandingPageOR {
	private WebUtil wt;

	public MarketingAccountLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void goToClickMarketingAccountCreateIcon() {
	wt=  WebUtil.getObject();
		wt.myClick(getMarketingAccountCreateBT());
	}

}
