package vtigerTestScript;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.eva.vtiger.pages.InventoryInvoiceCodes.InventoryInvoiceCreateAccountPage;
import com.eva.vtiger.pages.InventoryInvoiceCodes.InventoryInvoiceLandingPage;
import com.eva.vtiger.pages.MarketingAccountCodes.MarketingAccountLandingPage;
import com.eva.vtiger.pages.MarketingAccountCodes.MarketingCreateNewAccountPage;
import com.eva.vtiger.pages.MarketingContactsCodes.MarketingContactCreateAccountPage;
import com.eva.vtiger.pages.MarketingContactsCodes.MarketingContactLandingPage;
import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;
import com.vtiger.eva.pages.InventoryProduct.InventoryProductCreateAccountpage;
import com.vtiger.eva.pages.InventoryProduct.InventoryProductLandingpage;

public class InventoryInvoiceTestScripts extends BaseTest {
    @Test(groups="smoke")
	public void verifyVT002InvoceCreate() throws InterruptedException {
		
		crc.goToMarketing_Contacts();
		MarketingContactLandingPage mclp=new MarketingContactLandingPage(wt);
		mclp.goToClickContactCreateIcon();
		MarketingContactCreateAccountPage mccap= new MarketingContactCreateAccountPage(wt);
		mccap.contactBasicInformation();
	String contactLastName=	wt.findAttribute(mccap.getMarketingContactLastName(), "contact Last Name");
		crc.goToClickSaveButton();
		Thread.sleep(4000);
		crc.goToMarketing_Accounts();
		MarketingAccountLandingPage malp=new MarketingAccountLandingPage(wt);
		malp.goToClickMarketingAccountCreateIcon();
		MarketingCreateNewAccountPage mcnap=new MarketingCreateNewAccountPage(wt);
		  mcnap.fillMarketingAccountDetail();
		  String accName= wt.findAttribute(mcnap.getMarketingAccountACCNameTB(), "MarketingAccNameTB");		
		crc.goToClickSaveButton();
		Thread.sleep(4000);
		crc.goToInventory_Products();
		InventoryProductLandingpage ipl=new InventoryProductLandingpage(wt);
		ipl.goToClickProductCreateIcon();
		InventoryProductCreateAccountpage Ipcap =new InventoryProductCreateAccountpage(wt);
		String productName = Ipcap.fillproductname();
		crc.goToClickSaveButton();
		Thread.sleep(3000);
		crc.goToInventory_Invoice();
		InventoryInvoiceLandingPage iilp=new InventoryInvoiceLandingPage(wt);
		iilp.goToClickInvoiceCreateIcon();
		InventoryInvoiceCreateAccountPage iicap=new InventoryInvoiceCreateAccountPage(wt);
		iicap.fillSubjectElement();
		iicap.fillCustomerNo();
		Thread.sleep(5000);
		iicap.fillContactElement(contactLastName);
		iicap.fillAccountName(accName);
		iicap.fillBillingAddress();
		iicap.fillShippingAddress();
		Thread.sleep(3000);
		iicap.fillItemName(productName);
		iicap.fillQty();
		crc.goToClickSaveButton();

	}
}
