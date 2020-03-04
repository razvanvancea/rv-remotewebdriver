import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZaleniumTest extends BaseTest {

    @Test
    public void assertZaleniumDocs(){
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
}
