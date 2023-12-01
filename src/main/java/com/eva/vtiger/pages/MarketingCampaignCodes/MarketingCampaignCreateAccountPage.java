package com.eva.vtiger.pages.MarketingCampaignCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingCampaignCreateAccountPage extends MarketingCampaignCreateAccountPageOR {
	public WebUtil wt;

	public MarketingCampaignCreateAccountPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

//	public void fillCampaignBasicDetail(String CampaignName, String TargetAudience ,String Sponsor) {
//		wt.sendKeys(getCampaignNameTB(), CampaignName);
//		wt.sendKeys(getMarketingCampaignTargetAudienceTB(), TargetAudience);
//		wt.sendKeys(getSponsorNameTB(), Sponsor);
//	

//}
	public void fillCampaignBasicDetail(String CampaignName,String targetAudience, String sponsor) {
		wt.sendKeys(getCampaignNameTB(), CampaignName);
		wt.sendKeys(getMarketingCampaignTargetAudienceTB(), targetAudience);
		wt.sendKeys(getSponsorNameTB(), sponsor);
	
}
}
