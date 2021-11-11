package com.andrey.tests;

import com.andrey.pages.GitHubSteps;
import com.andrey.pages.GithubPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GitHubTestWithSteps extends BaseTest {

    GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @Owner("akiprushin")
    @Feature("Поиск на GitHub")
    @DisplayName("Поиск репозитория на GitHub. Шаги с аннотацией @Step")
    @Link(name = "GitHub", url = "https://github.com")
    public void selenideSearchTestWithSteps() {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(GithubPage.repoName)
                .clickOnRepo(GithubPage.repoName)
                .clickOnIssues()
                .checkTextInIssue(GithubPage.issueNum, GithubPage.issueText);
    }
}
