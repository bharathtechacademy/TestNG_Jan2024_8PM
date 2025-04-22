package com.creatio.crm.application.steps;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.SignUpPageElements;
import com.creatio.crm.framework.db.commons.DBCommons;

public class SignUpPageSteps extends SignUpPageElements{
	
	public SignUpPageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifySignUpPageIsLaunched() {
		waitForElement(signUpPageHeader, 60);
		log("pass","Application Signup page is launched successfully");
	}
	
	public void enterUserDetails(String email, String password) {
		enterText(businessEmailTxtb, uniqueId("hhmmss")+email);
		enterText(passwordTxtb, password);
		log("info","User details are entered successfully");
	}
	
	public void clickOnContinueButton() {
		click(continueBtn);
		log("info","Clicked on the Login Button");
	}
	
//	public void enterCompanyDetails() {
//		waitForElement(firstNameTxtb, 5);
//		wait(3);
//		enterText(firstNameTxtb, "BharathTechAcademy");
//		enterText(lastNameTxtb, "Academy");
//		enterText(websiteTxtb, "www.BharathTechAcademy.com");
//		enterText(companyTxtb, "BharathTechAcademy");
//		enterText(countryTxtb, "India");
//		waitForElement(countryOption,5);
//		click(countryOption);
//		wait(5);
//		click(phoneTxtb);
//		wait(5);
//		enterInfo(phoneTxtb, "90"+uniqueId("ddMMhhmm"));
//		log("info","Updated Company Details");
//	}
	
	public void enterCompanyDetails() throws SQLException {
		List<Map<String, String>> data = DBCommons.readData("Select * From COMPANY_INFO");		
		waitForElement(firstNameTxtb, 5);
		wait(3);
		enterText(firstNameTxtb, data.get(0).get("firstname"));
		enterText(lastNameTxtb, data.get(0).get("lastname"));
		enterText(websiteTxtb, data.get(0).get("website"));
		enterText(companyTxtb, data.get(0).get("companyname"));
		enterText(countryTxtb, data.get(0).get("country"));
		waitForElement(countryOption,5);
		click(countryOption);
		wait(5);
		click(phoneTxtb);
		wait(5);
		enterInfo(phoneTxtb, "90"+uniqueId("ddMMhhmm"));
		log("info","Updated Company Details");
	}
	
	public void clickOnSignUpButton() {
		jsClick(SignUpBtn);
		log("info","Clicked on the SignUp Button");
	}

}
