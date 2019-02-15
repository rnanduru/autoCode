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
 * From Events Mgmt: able to create any of the four event types via the Create Event button and 
 * sub nav; PPG, SKU MOD and Product Family
 * 
 */

/*CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)*/

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Event_Management)

/*CustomKeywords.'EventManagement.clickEventsTab'()

CustomKeywords.'EventManagement.clickCreateEventButton'(1)*/

String ppgs="YP0 7.25z M&C Blue Box 5+1 Prem 6;1.9LB SWEDISH FISH ASSORTED BAG 4;70CS MOD MAC & CHSE 5PK;Blue Box Mac & Cheese"

CustomKeywords.'EventManagement.createEventsWithDifferentTypes'(ppgs, "10")