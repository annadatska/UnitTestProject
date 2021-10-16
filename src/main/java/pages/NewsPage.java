package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(@class,'gs-c-promo-heading__title')]")
    private List<WebElement> articlesList;

    @FindBy(xpath = "//a[contains(@class,'gs-c-section-link--truncate')]//span[@aria-hidden='true']")
    private List<WebElement> articleCategoriesList;

    @FindBy(id = "orb-search-q")
    private WebElement searchField;

    @FindBy(id = "orb-search-button")
    private WebElement searchButton;

    @FindBy(xpath = "//li[contains(@class,'nav__wide-menuitem-container')]//a[@href=\"/news/coronavirus\"]")
    private WebElement coronavirusMenuItemButton;

    @FindBy(xpath = "//li[contains(@class,'nw-c-nav__secondary-menuitem-container')]//a[@href='/news/have_your_say']")
    private WebElement yourCoronavirusStoriesButton;

    @FindBy(xpath = "//h3[text()='Your questions answered: What questions do you have?']")
    private WebElement yourQuestionsAnswered;

    @FindBy(xpath = "//textarea[@class='text-input--long']")
    private WebElement questionField;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitQuestionButton;

    @FindBy(xpath = "//div[@class='long-text-input-container']//div[@class='input-error-message']")
    private WebElement questionErrorMessage;

    @FindBy(xpath = "//div[@class='input-threeup-leading ']//div[@class='input-error-message']")
    private WebElement nameErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'input-threeup-following')]//div[@class='input-error-message']")
    private WebElement emailErrorMessage;

    Actions action = new Actions(driver);

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfFirstArticleTitle() {
        return articlesList.get(0).getText();
    }

    public WebElement getFirstArticle() {
        return articlesList.get(0);
    }

    public String getTitlesOfSecondAndThirdArticles() {
        StringBuilder sb = new StringBuilder();
        String second = articlesList.get(2).getText();
        String third = articlesList.get(3).getText();
        return sb.append(second).append(", ").append(third).toString();
    }

    public String getTextOfHeadlineCategoryCategory() {
        return articleCategoriesList.get(0).getText();
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickCoronavirusMenuItemButton() {
        coronavirusMenuItemButton.click();
    }

    public void clickYourCoronavirusStoriesButton() {
        yourCoronavirusStoriesButton.click();;
    }

    public void clickYourQuestionsAnswered() {
        ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", yourQuestionsAnswered);
    }

    public WebElement getYourQuestionsAnswered() {
        return yourQuestionsAnswered;
    }

    public void enterQuestion(final String question) {
        questionField.clear();
        questionField.sendKeys(question);
    }

    public void enterName(final String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSubmitQuestionButton() {
        submitQuestionButton.click();
    }

    public String getTextOfQuestionErrorMessage() {
        return questionErrorMessage.getText();
    }

    public WebElement getQuestionErrorMessage() {
        return questionErrorMessage;
    }

    public String getTextOfNameErrorMessage() {
        return nameErrorMessage.getText();
    }

    public WebElement getNameErrorMessage() {
        return nameErrorMessage;
    }

    public String getTextOfEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

}
