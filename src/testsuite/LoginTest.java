package testsuite;
/*
Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValid Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed on page
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    /*
    1. userSholdLoginSuccessfullyWithValid Credentials
    * Enter “standard_user” username
    * Enter “secret_sauce” password
    * Click on ‘LOGIN’ button
    * Verify the text “PRODUCTS”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        // Verify the text "PRODUCTS"
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Login failed!", expectedText, actualText);
    }

    /*
    2. verifyThatSixProductsAreDisplayedOnPage
    * Enter “standard_user” username
    * Enter “secret_sauce” password
    * Click on ‘LOGIN’ button
    * Verify that six products are displayed on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click on LOGIN button
        driver.findElement(By.id("login-button")).click();

        // Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
        int actualProductCount = products.size();
        int expectedProductCount = 6;
        Assert.assertEquals(actualProductCount, expectedProductCount);
        //Assert.assertEquals(actualProductCount, expectedProductCount, "Incorrect number of products displayed!");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
