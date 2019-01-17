import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.*
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable
public class CompassUIElements {

	@Keyword
	public static void selectListBox(TestObject to,String data){

		if(data.equalsIgnoreCase(""))
			return
		waitCompassLoad()
		WebUI.waitForElementClickable(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(to)
		TestObject tox = new TestObject().addProperty('xpath', ConditionType.EQUALS,
				"//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"')]",true)
		WebUI.waitForElementVisible(tox, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementClickable(tox, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(tox)
	}
	@Keyword
	public static void waitCompassLoad(){
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/Spinner'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/PageLoad'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/PageLoadingText'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
	}
	@Keyword
	public static void clickButton(TestObject to){
		waitCompassLoad()
		WebUI.click(to)
	}
	@Keyword
	public static String executeJavaScript(TestObject to,String javascript) {
		waitCompassLoad()
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element;
		JavascriptExecutor executor;
		executor = ((driver) as JavascriptExecutor);
		element = WebUiCommonHelper.findWebElement(to, 2);
		String text = executor.executeScript('return arguments[0].innerText;', element);
		return text.toString()
	}
	@Keyword
	public static void selectMultiList(){
	}
	@Keyword
	public static boolean checkButtonEnable(TestObject to){
		WebUI.verifyElementClickable(to)
	}

	@Keyword
	public static void productCostTableItemsDelete(){
		int count=countAllDeleteButtons("//product-costing/div/div[3]/div//div[@class='scrollable ng-star-inserted']//div[@class='delete-cell pointer'][1]")
		WebDriver driver = DriverFactory.getWebDriver()
		for(int i=1;i<=count;i++){
			driver.findElement(By.xpath("//product-costing/div/div[3]/div//div[@class='scrollable ng-star-inserted'][1]//div[@class='delete-cell pointer'][1]")).click()
			WebUI.delay(1)
		}
	}
	@Keyword
	public static int countAllDeleteButtons(String to) {

		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> ele=driver.findElements(By.xpath(to))
		int rowcount=ele.size()
		println "size "+rowcount
		return rowcount
	}
	@Keyword
	public static void kendoMultiSelectList(TestObject to, String item){
		String[] allItems = item.split(GlobalVariable.multivalueseperator)
		for(String data:allItems){
			waitCompassLoad()
			//check if its already exist
			TestObject itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//li/span[contains(.,'"+data+"')]")
			boolean isSelected = true
			try{

				isSelected = WebUI.waitForElementVisible(itemObj,1)

			}
			catch(Exception e){
				isSelected = false
			}
			if(!isSelected)
			{
				WebUI.waitForElementVisible(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementClickable(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.click(to)
				itemObj = General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"')]")
				WebUI.waitForElementVisible(itemObj, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementClickable(itemObj, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.click(itemObj)
			}
		}
	}
	@Keyword
	public static void kendoDeleteMultiSelectItem(String item){
		String[] allItems = item.split(GlobalVariable.multivalueseperator)
		for(String data:allItems){
			waitCompassLoad()
			TestObject itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//span[contains(.,'"+data+"')]/following-sibling::span/span[@class='k-icon k-i-close']")
			WebUI.click(itemObj)
		}

	}
	@Keyword
	public static void kendoChartWidgetClose(String chartDisplayName){
		String[] allItems = chartDisplayName.split(GlobalVariable.multivalueseperator)
		TestObject obj,itemObj;
		for(String data:allItems){
			waitCompassLoad()
			if((!data.equalsIgnoreCase("events")))
				obj= General.createObject("//*[contains(.,'"+data+"') and ancestor::*[name()='kendo-chart']]//ancestor::*[name()='kendo-chart']/preceding-sibling::span")
			else if(data.equalsIgnoreCase("events"))
				obj = General.createObject("//th[contains(.,'Event ID')]//ancestor::*[name()='kendo-grid']/preceding-sibling::span")
			if(checkElementVisible(obj, 5)){
				WebUI.click(obj)
				waitCompassLoad()
				itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//li/span[contains(.,'"+data+"')]")
				if(checkElementVisible(itemObj, 5)){
					KeywordUtil.markFailed("Though the widget "+data+" is remove, it is still showing up in the add sections list")
				}
			}
		}
	}
	@Keyword
	public static void kendoVerifyChartVisible(String chartName){
		String[] allCharts = chartName.split(GlobalVariable.multivalueseperator)
		for(String data:allCharts){
			waitCompassLoad()
			//check if its already exist
			TestObject itemObj = General.createObject("//*[contains(.,'"+data+"') and ancestor::*[name()='kendo-chart']]//ancestor::*[name()='kendo-chart']")
			boolean isVisible = true
			try{

				isVisible = WebUI.waitForElementVisible(itemObj,5)

			}
			catch(Exception e){
				isVisible = false
			}
			if(!isVisible)
			{
				KeywordUtil.markPassed("The chart with name "+data+" is not visible")
			}
		}
	}
	@Keyword
	public static void verifyElementData(TestObject to,String value){
		waitCompassLoad()
		String[] allData = value.split(GlobalVariable.multivalueseperator)
		for(String data:allData){
			WebUI.verifyElementVisible(to)
			WebUI.verifyElementText(to, data, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
	@Keyword
	public static boolean checkElementVisible(TestObject to,int timeOut){
		boolean isVisible = false
		try{
			isVisible = WebUI.waitForElementVisible(to, timeOut)
		}
		catch(Exception e){
			isVisible = false
		}
		return isVisible
	}

	@Keyword
	public static int countAllCheckboxes(String to)
	{
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> ele=driver.findElements(By.xpath(to))
		int rowcount=ele.size()
		return rowcount
	}

	@Keyword
	public static void checkAllCheckboxes(int size)
	{
		for(int rownumber=1;rownumber<=size;rownumber++){

			TestObject to=General.createObject("//div[@id='k-tabstrip-tabpanel-0']//kendo-grid-list//tbody/tr["+rownumber+"]/td[1]")
			WebUI.click(to)
		}
	}
	@Keyword
	public static void clickBasePlanningQMW(String data){
		waitCompassLoad()
		TestObject t=General.createObject(findTestObject("//div[@id='k-tabstrip-tabpanel-1']/div/div/div/div/span[contains(text(),'"+data+"')]"),data)
		WebUI.click(t)
		println 'month button is'+t
	}
	//click on create view button in account planner page
	@Keyword
	public static void clickCreateViewbtn(String data)
	{
		if(data.equalsIgnoreCase('create_view'))
			WebUI.verifyElementText(findTestObject("//button[contains(text(),'"+data+"')]"), data)
	}
	//set text in input field box
	@Keyword
	public static void setText(TestObject to,String text){
		WebUI.setText(to, text)
	}
	@Keyword
	public static String kendoGridOperation(TestObject tblObj,String rowNo,String column,String operation,String data){
		String tblXPath = (tblObj.findPropertyValue("xpath")+"//table").toString()
		WebDriver driver = DriverFactory.getWebDriver()
		waitCompassLoad()
		if(rowNo.equalsIgnoreCase("all")){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))
			boolean isChecked;
			for(int i=1;i<rows.size()-1;i++){
				String tblXPath1 = tblXPath+"//tr["+i+"]/td["+column+"]";
				kendoGridCellOperation(tblXPath1,operation,data)
			}
			println "test"
		}
		else if(rowNo.contains(":")){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))

			String[] rowFrom = rowNo.split(":")
			for(int i=Integer.valueOf(rowFrom[0]);i<=Integer.valueOf(rowFrom[(rowFrom.length)-1]);i++){
				//WebUI.click(General.createObject(tblXPath+"//tr["+i+"]/td["+column+"]"))
				tblXPath = tblXPath+"//tr["+i+"]/td["+column+"]"
				kendoGridCellOperation(tblXPath,operation,data)
			}
		}
		else if(rowNo.contains(GlobalVariable.multivalueseperator)){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))

			String[] rowFrom = rowNo.split(GlobalVariable.multivalueseperator)
			for(int i=0;i<rowFrom.length;i++){
				//WebUI.click(General.createObject(tblXPath+"//tr["+rowFrom[i]+"]/td["+column+"]"))
				tblXPath =tblXPath+"//tr["+i+"]/td["+column+"]"
				kendoGridCellOperation(tblXPath,operation,data)
			}
		}
		else{
			tblXPath = tblXPath+"//tr["+rowNo+"]/td["+column+"]";
			kendoGridCellOperation(tblXPath,operation,data)
		}
		//WebUI.click(General.createObject(tblXPath+"//tr["+Integer.valueOf(rowNo)+"]/td["+column+"]"))
	}

	@Keyword
	public static String kendoGridCellOperation(String tblXPath1,String operation,String data){
		boolean isChecked = false;
		String tblObj1;
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor executor;
		WebElement element;
		executor = ((driver) as JavascriptExecutor)
		if(operation.equalsIgnoreCase("check"))
		{
			tblObj1 = tblXPath1;
			element = WebUiCommonHelper.findWebElement(General.createObject(tblObj1), 10)
			if(checkElementVisible(General.createObject(tblObj1), 2)){
				isChecked = WebUI.getAttribute(General.createObject(tblObj1), "checked");
				if(!isChecked)
					executor.executeScript("arguments[0].click();",element)
			}
		}
		else if(operation.equalsIgnoreCase("set"))
		{
			tblObj1 = tblXPath1+"//input";
			element = WebUiCommonHelper.findWebElement(General.createObject(tblObj1), 10)
			if(checkElementVisible(General.createObject(tblObj1), 2)){
				executor.executeScript("arguments[0].value='"+data+"';",element)
			}
		}
		else if(operation.equalsIgnoreCase("get"))
		{
			tblObj1 = tblXPath1+"//input";
			element = WebUiCommonHelper.findWebElement(General.createObject(tblObj1), 10)
			String stext=executor.executeScript("return arguments[0].innerText;",element).toString()
			print 'stext'

		}
		else if(operation.equalsIgnoreCase("list"))
		{
			if(data.contains("\$")){
				data = data.replace("\$","\$");
			}
			tblObj1 = tblXPath1 + "//Select" // "//table/tbody/tr[1]/td//Select/option[contains(text(),'"+data+"')]"
			element = WebUiCommonHelper.findWebElement(General.createObject(tblObj1), 10)
			//element.click();
			if(checkElementVisible(General.createObject(tblObj1), 2)){
				executor.executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } };",element,data)
			}
		}
	}
	@Keyword
	public static void kendoGridSelectCheckBox(TestObject tblObj,String rowNo,String column){
		//TestObject tblObj,String rowNo,int column,String operation,String data
		kendoGridOperation(tblObj,rowNo,column,"check","")
	}
	@Keyword
	public static void kendoGridSelectCheckBox(TestObject tblObj,String rowNo,int column){
		//TestObject tblObj,String rowNo,int column,String operation,String data
		kendoGridOperation(tblObj,rowNo,column.toString(),"check","")
	}
	@Keyword
	public static void kendoGridEnterTextBox(TestObject tblObj,String rowNo,String column,String data){
		//TestObject tblObj,String rowNo,int column,String operation,String data
		kendoGridOperation(tblObj,rowNo,column,"set",data)
	}
	@Keyword
	public static void KendoGridSortTableData(TestObject tblObj,String column,String rowNo,String data){
		kendoGridOperation(tblObj,rowNo,column,"","get","")
	}
	@Keyword
	public static void kendoGridSelectListBox(TestObject tblObj,String rowNo,String column,String data){
		kendoGridOperation(tblObj,rowNo,column,"list",data)
	}
	@Keyword
	public static BuildTableColumns(TestObject tb){
		waitCompassLoad()
		//get the columns and indexs into a Map
		def baseXPath = tb.findPropertyValue("xpath")+"/div/div"
		tb.addProperty("xpath", ConditionType.EQUALS, baseXPath) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
		ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
		def columnsIndexes = [:]
		int index = 0
		def column = ""
		TestObject twe;

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement element;
		JavascriptExecutor executor;
		for(WebElement we:wes){

			twe = tb.addProperty("xpath",ConditionType.EQUALS,baseXPath+"["+String.valueOf((Integer.valueOf(index)+1))+"]")
			element = WebUiCommonHelper.findWebElement(twe, 10)
			executor = ((driver) as JavascriptExecutor)
			column = executor.executeScript('return arguments[0].innerText;', element).toString()
			//column = new General().runJS(twe,"return arguments[0].innerText;", 20).toString() //we.getAttribute("innerText").trim()//we.getText().trim()
			if((column.equalsIgnoreCase(""))||(column.equalsIgnoreCase(" ")))
				column = "column"+index
			columnsIndexes.put(column,index)
			index++
		}
		return columnsIndexes
	}
	@Keyword
	public static void  EnterValueInTableCell(TestObject tb, String rowNo,String column,String data){
		waitCompassLoad()
		if((data.equalsIgnoreCase(""))||(data.equalsIgnoreCase("<null>")))
			return

		println "In COlumn "+column

		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1

		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
		}

		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//input")

		WebUI.click(tbd)

		WebUI.setText(tbd, data)
	}
	@Keyword
	public static void EnterDateInTableCell(TestObject tb,String rowNo,String column,String date){
		waitCompassLoad()
		if((date.equalsIgnoreCase(""))||(date.equalsIgnoreCase("<null>")))
			return

		println "In COlumn "+column

		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf((columns.get(column.toString()))+1)

		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 2)
			rowNo = wes.size
		}

		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//span[@class='k-icon k-i-calendar']")

