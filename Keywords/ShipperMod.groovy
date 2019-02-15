import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ShipperMod {


	@Keyword
	public static void selectShippeMod(String str){
		CompassUIElements.setText(findTestObject("Object Repository/Compass/ShipperMod/inpt_shipper_mod"), str)
		WebUI.delay(2)
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/ddb_shipper_mod'))
		CompassUIElements.waitCompassLoad()
	}
	@Keyword
	public static void clickCreateEvent(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/btn_createevent'))
		CompassUIElements.waitCompassLoad()
	}
	/*
	 * @promo
	 * enter the promo value
	 */
	@Keyword
	public static String createEvent(String promo){
		String date=General.evalString("{date.0.MMM/dd/yyyy}")
		AccountPlanner.enterStartAndEndDate(findTestObject('Object Repository/Compass/AccountPlaner/btn_eventdatepicker'), "Execution Start Date", date)

		WebUI.delay(2)

		CustomKeywords.'AccountPlanner.enterStartAndEndDate'(findTestObject('Object Repository/Compass/AccountPlaner/btn_eventdatepicker'), "Execution End Date", date)

		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/txt_promosrp'))

		WebUI.delay(2)

		CustomKeywords.'CompassUIElements.setText'(findTestObject('Object Repository/Compass/AccountPlaner/txt_promosrp'), promo)

		CustomKeywords.'AccountPlanner.clickCreationEventSaveBtn'()

		WebUI.delay(5)

		CustomKeywords.'AccountPlanner.verifyEventPPGCreationInfo'(findTestObject('Object Repository/Compass/AccountPlaner/txt_infomsg'), "event is saved")

		String eventNo=WebUI.getText(findTestObject('Object Repository/Compass/AccountPlaner/txt_infomsg')).split(" ")[0]

		CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/AccountPlaner/btn_ok'))

		return eventNo
	}
	/*
	 * This method clicks the View Events
	 */
	@Keyword
	public static void clickViewEventsBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/btn_viewevents'))
		CompassUIElements.waitCompassLoad()
	}
	/*
	 * @event
	 * Event name to verify event creation
	 */
	@Keyword
	public static void verifyEventCreation(String event){
		TestObject itemObj = General.createObject("//kendo-grid/div/div[@role='presentation']//table[@role='presentation']/thead[@role='presentation']/tr[2]/td[1]//kendo-grid-filter-wrapper-cell[@class='k-filtercell-wrapper']/input")
		CompassUIElements.setText(itemObj, event)

		TestObject itemObj1 = General.createObject("//kendo-grid-list[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr/td[1]//a")
		CompassUIElements.kendoGetText(itemObj1, event)
	}
	/*
	 * This method clicks the export to excel button
	 */
	@Keyword
	public static void clickExportToExcel(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/btn_exporttoexcel'))
		CompassUIElements.waitCompassLoad()
	}

	@Keyword
	public static void verifyExport(){
	}

	@Keyword
	public static void selectPPG(String data){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/ddb_select_ppg'))
		CompassUIElements.waitCompassLoad()
		TestObject to = General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"']")
		CompassUIElements.clickButton(to)
	}

	@Keyword
	public static void selectPlan(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/ddb_select_plans'))
		for(int i=1;i<=4;i++){
			TestObject to = General.createObject("//div[@class='options-container']/div[1]/div[2]/dropdown-filterable[@placeholder='Select Plans']//div["+i+"]/label[@class='k-form-field']/label[@class='k-checkbox-label']")
			CompassUIElements.clickButton(to)
		}
	}
	@Keyword
	public static void selectFields(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/ddb_select_fields'))
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> select_fields=driver.findElements(By.xpath(findTestObject('Object Repository/Compass/ShipperMod/ddb_selectfields_list')))
		for(int i=2;i<=select_fields.size();i++){
			select_fields.get(i).click()
		}
	}

	@Keyword
	public static void selectRange(String str){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/ShipperMod/ddb_select_range'))
		TestObject to = General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+str+"')]")
		CompassUIElements.clickButton(to)
	}

	@Keyword
	public static void clickComparePlan(){
		TestObject to = General.createObject(findTestObject('Object Repository/Compass/ShipperMod/btn_compareplans'))
		CompassUIElements.clickButton(to)
		CompassUIElements.waitCompassLoad()
	}

	@Keyword
	public static void verifyDataInGridLayout(){
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> gridLayout=driver.findElements(By.xpath(findTestObject('Object Repository/Compass/ShipperMod/tbl_gridlayout')))
		if(gridLayout.size()>0){
			println'Data in grid form'
		}else{
			KeywordUtil.markError("Data not in grid form")
		}
	}
}