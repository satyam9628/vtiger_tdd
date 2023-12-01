package com.vtiger.eva.pages.InventoryProduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class InventoryProductDetailPage extends InventoryProductDetailPageOR {
	public WebUtil wt;

	public InventoryProductDetailPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public String fillProductName() {
		RandomString random = new RandomString();
		String ProductName = random.nextString();
		wt.sendKeys(getProductNameTB(), ProductName);
		return ProductName;
	}

}
