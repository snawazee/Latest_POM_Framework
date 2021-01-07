package com.qa.Tests;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("EPIC-200: Design Accounts Page")
@Story("US - 201: desiging the accounts page with title, header, account sections and product results..")
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void AccountsPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Description("accounts Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void accountsPageTitleTest() {
		String title = accountsPage.getAccountPagePagetitle();
		System.out.println("accounts page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Description("accounts Page header Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyAccountsPageHeaderTest() {
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("accounts page header is : " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Description("accounts Page sections count Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == Constants.ACCOUNTS_SECTIONS);
	}

	@Description("accounts Page sections list Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyMyAccountSectionsListTest() {
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}

	@Description("accounts Page search Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void searchTest() {
		Assert.assertTrue(accountsPage.doSearch("iMac"));
	}

}
