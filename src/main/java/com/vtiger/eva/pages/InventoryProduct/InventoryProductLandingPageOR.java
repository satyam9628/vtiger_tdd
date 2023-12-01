package com.vtiger.eva.pages.InventoryProduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class InventoryProductLandingPageOR extends CommonReusableCode {
	public InventoryProductLandingPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//img[@title='Create Products...']")
	private WebElement inventoryProductCreateBT;

}
