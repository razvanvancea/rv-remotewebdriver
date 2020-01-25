package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Razvan Vancea
 */
public class ZaleniumPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@text()='Docker']")
    private WebElement dockerLink;

    @FindBy(xpath = "//h3[@text()='Starting Zalenium']")
    private WebElement startingZaleniumText;

    public ZaleniumPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void clickDockerLink(){
        wait.until(ExpectedConditions.visibilityOf(dockerLink));
        dockerLink.click();
    }

    public WebElement getStartingZaleniumText(){
        wait.until(ExpectedConditions.visibilityOf(startingZaleniumText));
        return startingZaleniumText;
    }
}
