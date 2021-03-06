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
 * Able to perform lookups via the ‘Add PPG/SKU/MOD/Product Family’ button on the bottom of the page, 
 * and see all related items added to the ‘Active [ ]’ drop down at the top of the page
*/


CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Event_Management)

CustomKeywords.'EventManagement.clickCreateEventButton'(1)

String ppg="YP0 7.25z M&C Blue Box 5+1 Prem 6;BEL ORT X/HVY TOM PUREE 10TIN6 6LB1;70CS MOD MAC & CHSE 5PK;Blue Box Mac & Cheese"

CustomKeywords.'EventManagement.verifyLookUpAddPPGBtn'(ppg)


