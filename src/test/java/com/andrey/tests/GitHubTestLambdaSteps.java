package com.andrey.tests;

import com.andrey.steps.GitHubSteps;
import com.andrey.pages.GithubPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class GitHubTestLambdaSteps extends BaseTest {

    GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @Owner("akiprushin")
    @Feature("Поиск на GitHub")
    @DisplayName("Поиск репозитория на GitHub. Lambda Steps")
    @Link(name = "GitHub", url = "https://github.com")
    public void selenideSearchTestLambdaSteps() {
        step("Открыть главную страницу", () -> {
            gitHubSteps.openPage();
        });
        step("Ввести в поиске "+GithubPage.repoName+" и нажать Enter", () -> {
            gitHubSteps.fillSearchAndPressEnter(GithubPage.repoName);
        });
        step("Кликнуть на репозиторий "+GithubPage.repoName, () -> {
            gitHubSteps.clickOnRepo(GithubPage.repoName);
        });
        step("Кликнуть на Issues", () -> {
            gitHubSteps.clickOnIssues();
        });
        step("В Issue под номером '" + GithubPage.issueNum + "' присутствует текст: " +GithubPage.issueText, () -> {
            gitHubSteps.checkTextInIssue(GithubPage.issueNum, GithubPage.issueText);
        });
    }
}
