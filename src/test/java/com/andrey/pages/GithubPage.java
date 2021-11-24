package com.andrey.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubPage {

    // locators & elements
    public static String repoName = "andkip/qa_guru_homework",
            issueNum = "1",
            issueText = "Some Issue";
    private SelenideElement
            searchInput = $("[name=q]"),
            repositoriesButton = $("[data-search-type=Repositories]"),
            issues = $(partialLinkText("Issues"));

    // actions
    public GithubPage openPage() {
        open("https://github.com");
        return this;
    }

    public GithubPage fillSearchAndPressEnter(String value) {
        searchInput.click();
        searchInput.setValue(value).pressEnter();
        repositoriesButton.shouldBe(visible);
        return this;
    }

    public GithubPage checkRepoExist(String repository) {
        $(linkText(repository)).shouldBe(visible);
        return this;
    }

    public GithubPage clickOnRepo(String value) {
        $(linkText(value)).click();
        return this;
    }

    public GithubPage clickOnIssues() {
        issues.click();
        return this;
    }

    public GithubPage checkTextInIssue(String issueNum, String issueText) {
        $("[aria-label=Issues] div").$$("div").findBy(text("#" + issueNum))
                .shouldHave(text(issueText));
        return this;
    }
}
