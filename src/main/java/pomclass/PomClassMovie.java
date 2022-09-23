package pomclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PomClassMovie {
		
	WebDriver driver;
	/**
	 Here we Locate All the webElements for Wikipedia
	 *  */
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchTextfield;
	
	@FindBy(xpath = "//input[@id='searchButton']")
	WebElement searchButtonWiki;
	
	@FindBy(xpath = "(//td[@class='infobox-data'])[10]/div/ul/li")
	
	WebElement releaseDateWiki;
	
	@FindBy(xpath = "//table[@class='infobox vevent']/tbody/tr[14]/td")
	
	WebElement countrytextWiki;
	
	/**
	 * Here we Locate all WebElements for IMDB
	 */

	@FindBy(xpath = "//input[@id='suggestion-search']")
	WebElement searchTextfieldimdb;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButtonimdb;
	
	@FindBy(xpath = "//a[text()='Pushpa: The Rise - Part 1']")
	WebElement searchResultimdb;
	
	@FindBy(xpath = "(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]")
	WebElement releaseDateIMDB;
	
	@FindBy(xpath = "(//div[@class='sc-f65f65be-0 ktSkVi'])[2]/ul/li/following-sibling::li/div/ul/li/a")
	WebElement countrytextImdb;
	
	/**
	 * Constructor to initialize webElements
	 * 
	 */
	public  PomClassMovie(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/****************Wiki Methods************/
	/**
	 * Method to enter Movie Name
	 * @param movieName
	 */
	public void enterMovieNamewiki(String movieName) {
		searchTextfield.sendKeys(movieName);
	}
	
	/**
	 * Method to click on Search Button
	 */
	public void clickOnSearchButtonwiki() {
		searchButtonWiki.click();
	}
	/**
	 * Method to return Release Date
	 * @return
	 */
	public String wikiReleaseDate() {
		return releaseDateWiki.getText();
	}
	/**
	 * Method to return Country Name
	 * @return
	 */
	public String wikiReleaseCountry() {
		return countrytextWiki.getText();
	}
	
/*********	IMDB Method *********/
	 /** 
	 * Method to enter Movie Name
	 * @param movieName
	 */
	public void enterMovieNameIMDB(String movieName) {
		searchTextfieldimdb.sendKeys(movieName);
	}
	/**
	 * Method to click on Search Button
	 */
	public void clickOnSearchButtonIMDB() {
		searchButtonimdb.click();
	}
	/**
	 * Method to click Serach Result
	 */
	public void clickSearchResultIMDB() {
		searchResultimdb.click();
	}
	/**
	 * Method to return Release Date
	 * @return
	 */
	public String imdbReleaseDate() {
		return releaseDateIMDB.getText();
	}
	/**
	 * Method to return Country Name
	 * @return
	 */
	public String imdbReleaseCountry() {
		return countrytextImdb.getText();
	}
	

}