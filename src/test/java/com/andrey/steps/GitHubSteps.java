package com.andrey.steps;

import com.andrey.pages.GithubPage;
import io.qameta.allure.Step;

public class GitHubSteps {

    GithubPage githubPage = new GithubPage();

    @Step("Открыть страницу Github")
    public GitHubSteps openPage() {
        githubPage.openPage();
        return this;
    }

    @Step("Ввести в поиске \"{0}\" и нажать Enter")
    public GitHubSteps fillSearchAndPressEnter(String value) {
        githubPage.fillSearchAndPressEnter(value);
        return this;
    }

    @Step("Кликнуть на репозиторий \"{0}\"")
    public GitHubSteps clickOnRepo(String value) {
        githubPage.clickOnRepo(value);
        return this;
    }

    @Step("Кликнуть на Issues")
    public GitHubSteps clickOnIssues() {
        githubPage.clickOnIssues();
        return this;
    }

    @Step("В Issue под номером \"{0}\" присутствует текст \"{1}\"")
    public GitHubSteps checkTextInIssue(String issueNum, String issueText) {
        githubPage.checkTextInIssue(issueNum, issueText);
        return this;
    }
}
