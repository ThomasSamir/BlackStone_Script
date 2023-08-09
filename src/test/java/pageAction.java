import org.example.LoginLocators1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class pageAction {
    LoginLocators1 locate1 = new LoginLocators1();
    Hooks hooks = new Hooks();

    @Test
    public void LoginIntoSystem() throws InterruptedException {

        // This part for opening the browser also login
        hooks.GetBrowser().navigate().to("https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login");
        hooks.GetBrowser().manage().window().maximize();
        hooks.GetBrowser().findElement(locate1.enterUsername()).sendKeys("store3@admin.com");
        hooks.GetBrowser().findElement(locate1.enterPassword()).sendKeys("P@ssw0rd");
        hooks.GetBrowser().findElement(locate1.clickLoginButton()).click();

       //This part to wait until the Dashboard button appears also get the current page URL
        WebDriverWait LoginWait = new WebDriverWait(hooks.GetBrowser(),Duration.ofSeconds(200));
        LoginWait.until(ExpectedConditions.presenceOfElementLocated(locate1.DashBoardButton()));
        String URL = hooks.GetBrowser().getCurrentUrl();


        //This part to assert that the admin dashboard page appeared and print page title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(URL, "https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/admin/dashboard", "Failed");
        System.out.println("\n"+hooks.GetBrowser().findElement(locate1.HomeTitle()).getText()+"\n");

        //This part to open the profile menu to click on logout
        hooks.GetBrowser().findElement(locate1.ClickProfileButton()).click();
        hooks.GetBrowser().findElement(locate1.clickLogoutButton()).click();

        //This part to wait until the user logout and login button appears
        WebDriverWait LogoutWait = new WebDriverWait(hooks.GetBrowser(),Duration.ofSeconds(50));
        LogoutWait.until(ExpectedConditions.presenceOfElementLocated(locate1.clickLoginButton()));

        //This part to assure that user logged out
        String URL2 = hooks.GetBrowser().getCurrentUrl();
        softAssert.assertEquals(URL2, "https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login", "Failed");

        softAssert.assertAll();


        hooks.QuitBrowser();
    }

}
