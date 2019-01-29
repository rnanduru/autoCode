import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import java.util.Calendar

/*Able to see the event info in a grid calendar form, 
with months and weeks going across the page from left to right, 
and all the PPGs and PPG groups listed to the left (two rows: for current and prior year plans); 
with the ability to select / view a single or multiple PPGs in the grid via the ‘Product’ drop down check box

1) Login and Navigate to Merch Calendar
2) Verify Months And weeks are from left to right.
3) Click the product btn 
4) Select the PPGs from product dropdown
5) Verify the PPGs left side and years i.e 2018, 2019
*/



CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Merch_Calendar)

CustomKeywords.'MerchCalendar.verifyMonthOrder'("Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sept;Oct;Nov;Dec")

CustomKeywords.'MerchCalendar.verifyWeekOrder'("Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sept;Oct;Nov;Dec")

CustomKeywords.'MerchCalendar.clickProductBtn'(findTestObject('Object Repository/Compass/MerchCalendar/ddb_product'))

CustomKeywords.'MerchCalendar.searchAndSelectPPGs'(findTestObject('Object Repository/Compass/MerchCalendar/input_product_ppgsearch'), "0IX 5.5-6z Mac&Cheese MWO 12")

CustomKeywords.'MerchCalendar.verifyPPGsAndYears'(findTestObject('Object Repository/Compass/MerchCalendar/btn_exporttoexcel'),"2018;2019","0IX 5.5-6z Mac&Cheese MWO 12")


