package com.eva.vtiger.pages.SalesAccountCodes;

import java.util.List;
import java.util.Random;

import com.eva.vtiger.pages.genericScript.WebUtil;

import net.bytebuddy.utility.RandomString;

public class SalesAccountCreatePage extends SalesAccountCreatePageOr {
  private  WebUtil wt;
	public SalesAccountCreatePage(WebUtil wu) {
		super(wu);
		this.wt=wu;
		
	}

	public void fillAccountInformation(List<String> strData) {
	String rand=wt.randomword(3);	
	wt.sendKeys(salesAccountNameTB, strData.get(0)+rand);
	wt.sendKeys(salesAccountPhoneTB, strData.get(1)+rand);
	wt.sendKeys(salesEmailTB, strData.get(2)+rand);
}
}
