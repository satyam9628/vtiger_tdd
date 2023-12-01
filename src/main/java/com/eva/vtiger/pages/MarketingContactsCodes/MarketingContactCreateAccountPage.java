package com.eva.vtiger.pages.MarketingContactsCodes;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingContactCreateAccountPage extends MarketingContactCreatePageOR {
	public WebUtil wt;

	public MarketingContactCreateAccountPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	
//	public void contactBasicInformation(Map<String,String> map) {
//	   String rand=	wt.randomword(3);
//		wt.sendKeys(getMarketingContactFirstNameTB(), map.get("FirstName")+rand);
//		wt.sendKeys(getMarketingContactLastName(), map.get("LastName")+rand);
//		wt.sendKeys(getMarketingContactMobNoTB(), map.get("Mobile"));
//		wt.sendKeys(getMarketingCampaignEmailTB(), map.get("Email"));
//	}
	public void contactBasicInformation() {
		 String rand=	wt.randomword(3);
		wt.sendKeys(getMarketingContactFirstNameTB(), "sam"+rand );
		wt.sendKeys(getMarketingContactLastName(), "yadav"+rand);
		wt.sendKeys(getMarketingContactMobNoTB(), "9628186775");
		wt.sendKeys(getMarketingCampaignEmailTB(), "sattu@12gmail.com");
	}
}
