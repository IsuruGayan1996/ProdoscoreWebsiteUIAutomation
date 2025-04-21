package com.prodoscore.ui.base;

import com.codimite.framework.core.config.enums.ConfigKeys;
import com.codimite.framework.core.testdataprovider.enums.DataProviderType;
import com.codimite.framework.core.testdataprovider.utils.DataProviderUtil;
import com.codimite.framework.ui.base.UIBaseTest;
import com.codimite.framework.ui.driver.controller.CDriver;
import com.prodoscore.ui.constant.DataSets;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseTestObject extends UIBaseTest {
    public static HashMap<String, String> urlData = null;
    protected static SoftAssert softAssert;
    protected static Map<String, String> sessionDetails = null;

    @BeforeSuite(alwaysRun = true)
    public void loadEnvironmentData() throws Exception {
        try {
            String path = config.getValue(ConfigKeys.KEY_DATA_FILE_PATH.getKey()) + config.getValue(ConfigKeys.KEY_ENVIRONMENT.getKey()).toLowerCase();
            DataProviderUtil.setDataFile(path, DataProviderType.PROPERTY);
            DataProviderUtil.loadData(EnumSet.allOf(DataSets.class).stream().map(DataSets::name).collect(Collectors.toList()));
            urlData = DataProviderUtil.getDataSet("Data", DataSets.Url.name());
        } catch (Exception e) {
            throw new Exception("Failed : loadEnvironmentData()" + e.getLocalizedMessage());
        }
    }

    @BeforeTest(alwaysRun = true)
    public void createBrowser() throws Exception {
        try {
            System.out.println("launchBrowser()");
            CDriver.launchDriver();
        } catch (Exception e) {
            throw new Exception("Failed : createBrowser()" + e.getLocalizedMessage());
        }
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() throws Exception {
        try {
            System.out.println("closeBrowser()");
            if (cDriver != null) {
                cDriver.close();
                cDriver.quit();
            }
        } catch (Exception e) {
            throw new Exception("Failed : closeBrowser()" + e.getLocalizedMessage());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {

        try {
            softAssert = new SoftAssert();

        } catch (Exception e) {
            throw new Exception("Failed : beforeMethod()" + e.getLocalizedMessage());
        }
    }
}