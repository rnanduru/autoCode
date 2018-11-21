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
import com.sun.corba.se.impl.presentation.rmi.InvocationHandlerFactoryImpl.CustomCompositeInvocationHandlerImpl as CustomCompositeInvocationHandlerImpl
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.clickCreateViewbtn'()

//WebUI.delay(5)
CustomKeywords.'AccountPlanner.setViewName'()

//CustomKeywords.'AccountPlanner.AccountPlannerKendoDialogBox2'()

//WebUI.delay(5)
CustomKeywords.'AccountPlanner.clickSavebtn'()

CustomKeywords.'AccountPlanner.messagePopupHandle'('Info Account Planner has been Saved')

CustomKeywords.'AccountPlanner.closeView'()

WebUI.delay(5)

CustomKeywords.'AccountPlanner.selectView'('Standard')

