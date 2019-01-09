import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CustomerAuthorization {

	@Keyword
	public static void clickKHCWeeksDropDown(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerAuthorization/ddb_khcweeks'))
	}

	@Keyword
	public static void selectKHCWeeks(int num){
		TestObject to=General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li["+Integer.toString(num)+"]")
		WebUI.click(to)
	}

	@Keyword
	public static void clickEDLPTab(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerAuthorization/tb_edlp'))
	}

	@Keyword
	public static void clickHILOTab(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerAuthorization/tb_hilo'))
	}

	@Keyword
	public static void clickExportToExcel(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerAuthorization/btn_exporttoexcel'))
	}
	
	public static void verifyKendoGridFilter(){		
		WebDriver driver=DriverFactory.getWebDriver()
	}
	
	
}
