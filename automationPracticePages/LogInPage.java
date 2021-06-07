package automationPracticePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;

    @FindBy(className = "logo")
    WebElement websiteLogo;

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id = 'passwd']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id = 'SubmitLogin']")
    WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void login() {
        loginButton.click();
    }

    public void logInUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        login();
    }

    public void clickLogoLink() {
        websiteLogo.click();
    }
}
