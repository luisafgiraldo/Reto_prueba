package co.sqasa.pageObjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.FindBy;
import org.openqa.selenium.WebElement;
public class CartPage extends PageObject {
    @FindBy(css = ".cart-price")
    private WebElement cartPriceLabel;
    public String getCartPrice() {
        return cartPriceLabel.getText();
    }
}
