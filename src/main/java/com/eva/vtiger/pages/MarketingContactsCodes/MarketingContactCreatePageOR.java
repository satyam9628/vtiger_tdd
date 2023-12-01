package com.eva.vtiger.pages.MarketingContactsCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class MarketingContactCreatePageOR extends CommonReusableCode {

	public MarketingContactCreatePageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement marketingContactFirstNameTB;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement marketingContactLastName;
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement marketingContactMobNoTB;
	@FindBy(xpath="//input[@id='email']")
	private WebElement MarketingCampaignEmailTB;

}
