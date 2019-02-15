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

/*CustomKeywords.'CustomerSettings.clickOnUPCActivationTableColumn1'('KHC PPG')

Map mp = CustomKeywords.'CustomerSettings.getAllTableValuesInPPGActivationTable'(findTestObject('Object Repository/Compass/CustomerSettings/tbl_UPCActivation_table_headers'),'KHC PPG')

CustomKeywords.'CustomerSettings.verifyValuesOrder'('KHC PPG', mp.get('KHC PPG'), GlobalVariable.multivalueseperator, 'desc')

CustomKeywords.'CustomerSettings.clickOnUPCActivationTableColumn1'('KHC PPG')

CustomKeywords.'CustomerSettings.verifyValuesOrder'('KHC PPG', mp.get('KHC PPG'), GlobalVariable.multivalueseperator, 'asc')*/
/*12.Able to sort content for all columns in ascending or descending order, and filter the content in the grid for the first 5 columns (KHC PPG, KHC PPG Desc, PPG Group)
*/
CustomKeywords.'CustomerSettings.clickOnUPCActivationTableColumn1'('KHC PPG Desc')

Map mp = CustomKeywords.'CustomerSettings.getAllTableValuesInPPGActivationTable'(findTestObject('Object Repository/Compass/CustomerSettings/tbl_UPCActivation_table_headers'), 
    'KHC PPG Desc')

CustomKeywords.'CustomerSettings.verifyValuesOrder'('KHC PPG Desc', mp.get('KHC PPG Desc'), GlobalVariable.multivalueseperator, 
    'desc')

CustomKeywords.'CustomerSettings.clickOnUPCActivationTableColumn1'('KHC PPG Desc')

CustomKeywords.'CustomerSettings.verifyValuesOrder'('KHC PPG Desc', mp.get('KHC PPG Desc'), GlobalVariable.multivalueseperator, 
    'asc')

