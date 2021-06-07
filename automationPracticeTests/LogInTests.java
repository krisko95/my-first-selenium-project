package automationPracticeTests;

import automationPracticePages.LogInPage;
import automationPracticePages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LogInTests {
    WebDriver driver;

    @BeforeEach
    public void setUpBeforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldNotLogInWithoutUsername() {
        String username = "";
        String password = "123qwER";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLinkToLogInPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInUser(username, password);

        List<WebElement> listOfAuthErrors = driver.findElements(By.xpath("//li[text()='An email address required.']"));
        Assertions.assertEquals(1, listOfAuthErrors.size());
    }

    @Test
    public void shouldNotLogInWithoutUsernameAndPassword() {
        String username = "";
        String password = "";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLinkToLogInPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInUser(username, password);

        List<WebElement> listOfAuthErrors = driver.findElements(By.xpath("//li[text()='An email address required.']"));
        Assertions.assertEquals(1, listOfAuthErrors.size());
    }

    @Test
    public void shouldRedirectFromLogInPageToMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLinkToLogInPage();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickLogoLink();

        Assertions.assertEquals("My Store", driver.getTitle());
    }
}
