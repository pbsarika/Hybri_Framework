package com.nv.scripts.homepage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nv.workflows.BusinessFunctions_NV;

public class ValidateCheckOut extends BusinessFunctions_NV{

	@BeforeClass
	public void excelLoad() throws Throwable {
		// Provide sheet path  and sheet name , will return the respective sheet object                 
		inputSheet=Excelobject.getSheetObject(TESTDATAWORKBOOKHOME,"NV_Checkout");
		
	}
	
	@Test
	public void checkOutValidation() throws Throwable {
		for (int iLoop = 2; iLoop <= inputSheet.getPhysicalNumberOfRows(); iLoop++) {
			try {
				  RowFailNum=0;
				  String SheetName="NV_Checkout";
				  String strDesc=Excelobject.getCellData(SheetName, "Description", iLoop);
				  String runStatus=Excelobject.getCellData(SheetName, "RunStatus", iLoop);
				  String strLinkName=Excelobject.getCellData(SheetName, "Link Name", iLoop);
				  
				  
				  if(runStatus.trim().equalsIgnoreCase("Y")) {

					child=extent.startTest("NV_CheckOut",strDesc);
					iterationReport(iLoop - 1, strDesc+" Start");
					
					//This method validate fields in Home Page
					validate_HomePageFields();
					
					//This method validates checkout functionality
					validateCheckout(strLinkName);
					
					
				
					
					parent.appendChild(child);
					//This will mark end of the one row in data sheet
					iterationReport(iLoop-1,"Completed");  

				  }

			} catch (Exception e) {
				catchBlock(e);
			}

		}
	}
}
	