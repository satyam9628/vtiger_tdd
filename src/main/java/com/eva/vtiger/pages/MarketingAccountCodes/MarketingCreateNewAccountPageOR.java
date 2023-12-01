package com.eva.vtiger.pages.MarketingAccountCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class MarketingCreateNewAccountPageOR extends CommonReusableCode {
	public MarketingCreateNewAccountPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement marketingAccountACCNameTB;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement marketingAccountPhoneNoTB;
	 @FindBy(xpath="//input[@id='email1']")
	 WebElement MarketingAccountEmailTB;

}
