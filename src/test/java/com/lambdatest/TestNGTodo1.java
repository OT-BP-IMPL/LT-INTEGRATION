package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("project", "git-testng");

        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };

        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        // String spanText;
        System.out.println("Loading Url");
        // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Opening WebApp\", \"level\": \"info\"}}");

        // driver.get("");

        // // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking List Items\", \"level\": \"info\"}}");

        // System.out.println("Checking Box");
        // driver.findElement(By.name("li1")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li2")).click();

        // System.out.println("Checking Box");
        // driver.findElement(By.name("li3")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li4")).click();

        // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding Items\", \"level\": \"info\"}}");

        // driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        // driver.findElement(By.id("addbutton")).click();

        // driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
        // driver.findElement(By.id("addbutton")).click();

        // driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
        // driver.findElement(By.id("addbutton")).click();

        // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking More Items\", \"level\": \"info\"}}");

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li1")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li3")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li7")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li8")).click();
        // Thread.sleep(300);

        // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding and Verify List Items\", \"level\": \"info\"}}");
        // System.out.println("Entering Text");
        // driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");

        // driver.findElement(By.id("addbutton")).click();

        // System.out.println("Checking Another Box");
        // driver.findElement(By.name("li9")).click();

        // // Let's also assert that the todo we added is present in the list.

        // spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
        // Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
        // Status = "passed";
        // Thread.sleep(150);
 driver.get("http://122.160.30.218:16680/login");

        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("opstree@opstree.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Opstree@12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class=\"btn-signin btn__primary\"]")).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        WebElement usermenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-controls='simple-menu' and @aria-haspopup='true']")));
        // Perform the click action
        usermenu.click();
Thread.sleep(4000);
WebElement switchuser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link btn-link-green']")));
// Perform the click action
switchuser.click();
Thread.sleep(4000);
        // driver.quit();
        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        // driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding Test Result and Closing Browser\", \"level\": \"info\"}}");
        // driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}