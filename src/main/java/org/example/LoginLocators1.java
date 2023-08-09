package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLocators1 {
    WebDriver driver;

    public By enterUsername() {
        return new By.ByXPath("//*[@id=\"mat-input-0\"]");
    }

    public By enterPassword() {
        return new By.ByXPath("//*[@id=\"mat-input-1\"]");

    }


    public By clickLoginButton() {
        return new By.ByXPath("/html/body/app-root/anonymous-layout/section/div[2]/div[2]/login/div/div[3]/loader-button/button");

    }

    public By DashBoardButton() {
        return new By.ByXPath("/html/body/app-root/admin-layout/section/div[1]/header/section/navbar/div/div[1]/nav-items/div/ul/li[1]/navitem/a");

    }
    public By ClickProfileButton() {
        return By.xpath("/html/body/app-root/admin-layout/section/div[1]/header/section/navbar/div/div[2]/nav-actions/div/ul/li[4]/div/div[2]/img");
    }

    public By clickLogoutButton() {
        return By.xpath("/html/body/app-root/admin-layout/section/div[1]/header/section/navbar/div/div[2]/nav-actions/div/ul/li[4]/div/div[2]/ul/li[3]");

    }


    public By HomeTitle() {
        return new By.ByXPath("/html/body/app-root/admin-layout/section/div[3]/dashboard/p");

    }


}