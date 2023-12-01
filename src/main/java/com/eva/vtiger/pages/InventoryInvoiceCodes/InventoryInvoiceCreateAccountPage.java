package com.eva.vtiger.pages.InventoryInvoiceCodes;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class InventoryInvoiceCreateAccountPage extends InventoryInvoiceCreateAccountPageOR {
	public WebUtil wt;

	public InventoryInvoiceCreateAccountPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void fillSubjectElement() {
		RandomString random = new RandomString(5);
		String SubjectName = random.nextString();
		wt.sendKeys(getInvoiceSubjectNameTB(), SubjectName);
	}

	public void fillCustomerNo() {
		Random rnd = new Random(3);
		int num = rnd.nextInt();
		String customerNo = Integer.toString(num);
		wt.sendKeys(getInvoiceCustomerNoTB(), customerNo);
	}

	public void fillContactElement(String contactLastName) throws InterruptedException {
		wt.myClick(getInvoiceContactPlusBT());
		wt.MyWindowHandleByContains("http://localhost:8888/index.php?module=Contacts&action=Popup&html", "trrgdjhkjk");
		CommonReusableCode crc = new CommonReusableCode(wt);
		crc.goToClickPlusBTForNewWindow(contactLastName);
		wt.MyWindowHandleByContains("http://localhost:8888/index.php?module", "jhhk");

	}

	public void fillAccountName(String accountLastName) throws InterruptedException {
		wt.myClick(getInvoiceAccountPlusBT());
		wt.MyWindowHandleByContains("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype",
				"trrgdjhkjk");
		CommonReusableCode crc = new CommonReusableCode(wt);
		crc.goToClickPlusBTForNewWindow(accountLastName);
	}

	public void fillBillingAddress() {
		wt.sendKeys(getBillingAddressTB(), "Vill-Barigaon Deeh Dist-Jaunpur");
	}

	public void fillShippingAddress() {
		wt.sendKeys(getShippingAddressTB(), "Varanashi shivpur ");
	}

	public void fillItemName(String productName) throws InterruptedException {
		wt.myClick(getSelectItemBT());
		wt.myWindowHandles(
				"http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form",
				"ghhjj");
		CommonReusableCode crc = new CommonReusableCode(wt);
		crc.goToClickPlusBTForNewWindowWithoutPopUp(productName);
		wt.MyWindowHandleByContains(
				"http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory",
				"jhhk");
	}

	public void fillQty() {

		wt.sendKeys(getQtyTB(), "3");
	}
}
