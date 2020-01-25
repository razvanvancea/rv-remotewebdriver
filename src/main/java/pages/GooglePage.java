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
public class GooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTextField;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    public GooglePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void goTo(String url){
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
    }

    public void searchFor(String text){
        wait.until(ExpectedConditions.elementToBeClickable(searchTextField));
        searchTextField.click();
        searchTextField.sendKeys(text);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }
}
