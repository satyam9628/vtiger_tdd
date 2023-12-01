package com.vtiger.eva.pages.InventoryProduct;


import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class InventoryProductCreateAccountpage extends InventoryProductCreateAccountPageOR {
	public WebUtil wt;

	public InventoryProductCreateAccountpage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public String fillproductname() {
		RandomString random = new RandomString(4);
		String productName = random.nextString();
		wt.sendKeys(getProductNameTB(), productName);
		return productName;

	}
}
