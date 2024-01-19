package com.lambdatest.tunnel;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExecutionListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenSingle implements IExecutionListener {
  Tunnel t;

  WebDriver driver = null;
  public static String status = "passed";

  String username = System.getenv("LT_USERNAME");
  String access_key = System.getenv("LT_ACCESS_KEY");

  @BeforeTest
  @org.testng.annotations.Parameters(value = { "browser", "version", "platform", "resolution" })
  public void setUp(String browser, String version, String platform, String resolution) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("build", "Single Maven Tunnel");
    capabilities.setCapability("name", "Maven Tunnel");
    capabilities.setCapability("browserName", browser);
    capabilities.setCapability("version", version);
    capabilities.setCapability("platform", platform);
    capabilities.setCapability("tunnel", true);
    capabilities.setCapability("network", true);
    capabilities.setCapability("console", true);
    capabilities.setCapability("visual", true);
    capabilities.setCapability("tunnelName", "MavenSingle");

    // create tunnel instance
    t = new Tunnel();
    HashMap<String, String> options = new HashMap<String, String>();
    options.put("user", username);
    options.put("key", access_key);
    options.put("tunnelName", "MavenSingle");

    // start tunnel
    t.start(options);
    driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"),
        capabilities);
    System.out.println("Started session");
  }

  @Test()
  public void testTunnel() throws Exception {
    // Check LocalHost on XAMPP
    driver.get("https://app.buildpiper.io/login");
    // Let's check that the item we added is added in the list.
    driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("opstree@opstree.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Tree@Jul2023");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class=\"btn-signin btn__primary\"]")).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        WebElement usermenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-controls='simple-menu' and @aria-haspopup='true']")));
        // Perform the click action
        usermenu.click();
Thread.sleep(4000);
// WebElement switchuser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-link btn-link-green']")));
// // Perform the click action
// switchuser.click();
// Thread.sleep(4000);
//         // driver.quit();
        System.out.println("TestFinished");
    
  }
  @AfterTest
  public void tearDown() throws Exception {
    ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
    driver.quit();
    // close tunnel
    t.stop();
  }
}
// mvn clean test -DsuiteXmlFile=MavenSingle.xml
