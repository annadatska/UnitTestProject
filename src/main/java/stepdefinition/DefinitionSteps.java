package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NewsPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SportPage;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchResultsPage searchResultsPage;
    SportPage sportPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User clicks News button")
    public void userClicksNewsButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickNewsButton();
    }

    @Then("User checks the name of the headline article against the {string}")
    public void checkTheNameOfTheHeadlineArticle(final String expectedName) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getFirstArticle());
        assertEquals(expectedName, newsPage.getTextOfFirstArticleTitle());
    }

    @Then("User checks article titles {string} to the right and below the headline article")
    public void checkArticleTitles(String articleTitles) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(articleTitles, newsPage.getTitlesOfSecondAndThirdArticles());
    }

    @When("User copies the text of the Category link of the headline article and enters it to search bar")
    public void copyTextOfTheCategoryLinkAndEnterToSearchField() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.enterTextToSearchField(newsPage.getTextOfHeadlineCategoryCategory());
    }

    @And("User clicks the search button")
    public void userClicksTheSearchButton() {
        newsPage.clickSearchButton();
    }

    @Then("User checks the {string} of the first article")
    public void userChecksTheExpectedNameOfTheFirstArticle(final String expectedName) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(expectedName, searchResultsPage.getNameOfFirstSearchResult());
    }

    @And("User clicks Coronavirus button")
    public void userClicksCoronavirusButton() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickCoronavirusMenuItemButton();
    }

    @And("User clicks Your coronavirus stories")
    public void userClicksYourCoronavirusStories() {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.clickYourCoronavirusStoriesButton();
    }

    @And("User opens Question form")
    public void userOpensQuestionForm() {
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getYourQuestionsAnswered());
        newsPage.clickYourQuestionsAnswered();
    }

    @When("User enters {string}, {string} and {string}")
    public void userEntersQuestionNameAndEmail(final String question, final String name, final String email) {
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        newsPage.enterQuestion(question);
        newsPage.enterName(name);
        newsPage.enterEmail(email);
        newsPage.clickSubmitQuestionButton();
    }

    @Then("User checks an empty question field {string}")
    public void checkAnEmptyQuestionFieldErrorMessage(final String errorMessage) {
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getQuestionErrorMessage());
        assertEquals(errorMessage, newsPage.getTextOfQuestionErrorMessage());
    }

    @Then("User checks an empty name field {string}")
    public void checkAnEmptyNameFieldErrorMessage(final String errorMessage) {
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getNameErrorMessage());
        assertEquals(errorMessage, newsPage.getTextOfNameErrorMessage());
    }

    @Then("User checks en empty email field {string}")
    public void checkEnEmptyEmailFieldErrorMessage(final String errorMessage) {
        newsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, newsPage.getEmailErrorMessage());
        assertEquals(errorMessage, newsPage.getTextOfEmailErrorMessage());
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
