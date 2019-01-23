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

//CustomKeywords.'AccountPlanner.toggleQMW'('W')
/*39.Able to enter CY Base Volume numbers in the editable field; and when entering at the monthly level, see the amount distributed evenly at the week level
*/
not_run: CustomKeywords.'AccountPlanner.clickBaseplanningButton'()

String py_base_vol_total = CustomKeywords.'AccountPlanner.getConsumptionCellTotal'('PY Base Volume')

String cy_base_vol_total = CustomKeywords.'AccountPlanner.getConsumptionCellTotal'('CY Base Volume')

String cy_est_base_vol_total = CustomKeywords.'AccountPlanner.getConsumptionCellTotal'('CY Estimated Base Volume')

String myCellVal = ''

int py_base_vol_total_from_cells = 0

for (int i = 1; i <= 52; i++) {
    myCellVal = CustomKeywords.'AccountPlanner.getConsumptionCellValue'('PY Base Volume', i)

    py_base_vol_total_from_cells = (py_base_vol_total_from_cells + Integer.parseInt('0' + myCellVal))
}

//compare total with cell totals
if (!(py_base_vol_total.equalsIgnoreCase(py_base_vol_total_from_cells.toString()))) {
    println('Oh my god PY Base volume total and cell values are not equal ')
}

int cy_base_vol_total_from_cells = 0

for (int i = 1; i <= 52; i++) {
    myCellVal = CustomKeywords.'AccountPlanner.getConsumptionCellValue'('CY Base Volume', i)

    cy_base_vol_total_from_cells = (cy_base_vol_total_from_cells + Integer.parseInt('0' + myCellVal))
}

//compare totals
if (!(cy_base_vol_total.equalsIgnoreCase(cy_base_vol_total_from_cells.toString()))) {
    println('Oh my god CY Base volume total and cell values are not equal ')
}

int cy_est_base_vol_total_from_cells = 0

for (int i = 1; i <= 52; i++) {
    myCellVal = CustomKeywords.'AccountPlanner.getConsumptionCellValue'('CY Estimated Base Volume', i)

    cy_est_base_vol_total_from_cells = (cy_est_base_vol_total_from_cells + Integer.parseInt('0' + myCellVal))
}

//compare totals
if (!(cy_est_base_vol_total.equalsIgnoreCase(cy_est_base_vol_total_from_cells.toString()))) {
    println('Oh my god CY estimated Base volume total and cell values are not equal ')
}

CustomKeywords.'AccountPlanner.accountPlannerHeaderListData'(null, '')

