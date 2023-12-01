package com.eva.vtiger.pages.SalesAccountCodes;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class SalesAccountDetailPageOr extends CommonReusableCode {

	public SalesAccountDetailPageOr(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}
}
