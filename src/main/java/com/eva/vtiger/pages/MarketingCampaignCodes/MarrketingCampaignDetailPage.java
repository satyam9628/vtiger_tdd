package com.eva.vtiger.pages.MarketingCampaignCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarrketingCampaignDetailPage extends MarrketingCampaignDetailPageOR {
	public WebUtil wt;

	public MarrketingCampaignDetailPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public String goToFindTextOfCampaignNo() {
		String campaignNO = wt.findText(getCampaignNoTB());
		String actualCampaignNO = wt.myReplace(campaignNO, " ", "");
		return actualCampaignNO;
	}
}
