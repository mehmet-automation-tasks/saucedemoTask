package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import saucedemo.utilities.Log;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends CommonPageElements{
    int maxPriceElementIndex = 0;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> productsPriceList;

    @FindBy(css = "[class='shopping_cart_link']")
    public WebElement cartBtn;


    public String getTheMostExpensiveProductPrice(){
        List<Double> priceListInDouble = new ArrayList<>();
        productsPriceList.stream().forEach(product -> priceListInDouble.add(Double.parseDouble(product.getText().substring(1))));
        double maxPrice = 0.0;
        for (int i = 0; i < priceListInDouble.size(); i++) {
            if(priceListInDouble.get(i)>maxPrice){
                maxPrice = priceListInDouble.get(i);
                maxPriceElementIndex = i+1;
            }
        }
        return maxPrice+"";
    }

    public void clickOnAddToCartButtonOfTheMostExpensiveProduct(){
        driver.findElement(By.xpath("(//button[.='Add to cart'])["+ maxPriceElementIndex +"]")).click();
    }


}
