package com.Step_Definaton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Step_Defination {

	public static WebDriver driver;

	@Given("User launch Adactin web Application")
	public void user_launch_adactin_web_application() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");

	}

	@Then("User verify Adactin Home page Hotel is displayed")
	public void user_verify_adactin_home_page_hotel_is_displayed() {

		String title = driver.getTitle();
		boolean contains = title.contains("Adactin.com - Hotel Reservation System");
		Assert.assertTrue("Verify Title", contains);
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Karthik2106");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Moon@123.");

	}

	@When("User clicks Login Button")
	public void user_clicks_login_button() {

		driver.findElement(By.xpath("//input[@id='login']")).click();

	}

	@Then("User verify Search Hotel page is displayed")
	public void user_verify_search_hotel_page_is_displayed() {

		WebElement welcomePage = driver
				.findElement(By.xpath("//td[contains(text(),'Welcome to Adactin Group of Hotels')]"));

		String text = welcomePage.getText();
		System.out.println(text.contains("AdactinGroupofHotels"));

	}

	@When("User select valid Location,Hotels Name,Room Type,no of Rooms,check in date,check out date,Adults per Room,Children per Room")
	public void user_select_valid_location_hotels_name_room_type_no_of_rooms_check_in_date_check_out_date_adults_per_room_children_per_room() {

		WebElement sctlocation = driver.findElement(By.xpath("//Select[@name='location']"));
		Select location = new Select(sctlocation);
		location.selectByIndex(4);
		sctlocation.click();

		WebElement scthotels = driver.findElement(By.xpath("//select[@name='hotels']"));
		Select hotels = new Select(scthotels);
		hotels.selectByIndex(3);
		scthotels.click();

		WebElement sctRoomType = driver.findElement(By.xpath("//select[@name='room_type']"));
		Select roomType = new Select(sctRoomType);
		roomType.selectByIndex(3);
		sctRoomType.click();

		WebElement sctNumberOfRooms = driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select NumberOfRoom = new Select(sctNumberOfRooms);
		NumberOfRoom.selectByIndex(3);
		sctNumberOfRooms.click();

		WebElement sctChkInDate = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		sctChkInDate.clear();
		sctChkInDate.sendKeys("03/02/2022");

		WebElement sctChkOutDate = driver.findElement(By.xpath("//input[@name='datepick_out']"));
		sctChkOutDate.clear();
		sctChkOutDate.sendKeys("03/04/2022");

		WebElement sctAdultsperRoom = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select AdultsperRoom = new Select(sctAdultsperRoom);
		AdultsperRoom.selectByIndex(2);
		sctAdultsperRoom.click();

		WebElement sctChildsperRoom = driver.findElement(By.xpath("//select[@name='child_room']"));
		Select ChildsperRoom = new Select(sctChildsperRoom);
		AdultsperRoom.selectByIndex(3);
		sctAdultsperRoom.click();

	}

	@When("User clicks search Button")
	public void user_clicks_search_button() {

		WebElement serachBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		serachBtn.click();

	}

	@Then("User verify Select Hotel page is displayed")
	public void user_verify_select_hotel_page_is_displayed() {

		WebElement page2 = driver.findElement(By.xpath("//td[@class='welcome_menu'][1]"));
		String text = page2.getText();
		boolean select = text.contains("Welcome to Adactin Group of Hotels");
		Assert.assertTrue("verify title", select);
		System.out.println("Welcome page:" + text);
	}

	@When("User select the select hotel options")
	public void user_select_the_select_hotel_options() {

		WebElement radioBtn = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
		radioBtn.click();
	}

	@When("User click search Button")
	public void user_click_search_button() {

		WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		continueBtn.click();
	}

	@Then("User verify Book A hotel page is displayed")
	public void user_verify_book_a_hotel_page_is_displayed() {

		WebElement page3 = driver.findElement(By.xpath("//td[@class='welcome_menu'][1]"));
		String text = page3.getText();
		boolean select = text.contains("Welcome to Adactin Group of Hotels");
		Assert.assertTrue("verify title", select);
		System.out.println(" Select Hotel page:" + text);

	}

	@When("User enters valid First Name,Last Name,Billing Address,Credit card number,Card Type and select Month,Year,Cvv number")
	public void user_enters_valid_first_name_last_name_billing_address_credit_card_number_card_type_and_select_month_year_cvv_number()
			throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Karthik");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Raja");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Ramanathapuram");
		driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("6988123456780980");

		WebElement cardType = driver.findElement(By.xpath("//select[@name='cc_type']"));
		Select select = new Select(cardType);
		select.selectByIndex(2);

		WebElement cardMonth = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		Select month = new Select(cardMonth);
		month.selectByIndex(4);

		WebElement CardYear = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
		Select Year = new Select(CardYear);
		Year.selectByIndex(12);

		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("4560");

	}

	@When("User clicks BookNow Button")
	public void user_clicks_book_now_button() throws InterruptedException {

		driver.findElement(By.xpath(("//input[@id='book_now']"))).click();
		Thread.sleep(6000);

	}

	@Then("User verify Booking Verification page is displayed")
	public void user_verify_booking_verification_page_is_displayed() throws InterruptedException {

		
		WebElement findElement = driver.findElement(By.xpath("//td[contains(text(),'Book')]"));
		String text = findElement.getText();
		boolean contains = text.contains("Book");
		System.out.println(contains);
	}

	@Then("User verify the Order Id is displayed")
	public void user_verify_the_order_id_is_displayed() {

		WebElement txt = driver.findElement(By.xpath("//input[@name='order_no']"));
		String attribute = txt.getAttribute("value");
		System.out.println("OrderId:" + attribute);
		driver.quit();

	}

}
