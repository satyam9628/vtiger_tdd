package com.eva.vtiger.pages.supportCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
@Getter
public class supportAccountLandingPageOR extends CommonReusableCode {
 
	public supportAccountLandingPageOR(WebUtil web) {
		super(web);
	PageFactory.initElements(web.getDriver(), this);
	
}
	@FindBy(xpath="//img[@title='Create Account...']")
	private WebElement supportAccountCreateBT;
}
