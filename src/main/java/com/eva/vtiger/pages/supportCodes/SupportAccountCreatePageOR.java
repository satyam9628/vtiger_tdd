package com.eva.vtiger.pages.supportCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
@Getter
public class SupportAccountCreatePageOR extends CommonReusableCode{
    
	public SupportAccountCreatePageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	    
	}
	@FindBy(xpath="//input[@name='accountname']") 
   private	WebElement  supportAccountNameTB;
	@FindBy(xpath="//input[@name='phone']")
	private WebElement supportAccountPhoneTB;
	@FindBy(xpath="//input[@name='email1']")
	private WebElement supportEmailTB;
	
}
