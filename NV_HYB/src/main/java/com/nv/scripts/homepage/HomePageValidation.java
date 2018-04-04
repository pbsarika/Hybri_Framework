package com.nv.scripts.homepage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nv.workflows.BusinessFunctions_NV;

public class HomePageValidation extends BusinessFunctions_NV{

	@BeforeClass
	public void excelLoad() throws Throwable {
		// Provide sheet path  and sheet name , will return the respective sheet object                 
		inputSheet=Excelobject.getSheetObject(TESTDATAWORKBOOKHOME,"NV_Home");
		
	}
	
	@Test
	public void nv_SignUpValidation() throws Throwable {
		for (int iLoop = 2; iLoop <= inputSheet.getPhysicalNumberOfRows(); iLoop++) {
			try {
				  RowFailNum=0;
				  String SheetName="NV_Home";
				  String strDesc=Excelobject.getCellData(SheetName, "Description", iLoop);
				  String runStatus=Excelobject.getCellData(SheetName, "RunStatus", iLoop);
				  String firstName=Excelobject.getCellData(SheetName, "First Name", iLoop);
				  String lastName=Excelobject.getCellData(SheetName, "Last Name", iLoop);
				  String email=Excelobject.getCellData(SheetName, "Email", iLoop);
				  String password=Excelobject.getCellData(SheetName, "Password", iLoop);
				  
				  if(runStatus.trim().equalsIgnoreCase("Y")) {

					child=extent.startTest("NV_SignUp",strDesc);
					iterationReport(iLoop - 1, strDesc+" Start");
					
					//This method validate fields in Home Page
					validate_HomePageFields();
					//This method used for signup
					validateSignUp(firstName, lastName, email, email, password, password);
				
					
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
	