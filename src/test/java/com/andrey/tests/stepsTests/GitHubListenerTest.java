package com.andrey.tests.stepsTests;

import com.andrey.pages.GithubPage;
import com.andrey.tests.BaseTest;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GitHubListenerTest extends BaseTest {

    GithubPage githubPage = new GithubPage();

    @Test
    @Owner("akiprushin")
    @Feature("Поиск на GitHub")
    @DisplayName("Поиск репозитория на GitHub. Listener")
    @Link(name = "GitHub", url = "https://github.com")
    public void selenideSearchListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        githubPage.openPage()
                .fillSearchAndPressEnter(GithubPage.repoName)
                .clickOnRepo(GithubPage.repoName)
                .clickOnIssues()
                .checkTextInIssue(GithubPage.issueNum, GithubPage.issueText);
    }
}
