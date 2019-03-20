package com.fm;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WhereToBuy {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
 	
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:/MyPrograms/Selenium/Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		baseUrl= "https://qa-federal-mogul.adobecqms.net/fmstorefront/";
		//baseUrl = "https://www.fmmotorparts.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  System.out.println("connected to the driver************** ");
  }

  @Test
  public void testWhereToBuy() throws Exception {
    //driver.get(baseUrl + "/fmstorefront/");
	driver.get(baseUrl); 
    driver.findElement(By.linkText("Where to Buy")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//select[@id='']")).click();
    driver.findElement(By.cssSelector("option[value=\"string:US\"]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("48098");
    new Select(driver.findElement(By.name("brand"))).selectByVisibleText("ANCO");
    driver.findElement(By.cssSelector("option[value=\"string:ANCO\"]")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//h2[@class=\"where-to-buy-search-results-headline\"]/span[3]")).getText(), "62 Locations Found Near 48098");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("label > span")).click();
    driver.findElement(By.id("locType_store")).click();
    driver.findElement(By.cssSelector("label > span")).click();
    driver.findElement(By.id("locType_all")).click();
    driver.findElement(By.xpath("//div[3]/label/span")).click();
    driver.findElement(By.id("distance_5")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//h2[@class=\"where-to-buy-search-results-headline\"]/span[3]")).getText(), "12 Locations Found Near 48098");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Home")).click();
    try {
      assertEquals(driver.findElement(By.linkText("Sign In")).getText(), "Sign In");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
