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

    @And("User clicks Sport menu button")
    public void userClicksSportMenuButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSportButton();
    }

    @And("User clicks Football menu button")
    public void userClicksFootballMenuButton() {
        sportPage = pageFactoryManager.getSportPage();
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sportPage.clickFootballButton();
    }

    @And("User clicks Scores and fixtures button")
    public void userClicksScoresAndFixturesButton() {
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sportPage.clickScoresAndFixturesButton();
    }

    @When("User makes search for the championship by a keyword {string}")
    public void searchForTheChampionship(final String championship) {
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sportPage.enterTextToSearchField(championship);
        sportPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sportPage.getSearchResultItem());
        sportPage.clickSearchResultItem();
    }

    @And("User filters the Score Results by month {string}")
    public void filterTheScoreResultsByMonth(final String month) {
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sportPage.selectResultsMonth(month);
    }

    @Then("User checks the name of first team {string}")
    public void userChecksTheNameOfFirstTeam(final String firstTeam) {
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sportPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sportPage.getDateOfGame());
        assertEquals(firstTeam, sportPage.getNameOfFirstTeam());
    }
    @Then("User checks the name of second team {string}")
    public void userChecksTheNameOfSecondTeam(final String secondTeam) {
        sportPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(secondTeam, sportPage.getNameOfSecondTeam());
    }

    @And("User checks the score of first team {string}")
    public void userChecksFirstScore(final String firstScore) {
        assertEquals(firstScore, sportPage.getScoreOfFirstTeam());
    }

    @And("User checks the score of second team {string}")
    public void userCheckSecondScore(final String secondScore) {
        assertEquals(secondScore, sportPage.getScoreOfSecondTeam());
    }

    @Then("User checks the name of first team {string} on the next page")
    public void checkTheNameOfFirstTeamFirstTeamOnTheNextPage(final String firstTeam) {
        sportPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sportPage.getSecondDateOfGame());
        assertEquals(firstTeam, sportPage.getNameOfFirstTeam());
    }

    @When("User clicks on first team name")
    public void userClicksOnFirstTeamName() {
        sportPage.clickOnFirstTeam();
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
