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

/*
From Accounts Planner: able to create a PPG-based event with the PPG pre-populating on the creation page,
 when launching the event from the ‘Events - Create’ button */

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.clickEventsCreteButton'()

CustomKeywords.'AccountPlanner.clickCreateAndViewEventBtn'("1")

String date=General.evalString("{date.0.MMM/dd/yyyy}")

CustomKeywords.'AccountPlanner.enterStartAndEndDate'(findTestObject('Object Repository/Compass/AccountPlaner/btn_eventdatepicker'), "Execution Start Date", date)

WebUI.delay(2)

CustomKeywords.'AccountPlanner.enterStartAndEndDate'(findTestObject('Object Repository/Compass/AccountPlaner/btn_eventdatepicker'), "Execution End Date", date) 

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/txt_promosrp'))

WebUI.delay(2)

CustomKeywords.'CompassUIElements.setText'(findTestObject('Object Repository/Compass/AccountPlaner/txt_promosrp'), "10")

CustomKeywords.'AccountPlanner.checkCheckBoxes'("7")

CustomKeywords.'AccountPlanner.enterCaseUnitText'("7", "10")

CustomKeywords.'AccountPlanner.clickOIBBCaseStartAndEndDateBtn'("7", "1")

CustomKeywords.'CompassUIElements.selectDatePicker'(date)

WebUI.delay(2)

CustomKeywords.'AccountPlanner.clickOIBBCaseStartAndEndDateBtn'("7", "2")

WebUI.delay(2)

CustomKeywords.'CompassUIElements.selectDatePicker'(date)


CustomKeywords.'AccountPlanner.clickSavebuton'()

WebUI.delay(5)

CustomKeywords.'AccountPlanner.verifyEventPPGCreationInfo'(findTestObject('Object Repository/Compass/AccountPlaner/txt_infomsg'), "event is saved")

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/AccountPlaner/btn_ok'))





