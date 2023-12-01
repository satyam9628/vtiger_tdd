package com.eva.vtiger.pages.MarketingContactsCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingContactLandingPage extends MarketingContactLandingPageOR {
	public WebUtil wt;

	public MarketingContactLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void goToClickContactCreateIcon() {
		wt.myClick(getMarketingContactCreateBT());
	}

}
