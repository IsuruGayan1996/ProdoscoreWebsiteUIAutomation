package com.prodoscore.ui.po;

import com.codimite.framework.ui.driver.controller.CDriver;
import com.prodoscore.ui.base.BasePageObject;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {
    // Popup content
    private final By popupContent = By.cssSelector(".popup-content");
    private final By popupCloseBtn = By.id("close-popup");
    // Prodo-video
    private final By prodoVidBtn = By.cssSelector(".circle.prodo-vid");
    private final By player = By.id("videoStory");
    private final By iFrame = By.cssSelector("iframe.yt-video");
    private final By ytVidPlyBtn = By.cssSelector("button.ytp-play-button");
    private final By ytVidCloseBtn = By.cssSelector(".popupCloseButton");

    public HomePage(CDriver driver) {
        super(driver);
    }

    public void popupContentHandle() {
        if (isDisplayed(popupContent)) {
            click(popupCloseBtn);
        }
    }

    public void clickProdoVidBtn() {
        click(prodoVidBtn);
    }

    public void waitUntilPlayerDisplayed() {
        waitToBeDisplayed(player);
    }

    public boolean isPlayerDisplayed() {
        return isDisplayed(player);
    }

    public void waitUntilPlayerHidden(){
        waitToBeHidden(player);
    }

    public String getIFrameSrc() {
        return getAttribute(iFrame, "src");
    }

    public void switchToIFrame() {
        cDriver.switchTo().frame(cDriver.findElement(iFrame));
    }

    public void switchToDefaultContent() {
        cDriver.switchTo().defaultContent();
    }

    public boolean isYtVidPlyBtnDisplayed() {
        return isDisplayed(ytVidPlyBtn);
    }

    public void clickYtVidCloseBtn() {
        click(ytVidCloseBtn);
    }
}
