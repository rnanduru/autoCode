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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import java.util.List;

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import internal.GlobalVariable

public class CustomerSettings {
	@Keyword
	public static void removeAllPPGAndGroups(){
		CompassUIElements.kendoGridSelectCheckBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'), "all", 1);
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/CustomerSettings/btn_delete"));
		CompassUIElements.kendoDialogBoxHandler("true","are you sure","Yes");
	}
	@Keyword
	public static void selectPPGs(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'), dataObj.get("ADD_PPG"))
		}
	}
	@Keyword
	public static void selectPPGs(String item){
		CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'), item)
	}
}
