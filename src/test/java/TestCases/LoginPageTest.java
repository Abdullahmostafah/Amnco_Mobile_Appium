package TestCases;


import Pages.LoginPage;
import TestBases.TestBase;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    @Test
    public void startAutomator()  {
        loginPage = new LoginPage();

        //Login Page
        loginPage.userCodeField.click();
        loginPage.userCodeField.sendKeys(loginPage.validUsername);

        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys(loginPage.validPassword);

        loginPage.loginBtn.click();

//        WebElement userCode =  driver.findElement(AppiumBy.xpath("//*[@hint=\"UserCode\"]"));
//        userCode.click();
//        userCode.sendKeys(validUsername);
//        WebElement password=  driver.findElement(AppiumBy.xpath("//*[@hint=\"password\"]"));
//        password.click();
//        password.sendKeys(validPassword);
//        driver.findElement(AppiumBy.accessibilityId("Login")).click();


    }


}
