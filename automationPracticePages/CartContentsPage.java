package automationPracticePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartContentsPage {
    WebDriver driver;

    @FindBy(className = "cart_quantity_delete")
    WebElement deleteProduct;

    public CartContentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDeleteProduct() {
        deleteProduct.click();
    }
}