		WebUI.click(tbd)

		String[] dates = date.split("/")

		def monthEx = dates[0]

		String monthString = """//kendo-calendar//span[(text() = '
					${monthEx}
				' or . = '
					${monthEx}
				')]"""

		WebUI.delay(1)

		TestObject calMonth = new General().createObject(monthString)

		WebUI.click(calMonth)

		WebUI.delay(4)

		println "Clicked Month"

		def monthName = new General().FormatDate(date, "MMM/dd/yyyy", "EEEE, MMMM dd, yyyy")

		TestObject da = new General().createObject("//kendo-calendar//table/tbody/tr/td[contains(@title, '${monthName}')]/span")

		WebUI.click(da)

	}
	@Keyword
	public static void kendoGridEnterTextInCell(String rowNo,int column,String data){

	}
	@Keyword
	public static String kendoGridGetTextInCell(String rowNo,int column){

	}
	@Keyword
	public static kendoDialogBoxHandler(String isDisplayed,String verifyText,String ppgname,String ppgtype,String buttonToClick) {
		waitCompassLoad()
		TestObject tb = General.createObject("//kendo-dialog")

		String dialog_pls_confirm = tb.findPropertyValue("xpath")

		String tb1 = ""

		ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 20)

		println "For loop"

		int index = 1

		for(WebElement we:wes) {
			if(we.isDisplayed()){
				tb1 = "("+dialog_pls_confirm+")["+index+"]"
				break;
			}
			index++
		}

		if((tb1.equalsIgnoreCase(""))&&(isDisplayed.equalsIgnoreCase("true")))
			KeywordUtil.markFailedAndStop("Dialog box is not displayed")
		else if((!tb1.equalsIgnoreCase("")) && (isDisplayed.equalsIgnoreCase("false")))
			KeywordUtil.markFailedAndStop("Dialog box is displayed")
		//verify the text message

		if(tb1.equalsIgnoreCase(""))
			return

		String messagePath = tb1+"//kendo-dialog-titlebar/following-sibling::div[@class='k-content k-window-content k-dialog-content']"

		TestObject messObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,messagePath)

		if(!verifyText.equalsIgnoreCase("")){
			if(!WebUI.getText(messObj).toLowerCase().contains(verifyText.toLowerCase()))
				KeywordUtil.markFailed("Dialog box text is not matched")
			else if(verifyText.equalsIgnoreCase("Version Name:"))
			{
				WebUI.delay(8)
				println "delay"
				TestObject to=General.createObject("/html/body/app-root/div/div[1]/div/accounts-planner/kendo-dialog[5]/div[2]/div/div[1]/b")
				WebUI.click(to)
				TestObject to1=General.createObject("//div/input[@name='version' and @id='ppg']/following-sibling::label[contains(.,'"+ppgtype+"')]")
				WebUI.delay(5)
				RobotX.RoboKeyPressSpecial("<tab>")
				RobotX.RoboKeyPressSpecial("<tab>")
				General.robotEnterString(ppgname)
				/*//WebUI.click(findTestObject("Object Repository/Compass/AccountPlaner/txt_version_save"))
				 WebUI.setText(findTestObject("Object Repository/Compass/AccountPlaner/txt_version_save"),ppgname)
				 */
				WebUI.click(to1)
			}
		}
		String buttonPath = tb1+"//kendo-dialog-titlebar/following-sibling::kendo-dialog-actions//button[contains(.,"+buttonToClick+")]"

		TestObject buttonObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,buttonPath)

		WebUI.click(buttonObj)
	}
	@Keyword
	public static void SelectValueInTableCell(TestObject tb,String rowNo,String column,String data){

		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1

		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.addProperty("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
		}

		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//span[@class='k-i-arrow-s k-icon']")

		CompassUIElements.selectListBox(tbd, data)
	}
	@Keyword
	public static void GetValueInTablecell(TestObject tb,String rowNo,String column){
		def columns = [:]

		columns = BuildTableColumns(tb)

		def colNo = Integer.valueOf(columns.get(column.toString()))+1

		if((rowNo.equalsIgnoreCase(""))||(rowNo.equalsIgnoreCase("<null>"))){
			def rowCount = tb.findPropertyValue("xpath")+"/following-sibling::div/div/div"
			tb.getProperties("xpath", ConditionType.EQUALS, rowCount) //"//kendo-tabstrip/div[1]/product-costing[@class='ng-star-inserted']/div[1]/div[@class='no-right header-panel']/div/div")
			ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 0)
			rowNo = wes.size
			TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"/following-sibling::div/div/div["+rowNo+"]/div/div["+String.valueOf(colNo)+"]//span[@class='k-i-arrow-s k-icon']")

		}

	}
	public static void checkItemInMultiSelectBox(TestObject to,String item)
	{
		waitCompassLoad()
		String toObject = to.findPropertyValue("xpath");
		String[] items = item.split(GlobalVariable.multivalueseperator);
		TestObject itemInList;

		for(String data:items){
			WebUI.setText(to, data)



			itemInList = General.createObject(toObject+"//ancestor::dropdown-filterable//label[text()='"+data+"']");
			if(checkElementVisible(itemInList, 5)){
				WebUI.click(itemInList);
			}
			else
				KeywordUtil.markFailed("Items "+data+" does not exists in the list of values to check");
		}
	}
	//Kendo button list
	@Keyword
	public static void selectKendoButtonList(String data)
	{
		waitCompassLoad()
		TestObject to=General.createObject("//kendo-popup//kendo-button-list/ul//li[contains(.,'"+data+"')]")
		WebUI.click(to)
	}
	@Keyword
	public static void kendoGetText(TestObject to, String value){
		kendoVerifyText(to,value,"true")
		/*		waitCompassLoad()
		 String actual=WebUI.getText(to)
		 if(actual.equalsIgnoreCase(value)){
		 println 'text value is equal'+actual
		 }else{
		 println 'text is not equal'
		 }*/

	}
	@Keyword
	public static void kendoVerifyText(TestObject to, String value,String doMatch){
		waitCompassLoad()
		String actual=WebUI.getText(to)
		println "actaul value"+  actual
		println "actaul value"+  value
		if((!actual.equalsIgnoreCase(value)) && (doMatch.equalsIgnoreCase("true"))){
			KeywordUtil.markFailed("Values do not match expected is "+value+" actual is "+actual);
		}else{
			println 'text is equal'
		}

	}
	@Keyword
	public static boolean isElementPresent(TestObject to,int timeOut){
		try{
			WebUI.verifyElementPresent(to, timeOut);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@Keyword
	public static boolean isElementAttributeExists(TestObject to,String attribute,int timeOut){
		try{
			boolean isExists = WebUI.verifyElementHasAttribute(to, attribute, timeOut);
			return true;
		}
		catch(Exception e){
			return false
		}
	}
	@Keyword
	public static void kendoEnterText(TestObject to,String value){
		value = General.evalString(value);
		if(checkElementVisible(to))
			WebUI.setText(to,value);
	}
}
