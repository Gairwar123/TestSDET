package testclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomclass.PomClassMovie;

public class TestclassMovie  { 
	WebDriver driver;
		
	@BeforeMethod
	public void setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	   public void extractTheDetailsTest()  {
			/**
			 * Launching Wikipedia Website		
			 */
			driver.get("https://en.wikipedia.org/wiki/Main_Page");
			/**
			 * Implicit wait
			 */
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        /**
	         * Here Creating object of PomClassMoive class
	         */
			PomClassMovie obj= new PomClassMovie(driver);
		    /**
		     * Calling the method and passing the parameter
		     */
			obj.enterMovieNamewiki("Pushpa: The Rise");
			/**
			 * Calling the method to click on search button
			 */	
			obj.clickOnSearchButtonwiki();
			/**
			 * Get the Country name and storing in String and print 	
			 */
			String wikiCountry= obj.wikiReleaseCountry();
			System.out.println("Wiki ReleaseCountry :"+wikiCountry);
			/**
			 * Get the Release date and storing in String and print
			 */
			String wikiDate = obj.wikiReleaseDate();
			System.out.println("Wiki ReleaseDate :" +wikiDate);
			
			
			/**
			 * Launching IMDB Website
			 */
			driver.get("https://www.imdb.com/?ref_=nv_home");
			/**
		     * Calling the method and passing the parameter
		     */
			obj.enterMovieNameIMDB("Pushpa: The Rise - Part 1");
			/**
			 * Calling the method 
			 */
			obj.clickOnSearchButtonIMDB();
			/**
			 * Calling the method 
			 */
			obj.clickSearchResultIMDB();
			/**
			 * Get the Country name and storing in String and print 	
			 */
			String imdbCountry= obj.imdbReleaseCountry();
			System.out.println("IMDB ReleaseCountry :" +imdbCountry);
			/**
			 * Get the Release date and storing in String and print
			 */
			String imdbDate = obj.imdbReleaseDate();
			System.out.println("IMDB ReleaseDate :"+imdbDate);
			
			/**
			 * Asserting the Data of both Website Wiki and IMDB
			 */
			SoftAssert softAsser=new SoftAssert();
			softAsser.assertEquals(wikiDate, imdbDate, "Date of Wiki and IMDB is not Matching");
			softAsser.assertEquals(wikiCountry, imdbCountry, "Country of Wiki and IMDB is not Matching");
			softAsser.assertAll();
				
	}
}
                         
