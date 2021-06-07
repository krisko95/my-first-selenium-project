package automationPracticeTests;

import automationPracticePages.CartContentsPage;
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

public class CartTests {
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
    public void shouldAddProductToCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addFadedShortSleeveTShirtsAndGoToCart();

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//td/p[@class='product-name']"));
        Assertions.assertTrue(listOfProducts.size() > 0);
    }

    @Test
    public void shouldDeleteProductFromCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.addBlouseAndGoToCart();

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//td/p[@class='product-name']"));
        Assertions.assertTrue(listOfProducts.size() > 0);

        CartContentsPage cartContentsPage = new CartContentsPage(driver);
        cartContentsPage.clickDeleteProduct();

        List<WebElement> listOfInfos = driver.findElements(By.xpath("//p[text()='Your shopping cart is empty.']"));
        Assertions.assertTrue(listOfInfos.size() > 0);
    }
}
