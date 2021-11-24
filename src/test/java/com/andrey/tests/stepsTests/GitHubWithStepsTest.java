package com.andrey.tests.stepsTests;

import com.andrey.steps.GitHubSteps;
import com.andrey.pages.GithubPage;
import com.andrey.tests.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GitHubWithStepsTest extends BaseTest {

    GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @Owner("akiprushin")
    @Feature("Поиск на GitHub")
    @DisplayName("Поиск репозитория на GitHub. Шаги с аннотацией @Step")
    @Link(name = "GitHub", url = "https://github.com")
    public void selenideSearchWithStepsTest() {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(GithubPage.repoName)
                .clickOnRepo(GithubPage.repoName)
                .clickOnIssues()
                .checkTextInIssue(GithubPage.issueNum, GithubPage.issueText);
    }
}
