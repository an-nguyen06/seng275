package lab05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UVicTest {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        // Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuthu\\seng275-lab\\chromedriver.exe");
        browser = new ChromeDriver();

        browser.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    // Your tests go here
    @Test
    public void showTitle() {
        browser.get("https://www.uvic.ca");
        assertEquals("Home - University of Victoria", browser.getTitle());
    }

    @Test
    public void showSearchButton(){
        browser.get("https://www.uvic.ca");

        WebElement searchButton = browser.findElement(By.id("search-btn"));
        assertTrue(searchButton.isDisplayed());
    }

    @Test
    public void showSearchBar() {
        browser.get("https://www.uvic.ca");

        WebElement searchButton = browser.findElement(By.id("search-btn"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(browser, 5);
        WebElement inputBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );

        assertTrue(inputBox.isDisplayed());
    }

    @Test
    public void typingCorrect(){
        browser.get("https://www.uvic.ca");

        WebElement searchButton = browser.findElement(By.id("search-btn"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(browser, 5);
        WebElement inputBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );

        inputBox.sendKeys("csc");

        assertEquals("csc", inputBox.getAttribute("value"));
    }

    @Test
    public void searchResultsPageLoads() {
        browser.get("https://www.uvic.ca");

        WebElement searchButton = browser.findElement(By.id("search-btn"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(browser,5);
        WebElement inputBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );

        inputBox.sendKeys("csc");
        inputBox.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleContains("Search"));

        assertTrue(browser.getTitle().contains("Search"));
    }

    @Test
    public void phoneNumberAppears() {
        browser.get("https://www.uvic.ca/ecs/computerscience/index.php");

        WebDriverWait wait = new WebDriverWait(browser, 5);

        WebElement body = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))
        );

        String pageText = body.getText();
        assertTrue(pageText.contains("1-250-472-5700"));
    }


}
