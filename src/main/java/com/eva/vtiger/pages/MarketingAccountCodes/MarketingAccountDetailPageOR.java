package com.eva.vtiger.pages.MarketingAccountCodes;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingAccountDetailPageOR extends CommonReusableCode {
	public MarketingAccountDetailPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}
}
