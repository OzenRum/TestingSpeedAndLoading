package MasterBranchAcademy.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base_Test {
    WebDriverWait wait;
    public WebDriver driver;
    protected static ExtentReports reports;
    protected static ExtentSparkReporter SparkReporter;
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void reportsBeforeTest() {

        reports = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-outputs/report.html";
        SparkReporter = new ExtentSparkReporter(path);
        reports.attachReporter(SparkReporter);
        SparkReporter.config().setReportName("Extent Reports For TestNG Project");

        reports.setSystemInfo("Enviroment", "QA");
        reports.setSystemInfo("Browser", Config_Reader.getProperties("browser"));
        reports.setSystemInfo("OS", "os.name");
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = Driver.getDriver();
        driver.get(Config_Reader.getProperties("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    }
    @AfterMethod
    public void closeMethod(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String screenShotPath = System.getProperty("user.dir") + "/test-output/ScreenShots/"+ result.getName() + date + ".jpg";

            TakesScreenshot ts = (TakesScreenshot)Driver.getDriver();
            File kaynak =ts.getScreenshotAs(OutputType.FILE);
            File sonDosya = new File(screenShotPath);
            FileUtils.copyFile(kaynak,sonDosya);
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }else if (result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test skipped" + result.getName());

        }
        driver.close();
        }
    @AfterTest
    public void reportsAfterTest(){
        reports.flush();
        }

}
