package browserfactory;
/*
Project-4 - ProjectName : com-saucedemo-sw-2
BaseUrl = https://www.saucedemo.com/
1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;



    public void openbrowser(String baseUrl) {
        // Launch the browser
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();

    }
}
