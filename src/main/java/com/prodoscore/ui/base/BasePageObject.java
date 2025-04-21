package com.prodoscore.ui.base;

import com.codimite.framework.ui.base.UIBasePage;
import com.codimite.framework.ui.driver.controller.CDriver;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePageObject extends UIBasePage {
    public BasePageObject(CDriver driver) {
        super(driver);
    }
}