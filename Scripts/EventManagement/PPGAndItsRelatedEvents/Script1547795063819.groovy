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
 * Able to view all events for the selected Customer Plan in the global navigation, 
 * or select a single PPG in the drop down (upper left, above Events tab) and 
 * see those related events for that PPG; the page defaults to loading ‘All’ for the PPG drop down, 
 * and thus all events created for all PPGs
 */

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Event_Management)

CustomKeywords.'EventManagement.selectPPG'("YN9 5.5z M&C Blue Box 3pk/12")

CustomKeywords.'EventManagement.verifyPPGsEventID'()

CustomKeywords.'EventManagement.selectPPG'("All")

CustomKeywords.'EventManagement.verifyPPGsEventID'()






