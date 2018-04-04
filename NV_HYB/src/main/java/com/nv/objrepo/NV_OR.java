package com.nv.objrepo;

import org.openqa.selenium.By;


public class NV_OR {
	
	public static final String HOMEPAGEHEADERLINKS="//ul[contains(@class,'main-navigation')]/li/a/span[text()='";
	public static final String CATEGORYLINKS="//label/a[contains(text(),'";
	public static final By EYEGLASSESLINK=By.xpath("//span[text()='Eyeglasses']");
	public static final By CONTACTLENSESLINK=By.xpath("//span[text()='Contact Lenses']");
	public static final By PROMOTIONSLINK=By.xpath("//span[text()='Promotions']");
	public static final By EYEEXAMSLINK=By.xpath("//span[text()='Eye Exams']");
	public static final By SEARCHLINK=By.xpath("//strong[@id='data-search']");
	public static final By FAVOURITESLINK=By.xpath("//span[@id='myfavoritesDIfav']");
	public static final By SIGINORSIGUPLINK=By.xpath("//span[text()='Sign in/up']");
	public static final By CARTLINK=By.xpath("//span[text()='Cart']");
	public static final By TITLE=By.xpath("//img[contains(@title,'America')]");
	public static final By FIRSTNAMETEXTBOX=By.xpath("//input[@name='firstName']");
	public static final By LASTNAMETEXTBOX=By.xpath("//input[@name='lastName']");
	public static final By EMAILTEXTBOX=By.xpath("//input[@name='email']");
	public static final By CONFIRMEMAILTEXTBOX=By.xpath("//input[@name='confirmEmail']");
	public static final By PASSWORDTEXTBOX=By.xpath("//input[@name='pwd']");
	public static final By CONFIRMPASSWORDTEXTBOX=By.xpath("//input[@name='checkPwd']");
	public static final By AGREEMENTCHECKBOX=By.xpath("//input[@id='chkAgreement']");
	public static final By AGECHECKBOX=By.xpath("//input[@id='chkAge']");
	public static final By CREATEACCOUNTBUTTON=By.xpath("//button[text()='Create Account']");
	public static final By SIGNUPFORANACCOUNTBTN=By.xpath("//button[contains(text(),'Sign up for an Account')]");
	public static final By HOMEPAGEBOTTOMLINKS=By.xpath("//div[contains(@class,'footer-social social')]/ul/li/a");
	public static final By ADDTOCARTBUTTON=By.xpath("//button[@id='configureProduct']");
	public static final By PRODUCTLINK=By.xpath("(//div[@id='productGridListing']//img)[1]");
	public static final By SUCESSMSG=By.xpath("//p[text()='Successfully added to Cart']");
	public static final By CARTCOUNT=By.xpath("//span[@class='cart-count']");
}



