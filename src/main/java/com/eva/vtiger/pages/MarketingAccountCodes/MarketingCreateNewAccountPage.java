package com.eva.vtiger.pages.MarketingAccountCodes;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingCreateNewAccountPage extends MarketingCreateNewAccountPageOR {
	public WebUtil wt;

	public MarketingCreateNewAccountPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

//	public void fillAccountFact(Map<String,String> map) {
//		
//		wt.sendKeys(getMarketingAccountACCNameTB(),map.get("AccountName") );
//		wt.sendKeys(MarketingAccountEmailTB, map.get("Email"));
//		wt.sendKeys(getMarketingAccountPhoneNoTB(), map.get("PhoneNumber"));
//	}
	public void fillMarketingAccountDetail() {
		RandomString rd=new RandomString(3);
		wt.sendKeys(getMarketingAccountACCNameTB(),"ramu"+rd );
		wt.sendKeys(MarketingAccountEmailTB,"sam@123gmail.com");
		wt.sendKeys(getMarketingAccountPhoneNoTB(),"9823143423" );
	}

	
	
	
	
//	public void fillPhoneNumber() {
//		Random rnd = new Random(10);
//		int num = rnd.nextInt();
//		String Phone = Integer.toString(num);
//
//		wt.sendKeys(getMarketingAccountPhoneNoTB(), Phone);
//	}

}
