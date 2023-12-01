package com.eva.vtiger.pages.supportCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
@Getter
public class SupportAccountDetailPageOR extends CommonReusableCode {

	SupportAccountDetailPageOR(WebUtil wt){
		super(wt);
	PageFactory.initElements(wt.getDriver(), this);	
	
	}
	@FindBy(xpath="//td[contains(text(),'ACC170')]")
	private WebElement supportAccountNumberTB;
	
	
}
