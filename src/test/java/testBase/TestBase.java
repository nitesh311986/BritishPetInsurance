package testBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {
    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String br) {
        if(br.equals("edge")) {
            driver = new EdgeDriver();
        }
        else if(br.equals("chrome")){
            driver=new ChromeDriver();
        }
        else {
            driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("http://52.32.106.250:7779/");
        //driver.navigate().to("http://52.32.106.250:7779/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + tname + "_" + timeStamp + ".png";


        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
}
