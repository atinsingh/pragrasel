package co.pragra.selframework.listeners;

import co.pragra.selframework.drivermanger.DriverManager;
import co.pragra.selframework.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        File screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path path = Paths.get("target","screenshot");
        try {
            Files.createDirectories(path.toAbsolutePath());
            FileUtils.copyFile(screenshot,new File(path.toString() +"/" + Utils.getFileName(result.getName())));
        }catch (IOException ex){

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
