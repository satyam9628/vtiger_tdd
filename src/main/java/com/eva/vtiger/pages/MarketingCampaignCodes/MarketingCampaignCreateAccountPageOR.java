package com.eva.vtiger.pages.MarketingCampaignCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class MarketingCampaignCreateAccountPageOR extends CommonReusableCode {
	public MarketingCampaignCreateAccountPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameTB;
	@FindBy(xpath = "//input[@id='sponsor']")
	private WebElement sponsorNameTB;
	@FindBy(xpath="//input[@id='targetaudience']")
	private WebElement MarketingCampaignTargetAudienceTB;

}
