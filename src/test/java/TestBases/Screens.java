package TestBases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;

public class Screens extends TestBase {
    public static String screenShotPath = Paths.get(currentDir , "ScreenShots").toString();
    public static String videoRecordPath = Paths.get(currentDir,"VideoRecords").toString();
        public static ATUTestRecorder testRecorder;


    public Screens() throws IOException {
    }

    // ScreenShots
    public static void takeScreenShot(String name) throws IOException {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File( screenShotPath +"\\"+ name + ".png"));
    }

    public void startRecording(Method method) throws ATUTestRecorderException {
        testRecorder= new ATUTestRecorder(videoRecordPath ,method.getName(),false);
        testRecorder.start();
    }

    public void stopRecording() throws ATUTestRecorderException {
        testRecorder.stop();
    }
}
