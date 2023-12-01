package vtigerTestScript;

import org.testng.annotations.Test;

import com.eva.vtiger.pages.supportCodes.SupportAccountCreatePage;
import com.eva.vtiger.pages.supportCodes.SupportAccountDetailPage;
import com.eva.vtiger.pages.supportCodes.SupportAccountLandingPage;

public class VerifySupportAcccount extends BaseTest{

	@Test
public void verifyCreateSupportAccount() {
	crc.goToSupport_Accounts();
	SupportAccountLandingPage  salp=new SupportAccountLandingPage(wt);
	salp.clickSupportAccountCreateIcon();
	SupportAccountCreatePage sacp=new SupportAccountCreatePage(wt);
	sacp.gotofillSupportAccountDetal();
	crc.goToClickSaveButton();
	SupportAccountDetailPage sadp=new SupportAccountDetailPage(wt);
     crc.goToSupport_Accounts();
     crc.goToSendInSearchForTextBox(sadp.gotoGetTextOfSupportAccNo());
     crc.goToClickSearchNowButton();
	  
}
	
}
