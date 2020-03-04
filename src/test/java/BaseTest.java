import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx){
        DesiredCapabilities cap;
        cap = DesiredCapabilities.chrome();

        String host = "http://localhost:4444/wd/hub";

        String testName = ctx.getCurrentXmlTest().getName();
        cap.setCapability("name", testName);

        try {
            this.driver = new RemoteWebDriver(new URL(host), cap);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
