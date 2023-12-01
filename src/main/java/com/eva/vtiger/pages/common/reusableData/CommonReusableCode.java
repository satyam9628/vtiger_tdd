package com.eva.vtiger.pages.common.reusableData;

import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
import lombok.Setter;


public class CommonReusableCode extends CommonReusableCodeOR {
	private WebUtil wt;

	public CommonReusableCode(WebUtil wu) {
		super(wu);
		wt = wu;
	}

	

	public void login(String userName, String password) {
//	this.launchAndOpenUrl("http://localhost:8888");
		wt.sendKeys(getUserNameTB(),userName );
		wt.sendKeys(getUserPasswordTB(), password);
		wt.myClick(getLoginBt());
	}

	public void goToClickSaveButton() {
		wt.myClick(getSaveButton());
	}

	public void goToClickDeleteButton() {
		wt.myClick(getDeleteBT());
		wt.popupAlert().accept();
	}

	public void goToSendInSearchForTextBox(String valueToSend) {
		wt.sendKeys(getSearchForTB(), valueToSend);

	}

	public void goToClickSearchNowButton() {
		wt.myClick(getSearchNowBT());

	}

	public void goToClickPlusBTForNewWindow(String elementToSearch) throws InterruptedException {
		wt.sendKeys(getNewWindowsearchBox(), elementToSearch);
		Thread.sleep(3000);
		wt.myClick(getNewWindowsearchNowBT());
//		Thread.sleep(2000);
		wt.myClick(getElementForSearchingBT());
		// Thread.sleep(2000);
		wt.popupAlert().accept();
		wt.MyWindowHandleByContains("http://localhost:8888/index.php?module", "jhhk");
	}

	public void goToClickPlusBTForNewWindowWithoutPopUp(String elementToSearch) throws InterruptedException {
		wt.sendKeys(getNewWindowsearchBox(), elementToSearch);
		Thread.sleep(3000);
		wt.myClick(getNewWindowsearchNowBT());
//		Thread.sleep(2000);
		wt.myClick(getElementForSearchingBT());
		// Thread.sleep(2000);
		wt.MyWindowHandleByContains("http://localhost:8888/index.php?module", "jhhk");
	}

	public void goToMyHomePage_Home() {
		wt.mouseOver(getMyHomePageLK());
		wt.myClick(getHomeSL());
	}

	public void goToMyHomePage_Calendar() {
		wt.mouseOver(getMyHomePageLK());
		wt.myClick(getCalendarSL());
	}

	public void goToMyHomePage_Webmail() {
		wt.mouseOver(getMyHomePageLK());
		wt.myClick(getWebmailSL());
	}

	public void goToMarketing_Campaigns() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarketingCampaignSL());
	}

	public void goToMarketing_Accounts() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkAccountSL());
	}

	public void goToMarketing_Contacts() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkContactSL());
	}

	public void goToMarketing_Webmail() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkWebmailSL());
	}

	public void goToMarketing_Leads() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkLeadsSL());
	}

	public void goToMarketing_Calendar() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkCalendarSL());
	}

	public void goToMarketing_Documents() {
		wt.mouseOver(getMarketingLK());
		wt.myClick(getMarkDocumentsSL());
	}

	public void goToSales_Leads() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesLeadsSL());

	}

	public void goToSales_Accounts() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesAccountSL());

	}

	public void goToSales_Contacts() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesContactsSL());
	}

	public void goToSales_Potentials() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesPotentialsSL());
	}

	public void goToSales_Quotes() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesQuotesSL());
	}

	public void goToSales_SalesOrder() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesOrderSL());
	}

	public void goToSales_Invoice() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesInvoiceSL());

	}

	public void goToSales_PriceBooks() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesPriceBooksSL());
	}

	public void goToSales_Documents() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesDocumentsSL());
	}

	public void goToSales_Calendar() {
		wt.mouseOver(getSalesLK());
		wt.myClick(getSalesCalendarSL());
	}

	public void goToSupport_TroubleTickets() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportTroubleTicketSL());
	}

	public void goToSupport_Faq() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportFaqSL());
	}

	public void goToSupport_Accounts() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportAccountSL());
	}

	public void goToSupport_Contacts() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportContactsSL());
	}

	public void goToSupport_Documents() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportDocumentsSL());
	}

	public void goToSupport_Webmail() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportWebmailSL());
	}

	public void goToSupport_Calendar() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportCalendarSL());
	}

	public void goToSupport_serviceContracts() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportServiceContractsSL());
	}

	public void goToSupport_ProjectsMilestones() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportProjectMilestonesSL());
	}

	public void goToSupport_PrjectsTasks() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportProjectTaskSL());
	}

	public void goToSupport_Projects() {
		wt.mouseOver(getSupportLK());
		wt.myClick(getSupportProjectsSL());
	}

	public void goToAnalytics_Reports() {
		wt.mouseOver(getAnalyticsLK());
		wt.myClick(getAnalyticsReportsSL());

	}

	public void goToAnalytics_DashBoard() {
		wt.mouseOver(getAnalyticsLK());
		wt.myClick(getAnalyticsDashBoardSL());
	}

	public void goToInventory_Products() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryProductsSL());
	}

	public void goToInventory_Vendors() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryVendorsSL());
	}

	public void goToInventory_PriceBooks() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryPriceBooksSL());
	}

	public void goToInventory_PurchaseOrder() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryPurchaseOrderSL());
	}

	public void goToInventory_SalesOrder() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventorySalesOrderSL());
	}

	public void goToInventory_Quotes() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryQuotesSL());
	}

	public void goToInventory_Invoice() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryInvoiceSL());

	}

	public void goToInventory_Services() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryServiceSL());
	}

	public void goToInventory_Assets() {
		wt.mouseOver(getInventoryLK());
		wt.myClick(getInventoryAssetsSL());
	}

	public void goToTools_Rss() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsRssSL());
	}

	public void goToTools_OurSites() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsOursitesSL());
	}

	public void goToTools_Documents() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsDocumentsSL());

	}

	public void goToTools_PBXmaneger() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsPBXmanagerSL());
	}

	public void goToTools_Comments() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsCommentsSL());
	}

	public void goToTools_RecycleBin() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsRecycleBinSL());
	}

	public void goToTools_SMSnotifier() {
		wt.mouseOver(getToolsLK());
		wt.myClick(getToolsSMSNotifierSL());
	}

	public void goToSettings_Settings() {
		wt.mouseOver(getSettingLK());
		wt.myClick(getSettingsSL());

	}

	public void goToSettings_ModuleManager() {
		wt.mouseOver(getSettingLK());
		wt.myClick(getSettingsModuleManagerSL());
	}
}
