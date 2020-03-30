package com.opencart.tools.test_runner;

import com.opencart.pages.HomePage;
import com.opencart.pages.account.AccountLogoutPage;
import com.opencart.pages.account.RegisterPage;
import com.opencart.pages.account.SuccessRegisterPage;
import com.opencart.pages.cart.CartPage;
import com.opencart.pages.wishlist.WishListPage;
import com.opencart.tools.AdminManager;
import com.opencart.tools.Driver;
import com.opencart.tools.JsonDataConfig;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class AccountTestRunner {
    JsonDataConfig jsonDataConfig = new JsonDataConfig("TestData.json");
    AdminManager adminAccess = new AdminManager();

    @BeforeClass
    public void beforeClass() {
        Driver.getDriver();
        try {
            primaryRegistration();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            adminAccess.deleteCustomerFromAdmin(jsonDataConfig.getEmailFromJson(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.quit();
    }

    @AfterMethod
    public void logoutUser() throws InterruptedException {
        if (getHomePage().isExistMyAccountDropdownOption("My Account")){
            AccountLogoutPage logoutPage = getHomePage().goToLogoutPage();
            logoutPage.logout();
        }
        else getHomePage();
    }

    public HomePage getHomePage() {
        return new HomePage(Driver.getDriver());
    }

    public void primaryRegistration() throws InterruptedException {
        RegisterPage registerPage = getHomePage().goToRegisterPage();
        SuccessRegisterPage success = registerPage.register(jsonDataConfig.getUserFromJson(0));
        success.goToAccountAfterRegistration();
        AccountLogoutPage logoutPage = getHomePage().goToLogoutPage();
        logoutPage.logout();
    }
}
