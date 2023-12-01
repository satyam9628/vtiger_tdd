package vtigerTestScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eva.vtiger.pages.MarketingCampaignCodes.MarketingCampaignCreateAccountPage;
import com.eva.vtiger.pages.MarketingCampaignCodes.MarketingCampaignLandingPage;
import com.eva.vtiger.pages.MarketingCampaignCodes.MarrketingCampaignDetailPage;
import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class MarketingTestScripts extends BaseTest {
	@DataProvider(name = "marketingData")
	public String[][] getTestData() {
		String[] arrData= new String [3]; 
		arrData[0]="satya";
		arrData[1]="sert";
		arrData[2]="acvg";
		
		String []arrData1=new String[3];
		arrData1[0]="shiva";
		arrData1[1]="sambo";
		arrData1[2]="acdf";
		
		String []arrData3=new String[3];
		arrData3[0]="shubh";
		arrData3[1]="seqal";
		arrData3[2]="seldm";
		
		String[ ][]arrTwo =new String[3][3];
		arrTwo[0]=arrData;
		arrTwo[1]=arrData1;
		arrTwo[2]=arrData3;
		return arrTwo;
	}
	    
	   @Test(dataProvider = "marketingData")
		public void verifyVt001CreateCampaign(String campaignName, String targetAudience ,String sponsor) {
			crc.goToMarketing_Campaigns();
			MarketingCampaignLandingPage mclp=new MarketingCampaignLandingPage(wt);
			mclp.goToClickCampaignCreateIcon();
			MarketingCampaignCreateAccountPage mccap=new MarketingCampaignCreateAccountPage(wt);
			mccap.fillCampaignBasicDetail(campaignName, targetAudience, sponsor);
			crc.goToClickSaveButton();
			MarrketingCampaignDetailPage mcdp=new MarrketingCampaignDetailPage(wt);
			String CampaignNO = mcdp.goToFindTextOfCampaignNo();
			crc.goToMarketing_Campaigns();
			crc.goToSendInSearchForTextBox(CampaignNO);
			crc.goToClickSearchNowButton();
			String actualCampaignNO = mclp.goToFindTextOfCampaignNo();
			wt.verifyString( actualCampaignNO, CampaignNO);

		}
}
