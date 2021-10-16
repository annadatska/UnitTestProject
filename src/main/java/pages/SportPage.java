package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SportPage extends BasePage {

    @FindBy(xpath = "//li[@class='sp-c-sport-navigation__item ']//a[@data-stat-title='Football']")
    private WebElement footballButton;

    @FindBy(xpath = "//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoresAndFixturesButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(@class,'search__result')][@id='downshift-0-item-0']")
    private WebElement searchResultItem;

    @FindBy(xpath = "//a[contains(@class,'date-picker-timeline')]")
    private List<WebElement> resultsMonthAndYearList;

    @FindBy(xpath = "//li[contains(@class,'date-picker-timeline')]//span[contains(@class,'gel-long-primer-bold')]")
    private List<WebElement> resultsMonthsList;

    @FindBy(xpath = "//span[contains(@class,'full-team-name')]")
    private List<WebElement> teamsNamesList;

    @FindBy(xpath = "//span[contains(@class,'fixture__number')]")
    private List<WebElement> scoresList;

    @FindBy(xpath = "//h3[text()='Saturday 28th August']")
    private WebElement dateOfGame;

    @FindBy(xpath = "//time[text()='SAT 28 Aug 2021']")
    private WebElement secondDateOfGame;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickFootballButton() {
        footballButton.click();
    }

    public void clickScoresAndFixturesButton() {
        scoresAndFixturesButton.click();
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchResultItem() {
        searchResultItem.click();
    }

    public WebElement getSearchResultItem() {
        return searchResultItem;
    }

    public void selectResultsMonth(final String month) {
        for (int i = 0; i < resultsMonthsList.size(); i++) {
            if (resultsMonthsList.get(i).getText().equals(month)) {
                resultsMonthAndYearList.get(i).click();
                break;
            }
        }
    }

    public String getNameOfFirstTeam() {
        return teamsNamesList.get(0).getText();
    }

    public String getNameOfSecondTeam() {
        return teamsNamesList.get(1).getText();
    }

    public String getScoreOfFirstTeam() {
        return scoresList.get(0).getText();
    }

    public String getScoreOfSecondTeam() {
        return scoresList.get(1).getText();
    }

    public void clickOnFirstTeam() {
        teamsNamesList.get(0).click();
    }

    public WebElement getDateOfGame() {
        return dateOfGame;
    }

    public WebElement getSecondDateOfGame() {
        return secondDateOfGame;
    }
}
