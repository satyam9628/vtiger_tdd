package com.eva.vtiger.pages.InventoryInvoiceCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class InventoryInvoiceLandingPage extends InventoryInvoiceLandingPageOR {
	public WebUtil wt;

	public InventoryInvoiceLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void goToClickInvoiceCreateIcon() {
		wt.myClick(getInventoryInvoiceCreateBT());
	}

}
