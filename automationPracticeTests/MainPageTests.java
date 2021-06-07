package automationPracticeTests;

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

public class MainPageTests {
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
    public void shouldContainLogoAndSearchBar() {
        List<WebElement> listOfLogos = driver.findElements(By.className("logo"));
        Assertions.assertTrue(listOfLogos.size() > 0);

        List<WebElement> listOfSearchBars = driver.findElements(By.className("search_query"));
        Assertions.assertTrue(listOfSearchBars.size() > 0);
    }

    @Test
    public void shouldRedirectFromMainPageToContactPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLinkToContactPage();

        List<WebElement> listOfContactBreadcrumbs = driver.findElements(By.xpath("//div[@class = 'breadcrumb clearfix']/span[text()='Contact']"));
        Assertions.assertTrue(listOfContactBreadcrumbs.size() > 0);

        List<WebElement> listOfSubheadings = driver.findElements(By.xpath("//fieldset/h3[text()='send a message']"));
        Assertions.assertTrue(listOfSubheadings.size() > 0);
    }
}
