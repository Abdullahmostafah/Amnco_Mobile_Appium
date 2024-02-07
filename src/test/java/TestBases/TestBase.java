package TestBases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    public static AndroidDriver driver;
    public static String currentDir = System.getProperty("user.dir");
    public static String apkPath= "/Apps/Amnco_Preprod_V1.4_12Dec.apk";
    public static String localHostPath ="http://localhost:4723";
    public static String virtualName = "Pixel";
    public static String realName = "Test A12";


    @BeforeTest
    public void initAndroid() throws MalformedURLException {
        // Desired Capabilities, System Platform
        UiAutomator2Options options = new UiAutomator2Options();
        //options.setPlatformName("Android"); //optional
        //options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //optional
        options.setDeviceName(virtualName);

        // Desired Capabilities specific to the application
        options.setApp(currentDir + apkPath);
        //  options.setApp("C:\\Users\\Abdullah\\IdeaProjects\\AppiumAmnco\\Apps\\Amnco_Preprod_V1.4_12Dec.apk");
        // options.setApp("C:\\Users\\Abdullah\\IdeaProjects\\AppiumFirstPilotProject\\apps\\thaki_test_1.0.30_v2.apk");
        // APK APP
        // options.setApp(System.getProperty("user.dir") + "/apps/thaki_test_1.0.30_v1.apk");
        // Built in APp
        // options.setAppPackage("com.android.deskclock");
        // options.setAppActivity(".DeskClock");
        // options.setAppPackage("com.scscsa.thaki");
        //  options.setAppActivity(".MainActivity");
        // WebElement mobile = driver.findElement(AppiumBy.accessibilityId(""));
        options.setNoReset(true);

        //Android Driver Initialization
        driver = new AndroidDriver(new URL(localHostPath), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
//appium --use-plugins=element-wait   //run with this command to avoid waits