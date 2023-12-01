package com.eva.vtiger.pages.MarketingContactsCodes;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingContactDetailPageOR extends CommonReusableCode {

	public MarketingContactDetailPageOR(WebUtil wu) {
		super(wu);
		PageFactory.initElements(wu.getDriver(), this);

	}

}
