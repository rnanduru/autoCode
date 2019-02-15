import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

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
	@Keyword
	public static void verifyKendoGridFilter(String item){
		String[] items=item.split(GlobalVariable.multivalueseperator)
		for(int i=1;i<items.size();i++){
			if (!items[i].equalsIgnoreCase("")) {

				//Filter Icon
				TestObject filterIcon=General.createObject("//kendo-tabstrip/div[1]//kendo-grid//div[@role='presentation']/table[@role='presentation']/thead[@role='presentation']/tr[2]/td["+i+"]//kendo-dropdownlist/span[@role='listbox']/span[@class='k-select']")
				WebUI.click(filterIcon)
				WebUI.delay(2)
				//Select Equal to Filter
				WebUI.click(General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[1]"))
				//Input textbox
				TestObject inpt=General.createObject("//kendo-tabstrip/div[1]//kendo-grid/div[@role='grid']//div[@role='presentation']/table[@role='presentation']//tr[2]/td["+i+"]//kendo-grid-filter-wrapper-cell[@class='k-filtercell-wrapper']/input")
				CompassUIElements.setText(inpt, items[i])
				// Validate Table Data
				TestObject rowData=General.createObject("//kendo-tabstrip/div[1]//kendo-grid//kendo-grid-list[@role='presentation']/div[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td["+i+"]")
				CompassUIElements.kendoGetText(rowData, items[i])
				//Clear Filter
				WebUI.click(General.createObject("//kendo-tabstrip/div[1]//kendo-grid/div[@role='grid']//table[@role='presentation']/thead[@role='presentation']/tr[2]/td["+i+"]/kendo-grid-string-filter-cell[@class='k-filtercell ng-star-inserted']/kendo-grid-filter-wrapper-cell[@class='k-filtercell-wrapper']/kendo-grid-filter-cell-operators[@class='k-filtercell-operator']/button/span"))
			}
		}
	}
}
