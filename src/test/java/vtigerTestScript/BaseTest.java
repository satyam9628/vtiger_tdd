package vtigerTestScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eva.vtiger.pages.common.reusableData.CommonReusableCode;
import com.eva.vtiger.pages.genericScript.WebUtil;

public class BaseTest {
	
	protected WebUtil wt =WebUtil.getObject();
	protected CommonReusableCode crc;
	private ExtentReports reports;
	private ExtentTest exTest;
	@BeforeMethod
	@Parameters({"userName","password"})
	public void beforeMethod(String userName, String password, Method mth) {
		exTest=reports.createTest(mth.getName());
		wt.setExtentTestObject(exTest);
		crc=new CommonReusableCode(wt);
		wt.clear(crc.getUserNameTB());
		wt.clear(crc.getUserPasswordTB());
		crc.login(userName,password);
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result, Method mth) {
		if(result.getStatus()==result.FAILURE) {
		String snapshot=wt.screenShot(mth.getName());
		wt.getExtentResultObject().addScreenCaptureFromPath(snapshot);
		
		}
		wt.signOut();
	}
	@BeforeClass
	//@Parameters({"browser","url","urlName"})
	public void beforeClass() {//String browser,String url ,String urlName
		String browser=wt.getPropertyData("browser");
		String url =wt.getPropertyData("url");
		String urlName=wt.getPropertyData("urlName");
		wt.browserLaunch(wt.getPropertyData("browser"));
		wt.openurl(url,urlName);
	 
	}@AfterClass
	public void afterClass() {
		wt.myquit();
	}
	@BeforeTest
	public void beforeTest() throws IOException {
//		InputStream is=new FileInputStream(System.getProperty("user.dir") + "src\\main\\resources\\dataprovider\\Book1.xlsx");
//		XSSFWorkbook bk= new XSSFWorkbook(is);
//		             XSSFSheet shet=bk.getSheet("Sheet1");
//		             for(int i=0; i<=shet.getLastRowNum(); i++) {
//		            	XSSFRow rowObj=shet.getRow(i) ;
//		            	for(int j=0; j<=rowObj.getLastCellNum()-1; j++) {
//		            		XSSFCell cellObj=rowObj.getCell(j);
//		            	String getfirstrowfirstcelldata	=cellObj.getStringCellValue();
//		            	System.out.println(getfirstrowfirstcelldata);
//		            	}
		             }
	
	@AfterTest
	public void afterTest() {
		
	}
	@BeforeSuite
	public void beforeSuite() {
		wt.loadProperties("config");
		  reports=new ExtentReports();
		ExtentSparkReporter esr =new ExtentSparkReporter("test-output\\vtigerExtentreport.html");
	     reports.attachReporter(esr);
	  
	}
	@AfterSuite
	public void afterSuite() {
		reports.flush();
	}
}
