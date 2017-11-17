package com.ivliev.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class BaseStep {

    public void shopOpen(){
        Selenide.open("http://www.shop.by");
    }

    public static void beforeTest() {
        Configuration.timeout = 6000;

        Configuration.browser = "firefox";
    }

    public static void afterTest() {
        Selenide.sleep(15000);
    }
}