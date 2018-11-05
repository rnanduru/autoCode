import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.*
import internal.GlobalVariable

public class CustomerSettings {

	@Keyword
	public static void clickDeleteBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_delete'))
	}

	@Keyword
	public static void clickAddPPGBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_addppg'))
	}
	@Keyword
	public static void clickGroupBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_group'))
	}
	@Keyword
	public static void saveBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_save'))
	}
	@Keyword
	public static void selectItem(int i){
		CompassUIElements.clickButton(findTestObject("//div/button[position()='"+i+"']"))
	}
	@Keyword
	public static void selectPPG(){
		TestObject ob=General.createObject("/html/body/app-root/div/div[1]/div/authorization-list/div[2]/div[1]/div/div[1]/dropdown-filterable[1]/div/div[1]/span/span")
		WebUI.click(ob)
	}
	@Keyword
	public static void selectItemsFromList(String data){
		TestObject to=General.createObject("//dropdown-filterable[1]//div[@class='product-items']//label[text()='"+data+"']")
		WebUI.click(to)
	}
	@Keyword
	public static void selectItemsfromExcel(TestData td,String rowNo){
		selectPPG()
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectItemsFromList(dataObj.get('PPG_NAME'))
		}
	}
	//handling popup
	@Keyword
	public static void clickOnPopUp(String titlename){
		General.createObject("//div/kendo-dialog-titlebar/div[text()='"+titlename+"']")

		println "obj :"+titlename
		if(titlename.equalsIgnoreCase("Please confirm"))
		{
			TestObject to=General.createObject("//div[text()='Are you sure?']/following-sibling::kendo-dialog-actions//button[contains(text(),'Yes')]")
			WebUI.click(to)
		}
		else if(titlename.equalsIgnoreCase("Info"))
		{
			TestObject to=General.createObject("//kendo-dialog-actions/button[contains(text(),'Ok')]")
			WebUI.click(to)
		}
	}

	@Keyword
	public static void selectPopUpDelete(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			clickOnPopUp(dataObj.get("POPUP_DELETE"))
		}
	}

	@Keyword
	public static void selectPopUpOk(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			clickOnPopUp(dataObj.get("POPUP_INFO"))
		}
	}


}
