package com.qa.Tests;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(ExtentReportListener.class)

@Epic("Epic 100: define loing page features....")
@Story("US 101: define the login page class features with title, forgot pwd link and login functionality")
public class LoginPageTest extends BaseTest {

	@Description("verify LoginPage Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("verify forgot pwd Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void verifyForgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Login page test with username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
