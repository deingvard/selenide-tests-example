package com.ivliev.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShopPage {

    // FIELDS
    @FindBy(css = ".ModelList__ModelBlockRow") ElementsCollection quantityOfElements;
    @FindBy(css = ".Paging__PageLink:not(.Paging__LastPage)") ElementsCollection quantityOfElements1;
    @FindBy(css = ".img-responsive") SelenideElement catalog;
    @FindBy(css = "[title = 'Компьютеры']") SelenideElement electronic;
    @FindBy(css = "[title = 'Ноутбуки и нетбуки']") SelenideElement laptopsAndNetbooksButton;
    @FindBy(xpath = "//*[contains(@class, 'ModelFilter__OpenHideAttrTxt Page__DarkDotLink') ]") SelenideElement buttonMoreManufacturer;
    @FindBy(xpath = "//label[text()=\"Lenovo\"]") SelenideElement laptopOne;
    @FindBy(xpath = "//label[text()=\"Dell\"]") SelenideElement laptopTwo;
    @FindBy(xpath = "//label[text()=\"HP\"]") SelenideElement laptopThree;
    @FindBy(css = "#minnum_45") SelenideElement minPrice;
    @FindBy(css = "#maxnum_45") SelenideElement maxPrice;
    @FindBy(css = "#minnum_1401") SelenideElement minDiagonal;
    @FindBy(css = "#maxnum_1401") SelenideElement maxDiagonal;
    @FindBy(xpath = "//*[contains(@class, 'ModelFilter__BtnFormSubmit') ]") SelenideElement applyButton;
    @FindBy(xpath = "//div[@class='PanelSetUp__SortBlock']") SelenideElement listWithSortElements;
    @FindBy(xpath = "//div[@class='ModelList']/div[@class='ModelList__ModelBlockRow'][last()]") SelenideElement lastElementOnThePage;
    private String firstElemmm = "";

    // METHODS

    public void clickMarket() {
        catalog.shouldBe(Condition.appear).click();
    }

    public void clickElectronic() {
        electronic.shouldBe(Condition.appear).click();
    }

    public void clickComputersButton() {
        Selenide.sleep(1000);
        laptopsAndNetbooksButton.shouldBe(Condition.appear).click();
    }

    public void setLaptop(){
        buttonMoreManufacturer.shouldBe(Condition.appear).click();
        laptopOne.click();
        Selenide.sleep(1000);
        laptopTwo.click();
        Selenide.sleep(1000);
        laptopThree.click();
    }

    public void setPriceMin(String minPriceValue){
        minPrice.click();
        minPrice.setValue(minPriceValue);
        minPrice.shouldHave(minPriceValue);
    }

    public void setPriceMax(String setPriceMax){
        maxPrice.click();
        maxPrice.setValue(setPriceMax);
        maxPrice.shouldHave(setPriceMax);
    }

    public void setDiagonalMin(String setDiagonalMin){
        minDiagonal.click();
        minDiagonal.setValue(setDiagonalMin);
        minDiagonal.shouldHave(setDiagonalMin);
    }


    public void setDiagonalMax(String setDiagonalMax){
        maxDiagonal.click();
        maxDiagonal.setValue(setDiagonalMax);
        maxDiagonal.shouldHave(setDiagonalMax);
    }

    public void clickApplyButton(){
        applyButton.shouldBe(Condition.appear).click();
        Selenide.sleep(3000);
    }

    public void сountElementsPerPage() {
        System.out.println("Count elements per page  = " + quantityOfElements.size());
        Assert.assertEquals(quantityOfElements.size(), 24);
    }

    public void clickSortButtonASC() {
        SelenideElement buttonSort = listWithSortElements.find(By.className("chzn-txt-sel"));
        buttonSort.click();
        Selenide.sleep(3000);
        ElementsCollection elementsList = listWithSortElements.find(By.className("chzn-results")).findAll(By.tagName("li"));
        elementsList.get(1).click();
        elementsList.shouldHave(CollectionCondition.size(4));
    }

       public void clickSortButtonDESC() {
           SelenideElement buttonSort = listWithSortElements.find(By.className("chzn-txt-sel"));
           buttonSort.click();
           Selenide.sleep(3000);
           ElementsCollection elementsList = listWithSortElements.find(By.className("chzn-results")).findAll(By.tagName("li"));
           elementsList.get(2).click();
           elementsList.shouldHave(CollectionCondition.size(4));
    }

    public String storeFirstElement() {
        this.firstElemmm = quantityOfElements.get(13).getText();
        return  firstElemmm;
    }

    public void savedElementOnLastPageAssert(){

        SelenideElement elem = quantityOfElements1.get(quantityOfElements1.size() - 1);
        elem.click();

        Selenide.sleep(3000);
        lastElementOnThePage.click();

        System.out.println("Element in memory is equals to:" + storeFirstElement());
        System.out.println("Element on the last page is equals to:" + lastElementOnThePage);

        Selenide.sleep(1000);
        Assert.assertEquals(storeFirstElement(), lastElementOnThePage.getText());
    }
}