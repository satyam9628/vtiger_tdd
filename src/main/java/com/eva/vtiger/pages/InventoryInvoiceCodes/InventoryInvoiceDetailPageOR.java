package com.eva.vtiger.pages.InventoryInvoiceCodes;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class InventoryInvoiceDetailPageOR extends CommonReusableCode {

	public InventoryInvoiceDetailPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}
}
