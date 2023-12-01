package com.eva.vtiger.pages.genericScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;

@Getter
//@Setter
public class WebUtil {
	private Properties prop=null;
	private WebDriver driver = null;
	private static WebUtil wt;
	private ExtentTest test;

	private WebUtil() {

	}
	public void setExtentTestObject(ExtentTest test) {
		this.test=test;
	}
	public ExtentTest getExtentResultObject() {
		return this.test;
	}

	public static WebUtil getObject() {
		if (wt == null) {
			wt = new WebUtil();
		}
		return wt;

	}

	public WebDriver setDriver(WebDriver driver) {
		// driver = new ChromeDriver();
		return driver;
	}
//	public WebDriver getDriver() {
//		return driver;
//	}

	public void browserLaunch(String brows) {
	
		if(brows.equals("chrome")) {
		try {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Passed: your browser has launched ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: You have yet to launch your browser ");
			throw e;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		else if(brows=="edge") {
			
			System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("Passed: your browser has launched ");
			
		}
		
		else if(brows=="firefox") {
			
			System.setProperty("webdriver.gecko.driver", "driver\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Passed: your browser has launched ");
		}
		
		
	}
	public void signOut() {
		driver.findElement(By.xpath("//td//a[text()='Sign Out']")).click();
		System.out.println("user has done...LOGOUT");
	}

	public void openurl(String url, String urlName) {
		try {
			driver.get(url);
			System.out.println(urlName + " url is hitted successfully ");
		} catch (WebDriverException e) {
			System.out.println(urlName + " url is not hitted you need to remove s from http");
		} catch (Exception e) {
			System.out.println(urlName + " url is not hitted");
			e.printStackTrace();
			throw e;

		}
	}

//	public  WebElement myFindElements(String xPath,String Elementname) {
//		WebElement we=null;
//
//		try {
//			we=	driver.findElement(By.xpath(xPath));
//
//			System.out.println(Elementname +" element is found");
//		}catch(NoSuchElementException e) {
//			WebDriverWait wait=		 new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
//		}catch(Exception e) {
//			System.out.println(Elementname + " element is not found");
//			throw e;
//		}
//		return we;
//
//	}
	public void sendKeys(WebElement we, String value) {

		String Elementname = we.getAccessibleName();

		try {
			we.sendKeys(value);
			test.log(Status.INFO, value + " is filled in " + Elementname + " element box");
			System.out.println(value + " is filled in " + Elementname + " element box");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value=arguments[1]", value, we);
			System.out.println(value + " is filled in " + Elementname + " element box");
		} catch (StaleElementReferenceException e) {
			we.sendKeys(value);
			System.out.println(value + " is filled in " + Elementname + " element box");
		}
	}
    public void clear(WebElement we) {
	we.clear();
    }
	public void myClick(WebElement we) {
		String Elementname = we.getAccessibleName();
		try {
			we.click();
			test.log(Status.INFO,"click performed on " + Elementname + " element" );
			System.out.println("click performed on " + Elementname + " element");
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", we);
			System.out.println("click performed on " + Elementname + " element");
		} catch (StaleElementReferenceException e) {

			we.click();
			System.out.println("click performed on " + Elementname + " element");
		}
	}
	public String randomword(int i) {
		RandomString str=new RandomString(i);
	String strObj=	 str.nextString();
	 return strObj;
		
	}

	public String findText(WebElement we) {
		String Elementname = we.getAccessibleName();

		String text = null;
		try {
			text = we.getText();
			System.out.println(Elementname + " text is got as" + text);
		} catch (StaleElementReferenceException e) {

			text = we.getText();
			System.out.println(Elementname + " text isn't got");
		}
		return text;
	}

	public void myClose() {
		try {
			driver.close();
			System.out.println("browser has been closed");
		} catch (Throwable e) {
			driver.quit();
			System.out.println("browser has been closed");
		}

	}

	public String findAttribute(WebElement we, String AttributeName) {

		String Elementname = we.getAccessibleName();
		String Attributevalue = null;
		try {
			Attributevalue = we.getAttribute(AttributeName);
			System.out.println(Elementname + "Attribute value found as " + Attributevalue);
		} catch (StaleElementReferenceException e) {

		} catch (Exception e) {
			System.out.println(Elementname + "Attribute value not found");
			throw e;
		}
		return Attributevalue;
	}

	public void verifyString( String ActualText, String ExpectedText) {
		if (ActualText.equalsIgnoreCase(ExpectedText) || ActualText.contains(ExpectedText)) {
			System.out.println(
					"passed: Actual text " + (ActualText) + " is matching with expected text " + (ExpectedText));
		} else {
			System.out.println("failed." + ActualText + " is not got as inertext");
		}

	}

	public void mouseOver(WebElement we) {
		String Elementname = we.getAccessibleName();
		Actions actobj = null;
		try {
			actobj = new Actions(driver);
			test.log(Status.INFO, "mouseover performed" + Elementname );

		} catch (WebDriverException e) {
			e.printStackTrace();
			actobj = new Actions(driver);

		}
		try {
			actobj.moveToElement(we).build().perform();
			System.out.println("mouse over perform on" + Elementname);
		} catch (StaleElementReferenceException e) {

			actobj = new Actions(driver);
			actobj.moveToElement(we).build().perform();
			System.out.println("mouse over perform on" + Elementname);
		}
	}

	public Alert popupAlert() {
		Alert alt = null;
		try {
			alt = driver.switchTo().alert();
			System.out.println("your driver switched on popup and resolved it");
		} catch (NoAlertPresentException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("your driver couldn't switched on popup and resolved it");
		}
		return alt;
	}

	public void myquit() {
		try {
			driver.quit();
			System.out.println("all opened tab are quited ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseClick(WebElement weAct) {

		String Elementname = weAct.getAccessibleName();
		Actions act = new Actions(driver);
		try {
			act.click(weAct).build().perform();
			;
			System.out.println("click perform on" + Elementname);

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", weAct);
			System.out.println("click perform on" + Elementname);
		}

	}

	public void doubleClick(WebElement weAct) {
		String Elementname = weAct.getAccessibleName();
		Actions actobj = new Actions(driver);
		try {
			actobj.doubleClick(weAct).build().perform();
			System.out.println("Passed: Double Click is  performed on " + Elementname);

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", weAct);
			System.out.println("Passed: Double Click is  performed on" + Elementname);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Double Click isn't  performed on" + Elementname);
		}
	}

	public void myDragAndDrop(WebElement weDrag, WebElement weDrop) {
		String dragElementName = weDrag.getAccessibleName();
		String dropElementName = weDrop.getAccessibleName();
		Actions actobj = new Actions(driver);
		try {
			actobj.dragAndDrop(weDrag, weDrop).build().perform();
			;
			System.out.println("Passed:Drag And Drop is performed successfully ");
		} catch (MoveTargetOutOfBoundsException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", weDrag);
			actobj.dragAndDrop(weDrag, weDrop).build().perform();
			System.out.println("Passed:Drag And Drop is performed successfully ");

		}
	}

	public void mouseRightClick(WebElement weContext) {
		String Elementname = weContext.getAccessibleName();
		Actions actobj = new Actions(driver);

		actobj.contextClick(weContext).build().perform();

		System.out.println("Passed: Right click is performed on " + Elementname);

	}

	public void mouseSendkeys(WebElement weSendkeys, String value) {
		String Elementname = weSendkeys.getAccessibleName();
		Actions actobj = new Actions(driver);
		try {
			actobj.sendKeys(weSendkeys).build().perform();
			System.out.println("Passed:" + value + " is sent in textbox");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value=arguments[1]", value, weSendkeys);
			System.out.println("Passed:" + value + " is sent in textbox");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed:" + value + " isn't sent in textbox");

		}
	}

	public void dropSelectByIndex(WebElement weselect, int index) {
		String Elementname = weselect.getAccessibleName();
		Select se = null;

		se = new Select(weselect);
		System.out.println("Passed: Select class object has been created");

		try {
			se.selectByIndex(index);
			System.out.println("Passed:" + index + "th element is selected in select box ");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Failed: You have selected invalid index");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Failed: You have selected invalid index");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			System.out.println("Failed: You have selected invalid index");
		}

	}

	public void dropSelectByVisibleText(WebElement weselect, String text) {
		String Elementname = weselect.getAccessibleName();
		Select se = null;

		se = new Select(weselect);
		System.out.println("Passed: Select class object has been created");

		try {
			se.selectByVisibleText(text);
			System.out.println("Passed:" + text + " is selected in select box");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Failed: You have selected invalid text in select box");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + text + " isn't selected in select box");
		}
	}

	public void dropSelectedByValue(WebElement weselect, String Attributevalue) {
		String Elementname = weselect.getAccessibleName();
		Select se = null;

		se = new Select(weselect);
		System.out.println("Passed: Select class object has been created");

		try {
			se.selectByValue(Attributevalue);
			System.out.println("Passed:" + Attributevalue + "is selected in select box ");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Failed:" + Attributevalue + "isn't selected in select box ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + Attributevalue + "isn't selected in select box ");
		}

	}

	public String findCurrentUrl() {
		String url=null;
		try {
			url=driver.getCurrentUrl();
			System.out.println("Current URL is found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Current URL is not found");
		}
		return url;
	}

	public String findTitle(String pageName) {
		String title = null;
		try {
			title = driver.getTitle();
			System.out.println("Title of " + pageName + " is found");
		} catch (Exception e) {
			System.out.println("Title of " + pageName + " isn't found");
		}
		return title;

	}

	public String findFirstSelectOption(WebElement weselect) {

		String Elementname = weselect.getAccessibleName();
		Select se = null;

		se = new Select(weselect);
		System.out.println("Passed: Select class object has been created");

		WebElement weoption = null;
		try {
			weoption = se.getFirstSelectedOption();
			System.out.println("Passed: WebElement was found  Whatever was selected in select box");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: WebElement wasn't found  Whatever was selected in select box");
		}
		String text = null;
		try {
			text = weoption.getText();
			System.out.println("Text was found what was selected");
		} catch (StaleElementReferenceException e) {
			weoption = se.getFirstSelectedOption();
			text = weoption.getText();
			System.out.println("Text was found what was selected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Text wasn't found what was selected");
		}
		return text;
	}

	public String myReplace(String obj, String oldChar, String newchar) {
		String newChar = null;
		try {
			newChar = obj.replace(oldChar, newchar);
			System.out.println("Passed:" + oldChar + "is replace by" + newchar);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Replacement was unsuccessful");

		}
		return newChar;
	}

	public int getOptionCount(WebElement wesel) {
		String Elementname = wesel.getAccessibleName();
		Select se = null;
		try {
			se = new Select(wesel);
			System.out.println("Passed: Select class object is created");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Select class object is not created");
		}
		List<WebElement> opList = null;
		try {
			opList = se.getOptions();
			System.out.println("Passed: Options are found succssfully");
		} catch (Exception e) {
			System.out.println("Passed: Options aren't found");
		}
		int listSize = 0;
		try {
			listSize = opList.size();
			System.out.println("Passed:" + listSize + "is size of options");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: it is fail to get options size");
		}
		return listSize;
	}

	public List<String> getOptionText(WebElement weSel) {
		String Elementname = weSel.getAccessibleName();
		List<String> textList = null;
		try {
			textList = new ArrayList<String>();
			System.out.println("Passed array list objectis created");
		} catch (ClassCastException e) {
			textList = new ArrayList<String>();
			System.out.println("Passed array list objectis created");
		}

		Select se = null;
		try {
			se = new Select(weSel);
			System.out.println("Passed: Select class object is created");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Select class object isn't created");

		}
		List<WebElement> optionslist = null;
		try {
			optionslist = se.getOptions();
			System.out.println("Passed: Optons is found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Optons isn't found");
		}
		for (int i = 0; i < optionslist.size(); i++) {
			WebElement weoption = null;
			try {
				weoption = optionslist.get(i);
				System.out.println("Passed: Element are found from options");
			} catch (StaleElementReferenceException e) {
				weoption = optionslist.get(i);
				System.out.println("Passed: Element are found from options");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Element aren't found from options");
			}
			String optionsText = null;
			try {
				optionsText = weoption.getText();
				System.out.println("Passed: Options text is found successly");
			} catch (StaleElementReferenceException e) {
				weoption = optionslist.get(i);
				optionsText = weoption.getText();
				System.out.println("Passed: Options text is found successfully");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Options text isn't found ");
			}
			try {
				textList.add(optionsText);
				System.out.println("Passed:" + optionsText + "are added in list");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Passed:" + optionsText + "aren't added in list");

			}
		}
		return textList;
	}

	public void getSureOptionText(WebElement weSel, String selectText) {
		int indexNum = -1;

		Select se = null;
		try {
			se = new Select(weSel);
			System.out.println("Passed: Select class object is created");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Select class object isn't created");
		}
		List<WebElement> optionslist = null;
		try {
			optionslist = se.getOptions();
			System.out.println("Passed: Optons is found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Optons isn't found");
		}
		for (int i = 0; i < optionslist.size(); i++) {
			WebElement weoption = null;
			try {
				weoption = optionslist.get(i);
				System.out.println("Passed: Element are found from options");
			} catch (StaleElementReferenceException e) {
				weoption = optionslist.get(i);
				System.out.println("Passed: Element are found from options");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Element aren't found from options");

			}
			String optionsText = null;
			try {
				optionsText = weoption.getText();
				System.out.println("Passed: Options text is found successly");
			} catch (StaleElementReferenceException e) {
				weoption = optionslist.get(i);
				optionsText = weoption.getText();
				System.out.println("Passed: Options text is found successfully");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Options text isn't found ");
			}
			if (optionsText.contains(selectText)) {
				indexNum = i;
				break;
			}
		}
		try {
			se.selectByIndex(indexNum);
			System.out.println("Passed: Element of" + indexNum + "is selected ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: Element of" + indexNum + "isn't selected ");
		}
	}

	/*
	 * This is the method switch driver focus on other window it will take two
	 * parameter actual URL and actual title In parameter will be sent url and title
	 * of that window on whichever window you want to shifted driver focus it will
	 * switched on that window either the help of actualUrl or actualTitle
	 */
	public void myWindowHandles(String actualUrl, String actualTitle) {
		Set<String> set = null;
		try {
			set = driver.getWindowHandles();
			System.out.println("Passed: Handle value of multiple window are found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Handle value of multiple window are not found");
		}
		for (String str : set) {
			try {
				driver.switchTo().window(str);
				System.out.println("Passed: Focus is switched on different window successfully");
			} catch (Exception e) {
				System.out.println("Passed: Focus isn't switched on different window successfully");
			}
			try {
				String title = driver.getTitle();
				String url = driver.getCurrentUrl();
				if (url.equalsIgnoreCase(actualUrl) || title.equalsIgnoreCase(actualTitle)) {
					break;

				}
				System.out.println("Passed: matching of title and Url is done successfully");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Passed: matching of title and Url isn't done successfully");
			}
		}

	}/*
		 * This is the method to handle the popup it will take a parameter
		 * acceptOrDismiss if Accept will be sent then it will click on ok[Accept]
		 * Dismiss will be sent then it will click on cancel [Rejection]
		 */

	public void alertDeclaration(String acceptOrDismiss) {

		String str = acceptOrDismiss.toLowerCase();
		switch (str) {
		case "accept":
			try {
				driver.switchTo().alert().accept();
				System.out.println("Passed: alert is handled by Accept");
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
				System.out.println("Failed: Alert is not present");
			}
		case "dismiss":
			try {
				driver.switchTo().alert().dismiss();
				;
				System.out.println("Passed: alert is handled by Accept");
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
				System.out.println("Failed: there is no alert presence");
			}

		}

	}

	/*
	 * It is the method to switched on popup and get its text it will return text of
	 * pop up
	 */
	public String alertText() {
		String textOfAlert = null;
		try {
			textOfAlert = driver.switchTo().alert().getText();
			System.out.println("Passed: alert is handled  and alert text-" + textOfAlert + " is found ");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			System.out.println("Failed: there is not any alert presence");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: alert is handled but alert text-:" + textOfAlert + "is not found ");
		}
		return textOfAlert;
	}

	/*
	 * This is the method you can switched a window to frame with the help of frame
	 * index It will take two parameter index and elementname first parameter index
	 * will take the index of frame Second xPath is only for reporting where element
	 * name will be written
	 */
	public void myFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
			System.out.println("Passed: browser focus shifted on" + index + "st  number frame successfully ");
		} catch (NoSuchElementException e) {

			System.out.println(
					"Failed: browser couldn't exert its focus on frame\nEither it's not a frame oryou are puting wrong index ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: browser  couldn't focus on frame");
		}
	}

	/*
	 * This is the method you can switched a window to frame with the help of frame
	 * name or frame id It will take two parameter xPath and elementname first
	 * parameter nameOrId will take the NameOrId of frame WebElement Second xPath is
	 * only for reporting where element name will be written
	 */
	public void myFrameByName(String nameorId) {
		try {
			driver.switchTo().frame(nameorId);
			test.log(Status.INFO, "browser focus shifted on frame");
			System.out.println("Passed: browser focus shifted on frame ");
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "browser couldn't shifted its focus on frame");
			System.out.println("Failed: browser couldn't shifted its focus on frame");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: browser couldn't shifted its focus on frame");
		}
	}

