import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Razvan Vancea
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        DesiredCapabilities capabilities;
        capabilities = DesiredCapabilities.chrome();
        String host = "http://localhost:4444/wd/hub";
        try {
            this.driver = new RemoteWebDriver(new URL(host), capabilities);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
