package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.junit.Assert.*;

import java.io.File;

public class Task1 {
    WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        String expectedError = "Please enter a number";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String text = "ftdchj";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(text);
        submit.click();

        assertEquals(expectedError, error.getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        String expectedError = "Number is too small";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String number = "10";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(number);
        submit.click();

        assertEquals(expectedError, error.getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        String expectedError = "Number is too big";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String number = "1000";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(number);
        submit.click();

        assertEquals(expectedError, error.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        String expectedError = "";
        String expectedResult = "Square root of 81 is 9.00";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String number = "81";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(number);
        submit.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String result = alert.getText();
        alert.accept();

        System.out.println(result);
        assertEquals(expectedError, error.getText());
        assertEquals(expectedResult, result);
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        String expectedError = "";
        String expectedResult = "Square root of 50 is 7.07";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String number = "50";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(number);
        submit.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String result = alert.getText();
        alert.accept();

        System.out.println(result);
        assertEquals(expectedError, error.getText());
        assertEquals(expectedResult, result);
    }
}
