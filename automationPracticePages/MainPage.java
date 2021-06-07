package automationPracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class = 'login']")
    WebElement linkToLogInPage;

    @FindBy(xpath = "//div[@id = 'contact-link']/a")
    WebElement linkToContactPage;

    @FindBy(xpath = "//ul[@id = 'homefeatured']//img[@title = 'Faded Short Sleeve T-shirts']")
    WebElement imageFadedShortSleeveTShirts;

    @FindBy(xpath = "//ul[@id = 'homefeatured']//a[@title = 'Faded Short Sleeve T-shirts']/../..//a[@title = 'Add to cart']")
    WebElement buttonAddToCartFadedShortSleeveTShirts;

    @FindBy(xpath = "//ul[@id = 'homefeatured']//img[@title = 'Blouse']")
    WebElement imageBlouse;

    @FindBy(xpath = "//ul[@id = 'homefeatured']//a[@title = 'Blouse']/../..//a[@title = 'Add to cart']")
    WebElement buttonAddToCartBlouse;

    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    WebElement buttonProceedToCheckout;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLinkToLogInPage() {
        linkToLogInPage.click();
    }

    public void clickLinkToContactPage() {
        linkToContactPage.click();
    }

    public void hoverOnImageFadedShortSleeveTShirts() {
        Actions action = new Actions(driver);
        action.moveToElement(imageFadedShortSleeveTShirts).perform();
    }

    public void hoverOnImageBlouse() {
        Actions action = new Actions(driver);
        action.moveToElement(imageBlouse).perform();
    }

    public void clickAddToCartFadedShortSleeveTShirts() {
        buttonAddToCartFadedShortSleeveTShirts.click();
    }

    public void clickAddToCartBlouse() {
        buttonAddToCartBlouse.click();
    }

    public void clickProceedToCheckout() {
        buttonProceedToCheckout.click();
    }

    public void addFadedShortSleeveTShirtsAndGoToCart() {
        hoverOnImageFadedShortSleeveTShirts();
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCartFadedShortSleeveTShirts));
        clickAddToCartFadedShortSleeveTShirts();
        wait.until(ExpectedConditions.elementToBeClickable(buttonProceedToCheckout));
        clickProceedToCheckout();
    }

    public void addBlouseAndGoToCart() {
        hoverOnImageBlouse();
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCartBlouse));
        clickAddToCartBlouse();
        wait.until(ExpectedConditions.elementToBeClickable(buttonProceedToCheckout));
        clickProceedToCheckout();
    }
}
