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

//CustomKeywords.'EventManagement.kendoGridFilterCell'(null, null, null, null);

//CustomKeywords.'EventManagement.sortAndFilterColumns'()


CustomKeywords.'CompassUIElements.kendoGridOperation'(null, null, null, null, null)

CustomKeywords.'AccountPlanner.selectMiddleHeader'(findTestData('AccountPlanner'), '1')

CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'), '5',dataObj.get('CUSTOMER_SEGMENT'))
CompassUIElements.kendoGridSelectListBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'),'10',dataObj.get('EDLP_SPEND_METHOD'))
CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'),'11',dataObj.get('Shp_Lead_WK'))
CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'), '15',dataObj.get('COMMENTS'))


