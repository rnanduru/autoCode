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

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_customer_settings)

CustomKeywords.'CustomerSettings.removeAllPPGAndGroups'()

CustomKeywords.'CustomerSettings.saveBtn'()

CustomKeywords.'CustomerSettings.selectPPgs'(findTestData('CustomerSettings'), '3')

CustomKeywords.'CustomerSettings.clickAddPPGButton'()

CustomKeywords.'CustomerSettings.saveBtn'()

WebUI.delay(4)

CustomKeywords.'CustomerSettings.clickUPCActivationBtn'()

WebUI.delay(4)

CustomKeywords.'CustomerSettings.selectUPCs'(findTestData('CustomerSettings'),'4') 

CustomKeywords.'CustomerSettings.clickAddUPCButton'()

WebUI.delay(4)

CustomKeywords.'CustomerSettings.saveUPCBtn'()

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Customer_Authorization) 

int num =CustomKeywords.'General.getCurrentweekNum'()

CustomKeywords.'CustomerAuthorization.clickKHCWeeksDropDown'()

WebUI.delay(4)

CustomKeywords.'CustomerAuthorization.selectKHCWeeks'(num)






