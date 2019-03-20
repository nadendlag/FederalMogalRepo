package com.fm;

import org.testng.annotations.Test;
import jxl.read.biff.BiffException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class PartsFinder {
	WebDriver driver;
	String baseUrl;
	String[][] getData;
	int n;
	 WebElement box ;
	 WebDriverWait wait;
	File f = new File("C:\\MyPrograms\\FederalMogulProject\\TestData\\PartsFinder.xls");
	WorkbookCopy workbookCopy = new WorkbookCopy();
	Logger log;

	public PartsFinder() {
		System.setProperty("webdriver.chrome.driver", "C:/MyPrograms/Selenium/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl= "https://qa-federal-mogul.adobecqms.net/fmstorefront/";
        log = Logger.getLogger("devpinoyLogger");

	}
	
	
// Vehicle tab in PartsFinder
	@DataProvider(name = "vehicle")
	public String[][] getDataFromExcelVehicle() throws BiffException, IOException {
		getData = workbookCopy.workbookCopyfunc(0, f);
		return getData;
	}

	@Test(dataProvider = "vehicle")
	public void showVehicle(String str1, String str2, String str3, String str4 ) {
	    System.out.println("VehicleType is :  " +str1 +",   Year:" +str2 +" , Make: " +str3 +"   , Model : "+str4);

	    driver.get(baseUrl);
		log.debug("opening webiste");
	    driver.findElement(By.linkText("VEHICLE")).click();
  		 log.debug("Vehicle tab in the PartsFinder");

	    box = driver.findElement(By.xpath("//*[@id='normalYMMForm']"));
	   
	    new Select(box.findElement(By.id("vehiclesegment"))).selectByVisibleText(str1);
	   
	    wait = new WebDriverWait(driver, 15);          //add Explicit Wait
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='year']"))));
	    driver.findElement(By.xpath("//*[@id='year']")).click();   //After Explicit Wait Click on WebElement
	   	new Select(box.findElement(By.xpath(".//*[@id='year']"))).selectByValue(str2);
	    
	    wait = new WebDriverWait(driver, 15);          //add Explicit Wait
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("make"))));
	    driver.findElement(By.id("make")).click();  //After Explicit Wait Click on WebElement
	    new Select(box.findElement(By.id("make"))).selectByValue(str3);
	    
	    wait = new WebDriverWait(driver, 15);          //add Explicit Wait
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("modelhome"))));
	    driver.findElement(By.id("modelhome")).click();   //After Explicit Wait Click on WebElement
	    new Select(box.findElement(By.id("modelhome"))).selectByValue(str4);
	    
	   driver.findElement(By.linkText("LOOK IT UP")).click();
	   wait = new WebDriverWait(driver, 15);          //add Explicit Wait
		 log.debug("Vehicle tab is done in the PartsFinder");

	} 
			
// VIN Tab in PartsFinder
	@DataProvider(name = "VinNumber")
	public String[][] getDataFromExcelVIN() throws BiffException, IOException {
		getData = workbookCopy.workbookCopyfunc(2, f);
		return getData;
	}

	@Test(dataProvider = "VinNumber")
	public void showVin(String str1) {
	    System.out.println("VinNumber is :  " +str1);

	    driver.get(baseUrl);
		driver.findElement(By.linkText("VIN")).click();
		
		WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		wait_iframe.until(ExpectedConditions.visibilityOfElementLocated((By.id("vin"))));
		
		driver.findElement(By.id("vin")).clear();
		driver.findElement(By.id("vin")).sendKeys(str1);
	    driver.findElement(By.xpath("//*[@id='vinLookupFormData']/div[2]/button")).click();
	} 

	
// License plate tab in PartsFinder 
		@DataProvider(name = "lp")
		public String[][] getDataFromExcelLicensePlate() throws BiffException,
				IOException {
			getData = workbookCopy.workbookCopyfunc(3, f);
			return getData;
		}

		@Test(dataProvider = "lp")
		public void showLicensePlate(String str1, String str2) {
			
			System.out.println("LicensePlate ::" +str1);
			System.out.println("state ::" +str2);
			driver.get(baseUrl);
			driver.findElement(By.linkText("LICENSE PLATE")).click();
			WebDriverWait wait_iframe1;
			wait_iframe1 = new WebDriverWait(driver, 20000);
			wait_iframe1.until(ExpectedConditions.visibilityOfElementLocated((By.name("licensePlate"))));
			
			
			box = driver.findElement(By.xpath("//*[@id='LicensePlateRequestForm']"));
			box.findElement(By.name("licensePlate")).sendKeys(str1);
			new Select(box.findElement(By.tagName("select"))).selectByVisibleText("Michigan");
			
			
			driver.findElement(By.xpath("//*[@id='LicensePlateRequestForm']/div[3]/button")).click();
			System.out.println("after License plate");
		
		}
	

// Competitor Tab in PartsFinder
		@DataProvider(name = "competitor")
		public String[][] getDataFromExcelCompetitor() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(1, f);
			return getData;
		}

		@Test(dataProvider = "competitor")
		public void showCompetitor(String str1) {
		    System.out.println("Competitor is :  " +str1);

		    driver.get(baseUrl);
			driver.findElement(By.linkText("COMPETITOR")).click();
			
			WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
			wait_iframe.until(ExpectedConditions.visibilityOfElementLocated((By.name("externalPart"))));

			driver.findElement(By.name("externalPart")).clear();
			driver.findElement(By.name("externalPart")).sendKeys(str1);
		    driver.findElement(By.xpath("//*[@id='partInterchangeForm']/div[2]/button")).click();

		}

}
	
