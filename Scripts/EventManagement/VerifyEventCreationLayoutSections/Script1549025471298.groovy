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
For all customer plans, able to see the page load with the new layout with 3 sections; 
Parameters, Lift/Pace and Financials; with the event start/ed dates pre-populating to today’s date; 
able to enter values for all editable fields in the Parameters and Lift/Pace sections; 
able to search and add a PPG to the event and see it included in the ‘Active PPG(s)’ drop down at the top center of the page; 
if the event spans multiple weeks, able to see a totals row in the Lift/Pace section where the user can enter values in the editable fields 
and see those amounts be distributed evenly across all weeks (for Load/Deload) or 
based on the Base Volume numbers (for the Total and Inc. Volume columns)

1) Verify 3 sections Parameters, Lift/Pace and Financials;
2)
*/


//AccountPlanner.selectHeaderItem'(findTestData('AccountPlanner'), '1')