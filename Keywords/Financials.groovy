import org.apache.xmlbeans.impl.store.Locale.domNthCache
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Financials {

	/*
	 * Click the tabs 
	 * i.e Financials,Planned Funds,Approved Funds
	 */

	@Keyword
	public static void clickTabsInFinancials(String data){
		TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li[contains(.,'"+data+"')]/span[@class='k-link']")
		CompassUIElements.clickButton(itemObj)
		CompassUIElements.waitCompassLoad()
	}

	/*
	 *
	 * This method verify the Quarter Column's total in the financial Tab
	 * 
	 * to- Test object to click Quarter Button
	 */

	@Keyword
	public static void verifyFinancialQuarterAmt(TestObject to){

		def headers = to.findPropertyValue("xpath")+"/div[1]"
		TestObject tblHeaders=to.addProperty("xpath", ConditionType.EQUALS, headers)
		List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(tblHeaders, 10)
		for(int i=1;i<=tableHeaders.size();i++){
			def header = to.findPropertyValue("xpath")+"["+i+"]/div[2]"
			TestObject colTotal=to.addProperty("xpath", ConditionType.EQUALS, header)

			WebDriver driver2 =  DriverFactory.getWebDriver()
			WebElement colValue=WebUiCommonHelper.findWebElement(colTotal, 0)
			JavascriptExecutor executor2 = (JavascriptExecutor) driver2
			String total = executor2.executeScript("return arguments[0].innerHTML;",colValue)
			total=total.replace("\$","")
			total=total.replace(",","")
			total=total.replace("(","")
			total=total.replace(")","")
			total=total.trim()
			if (i==10) {
				WebDriver driver =  DriverFactory.getWebDriver()
				def col10=to.findPropertyValue("xpath")+"["+i+"]/div[1]"
				TestObject tblHeaders10=to.addProperty("xpath", ConditionType.EQUALS, col10)

				WebElement element= WebUiCommonHelper.findWebElement(tblHeaders10,0)
				JavascriptExecutor executor = (JavascriptExecutor) driver
				executor.executeScript("arguments[0].click();", element);
			}


			int columnTotal=0;
			for(int j=1;j<=4;j++){
				TestObject columndata = General.createObject("//div[@id='vBasePlnDataGridNoMonths']/div[@class='scrollable']/div["+i+"]/div["+j+"]/div")
				String amt=WebUiCommonHelper.findWebElement(columndata, 0).getText()
				/*amt = amt.replace("\$","")
				 amt = amt.replace("(","")
				 amt = amt.replace(")","")
				 amt = amt.replace(",","")
				 amt = amt.trim()*/

				if (amt.startsWith("\$(")) {
					amt=amt.replace("\$", "").replace(")", "").replace("(", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal-Integer.parseInt(amt)
				}else if(amt.startsWith("\$")){
					amt=amt.replace("\$", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}else{
					amt=amt.replace(',', '').trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}
			}
			if (columnTotal==Integer.parseInt(total)) {
				println "Total is equal    "+i+"   "+total+"    "+columnTotal
			}else{
				//KeywordUtil.markFailed("Total Mismatched  "+i     +total+"  Column total is "+columnTotal)
				KeywordUtil.markError("Total Mismatched  "+i     +total+"  Column total is "+columnTotal)
			}
		}
	}

	/* 
	 * This method verify the Month's Column's total in the financial Tab
	 *
	 *to- Test object to click Month Button
	 */

	@Keyword
	public static void verifyFinancialMonthAmt(TestObject to){

		def headers = to.findPropertyValue("xpath")+"/div[2]"
		TestObject tblHeaders=to.addProperty("xpath", ConditionType.EQUALS, headers)
		List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(tblHeaders, 10)
		for(int i=1;i<=tableHeaders.size();i++){
			def header = to.findPropertyValue("xpath")+"["+i+"]/div[2]"
			TestObject colTotal=to.addProperty("xpath", ConditionType.EQUALS, header)

			WebDriver driver2 =  DriverFactory.getWebDriver()
			WebElement colValue=WebUiCommonHelper.findWebElement(colTotal, 0)
			JavascriptExecutor executor2 = (JavascriptExecutor) driver2
			String total = executor2.executeScript("return arguments[0].innerHTML;",colValue)
			total=total.replace("\$","")
			total=total.replace(",","")
			total=total.replace("(","")
			total=total.replace(")","")
			total=total.trim()
			if (i==10) {
				WebDriver driver =  DriverFactory.getWebDriver()
				def col10=to.findPropertyValue("xpath")+"["+i+"]/div[1]"
				TestObject tblHeaders10=to.addProperty("xpath", ConditionType.EQUALS, col10)

				WebElement element= WebUiCommonHelper.findWebElement(tblHeaders10,0)
				JavascriptExecutor executor = (JavascriptExecutor) driver
				executor.executeScript("arguments[0].click();", element);
			}
			int columnTotal=0;
			for(int j=1;j<=12;j++){
				TestObject columndata = General.createObject("//div[@id='vBasePlnDataGridNoWeeks']/div/div["+i+"]/div["+j+"]/div")
				String amt=WebUiCommonHelper.findWebElement(columndata, 0).getText()

				if (amt.startsWith("\$(")) {
					amt=amt.replaceAll("\$", "").replace(")", "").replace("(", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal-Integer.parseInt(amt)
				}else if(amt.startsWith("\$")){
					amt=amt.replaceAll("\$", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}else{
					amt=amt.replaceAll(',', '').trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}
			}
			if (columnTotal==Integer.parseInt(total)) {
				println "Total is equal    "+i+"     "+total+"    "+columnTotal
			}else{
				//KeywordUtil.markFailed("Total Mismatched  "+i     +total+"  Column total is "+columnTotal)
				KeywordUtil.markError("Total Mismatched  "+i+"   "+total+"  Column total is "+columnTotal)
			}
		}
	}

	/*
	 * This method verify the Month's Column's total in the financial Tab
	 *
	 *to- Test object to click Month Button
	 */

	@Keyword
	public static void verifyFinancialWeekAmt(TestObject to){

		def headers = to.findPropertyValue("xpath")+"/div[2]"
		TestObject tblHeaders=to.addProperty("xpath", ConditionType.EQUALS, headers)
		List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(tblHeaders, 10)
		for(int i=1;i<=tableHeaders.size();i++){
			def header = to.findPropertyValue("xpath")+"["+i+"]/div[2]"
			TestObject colTotal=to.addProperty("xpath", ConditionType.EQUALS, header)

			WebDriver driver2 =  DriverFactory.getWebDriver()
			WebElement colValue=WebUiCommonHelper.findWebElement(colTotal, 0)
			JavascriptExecutor executor2 = (JavascriptExecutor) driver2
			String total = executor2.executeScript("return arguments[0].innerHTML;",colValue)
			total=total.replace("\$","")
			total=total.replace(",","")
			total=total.replace("(","")
			total=total.replace(")","")
			total=total.trim()
			if (i==10) {
				WebDriver driver =  DriverFactory.getWebDriver()
				def col10=to.findPropertyValue("xpath")+"["+i+"]/div[1]"
				TestObject tblHeaders10=to.addProperty("xpath", ConditionType.EQUALS, col10)

				WebElement element= WebUiCommonHelper.findWebElement(tblHeaders10,0)
				JavascriptExecutor executor = (JavascriptExecutor) driver
				executor.executeScript("arguments[0].click();", element);
			}
			int columnTotal=0;
			for(int j=1;j<=52;j++){
				TestObject columndata = General.createObject("//div[@id='vBasePlnDataGrid']/div/div["+i+"]/div["+j+"]/div")
				String amt=WebUiCommonHelper.findWebElement(columndata, 0).getText()

				if (amt.startsWith("\$(")) {
					amt=amt.replaceAll("\$", "").replace(")", "").replace("(", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal-Integer.parseInt(amt)
				}else if(amt.startsWith("\$")){
					amt=amt.replaceAll("\$", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}else{
					amt=amt.replaceAll(',', '').trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}
			}
			if (columnTotal==Integer.parseInt(total)) {
				println "Total is equal    "+i+"     "+total+"    "+columnTotal
			}else{
				//KeywordUtil.markFailed("Total Mismatched  "+i     +total+"  Column total is "+columnTotal)
				KeywordUtil.markError("Total Mismatched  "+i+"   "+total+"  Column total is "+columnTotal)
			}
		}
	}
	@Keyword
	public static void verifyEditColumnsDataInWeekTab(TestObject to,int col1,int col2){

		/*def headers = to.findPropertyValue("xpath")+"/div[2]"
		 TestObject tblHeaders=to.addProperty("xpath", ConditionType.EQUALS, headers)
		 List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(tblHeaders, 10)*/
		for(int i=col1;i<col2;i++){
			def header = to.findPropertyValue("xpath")+"["+i+"]/div[2]"
			TestObject colTotal=to.addProperty("xpath", ConditionType.EQUALS, header)

			WebDriver driver2 =  DriverFactory.getWebDriver()
			WebElement colValue=WebUiCommonHelper.findWebElement(colTotal, 0)
			JavascriptExecutor executor2 = (JavascriptExecutor) driver2
			String total = executor2.executeScript("return arguments[0].innerHTML;",colValue)
			total=total.replace("\$","")
			total=total.replace(",","")
			total=total.replace("(","")
			total=total.replace(")","")
			total=total.trim()

			int columnTotal=0;
			TestObject columndata;
			for(int j=1;j<=52;j++){
				executor2 = (JavascriptExecutor) driver2
				String amt = "";
				if (i>col1) {
					columndata = General.createObject("//div[@id='vBasePlnDataGrid']/div/div["+i+"]/div["+j+"]/div/kendo-numerictextbox//input[@role='spinbutton']")
					WebElement colValue2=WebUiCommonHelper.findWebElement(columndata, 0)
					amt = executor2.executeScript("return arguments[0].getAttribute('aria-valuenow');",colValue2)
				}else{
					columndata = General.createObject("//div[@id='vBasePlnDataGrid']/div/div["+i+"]/div["+j+"]/div")
					WebElement colValue2=WebUiCommonHelper.findWebElement(columndata, 0)
					amt = executor2.executeScript("return arguments[0].innerText;",colValue2)
				}
				if (amt.startsWith("\$(")) {
					amt=amt.replaceAll("\$", "").replace(")", "").replace("(", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal-Integer.parseInt(amt)
				}else if(amt.startsWith("\$")){
					amt=amt.replaceAll("\$", "").replace(',', '').substring(1).trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}else{
					amt=amt.replace(',', '').trim()
					columnTotal=columnTotal+Integer.parseInt(amt)
				}
			}
			if (columnTotal==Integer.parseInt(total)) {
				println "Total is equal    "+i+"     "+total+"    "+columnTotal
			}else{
				//KeywordUtil.markFailed("Total Mismatched  "+i     +total+"  Column total is "+columnTotal)
				KeywordUtil.markError("Total Mismatched  "+i+"   "+total+"  Column total is "+columnTotal)
			}
		}
	}
	/*
	 * row- 1- Annual
	 * 		2-Quartely
	 * 		3- Monthly
	 * 		4- Weekly
	 */
	@Keyword
	public static void selectDateRange(int row){
		TestObject itemObj = General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li["+row+"]")
		CompassUIElements.clickButton(itemObj)
	}

	@Keyword
	public static void modifyFianacialsWriteOffAmount(int row){
		//Write Off Manual
		CompassUIElements.setText(findTestObject('Object Repository/Compass/Financials/input_write_off_manual'),"1")

		//Write Off Auto
		CompassUIElements.setText(findTestObject('Object Repository/Compass/Financials/input_write_off_auto'),"1")

		//Write Off Tolerance
		CompassUIElements.setText(findTestObject('Object Repository/Compass/Financials/input_write_off_tolerance'),"1")

		//Select Date Range dropdown btn
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/Financials/ddb_select_date_range'))

		WebUI.delay(3)
		//Select Date Rangesec
		selectDateRange(row)

		//Click Apply
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/Financials/btn_apply'))

		CompassUIElements.waitCompassLoad()
	}

	@Keyword
	public static void scrollToElement(TestObject to){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element= WebUiCommonHelper.findWebElement(to,0)
		Actions actions=new Actions(driver)
		actions.moveToElement(element)
		//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	@Keyword
	public static void clickEditWriteBtn(TestObject to){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element= WebUiCommonHelper.findWebElement(to,0)
		JavascriptExecutor executor = (JavascriptExecutor) driver
		executor.executeScript("arguments[0].click();", element);
	}

	@Keyword
	public static void clickSaveBtn(TestObject to){
		CompassUIElements.clickButton(to)
		CompassUIElements.waitCompassLoad()
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/Financials/btn_save_ok'))
		WebUI.delay(4)
	}
}
