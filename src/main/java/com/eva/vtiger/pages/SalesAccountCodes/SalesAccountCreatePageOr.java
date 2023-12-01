package com.eva.vtiger.pages.SalesAccountCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
@Getter
public class SalesAccountCreatePageOr extends CommonReusableCode{
 public SalesAccountCreatePageOr(WebUtil wt) {
	 super(wt);
	PageFactory.initElements(wt.getDriver(), this);
}
 @FindBy(xpath="//input[@name='accountname']")
 WebElement salesAccountNameTB;
 @FindBy(xpath="//input[@id='phone']")
 WebElement salesAccountPhoneTB;
 @FindBy(xpath="//input[@id='email1']")
 WebElement salesEmailTB;
}
