import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void assertTitle(){
        driver.get(baseUrl);

        String currentTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(currentTitle, expectedTitle);
    }
}
