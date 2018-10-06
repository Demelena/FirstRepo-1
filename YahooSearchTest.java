package LoginExYahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooSearchTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver () {
        System.setProperty("webdriver.gecko.driver", "/Users/Ju/IdeaProjects/WebdriverJavabootcamp/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void testYahoo() {
        navigatingToMainPage();
        typeRequestInSearchInput();
        submitSearch();
        printOutAmountOfResult();

    }

    private void printOutAmountOfResult() {
        String res = driver.findElement(YahooMainPage.resultStats).getText();
        System.out.println(res);

    }

    private void submitSearch() {
        driver.findElement(YahooMainPage.submitButton).click();

    }

    private void typeRequestInSearchInput() {
        driver.findElement(YahooMainPage.searchInput).sendKeys("Portnov computer school");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void navigatingToMainPage() {
        String url = "https://www.yahoo.com/";
        driver.get(url);
    }
}
