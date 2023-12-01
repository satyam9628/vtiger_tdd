package com.eva.vtiger.pages.InventoryInvoiceCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;

@Getter
public class InventoryInvoiceCreateAccountPageOR extends CommonReusableCode {
	public InventoryInvoiceCreateAccountPageOR(WebUtil wt) {
		super(wt);
		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement invoiceSubjectNameTB;
	@FindBy(xpath = "//input[@id='customerno']")
	private WebElement invoiceCustomerNoTB;

	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement invoiceContactPlusBT;
	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement invoiceAccountPlusBT;
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billingAddressTB;
	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shippingAddressTB;
	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement selectItemBT;
	@FindBy(xpath = "//input[@id='qty1']")
	private WebElement qtyTB;

}
