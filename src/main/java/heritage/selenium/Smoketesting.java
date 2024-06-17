package heritage.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Smoketesting {
    private WebDriver driver;

    public Smoketesting(WebDriver driver) {
        this.driver = driver;
    }

    public void runTests() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement megaMenu = driver.findElement(By.id("menu16"));
        Actions actions = new Actions(driver);
        actions.moveToElement(megaMenu).perform();
        Thread.sleep(5000);

        //Chlidcategory
        List<WebElement> listItems = driver.findElements(By.className("is-loaded"));
        listItems.get(0).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);

        //PLP1
        WebElement plp1 = driver.findElement(By.className("subcategories__article-title"));
        plp1.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
        Thread.sleep(2000);

        //PLP2
        WebElement plp2 = driver.findElement(By.className("form-actions"));
        plp2.click();
        Thread.sleep(2000);

        //Form modal go to the cart page
        WebElement button = driver.findElement(By.className("modal-buttons"));
        button.click();
        Thread.sleep(2000);

        //Go back to the PLP page
        driver.navigate().back();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");

        //PLP to PDP
        WebElement productname = driver.findElement(By.className("product-item-link"));
        productname.click();
        System.out.println("Navigate to the pdp page");

        //Add Product from PDP
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        WebElement AddToCart = driver.findElement(By.id("product-addtocart-button"));
        AddToCart.click();
        Thread.sleep(2000);

        //Continue shopping
        WebElement continueshopping = driver.findElement(By.className("modal-buttons"));
        Thread.sleep(1000);
        continueshopping.click();

        //Click on Logo
        WebElement logo = driver.findElement(By.className("logo"));
        Thread.sleep(1000);
        logo.click();

        //Search Product
        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("Beetle");
        search.submit();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");

        WebElement quantityBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#instant-search-results-container > div > div > ol > li:nth-child(1) > div > div.result.item > div > div > div.product-item__lower > form > div.product-item__price > div.qty_wrapper > input")));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        quantityBox.submit();
        Thread.sleep(2000);

        WebElement againgotobasket = driver.findElement(By.className("modal-buttons"));
        againgotobasket.click();
        Thread.sleep(3000);
        driver.navigate().back();

        //Click on cart Icon
        WebElement cartIcon = driver.findElement(By.className("minicart-wrapper"));
        Thread.sleep(2000);
        cartIcon.click();

        //From cart update the quantity
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
        WebElement updatequantity = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div/div[4]/div[2]/form[1]/div[1]/div/table/tbody[2]/tr[1]/td[3]/div/div/button[2]"));
        updatequantity.click();
        Thread.sleep(5000);
        WebElement update = driver.findElement(By.className("qty-update js-update-qty"));
        update.click();
        Thread.sleep(5000);

//        WebElement updatequantity1 = driver.findElement(By.className("qty-actions__iterator qty-actions__iterator--decrement js-qty-iterator"));
//        updatequantity1.click();
//        WebElement update1 = driver.findElement(By.className("qty-update js-update-qty"));
//        update1.click();

    }
}
