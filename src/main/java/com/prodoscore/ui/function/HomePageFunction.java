package com.prodoscore.ui.function;

import com.prodoscore.ui.base.BaseFunction;
import com.prodoscore.ui.po.HomePage;

public class HomePageFunction extends BaseFunction {
    protected static HomePage homePage;

    public static HomePage goToHomePage(String url) {
        cDriver.get(url);
        homePage = new HomePage(cDriver);
        return homePage;
    }
}
