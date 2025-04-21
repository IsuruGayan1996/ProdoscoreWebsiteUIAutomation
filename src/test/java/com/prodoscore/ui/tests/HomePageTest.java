package com.prodoscore.ui.tests;

import com.codimite.framework.core.annotations.TestCaseID;
import com.codimite.framework.core.annotations.TestCaseType;
import com.codimite.framework.core.enums.TestType;
import com.prodoscore.ui.base.BaseTestObject;
import com.prodoscore.ui.function.HomePageFunction;
import com.prodoscore.ui.po.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTestObject {
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void testSetUp() {
        try {
            //Login to the application
            homePage = HomePageFunction.goToHomePage(urlData.get("homePageUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TestCaseID(id = "QA-TC-133", description = "Test")
    @TestCaseType(types = {TestType.FUNCTIONAL})
    @Test(priority = 1)
    public void VerifyHistogramChartLabelAccuracy() {
        try {
            // Check if the popup content is displayed and close it if it is
            homePage.popupContentHandle();

            // Click on the Prodo Video button
            homePage.clickProdoVidBtn();

            // Wait for the player to load
            homePage.waitUntilPlayerDisplayed();

            // Verify the player is displayed
            softAssert.assertTrue(homePage.isPlayerDisplayed(), "Player is not displayed");

            // Verify iframe (Youtube) is loaded
            softAssert.assertTrue(homePage.getIFrameSrc().contains("youtube"), "Iframe is not loaded");

            // Switch to the iframe
            homePage.switchToIFrame();

            // Verify the video state
            softAssert.assertTrue(homePage.isYtVidPlyBtnDisplayed(), "YouTube play button is not displayed");

            // Switch back to the default content
            homePage.switchToDefaultContent();

            // Click on the YouTube close button
            homePage.clickYtVidCloseBtn();

            // Wait for the player to be hidden
            homePage.waitUntilPlayerHidden();

            // Verify the player is hidden;
            softAssert.assertFalse(homePage.isPlayerDisplayed(), "Player is still displayed");

            //Check for any soft assert failures
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
