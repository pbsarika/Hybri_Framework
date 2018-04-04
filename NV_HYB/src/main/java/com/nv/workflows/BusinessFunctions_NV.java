package com.nv.workflows;

import org.openqa.selenium.By;

import com.nv.accelerators.ActionEngine;
import com.nv.objrepo.NV_OR;

public class BusinessFunctions_NV extends ActionEngine {

	/********************************************************************************************************
	 * Method Name : validate_HomePageFields() 
	 * Author : 
	 * Description : This method Validates the Fields on the Home Page
	 * Date of creation :
	 * modifying person :
	 * Date of modification :
	 * @throws Throwable
	 ********************************************************************************************************/
	public void validate_HomePageFields() throws Throwable {
		blnEventReport = true;
		// Validate whether User is navigated to National Vision Home Page
		if (waitForVisibilityOfElementWithoutReport(NV_OR.TITLE, "Sign In Button")) {
			SuccessReport("Validate whether User is navigated to National Vision Home Page",
					"User Is succesfully navigated to National Vision Home Page");
		} else {
			failureReport("Validate whether User is navigated to National Vision Home Page", "Failed to Navigate");
		}
		// Validate the Fields on the Home page
		isElementDisplayed(NV_OR.EYEGLASSESLINK,"EyeGlasses Link");
		isElementDisplayed(NV_OR.CONTACTLENSESLINK,"Contact Lenses Link");
		isElementDisplayed(NV_OR.PROMOTIONSLINK,"Promotions Link");
		isElementDisplayed(NV_OR.EYEEXAMSLINK,"Search Link");
		isElementDisplayed(NV_OR.SEARCHLINK,"Search Link");
		isElementDisplayed(NV_OR.FAVOURITESLINK,"Favourites Link");
		isElementDisplayed(NV_OR.SIGINORSIGUPLINK,"SignIn Or SignUp Link");
		isElementDisplayed(NV_OR.CARTLINK,"Cart Link");
		
		blnEventReport = false;
	}
	
	/********************************************************************************************************
	 * Method Name : validateSignUp() 
	 * Author : 
	 * Description : This method Validates the SignUp Functionality
	 * Date of creation :
	 * modifying person :
	 * Date of modification :
	 * @throws Throwable
	 ********************************************************************************************************/
	public void validateSignUp(String firstName,String lastName,String email,String ConfirmEmail,String password,String confirmPassword) throws Throwable {
		blnEventReport = true;
		
		click(NV_OR.SIGINORSIGUPLINK, "SigIn Or SignUp Link");
		click(NV_OR.SIGNUPFORANACCOUNTBTN, "SignUp For An Account Button");
		
		// Validate whether User is navigated to signup Page
		waitForVisibilityOfElementWithoutReport(NV_OR.FIRSTNAMETEXTBOX, "First NAme Text Field"); 
		
		// Fill the mandatory fields for signup
		type(NV_OR.FIRSTNAMETEXTBOX, firstName, "First Name Text Field");
		type(NV_OR.LASTNAMETEXTBOX, lastName, "Last Name Text Field");
		type(NV_OR.EMAILTEXTBOX, email, "Email Text Field");
		type(NV_OR.CONFIRMEMAILTEXTBOX, ConfirmEmail, "Confirm Email Text Field");
		type(NV_OR.PASSWORDTEXTBOX, password, "Password Text Field");
		type(NV_OR.CONFIRMPASSWORDTEXTBOX, confirmPassword, "Confirm Password Text Field");
		click(NV_OR.AGREEMENTCHECKBOX, "Agreement Check Box");
		click(NV_OR.AGECHECKBOX, "Age Check Box");
		click(NV_OR.CREATEACCOUNTBUTTON, "Create Account Button");
		blnEventReport = false;
	}
	
	
	 /********************************************************************************************************
	   * Method 	Name	:	clickOnCategory()
	   * Author				:	
	   * Description		:	This method click on category
	   * Date of creation 	:	
	   * modifying person 	: 	
	   * Date of modification	:
	  ********************************************************************************************************/	 
	   public void clickOnCategory(String strLinkName) throws Throwable{
		  try{
			  blnEventReport=true;
			  Thread.sleep(lSleep_Medium);
			  waitForElementPresentWithoutReport(By.xpath(NV_OR.CATEGORYLINKS+strLinkName+"')]"), strLinkName+"Link");
			  click(By.xpath(NV_OR.CATEGORYLINKS+strLinkName+"')]"), strLinkName+"Link");
			 
			  blnEventReport=true;
			} catch (Exception e) {
				throw e;
			}
	  }
	   
	   /********************************************************************************************************
		   * Method 	Name	:	validateCheckout()
		   * Author				:	
		   * Description		:	This method validates checkout functionality
		   * Date of creation 	:	
		   * modifying person 	: 	
		  * Date of modification	:
		 ********************************************************************************************************/	 
		  public void validateCheckout(String strLinkName) throws Throwable{
			 try{
			  blnEventReport=true;
			  click(NV_OR.EYEGLASSESLINK,"Eye Glasses link");
			  clickOnCategory(strLinkName);
			  Thread.sleep(lSleep_Low);
			  click(NV_OR.PRODUCTLINK,"Any Product");
			  waitForElementPresentWithoutReport(NV_OR.ADDTOCARTBUTTON, "Add To Cart Button");
			  Thread.sleep(lSleep_Medium);
			  String strValue1=getText(NV_OR.CARTCOUNT,"Cart Count");
			  click(NV_OR.ADDTOCARTBUTTON,"Add to cart Button");
			  Thread.sleep(lSleep_Medium);
			  String strValue2=getText(NV_OR.CARTCOUNT,"Cart Count");
			  if(strValue1.isEmpty())
			  {
				  if(strValue2.equalsIgnoreCase("1"))
				  {
					  SuccessReport("Validate whether user is able to add product to Cart","User is sucessfully added product to Cart");
				  }
				  else
				  {
					  failureReport("Validate whether user is able to add product to Cart","User is failed to add product to Cart");
				  }
			  }
			  else
			  {
				  int cartCount1=Integer.parseInt(strValue1)+1;
				  int cartCount2=Integer.parseInt(strValue2);
				  if(cartCount1==cartCount2)
				  {
					  SuccessReport("Validate whether user is able to add product to Cart","User is sucessfully added product to Cart");
				  }
				  else
				  {
					  failureReport("Validate whether user is able to add product to Cart","User is failed to add product to Cart");
				  } 
			  }
			  
			  
			  
			  blnEventReport=false;
			} catch (Exception e) {
				throw e;
			}
		 }
	
	
}