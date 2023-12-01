package com.vtiger.eva.pages.InventoryProduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

public class InventoryProductLandingpage extends InventoryProductLandingPageOR {
	public WebUtil wt;

	public InventoryProductLandingpage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void goToClickProductCreateIcon() {
		wt.myClick(getInventoryProductCreateBT());

	}

}
