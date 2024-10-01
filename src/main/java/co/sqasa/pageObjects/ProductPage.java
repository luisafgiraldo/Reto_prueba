package co.sqasa.pageObjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.FindBy;
import org.openqa.selenium.WebElement;
public class ProductPage extends PageObject {
    @FindBy(class = "comet-v2-btn comet-v2-btn-primary comet-v2-btn-large")
    private WebElement addToCartButton;
    @FindBy(class = "comet-v2-input-number-btn comet-v2-input-number-btn-increase") // Selector por nombre para el campo de cantidad
    private WebElement quantityInput;
    @FindBy(css = "price")
    private WebElement priceLabel;
    public void addToCart(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
        addToCartButton.click();
    }
    public String getPrice() {
        return priceLabel.getText();
    }
}







