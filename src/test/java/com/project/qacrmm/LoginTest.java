package com.project.qacrmm;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private DesiredCapabilities desiredCapablities = new DesiredCapabilities();

  public static final String SELENIUM_GRID_URL = System.getProperty("selenium_grid_url");
     

  @BeforeClass
  public void SetUp() throws Exception {
    desiredCapablities.setBrowserName(System.getProperty("browser"));
    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_URL), desiredCapablities);
  }

  @Test
  public void validUserCrediantials() {
    driver.get(System.getProperty("website"));
    driver.findElement(By.id("authentication_username")).sendKeys("heather");
    driver.findElement(By.id("authentication_password")).sendKeys("heather");
    driver.findElement(By.name("commit")).click();
  }

  @AfterClass
  public void TearDown() {
    driver.quit();
  }
}
