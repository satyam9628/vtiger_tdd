package com.eva.vtiger.pages.MarketingCampaignCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class MarketingCampaignLandingPageOR extends CommonReusableCode {
	public MarketingCampaignLandingPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//td[contains(text(),'CAM')]")
	private WebElement campaignNoTB;
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement campaignCreateBT;

}
