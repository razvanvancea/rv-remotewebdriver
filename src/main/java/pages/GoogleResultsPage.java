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
public class GoogleResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h3[@text()='Zalenium - A flexible and scalable Selenium Grid.']")
    private WebElement zaleniumTextResult;

    public GoogleResultsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void clickZaleniumResult(){
        wait.until(ExpectedConditions.visibilityOf(zaleniumTextResult));
        zaleniumTextResult.click();
    }
}
