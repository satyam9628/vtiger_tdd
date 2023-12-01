package com.eva.vtiger.pages.common.reusableData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.genericScript.WebUtil;

import lombok.Getter;
import lombok.Setter;

@Getter

public class CommonReusableCodeOR {
	public CommonReusableCodeOR(WebUtil wt) {

		PageFactory.initElements(wt.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameTB;
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement userPasswordTB;
	@FindBy(xpath = "//select[@name='login_theme']")
	private WebElement colourThemeSB;
	@FindBy(xpath = "//select[@name='login_language']")
	private WebElement languageSB;
	@FindBy(xpath = "//input[@name='Login']")
	private WebElement loginBt;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	@FindBy(xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteBT;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchForTB;
	@FindBy(xpath = "(//input[contains(@value,'Search Now ')])[1]")
	private WebElement searchNowBT;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[1]")
	private WebElement myHomePageLK;
	@FindBy(xpath = "(//div[@id='My Home Page_sub']//a)[1]")
	private WebElement homeSL;
	@FindBy(xpath = "(//div[@id='My Home Page_sub']//a)[2]")
	private WebElement calendarSL;
	@FindBy(xpath = "(//div[@id='My Home Page_sub']//a)[3]")
	private WebElement webmailSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[2]")
	private WebElement marketingLK;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[1]")
	private WebElement marketingCampaignSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[2]")
	private WebElement markAccountSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[3]")
	private WebElement markContactSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[4]")
	private WebElement markWebmailSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[5]")
	private WebElement markLeadsSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[6]")
	private WebElement markCalendarSL;
	@FindBy(xpath = "(//div[@id='Marketing_sub']//a)[7]")
	private WebElement markDocumentsSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[3]")
	private WebElement SalesLK;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[1]")
	private WebElement salesLeadsSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[2]")
	private WebElement salesAccountSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[3]")
	private WebElement salesContactsSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[4]")
	private WebElement salesPotentialsSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[5]")
	private WebElement salesQuotesSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[6]")
	private WebElement salesOrderSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[7]")
	private WebElement salesInvoiceSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[8]")
	private WebElement salesPriceBooksSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[9]")
	private WebElement salesDocumentsSL;
	@FindBy(xpath = "(//div[@id='Sales_sub']//a)[10]")
	private WebElement salesCalendarSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[4]")
	private WebElement SupportLK;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[1]")
	private WebElement supportTroubleTicketSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[2]")
	private WebElement supportFaqSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[3]")
	private WebElement supportAccountSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[4]")
	private WebElement supportContactsSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[5]")
	private WebElement supportDocumentsSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[6]")
	private WebElement supportWebmailSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[7]")
	private WebElement supportCalendarSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[8]")
	private WebElement supportServiceContractsSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[9]")
	private WebElement supportProjectMilestonesSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[10]")
	private WebElement supportProjectTaskSL;
	@FindBy(xpath = "(//div[@id='Support_sub']//a)[11]")
	private WebElement supportProjectsSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[5]")
	private WebElement AnalyticsLK;
	@FindBy(xpath = "(//div[@id='Analytics_sub']//a)[1]")
	private WebElement analyticsReportsSL;
	@FindBy(xpath = "(//div[@id='Analytics_sub']//a)[2]")
	private WebElement analyticsDashBoardSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[6]")
	private WebElement InventoryLK;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[1]")
	private WebElement inventoryProductsSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[2]")
	private WebElement inventoryVendorsSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[3]")
	private WebElement inventoryPriceBooksSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[4]")
	private WebElement inventoryPurchaseOrderSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[5]")
	private WebElement inventorySalesOrderSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[6]")
	private WebElement inventoryQuotesSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[7]")
	private WebElement inventoryInvoiceSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[8]")
	private WebElement inventoryServiceSL;
	@FindBy(xpath = "(//div[@id='Inventory_sub']//a)[9]")
	private WebElement inventoryAssetsSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[7]")
	private WebElement ToolsLK;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[1]")
	private WebElement toolsRssSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[2]")
	private WebElement toolsOursitesSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[3]")
	private WebElement toolsDocumentsSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[4]")
	private WebElement toolsPBXmanagerSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[5]")
	private WebElement toolsCommentsSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[6]")
	private WebElement toolsRecycleBinSL;
	@FindBy(xpath = "(//div[@id='Tools_sub']//a)[7]")
	private WebElement toolsSMSNotifierSL;
	@FindBy(xpath = "(//table[@class='hdrTabBg']//a)[8]")
	private WebElement SettingLK;
	@FindBy(xpath = "(//div[@id='Settings_sub']//a)[1]")
	private WebElement settingsSL;
	@FindBy(xpath = "(//div[@id='Settings_sub']//a)[2]")
	private WebElement settingsModuleManagerSL;
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement newWindowsearchBox;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement newWindowsearchNowBT;
	@FindBy(xpath = "(//td//a)[4]")
	private WebElement elementForSearchingBT;

}
