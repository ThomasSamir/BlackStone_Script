import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    WebDriver driver;

    public WebDriver GetBrowser() {
        if (driver == null) {
            String ChromePath = System.getProperty("user dir") + "\\SRC\\Main\\resourceschromedriver.exe";
            System.setProperty("Webdriver.chrome.driver", ChromePath);
            return driver = new ChromeDriver();
        }

        return driver;
    }
    public void QuitBrowser(){
        driver.close();
        driver= null;
    }
}
