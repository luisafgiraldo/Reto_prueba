package co.sqasa.pageObjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.FindBy;
import org.openqa.selenium.WebElement;
public class SearchPage extends PageObject {
    @FindBy(id="search-words")
    private WebElement searchInput;
    @FindBy(class="search--submit--2VTbd-T")
    private WebElement searchButton;
    @FindBy(class="src--autoItem--9yCOcGQ")
    private WebElement firstProduct;
    public void searchFor(String product) {
        searchInput.clear();
        searchInput.sendKeys(product);
        searchButton.click();
    }
    public void selectFirstProduct() {
        firstProduct.click();
    }
}