	/*
	 * This is the method you can switched a window to frame with the help of frame
	 * webelement It will take two parameter xPath and elementname first parameter
	 * xpath will take the xPath of frame WebElement Second xPath is only for
	 * reporting where element name will be written
	 */
	public void myFrameByWebElement(WebElement frameElement) {

		try {
			driver.switchTo().frame(frameElement);
			test.log(Status.INFO, "Browser focus shift on frame through WebElement successfully");
			System.out.println("Passed: Browser focus shift on frame through WebElement successfully");
		} catch (NoSuchElementException e) {
			System.out.println("Failed : browser couldn't shift its focus on frame");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.INFO, "browser couldn't shift its focus on frame");
			System.out.println("Failed: browser couldn't shift its focus on frame");

		}
	}

	/* Withthe help of the method focus can be switched from frame to main window */
	public void returnFromFrame() {
		try {
			driver.switchTo().defaultContent();
			test.log(Status.INFO, "Browser focus shifted on main window from frame");
			System.out.println("Passed: Browser focus shifted on main window from frame");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.INFO, "Browser couldn't shifted back on main window");
			System.out.println("Failed: Browser couldn't shifted back on main window");

		}
	}

	/* With the help of this method can be switched child frame to parent frame */
	public void myParentFrame() {
		try {
			driver.switchTo().parentFrame();
			test.log(Status.INFO, " Browser shifted its focus on parent frame");
			System.out.println("Passed: Browser shifted its focus on parent frame");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.INFO, "Browser couldn't shift its focus on parent frame");
			System.out.println("Failed: Browser couldn't shift its focus on parent frame");

		}

	}
	/*
	 * This method is used for geting table row list size It will take two parameter
	 * first parameter will take actual coloumn list x path for this find elements
	 * has been used finally it will return table row list size
	 */

	public int getTableRowCount(String TablexPath) {
		List<WebElement> TableList = null;
		try {
			TableList = driver.findElements(By.xpath(TablexPath + "//tr[1]//td"));
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TablexPath)));
			System.out.println("Passed: Elements were found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Elements were not found");
		}
		int TableListSize = 0;
		try {
			TableListSize = TableList.size();
			System.out.println("Passed:" + TableListSize + " is the size of list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: We didn't get the size");

		}
		return TableListSize;
	}

	/*
	 * This method is used for geting table coloumn count It will take two parameter
	 * first parameter will take actual coloumn list x path for this find elements
	 * has been used finally it will return table coloumn list size
	 */
	public int getTableColumnCount(String xPath) {
		List<WebElement> TableList = null;
		try {
			TableList = driver.findElements(By.xpath(xPath + "//tr"));
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
			System.out.println("Passed: Elements were found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Elements were not found");
		}
		int TableListSize = 0;
		try {
			TableListSize = TableList.size();
			System.out.println("Passed:" + TableListSize + " is the size of list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: We didn't get the size");
		}
		return TableListSize;

	}

	/*
	 * This method is used for geting all table row count if it having next table it
	 * will take three parameter TablexPath ,OfnumberxPath, nextIconxPath in first
	 * parameter will be given table xPath in second Parameter will be given the
	 * xPath of (of2,of3) mean which number table do you wanna go in third parameter
	 * next icon xPath will be given so that we may get access of next table finally
	 * it will add first table row count and next table row count it will return
	 * both added count of row list
	 */
	public int getAllTableRowCount(WebElement TablexPath, WebElement ofNumberXPath, WebElement nextIconXPath) {
		List<WebElement> coloumnList = null;
		try {
			coloumnList = driver.findElements(By.xpath(TablexPath + "//tr"));
			System.out.println("Passed: coloumn list elements are found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Passed: coloumn list elements aren't found");
		}
		int FirstPageColoumnCount = 0;
		try {
			FirstPageColoumnCount = coloumnList.size();
			System.out.println("Passed:" + FirstPageColoumnCount + " is the size of coloumn list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Accurate size is not defined");
		}
		String nextIconText = null;

		nextIconText = findText(ofNumberXPath);
		String actualText = null;
		try {
			actualText = nextIconText.replace("of ", "");
			System.out.println("Passed: Old char is replace by new char");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Old char is not replace by new char");
		}
		int AllColoumnCount = -1;
		int ActualpageSize = 0;
		try {
			ActualpageSize = Integer.parseInt(actualText);
			System.out.println("Passed: " + actualText + " is converted in int");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: String data is not converted in String");
		}
		for (int i = 1; i < ActualpageSize; i++) {
			myClick(nextIconXPath);
			List<WebElement> weNextPageColoumnList = null;
			try {
				weNextPageColoumnList = driver.findElements(By.xpath(TablexPath + "//tr"));
				System.out.println("Passed: Next page coloumn list elements are found");
			} catch (Exception e) {
				System.out.println("Failed: Next page coloumn list elements are not found");

			}
			int NextPageColoumCount = 0;
			try {
				NextPageColoumCount = weNextPageColoumnList.size();
				System.out.println("Passed:" + NextPageColoumCount + "is next page coloumn  list size");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed:Actual size is not defined");
			}
			AllColoumnCount = FirstPageColoumnCount + NextPageColoumCount;

		}
		return AllColoumnCount;
	}

	/*
	 * This method will be used to work one window to other window In this method
	 * your driver focus will be shifted one window to others For excuting all this
	 * process getwindowHandles method will be called this method will return list
	 * of handle value For each loop is used so that we can get handle value one by
	 * one In for each loop driver's switchTo method is called then it's window
	 * method has been called in Window method's parameter handle value is given
	 * Then if else is used for matching actual handle vale so that driver object
	 * switched on actual window
	 */
	public void MyWindowHandleByContains(String actualUrl, String actualTitle) {
		Set<String> set = null;
		try {
			set = driver.getWindowHandles();
			System.out.println("Passed: Handle value of multiple window are found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Handle value of multiple window are not found");
		}
		for (String str : set) {
			try {
				driver.switchTo().window(str);
				System.out.println("Passed: Focus is switched on different window successfully");
			} catch (Exception e) {
				System.out.println("Passed: Focus isn't switched on different window successfully");
			}
			try {
				String title = driver.getTitle();
				String url = driver.getCurrentUrl();
				if (url.contains(actualUrl) || title.contains(actualTitle)) {
					break;

				}
				System.out.println("Passed: matching of title and Url is done successfully");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Passed: matching of title and Url isn't done successfully");
			}

		}
	}

	/*
	 * This method will used for check all check box it will take two parameter
	 * xPath and Elementname In First parameter checkbox's list xPath will be given
	 * Where findelements will be used for geting xPath of allCheckBoxes In second
	 * parameter Element name will be given just for reporting Finally this method
	 * will check all check box
	 */
	public void checkAllCheckBox(String xPath, String Elementname) {
		List<WebElement> Welist = null;
		try {
			Welist = driver.findElements(By.xpath(xPath));
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
			System.out.println("Passed: Elements were found");
		}
		for (int i = 0; i < Welist.size(); i++) {
			WebElement weFinder = null;
			try {
				weFinder = Welist.get(i);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Elements were not got");
			}

			if (weFinder.isSelected() == false) {
				weFinder.click();
			}

		}
	}

	/*
	 * This method will used for uncheck all check box it will take two parameter
	 * xPath and Elementname In First parameter checkbox's list xPath will be given
	 * Where findelements will be used for geting xPath of allCheckBoxes In second
	 * parameter Element name will be given just for reporting Finally this method
	 * will uncheck all check box
	 */
	public void uncheckAllCheckBox(String xPath, String Elementname) {
		List<WebElement> Welist = null;
		try {
			Welist = driver.findElements(By.xpath(xPath));
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
			System.out.println("Passed: Elements were found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Elements were not found");
		}
		for (int i = 0; i < Welist.size(); i++) {
			WebElement weFinder = null;
			try {
				weFinder = Welist.get(i);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Either element was not got or its text name");

			}
			if (weFinder.isSelected() == true) {
				weFinder.click();
			}

		}
	}

	/*
	 * This method is used for geting coloumn name list It will take two parameter
	 * xPath and Elementname In first parameter genuine xPath will be given of Table
	 * coloumn list according to requirment Second parameter is just for naming
	 * while reporting This method will return the list of table coloumn name
	 */
	public List<String> getTableColoumnNameList(String xPath, String Elementname) {
		List<String> listObj = new ArrayList<>();
		List<WebElement> weList = null;
		try {
			weList = driver.findElements(By.xpath(xPath));
			System.out.println("Passed: Elements was found");
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
			System.out.println("Passed: Elements were found");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Elements were not found");

		}
		for (int i = 0; i < weList.size(); i++) {
			String ColoumnTextList = null;
			try {
				ColoumnTextList = weList.get(i).getText();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Either element was not got or its text name");
			}
			listObj.add(ColoumnTextList);

		}
		return listObj;
	}

	/*
	 * This method is used for geting coloumn data list with the help of coloumn
	 * number It will take three parameter TablexPath , Elementname and
	 * coloumnNumber TablexPath is manadatory because it's all xpath is regarding in
	 * Table In table some internal code is written Elementname parameter is just
	 * for naming while reporting Third parameter is coloumn Whichever coloumn
	 * number will be given It will return coloumn data list of that coloumn
	 * sequence
	 */
	public List<String> getColumnDataListByColumnNumber(String Tablexpath, String Elementname, int ColoumnNumber) {
		List<WebElement> wecoloumnDataList = null;
		try {
			wecoloumnDataList = driver
					.findElements(By.xpath(Tablexpath + "//tr[1]/following-sibling::tr//td[" + ColoumnNumber + "]"));
			System.out.println("Passed: coloumn list elements are found");
		} catch (Exception e) {
			System.out.println("Failed: coloumn list elements are not found");
		}
		List<String> ColoumnDataList = new ArrayList<>();
		for (int i = 0; i < wecoloumnDataList.size(); i++) {
			WebElement ColoumnData = null;
			try {
				ColoumnData = wecoloumnDataList.get(i);
				System.out.println("coloumn list element is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("coloumn list element isn't got");
			}
			String ColoumnDataListText = null;
			try {
				ColoumnDataListText = ColoumnData.getText();
				System.out.println("Passed: coloumn list text is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Passed: coloumn list text isn't got");

			}
			ColoumnDataList.add(ColoumnDataListText);
		}
		return ColoumnDataList;
	}
	/*
	 * This method is used for geting row data list with the help of row id It has
	 * taken three parameter Tablexpath Elementname and rowId TablexPath is
	 * manadatory because it's all xpath is regarding in Table In table some
	 * internal code is written Elementname parameter is just for naming while
	 * reporting Third parameter is row Id whichever row id will be given it will
	 * return the row data list of that row id
	 */

	public List<String> getRowDataListByRowId(String xPath, String Elementname, String rowId) {
		int rowNumber = getRowNumberByRowId(xPath, Elementname, rowId);
		List<String> rowDataList = getRowDataListByRowNumber(xPath, Elementname, (rowNumber + 1));
		return rowDataList;

	}

	/*
	 * This method is used for geting coloumn data list with the help of coloumn
	 * name it's having three parameter Tablexpath,Elementname and coloumnName Table
	 * xPath is manadatory for its all xPath are regarding in table some internal
	 * code is written in TablexPath Elementname parameter is just for naming while
	 * reporting Third parameter is coloumn name In third parameter whichever
	 * coloumn name will be given it will return the coloumn data
	 */
	public List<String> getColumnDataListByColumnName(String xPath, String Elementname, String coloumnName) {
		int ColoumnNumber = getColoumnNumberByColoumnName(xPath, Elementname, coloumnName);
		List<String> ColoumnDataList = getColumnDataListByColumnNumber(xPath, Elementname, (ColoumnNumber + 1));
		return ColoumnDataList;
	}

	/*
	 * This method is used for geting coloumn data list with the help of coloumn
	 * name it's having three parameter Tablexpath,Elementname and coloumnName Table
	 * xPath is manadatory for its all xPath are regarding in table some internal
	 * code is written in TablexPath Elementname parameter is just for naming while
	 * reporting Third parameter is coloumn name In third parameter whichever
	 * coloumn name will be given it will return the coloumn datalist of that
	 * coloumn name
	 */
	public List<String> getColumnDataListByColumnNameInDetail(String TablexPath, String Elementname, String Textname) {
		List<WebElement> rowList = null;
		try {
			rowList = driver.findElements(By.xpath(TablexPath + "//tr[1]//td"));
			System.out.println("Passed:" + Elementname + "table list is found ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + Elementname + "table list is not found ");
		}
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < rowList.size(); i++) {
			rowList = driver.findElements(By.xpath(TablexPath + "//tr[1]//td"));
			strList = new ArrayList<>();
			WebElement weRowListtext = null;
			try {
				weRowListtext = rowList.get(i);
				System.out.println("Passed: row element is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed:row element is not got");
			}
			String rowListText = null;
			try {
				rowListText = weRowListtext.getText();
				System.out.println("Passed: row list text is got");
			} catch (Exception e) {
				System.out.println("Failed: row list text is not got");

			}
			if (rowListText.equalsIgnoreCase(Textname)) {
				List<WebElement> ColoumnList = null;
				try {
					ColoumnList = driver.findElements(By.xpath(TablexPath + "//tr//td[" + (i + 1) + "]"));
					System.out.println("Passed: coloumn list elements are found");
				} catch (Exception e) {
					System.out.println("Passed: coloumn list elements aren't found");
				}
				for (int j = 0; j < ColoumnList.size(); j++) {
					WebElement weColoumnList = null;
					try {
						weColoumnList = ColoumnList.get(j);
						System.out.println("Passed: coloumn list element is got");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Failed:coloumn list element is not got ");
					}
					String coloumnListText = null;
					try {
						coloumnListText = weColoumnList.getText();
						System.out.println("Passed: coloumn list text is got");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Failed: coloumn list text is not got");
					}
					strList.add(coloumnListText);
				}
				break;
			}

		}
		return strList;
	}
	/*
	 * This is the method for getting row number with the help of rowId it will take
	 * three parameter first one is TablexPath and others are Elementname and idName
	 * Table xPath is manadatory because its all are regarding to table Some
	 * internal codes are written in tablexPath element Name paramter is only for
	 * naming while reporting In id name we will send that id which row sequence i
	 * need of finally it will return row number of given row id
	 */

	public int getRowNumberByRowId(String TablexPath, String Elementname, String idName) {
		List<WebElement> ListOfRow = null;
		try {
			ListOfRow = driver.findElements(By.xpath(TablexPath + "//tr//td[2]"));
			System.out.println("Passed:" + Elementname + "table is found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + Elementname + "table is not found");
		}
		int rowNumber = -1;
		for (int i = 0; i < ListOfRow.size(); i++) {
			WebElement rowIdList = null;
			try {
				rowIdList = ListOfRow.get(i);
				System.out.println("Passed: row element is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: row element is not got");
			}
			String rowIdText = null;
			try {
				rowIdText = rowIdList.getText();
				System.out.println("Passed: row list text is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: row list text is not got");
			}
			if (rowIdText.equalsIgnoreCase(idName) == true) {
				rowNumber = i;
				break;
			}
		}
		return rowNumber;
	}
	/*
	 * This is the method for print all table data it will print all data through
	 * row and coloumn it will take only one parameter table xPath in table xpath
	 * some internal code is written finally it will print entire table data
	 */

	public void printAllTableData(String tablexPath) {
		List<WebElement> weRowlist = null;
		try {
			weRowlist = driver.findElements(By.xpath(tablexPath + "//tr[1]//td"));
			System.out.println("Passed: Row elements are found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed: Row elements list are not found");
		}
		for (int i = 1; i < weRowlist.size(); i++) {
			WebElement werowList = null;
			try {
				werowList = weRowlist.get(i);
				System.out.println("Passed: Row element is got ");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Row element is not got");
			}
			String rowListText = null;
			try {
				rowListText = werowList.getText();
				System.out.println("Passed: Row list text is found");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Row list is not found");
			}
			System.out.println(rowListText);

			List<WebElement> weColoumnList = null;
			try {
				weColoumnList = driver.findElements(By.xpath(tablexPath + "//tr//td[" + (i + 1) + "]"));
				System.out.println("Passed:coloumn list elements are found");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: Coloumn list elements are not found");
			}
			for (int j = 1; j < weColoumnList.size(); j++) {
				WebElement coloumnList = null;
				try {
					coloumnList = weColoumnList.get(j);
					System.out.println("Passed: coloumn element is found");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Failed:coloumn element is not found");
				}
				String coloumnListText = null;
				try {
					coloumnListText = coloumnList.getText();
					System.out.println("Failed:coloumn list text is found");
				} catch (Exception e) {
					System.out.println("Passed: coloumn list text is not found");

				}

				System.out.println(coloumnListText);
			}
			System.out.println("");
		}
	}

	/*
	 * This is the methods for getting coloumn name with the help of coloumn number
	 * it having three parameter first one is table xath and others are Elementname
	 * and coloumn name Writing table xPath is necessary because its all xPath are
	 * regarding to table some internal codes are writen in TablexPath second
	 * parameter Elementname is only for naming Third parameter is coloumnName in
	 * this parameter you will send the coloumn name for which you want to get
	 * coloumn number Finally it will return coloumn number
	 */
	public int getColoumnNumberByColoumnName(String TablexPath, String Elementname, String coloumnName) {
		List<WebElement> coloumnCountList = null;
		try {
			coloumnCountList = driver.findElements(By.xpath(TablexPath + "//tr[1]//td"));
			System.out.println("Passed:" + Elementname + " list found through" + coloumnName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + Elementname + " list not found");
		}
		int coloumnNumber = -1;
		for (int i = 0; i < coloumnCountList.size(); i++) {
			WebElement weColounmCount = null;
			try {
				weColounmCount = coloumnCountList.get(i);
				System.out.println("Passed: coloumn data is  got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed:coloumn data is not got");
			}
			String coloumnText = null;
			try {
				coloumnText = weColounmCount.getText();
				System.out.println("Passed:" + Elementname + " data Text is found");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed:" + Elementname + " data Text is not found");
			}
			if (coloumnText.equalsIgnoreCase(coloumnName) == true) {
				coloumnNumber = i;
				break;
			}
		}
		return coloumnNumber;

	}

	/*
	 * This is the method will give you RowDataList with the help of rowNumber.The
	 * method having three parameter The parameter is TablexPath, Element name,
	 * rowNumber. Writing table xPath is manadetory because it's all is regarding to
	 * table ,internaly some fixed adjcant code are written in table xPath and
	 * second argument is only for naming and third argument is for rowNumer from
	 * which helps we find rowdata list Finally it will return rowData list
	 */
	public List<String> getRowDataListByRowNumber(String TablexPath, String Elementname, int rowNumber) {
		List<WebElement> rowDataList = null;
		try {
			rowDataList = driver.findElements(By.xpath(TablexPath + "//tr[" + rowNumber + "]//td"));
			System.out.println("Passed:" + Elementname + " list found through" + rowNumber);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed:" + Elementname + " list not found");

		}
		List<String> rowlistObj = new ArrayList<>();
		for (int i = 1; i < rowDataList.size(); i++) {
			WebElement weRowCount = null;
			try {
				weRowCount = rowDataList.get(i);
				System.out.println("Passed:row Data is got");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed: row data isn't got");
			}
			String rowDataListText = null;
			try {
				rowDataListText = weRowCount.getText();
				System.out.println("Passed:" + Elementname + "text is found");
			} catch (Exception e) {
				e.printStackTrace();
			}
			rowlistObj.add(rowDataListText);

		}
		return rowlistObj;

	}
	public String screenShot(String testCaseName)  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	 DateFormat df= new SimpleDateFormat("dd mmm yyyy hh mm ss");
	   String dfs=    df.format(new Date());
	  File fl=  ts.getScreenshotAs(OutputType.FILE);
	        File flo=new File("E:\\Satyam\\vtigercrm.tdd\\test-output\\"+testCaseName+dfs+".png");
	        
	        try {
				Files.copy(fl, flo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String Filepath=flo.getAbsolutePath();
	        return Filepath;
	}
	public void verifyInnerText(WebElement we ,String expectedInnerText ) {
	String actualInnerText=	wt.findText(we);
	wt.verifyString( actualInnerText, expectedInnerText);
	 Assert.assertEquals(actualInnerText, expectedInnerText);
	}
	public void verifyAttributeValue(WebElement we, String attributeName,String expectedValue) {
  String actualValue=  wt.findAttribute(we, attributeName);
   wt.verifyString(actualValue, expectedValue);
   Assert.assertEquals(actualValue, expectedValue);
	}
   public void verifyUrl(String expectedUrl) {
	  String ActualUrl= wt.findCurrentUrl();
	  wt.verifyString(ActualUrl, expectedUrl);
	  Assert.assertEquals(ActualUrl, expectedUrl);
   }
   public void verifyTitle( String pageName,String expectedtitle) {
	String actualTitle=  wt.findTitle(pageName);
	wt.verifyString(actualTitle, expectedtitle);
	Assert.assertEquals(actualTitle, expectedtitle);
   
   }
   public void verifyEnable(WebElement we , String ElementName) {
	
	boolean be= we.isEnabled();
	   if(be==true) {
		   test.log(Status.PASS, "Passed: "+ ElementName+" element is enable");
		   System.out.println("Passed: "+ ElementName+" element is enable");
	   }else {
		   test.log(Status.FAIL, "Failed: "+ ElementName+" element is disable");
		   System.out.println(" Failed: "+ ElementName+" element is disable");
	   }
	   Assert.assertTrue(be);
   }
   public void verifyElementDisplayed(WebElement we, String elementName) {
	 boolean bl= we.isDisplayed();
	 if(bl==true) {
		 test.log(Status.PASS, "Passed:"+ elementName+" element is visible");
		 System.out.println("Passed:"+ elementName+" element is visible");
	 }else {
		 test.log(Status.FAIL, "Failed:"+ elementName+" element is visible");
		 System.out.println("Failed:"+ elementName+" element is visible");
	 }
	   Assert.assertTrue(bl);
	 
   }
   public void verifyDropDownValue(WebElement we,  String expectedSelectedOption ) {
	String actualselectOption= wt.findFirstSelectOption(we);
	wt.verifyString(actualselectOption, expectedSelectedOption);
	Assert.assertEquals(actualselectOption, expectedSelectedOption);
   }
   public void verifyPopupText(String expectedAlertText) {
	String actualAlertText=  wt.alertText(); 
	 wt.verifyString(actualAlertText, expectedAlertText);
	 Assert.assertEquals(actualAlertText, expectedAlertText);
   }
   public   void loadProperties(String fileName) {
	   FileInputStream fis=null;
	 try {
		 fis=new FileInputStream("src\\main\\resources\\"+fileName+".properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	 prop= new Properties();
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   
   }
   public String getPropertyData(String keyName) {
	  String data= prop.getProperty(keyName);
	  return data; 
   }
 
}
