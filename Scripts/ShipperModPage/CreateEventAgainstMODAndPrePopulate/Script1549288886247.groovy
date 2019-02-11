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
Ability to create a new event against the selected Mod (via the ‘Create Event’ button) and 
have the Mod pre-populate on the event creation page, 
with ability to save those changes and later view that and 
other events created against this Mod via the ‘View Events’ button 
1) Navigate to Shipper MOD
2) Click Create Event btn and create event and verify MOD- pre-populate on the event creation page and save changes.
3) View the event against MOD via "View Events button"
*
*/
//Navigate to Shipper MOD
CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Shipper_Mod)

CustomKeywords.'ShipperMod.selectShippeMod'("BRK 4.7Z DBL CC FRT PINE 12")

CustomKeywords.'ShipperMod.clickCreateEvent'()

CustomKeywords.'EventManagement.verifyPPGOnEventCreationPage'("BRK 4.7Z DBL CC FRT PINE 12")

String eventName=CustomKeywords.'ShipperMod.createEvent'("12")

CustomKeywords.'ShipperMod.clickViewEventsBtn'(eventName)










