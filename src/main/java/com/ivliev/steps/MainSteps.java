package com.ivliev.steps;

import com.codeborne.selenide.Selenide;
import com.ivliev.pages.ShopPage;


public class MainSteps extends BaseStep {

    ShopPage shopPage = null;

    public MainSteps() {
        shopPage = Selenide.page(ShopPage.class);
    }

    public MainSteps openShop() {
        super.shopOpen();
        return this;
    }
    public MainSteps clickMarket() {
        shopPage.clickMarket();
        return this;
    }

    public MainSteps chooseComputers() {
        shopPage.clickElectronic();
        return this;
    }

    public MainSteps chooseLaptopsAndNetbooksButton() {
        shopPage.clickComputersButton();
        return this;
    }

    public MainSteps setLaptops(){
        shopPage.setLaptop();
        return this;
    }

    public MainSteps setPriceMin(String minPrice){
        shopPage.setPriceMin(minPrice);
        return this;
    }
    public MainSteps setPriceMax(String maxPrice){
        shopPage.setPriceMax(maxPrice);
        return this;
    }
    public MainSteps setDiagonalMin(String minDiagonal){
        shopPage.setDiagonalMin(minDiagonal);
        return this;
    }
    public MainSteps setDiagonalMax(String maxDiagonal){
        shopPage.setDiagonalMax(maxDiagonal);
        return this;
    }

    public MainSteps clickApplyButton() {
        shopPage.clickApplyButton();
        return this;
    }
    public MainSteps сountElementsPerPage() {
        shopPage.сountElementsPerPage();
        return this;
    }
    public MainSteps sortLaptopPageASC() {
        shopPage.clickSortButtonASC();
        return this;
    }
    public MainSteps sortLaptopPageDESC() {
        shopPage.clickSortButtonDESC();
        return this;
    }
    public MainSteps storeFirstElement() {
        shopPage.storeFirstElement();
        return this;
    }
    public MainSteps lastPage() {
        shopPage.savedElementOnLastPageAssert();
        return this;
    }

}