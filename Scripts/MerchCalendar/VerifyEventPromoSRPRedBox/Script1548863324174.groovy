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

/*Able to see any events created for a given PPG / PPG group in a red box for each week that the event spans, 
 * with a number in the box, which represents the Promo SRP price entered in the event.  
 * Further from that, the user can mouse over the event and see various details about the event, 
 * including a link to create a new event for that PPG / PPG group
 * 
 * 1) Create Event
 * 2) Navigate to Merch Calendar page.
 * 3) Navigate to current week, verify PPG in red box and with Promo SRP price entered in the event.
 * 4) Mouse over the event and verify details
 * 5) Verify Create a new event link exists.
 */

//1) Create Event

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)
/*
CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.btnclickEvents'()

CustomKeywords.'AccountPlanner.clickCreateAndViewEventBtn'("1")*/

//String ppg="YP0 7.25z M&C Blue Box 5+1 Prem 6"

String ppg="20z Frozen Mac & Cheese"

//CustomKeywords.'MerchCalendar.createEvent'("12",ppg) 

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Merch_Calendar)

CustomKeywords.'MerchCalendar.clickProductBtn'(findTestObject('Object Repository/Compass/MerchCalendar/ddb_product'))

CustomKeywords.'MerchCalendar.searchAndSelectPPGs'(findTestObject('Object Repository/Compass/MerchCalendar/input_product_ppgsearch'), ppg)

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/MerchCalendar/btn_exporttoexcel')) 

String promo="\$12.00";


CustomKeywords.'MerchCalendar.hoverToCurrentWeekTab'(promo)

CustomKeywords.'MerchCalendar.verifyPromoSRP'(promo)








