import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.GoogleResultsPage;
import pages.ZaleniumPage;

/**
 * @author Razvan Vancea
 */
public class ZaleniumTest extends BaseTest {


    @Test
    public void assertDocumentation(){
        GooglePage googlePage = new GooglePage(driver);
        GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);
        ZaleniumPage zaleniumPage = new ZaleniumPage(driver);

        googlePage.goTo("https://www.google.ro");
        googlePage.searchFor("Zalenium docs");
        googlePage.clickSearchBtn();
        googleResultsPage.clickZaleniumResult();
        zaleniumPage.clickDockerLink();
        Assert.assertTrue(zaleniumPage.getStartingZaleniumText().isDisplayed());
    }
}
