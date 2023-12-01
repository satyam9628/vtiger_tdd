package com.eva.vtiger.pages.MarketingCampaignCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingCampaignLandingPage extends MarketingCampaignLandingPageOR {
	public WebUtil wt;

	public MarketingCampaignLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void goToClickCampaignCreateIcon() {
		wt.myClick(getCampaignCreateBT());
	}

	public String goToFindTextOfCampaignNo() {
		String campaignNO = wt.findText(getCampaignNoTB());

		return campaignNO;
	}
}
