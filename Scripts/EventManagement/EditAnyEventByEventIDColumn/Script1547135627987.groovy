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
Able to edit any event via the Event ID column; 
all events linked to by their Event ID (both tabs) */

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Event_Management)

CustomKeywords.'EventManagement.clickEventsTab'()

CustomKeywords.'EventManagement.editByEventID'("EVT.US000001663","1")

String str="Test"+String.valueOf(System.currentTimeMillis().toString().substring(5, 13))

CustomKeywords.'EventManagement.clickEventNameBtn'(str)

CustomKeywords.'EventManagement.clickSaveBtn'()

CustomKeywords.'EventManagement.verifyEditEvent'("1", str)

CustomKeywords.'EventManagement.clickProductsTab'()

CustomKeywords.'EventManagement.editByEventID'("EVT.US000001663","2")

str="Test"+String.valueOf(System.currentTimeMillis().toString().substring(5, 13))

CustomKeywords.'EventManagement.clickEventNameBtn'(str)

CustomKeywords.'EventManagement.clickSaveBtn'()

CustomKeywords.'EventManagement.verifyEditEvent'("2", str)




