package co.sqasa.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import your.package.name.pages.SearchPage;
import your.package.name.pages.ProductPage;
import your.package.name.pages.CartPage;
import your.package.name.utils.ExcelReader;
import static org.junit.Assert.assertEquals;
import java.util.List;
public class SearchSteps {
    @Steps
    SearchPage searchPage;
    @Steps
    ProductPage productPage;
    @Steps
    CartPage cartPage;
    String productPrice;
    @Given("I am on the AliExpress homepage")
    public void iAmOnTheAliExpressHomepage() {
        searchPage.open();
    }
    @When("I search for products from Excel")
    public void iSearchForProductsFromExcel() {
        List<String> products = ExcelReader.getProducts("src/test/resources/products.xlsx");
        for (String product : products) {
            searchPage.searchFor(product);
            searchPage.selectFirstProduct();
            productPrice = productPage.getPrice();
            productPage.addToCart(3); // Cambiar la cantidad a 3
        }
    }
    @Then("I validate the price in the cart")
    public void iValidateThePriceInTheCart() {
        cartPage.open(); // Asegúrate de abrir la página del carrito
        String cartPrice = cartPage.getCartPrice();
        assertEquals("El precio del carrito no coincide con el precio del producto", productPrice, cartPrice);
    }
}
