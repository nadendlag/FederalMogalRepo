package com.fm;
	import org.testng.annotations.Test;
	import jxl.read.biff.BiffException;
	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

	public class AllUserRegistration {
		WebDriver driver;
		String RegistrationURL;
		String[][] getData;
		int n;
		 WebDriverWait wait;

		File f = new File("C:\\Personal\\FederalMogulData\\RegisterUser.xls");
		
						
		WorkbookCopy workbookCopy = new WorkbookCopy();

		public AllUserRegistration() {
			 System.setProperty("webdriver.chrome.driver", "C:/MyPrograms/Selenium/NewDrivers/chromedriver.exe");
			 driver = new ChromeDriver();
			 //RegistrationURL = "https://localhost:9002/fmstorefront/federalmogul/en/USD/registration";
			//RegistrationURL = "https://qa-federal-mogul.adobecqms.net/fmstorefront/federalmogul/en/USD/registration?";
			RegistrationURL = "https://www.fmmotorparts.com/fmstorefront/federalmogul/en/USD/registration?";
		}

		// Warehouse Distributor light Vehicle Registration
		@DataProvider(name = "whdl")
		public String[][] dataProviderWarehouseDistributorLightVehicle() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(0, f);
			return getData;
		}

		@Test(dataProvider = "whdl")
		public void registerWarehouseDistributorLightVehicle(String str1, String str2, String str3, String str4,
				String str5, String str6, String str7) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Warehouse Distributor Light Vehicle");
			driver.findElement(By.id("accNo")).clear();
			driver.findElement(By.id("accNo")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Retail Shop Owner Registration
		@DataProvider(name = "rso")
		public String[][] dataProviderRetailShopOwner() throws BiffException,
				IOException {
			getData = workbookCopy.workbookCopyfunc(1, f);
			return getData;
		}

		@Test(dataProvider = "rso")
		public void registerRetailShopOwner(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7, String str8) {

			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Repair Shop Owner");
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str1);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str2);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str3);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str4);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str5);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str6);
			new Select(driver.findElement(By.id("pcountry")))
					.selectByVisibleText(str7);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(str8);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Consumer Registration
		@DataProvider(name = "rc")
		public String[][] dataProviderConsumer() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(2, f);
			return getData;
		}

		@Test(dataProvider = "rc")
		public void registerConsumer(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7, String str8,
				String str9) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Consumer");
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str1);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str2);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str3);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str4);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str5);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str6);
			new Select(driver.findElement(By.id("pcountry")))
					.selectByVisibleText(str7);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(str8);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(str9);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Student Registration
		@DataProvider(name = "st")
		public String[][] dataProviderStudent() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(3, f);
			return getData;
		}

		@Test(dataProvider = "st")
		public void registerStudent(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7, String str8,
				String str9, String str10, String str11, String str12) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Student");
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str1);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str2);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str3);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str4);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str5);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str6);
			driver.findElement(By.id("contactAddress")).clear();
			driver.findElement(By.id("contactAddress")).sendKeys(str7);
			driver.findElement(By.id("contactAddress")).clear();
			driver.findElement(By.id("contactAddress")).sendKeys(str8);
			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(str9);
			new Select(driver.findElement(By.id("pcountry")))
					.selectByVisibleText(str10);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		/*	wait = new WebDriverWait(driver, 30);          //add Explicit Wait
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='state']"))));
			driver.findElement(By.xpath("//*[@id='state']")).click();   //After Explicit Wait Click on WebElement
			**/
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText(str11);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(str12);
			driver.findElement(By.id("regsubmit")).click();
			
		}

		// F-M Employee Registration
		@DataProvider(name = "fme")
		public String[][] dataProviderFMEmployee() throws BiffException,
				IOException {
			getData = workbookCopy.workbookCopyfunc(4, f);
			return getData;
		}

		@Test(dataProvider = "fme")
		public void registerFMEmployee(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("F-M Employee");
			driver.findElement(By.id("employeeId")).clear();
			driver.findElement(By.id("employeeId")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("regsubmit")).click();
			
		}

		// Jobber Registration
		@DataProvider(name = "jo")
		public String[][] dataProviderJobber() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(5, f);
			return getData;
		}

		@Test(dataProvider = "jo")
		public void registerJobber(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Jobber");
			driver.findElement(By.id("accNo")).clear();
			driver.findElement(By.id("accNo")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Retailer Registration
		@DataProvider(name = "re")
		public String[][] dataProviderRetailer() throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(7, f);
			return getData;
		}

		@Test(dataProvider = "re")
		public void registerRetailer(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Retailer");
			driver.findElement(By.id("accNo")).clear();
			driver.findElement(By.id("accNo")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Warehouse Distributor Commercial Vehicle Registration
		@DataProvider(name = "wdcv")
		public String[][] dataProviderWarehouseDistributorCommercialVehicle()
				throws BiffException, IOException {
			getData = workbookCopy.workbookCopyfunc(8, f);
			return getData;
		}

		@Test(dataProvider = "wdcv")
		public void registerWarehouseDistributorCommercialVehicle(String str1,
				String str2, String str3, String str4, String str5, String str6,
				String str7) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Warehouse Distributor Commercial Vehicle");
			driver.findElement(By.id("accNo")).clear();
			driver.findElement(By.id("accNo")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("regsubmit")).click();
		}

		// Technician Registration
		@DataProvider(name = "te")
		public String[][] dataProviderTechnician() throws BiffException,
				IOException {
			getData = workbookCopy.workbookCopyfunc(6, f);
			return getData;
		}

		@Test(dataProvider = "te")
		public void registerTechnician(String str1, String str2, String str3,
				String str4, String str5, String str6, String str7, String str8,
				String str9, String str10, String str11, String str12, String str13) {
			driver.get(RegistrationURL);
			new Select(driver.findElement(By.id("whatdescribes")))
					.selectByVisibleText("Technician");
			driver.findElement(By.id("referredBy")).click();
			driver.findElement(By.id("referById")).clear();
			driver.findElement(By.id("referById")).sendKeys(str1);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(str2);
			driver.findElement(By.id("confirmEmail")).clear();
			driver.findElement(By.id("confirmEmail")).sendKeys(str3);
			driver.findElement(By.id("setnewpwd")).clear();
			driver.findElement(By.id("setnewpwd")).sendKeys(str4);
			driver.findElement(By.id("confPassword")).clear();
			driver.findElement(By.id("confPassword")).sendKeys(str5);
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(str6);
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(str7);
			driver.findElement(By.id("contactAddress")).clear();
			driver.findElement(By.id("contactAddress")).sendKeys(str8);
			driver.findElement(By.id("contactAddress")).clear();
			driver.findElement(By.id("contactAddress")).sendKeys(str9);
			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(str10);
			new Select(driver.findElement(By.id("pcountry")))
					.selectByVisibleText(str11);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*	
			wait = new WebDriverWait(driver, 30);          //add Explicit Wait
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='state']"))));
			driver.findElement(By.xpath("//*[@id='state']")).click();   //After Explicit Wait Click on WebElement
		**/
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText(str12);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(str13);
			driver.findElement(By.id("regsubmit")).click();
			
		}

	}


