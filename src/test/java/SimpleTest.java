import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author Razvan Vancea
 */
public class SimpleTest {

    private WebDriver driver;

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

    @Test
    public void checkZaleniumDocs(){
        driver.get("https://www.google.ro");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Zalenium docs");

        WebElement searchBtn = driver.findElement(By.name("btnK"));
        searchBtn.click();

        WebElement googleFirstResult = driver.findElement(By.cssSelector("#rso a"));
        googleFirstResult.click();

        WebElement dockerLink = driver.findElement(By.linkText("Docker"));
        dockerLink.click();

        WebElement linuxLogo = driver.findElement(By.cssSelector("i.fa.fa-linux"));

        Assert.assertTrue(linuxLogo.isDisplayed());
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
