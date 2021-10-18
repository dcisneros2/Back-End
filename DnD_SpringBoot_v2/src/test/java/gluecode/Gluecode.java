package gluecode;

import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * This file is called a "Step Definition File". It contains what we refer to as a "Gluecode". Gluecode is
 * the code that is generated for us via Cucumber.
 */
public class Gluecode {
	
	private static WebDriver driver;

	@Given("the user is on the login page")
	public void a_user_is_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Navigate to the home page
		driver.get("http://localhost:4200/");
	}
	
	@Given("the user is on the player dashboard")
	public void the_user_is_on_the_player_dashboard() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Navigate to the home page
		driver.get("http://localhost:4200/dashboard");
	}

	@When("the player user inputs the correct username")
	public void the_player_user_inputs_the_correct_username() {
		WebElement usernameBox = driver.findElement(By.id("usernameinput"));
		usernameBox.sendKeys("user1");
	}

	@When("the player user inputs the correct password")
	public void the_player_user_inputs_the_correct_password() {
		WebElement passwordBox = driver.findElement(By.id("passwordinput"));
		passwordBox.sendKeys("pass1");
	}
	
	@When("the dungeon master user inputs the correct username")
	public void the_dungeon_master_user_inputs_the_correct_username() {
		WebElement usernameBox = driver.findElement(By.id("usernameinput"));
		usernameBox.sendKeys("user2");
	}

	@When("the dungeon master user inputs the correct password")
	public void the_dungeon_master_user_inputs_the_correct_password() {
		WebElement passwordBox = driver.findElement(By.id("passwordinput"));
		passwordBox.sendKeys("pass2");
	}

	@Then("the user is sent to the player home page")
	public void the_user_is_sent_to_the_player_home_page() {
		Assert.assertEquals("http://localhost:4200/dashboard", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the user is sent to the dungeon master home page")
	public void the_user_is_sent_to_the_manager_page() {
		Assert.assertEquals("http://localhost:4200/dashboard", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the user is forwarded to the login page")
	public void the_user_is_redirected_to_the_login_page() {
		Assert.assertEquals("http://localhost:4200/", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@When("the player user inputs the incorrect password")
	public void the_user_inputs_the_incorrect_password() {
		WebElement passwordBox = driver.findElement(By.id("passwordinput"));
		passwordBox.sendKeys("incorrect");
	}
	
	@When("I click login")
	public void i_click_logout() {
		WebElement logoutButton = driver.findElement(By.id("submitButton"));
		logoutButton.click();
	}
	
	@When("I click submit")
	public void i_click_submit() {
		WebElement logoutButton = driver.findElement(By.id("submitButton2"));
		logoutButton.click();
	}
	
	@Then("I am redirected to the login page")
	public void i_am_redirected_to_the_login_page() {
		Assert.assertEquals("http://localhost:4200/", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player clicks on a character")
	public void the_player_clicks_on_a_character() {
		WebElement characterButton = driver.findElement(By.id("campaignButton"));
		characterButton.click();
	}
	
	@When("the player clicks the create character button")
	public void the_player_clicks_the_create_character_button() {
		WebElement createButton = driver.findElement(By.id("createButton"));
		createButton.click();
	}
	
	@Then("the user is sent to the character page")
	public void the_user_is_sent_to_the_character_page() {
		Assert.assertEquals("http://localhost:4200/character", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the character creation menu pops up")
	public void the_character_creation_menu_pops_up() {
		WebElement createMenu = driver.findElement(By.id("cdk-overlay-0"));
		Assert.assertNotNull(createMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs a character name")
	public void the_player_inputs_a_character_name() {
		WebElement charName = driver.findElement(By.id("charName"));
		charName.sendKeys("charnametest");
	}
	
	@When("the player inputs a player name")
	public void the_player_inputs_a_player_name() {
		WebElement playName = driver.findElement(By.id("playName"));
		playName.sendKeys("playernametest");
	}
	
	@When("the player inputs a character race")
	public void the_player_inputs_a_character_race() {
		WebElement charRace = driver.findElement(By.id("charRace"));
		charRace.sendKeys("charracetest");
	}
	
	@When("the player inputs a class")
	public void the_player_inputs_a_class() {
		WebElement className = driver.findElement(By.id("className"));
		className.sendKeys("classtest");
	}
	
	@When("the player inputs a level")
	public void the_player_inputs_a_level() {
		WebElement charLevel = driver.findElement(By.id("charLevel"));
		charLevel.sendKeys("1");
	}
	
	@When("the player inputs an alignment")
	public void the_player_inputs_an_alignment() {
		WebElement charAlign = driver.findElement(By.id("charAlign"));
		charAlign.sendKeys("charaligntest");
	}
	
	@Then("the basic information is stored in the form")
	public void the_basic_information_is_stored_in_the_form() {
		WebElement charName = driver.findElement(By.id("charName"));
		WebElement playName = driver.findElement(By.id("playName"));
		WebElement charRace = driver.findElement(By.id("charRace"));
		WebElement className = driver.findElement(By.id("className"));
		WebElement charLevel = driver.findElement(By.id("charLevel"));
		WebElement charAlign = driver.findElement(By.id("charAlign"));
		
		Assert.assertEquals(charName.getAttribute("value"), "charnametest");
		Assert.assertEquals(playName.getAttribute("value"), "playernametest");
		Assert.assertEquals(charRace.getAttribute("value"), "charracetest");
		Assert.assertEquals(className.getAttribute("value"), "classtest");
		Assert.assertEquals(charLevel.getAttribute("value"), "1");
		Assert.assertEquals(charAlign.getAttribute("value"), "charaligntest");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player clicks the next button from basic")
	public void the_player_clicks_the_next_button_from_basic() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut"));
		nextButton.click();
	}
	
	@Then("the player sees the gameplay menu")
	public void the_player_sees_the_gameplay_menu() 	{
		WebElement gameplayMenu = driver.findElement(By.id("hp"));
		Assert.assertNotNull(gameplayMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs an HP")
	public void the_player_inputs_an_HP() {
		WebElement hp = driver.findElement(By.id("hp"));
		hp.sendKeys("1");
	}
	
	@When("the player inputs an AC")
	public void the_player_inputs_an_AC() {
		WebElement ac = driver.findElement(By.id("ac"));
		ac.sendKeys("2");
	}
	
	@When("the player inputs a speed")
	public void the_player_inputs_a_speed() {
		WebElement speed = driver.findElement(By.id("speed"));
		speed.sendKeys("3 ft");
	}
	
	@When("the player inputs a hit dice")
	public void the_player_inputs_a_hit_dice() {
		WebElement hitdice = driver.findElement(By.id("hitdice"));
		hitdice.sendKeys("4");
	}
	
	@When("the player inputs a proficiency")
	public void the_player_inputs_a_proficiency() {
		WebElement prof = driver.findElement(By.id("prof"));
		prof.sendKeys("5");
	}
	
	@Then("the gameplay information is stored in the form")
	public void the_gameplay_information_is_stored_in_the_form() {
		WebElement hp = driver.findElement(By.id("hp"));
		WebElement ac = driver.findElement(By.id("ac"));
		WebElement speed = driver.findElement(By.id("speed"));
		WebElement hitdice = driver.findElement(By.id("hitdice"));
		WebElement prof = driver.findElement(By.id("prof"));
		
		Assert.assertEquals(hp.getAttribute("value"), "1");
		Assert.assertEquals(ac.getAttribute("value"), "2");
		Assert.assertEquals(speed.getAttribute("value"), "3 ft");
		Assert.assertEquals(hitdice.getAttribute("value"), "4");
		Assert.assertEquals(prof.getAttribute("value"), "5");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player clicks the next button from gameplay")
	public void the_player_clicks_the_next_button_from_gameplay() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut2"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from gameplay")
	public void the_player_clicks_the_previous_button_from_gameplay() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut"));
		nextButton.click();
	}
	
	@When("the player clicks the next button from abilities")
	public void the_player_clicks_the_next_button_from_abilities() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut3"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from abilities")
	public void the_player_clicks_the_previous_button_from_abilities() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut2"));
		nextButton.click();
	}
	
	@When("the player clicks the next button from actions")
	public void the_player_clicks_the_next_button_from_actions() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut4"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from actions")
	public void the_player_clicks_the_previous_button_from_actions() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut3"));
		nextButton.click();
	}
	
	@When("the player clicks the next button from traits")
	public void the_player_clicks_the_next_button_from_traits() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut5"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from traits")
	public void the_player_clicks_the_previous_button_from_traits() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut4"));
		nextButton.click();
	}
	
	@When("the player clicks the next button from second traits")
	public void the_player_clicks_the_next_button_from_second_traits() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut6"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from second traits")
	public void the_player_clicks_the_previous_button_from_second_traits() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut5"));
		nextButton.click();
	}
	
	@When("the player clicks the next button from proficiency")
	public void the_player_clicks_the_next_button_from_proficiency() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("nextBut7"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from proficiency")
	public void the_player_clicks_the_previous_button_from_proficiency() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut6"));
		nextButton.click();
	}
	
	@When("the player clicks the submit button from feats")
	public void the_player_clicks_the_next_button_from_feats() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("submitButton"));
		nextButton.click();
	}
	
	@When("the player clicks the previous button from feats")
	public void the_player_clicks_the_previous_button_from_feats() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement nextButton = driver.findElement(By.id("prevBut7"));
		nextButton.click();
	}
	
	@Then("the player sees the abilities menu")
	public void the_player_sees_the_abilities_menu() 	{
		WebElement abilitiesMenu = driver.findElement(By.id("exp1"));
		Assert.assertNotNull(abilitiesMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the actions menu")
	public void the_player_sees_the_actions_menu() 	{
		WebElement actionsMenu = driver.findElement(By.id("actName"));
		Assert.assertNotNull(actionsMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the traits menu")
	public void the_player_sees_the_traits_menu() 	{
		WebElement traitsMenu = driver.findElement(By.id("personality"));
		Assert.assertNotNull(traitsMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the second traits menu")
	public void the_player_sees_the_second_traits_menu() 	{
		WebElement traits2Menu = driver.findElement(By.id("ideal"));
		Assert.assertNotNull(traits2Menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the proficiency menu")
	public void the_player_sees_the_proficiency() 	{
		WebElement proficiencyMenu = driver.findElement(By.id("proficiency"));
		Assert.assertNotNull(proficiencyMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the feats menu")
	public void the_player_sees_the_feats_menu() 	{
		WebElement featsMenu = driver.findElement(By.id("featName"));
		Assert.assertNotNull(featsMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the basic menu")
	public void the_player_sees_the_basic_menu() 	{
		WebElement basicMenu = driver.findElement(By.id("charName"));
		Assert.assertNotNull(basicMenu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player clicks the strength dropdown")
	public void the_player_clicks_the_strength_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp1"));
		expand.click();
	}
	
	@When("the player clicks the dexterity dropdown")
	public void the_player_clicks_the_dexterity_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp2"));
		expand.click();
	}
	
	@When("the player clicks the constitution dropdown")
	public void the_player_clicks_the_constitution_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp3"));
		expand.click();
	}
	
	@When("the player clicks the intelligence dropdown")
	public void the_player_clicks_the_intelligence_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp4"));
		expand.click();
	}
	
	@When("the player clicks the wisdom dropdown")
	public void the_player_clicks_the_wisdom_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp5"));
		expand.click();
	}
	
	@When("the player clicks the charisma dropdown")
	public void the_player_clicks_the_charisms_dropdown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement expand = driver.findElement(By.id("exp6"));
		expand.click();
	}
	
	@Then("the player sees the strength dropdown menu")
	public void the_player_sees_the_strength_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("str"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the dexterity dropdown menu")
	public void the_player_sees_the_dexterity_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("dex"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the constitution dropdown menu")
	public void the_player_sees_the_constitution_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("con"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the intelligence dropdown menu")
	public void the_player_sees_the_intelligence_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("int"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the wisdom dropdown menu")
	public void the_player_sees_the_wisdom_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("wis"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the player sees the charisma dropdown menu")
	public void the_player_sees_the_charisma_dropdown_menu() 	{
		WebElement menu = driver.findElement(By.id("charisma"));
		Assert.assertNotNull(menu);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs a strength score")
	public void the_player_inputs_a_strength_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("str"));
		prof.sendKeys("1");
	}
	
	@When("the player inputs a dexterity score")
	public void the_player_inputs_a_dexterity_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("dex"));
		prof.sendKeys("2");
	}
	
	@When("the player inputs a constitution score")
	public void the_player_inputs_a_constitution_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("con"));
		prof.sendKeys("3");
	}
	
	@When("the player inputs an intelligence score")
	public void the_player_inputs_an_intelligence_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("int"));
		prof.sendKeys("4");
	}
	
	@When("the player inputs a wisdom score")
	public void the_player_inputs_a_wisdom_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("wis"));
		prof.sendKeys("5");
	}
	
	@When("the player inputs a charisma score")
	public void the_player_inputs_a_charisma_score() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement prof = driver.findElement(By.id("charisma"));
		prof.sendKeys("6");
	}
	
	@Then("the strength information is stored in the form")
	public void the_strength_information_is_stored_in_the_form() {
		WebElement str = driver.findElement(By.id("str"));

		Assert.assertEquals(str.getAttribute("value"), "1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the dexterity information is stored in the form")
	public void the_dexterity_information_is_stored_in_the_form() {
		WebElement dex = driver.findElement(By.id("dex"));

		Assert.assertEquals(dex.getAttribute("value"), "2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the constitution information is stored in the form")
	public void the_constitution_information_is_stored_in_the_form() {
		WebElement con = driver.findElement(By.id("con"));

		Assert.assertEquals(con.getAttribute("value"), "3");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the wisdom information is stored in the form")
	public void the_wisdom_information_is_stored_in_the_form() {
		WebElement wis = driver.findElement(By.id("wis"));

		Assert.assertEquals(wis.getAttribute("value"), "5");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the intelligence information is stored in the form")
	public void the_intelligence_information_is_stored_in_the_form() {
		WebElement intel = driver.findElement(By.id("int"));

		Assert.assertEquals(intel.getAttribute("value"), "4");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the charisma information is stored in the form")
	public void the_charisma_information_is_stored_in_the_form() {
		WebElement charisma = driver.findElement(By.id("charisma"));

		Assert.assertEquals(charisma.getAttribute("value"), "6");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player checks the athletics box")
	public void the_player_checks_the_athletics_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("ath"));
		box.click();
	}
	
	@When("the player checks the sleight of hand box")
	public void the_player_checks_the_sleight_of_hand_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("sleight"));
		box.click();
	}
	
	@When("the player checks the acrobatics box")
	public void the_player_checks_the_acrobatics_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("acro"));
		box.click();
	}
	
	@When("the player checks the stealth box")
	public void the_player_checks_the_stealth_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("stealth"));
		box.click();
	}
	
	@When("the player checks the arcana box")
	public void the_player_checks_the_arcana_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("arcana"));
		box.click();
	}
	
	@When("the player checks the history box")
	public void the_player_checks_the_history_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("history"));
		box.click();
	}
	
	@When("the player checks the investigation box")
	public void the_player_checks_the_investigation_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("invest"));
		box.click();
	}
	
	@When("the player checks the nature box")
	public void the_player_checks_the_nature_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("nat"));
		box.click();
	}
	
	@When("the player checks the religion box")
	public void the_player_checks_the_religion_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("rel"));
		box.click();
	}
	
	@When("the player checks the animal handling box")
	public void the_player_checks_the_animal_handling_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("anim"));
		box.click();
	}
	
	@When("the player checks the insight box")
	public void the_player_checks_the_insight_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("insight"));
		box.click();
	}
	
	@When("the player checks the medicine box")
	public void the_player_checks_the_medicine_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("med"));
		box.click();
	}
	
	@When("the player checks the perception box")
	public void the_player_checks_the_perception_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("perc"));
		box.click();
	}
	
	@When("the player checks the survival box")
	public void the_player_checks_the_survival_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("surv"));
		box.click();
	}
	
	@When("the player checks the deception box")
	public void the_player_checks_the_deception_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("dec"));
		box.click();
	}
	
	@When("the player checks the intimidation box")
	public void the_player_checks_the_intimidation_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("intim"));
		box.click();
	}
	
	@When("the player checks the performance box")
	public void the_player_checks_the_performance_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("perf"));
		box.click();
	}
	
	@When("the player checks the persuasion box")
	public void the_player_checks_the_persuasion_box() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement box = driver.findElement(By.id("pers"));
		box.click();
	}
	
	@Then("the athletics box is checked in the form")
	public void the_athletics_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("ath"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the acrobatics box is checked in the form")
	public void the_acrobatics_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("acro"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the sleight of hand box is checked in the form")
	public void the_sleight_of_hand_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("sleight"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the stealth box is checked in the form")
	public void the_stealth_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("stealth"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the arcana box is checked in the form")
	public void the_arcana_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("arcana"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the history box is checked in the form")
	public void the_history_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("history"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the investigation box is checked in the form")
	public void the_investigation_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("invest"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the nature box is checked in the form")
	public void the_nature_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("nat"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the religion box is checked in the form")
	public void the_religion_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("rel"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the animal handling box is checked in the form")
	public void the_animal_handling_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("anim"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the insight box is checked in the form")
	public void the_insight_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("insight"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the medicine box is checked in the form")
	public void the_medicine_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("med"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the perception box is checked in the form")
	public void the_perception_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("perc"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the survival box is checked in the form")
	public void the_survival_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("surv"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the deception box is checked in the form")
	public void the_deception_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("dec"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the intimidation box is checked in the form")
	public void the_intimidation_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("intim"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the performance box is checked in the form")
	public void the_performance_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("perf"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("the persuasion box is checked in the form")
	public void the_persuasion_box_is_checked_in_the_form() {
		WebElement box = driver.findElement(By.id("pers"));

		Assert.assertEquals(driver.findElement(By.className("mat-checkbox-checked")), box);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs action information")
	public void the_player_inputs_action_information() {
		WebElement name = driver.findElement(By.id("actName"));
		WebElement att = driver.findElement(By.id("actAtt"));
		WebElement dam = driver.findElement(By.id("actDam"));
		WebElement damtype = driver.findElement(By.id("actDamType"));
		
		name.sendKeys("1");
		att.sendKeys("2");
		dam.sendKeys("3");
		damtype.sendKeys("4");
	}
	
	@When("the player clicks the add action button")
	public void the_player_clicks_the_add_action_button() {
		WebElement but = driver.findElement(By.id("actAddBut"));
		but.click();
	}
	
	@Then("the action is added to the form")
	public void the_action_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs personality information")
	public void the_player_inputs_personality_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement pers = driver.findElement(By.id("personality"));
		
		pers.sendKeys("perstest");
	}
	
	@When("the player clicks the add personality button")
	public void the_player_clicks_the_add_personality_button() {
		WebElement but = driver.findElement(By.id("persAdd"));
		but.click();
	}
	
	@Then("the personality is added to the form")
	public void the_personality_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs bond information")
	public void the_player_inputs_bond_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement bond = driver.findElement(By.id("bond"));
		
		bond.sendKeys("bondtest");
	}
	
	@When("the player clicks the add bond button")
	public void the_player_clicks_the_add_bond_button() {
		WebElement but = driver.findElement(By.id("bondAdd"));
		but.click();
	}
	
	@Then("the bond is added to the form")
	public void the_bond_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs ideal information")
	public void the_player_inputs_ideal_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement pers = driver.findElement(By.id("ideal"));
		
		pers.sendKeys("idealtest");
	}
	
	@When("the player clicks the add ideal button")
	public void the_player_clicks_the_add_ideal_button() {
		WebElement but = driver.findElement(By.id("idealAdd"));
		but.click();
	}
	
	@Then("the ideal is added to the form")
	public void the_ideal_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs flaw information")
	public void the_player_inputs_flaw_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement pers = driver.findElement(By.id("flaw"));
		
		pers.sendKeys("flawtest");
	}
	
	@When("the player clicks the add flaw button")
	public void the_player_clicks_the_add_flaw_button() {
		WebElement but = driver.findElement(By.id("flawAdd"));
		but.click();
	}
	
	@Then("the flaw is added to the form")
	public void the_flaw_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs proficiency information")
	public void the_player_inputs_proficiency_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement pers = driver.findElement(By.id("proficiency"));
		
		pers.sendKeys("flawtest");
	}
	
	@When("the player clicks the add proficiency button")
	public void the_player_clicks_the_add_proficiency_button() {
		WebElement but = driver.findElement(By.id("proficiencyAdd"));
		but.click();
	}
	
	@Then("the proficiency is added to the form")
	public void the_proficiency_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@When("the player inputs feat information")
	public void the_player_inputs_feat_information() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		WebElement pers = driver.findElement(By.id("featName"));
		
		pers.sendKeys("perstest");
	}
	
	@When("the player clicks the add feat button")
	public void the_player_clicks_the_add_feat_button() {
		WebElement but = driver.findElement(By.id("featAdd"));
		but.click();
	}
	
	@Then("the feat is added to the form")
	public void the_feat_is_added_to_the_form() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Then("a new character is added to the dashboard")
	public void a_new_character_is_added_to_the_dashboard() 	{
		WebElement act = driver.findElement(By.className("cdk-row"));
		Assert.assertNotNull(act);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
