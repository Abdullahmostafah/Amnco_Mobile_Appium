package Pages;

import TestBases.TestBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    public String validUsername = "aa100";
    public String validPassword= "Besm@100100";
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@hint='UserCode']")
    public WebElement userCodeField;

    @FindBy(xpath = "//*[@hint='password']")
    public WebElement passwordField;
    @FindBy(xpath = "//*[@content-desc='Login']")
    public WebElement loginBtn;





    // WebElement userCode =  driver.findElement(AppiumBy.xpath("//*[@hint='UserCode']"));
    // userCode.click();
    //  userCode.sendKeys(validUsername);


//         @FindBy()
//    WebElement password=  driver.findElement(AppiumBy.xpath("//*[@hint='password']"));
//        password.click();
//        password.sendKeys(validPassword);
//        driver.findElement(AppiumBy.accessibilityId("Login")).click();
}
