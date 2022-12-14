package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@href='/computers']")
    WebElement computerMenu;

    public void clickOnComputer() {
        Reporter.log("clickOnComputer" +computerMenu.toString());
        clickOnElement(computerMenu);
        CustomListeners.test.log(Status.PASS,"clickOnComputer");
    }
    @CacheLookup
    @FindBy(xpath = "//h2[@class='title']//a")
    WebElement desktopMenu;

    public void clickOnDesktop() {
        Reporter.log("clickOnDesktop" + desktopMenu.toString());
        clickOnElement(desktopMenu);
        CustomListeners.test.log(Status.PASS,"clickOnDesktop");
    }

    public void sortProductZToA(){
        List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByValueFromDropDown(By.xpath("//select[@name='products-orderby']"),"6");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h2[@class='product-title']//a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

    }
}
