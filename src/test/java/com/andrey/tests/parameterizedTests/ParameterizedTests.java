package com.andrey.tests.parameterizedTests;

import com.andrey.steps.GitHubSteps;
import com.andrey.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Параметризованные тесты")
public class ParameterizedTests extends BaseTest {

    GitHubSteps gitHubSteps = new GitHubSteps();

    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием: {0}")
    @DisplayName("Поиск репозиториев на GitHub")
    @ValueSource(strings = {"influxdata/influxdb", "cucumber/cucumber-jvm", "SeleniumHQ/selenium"})
    public void githubSearchRepoTest(String strings) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(strings)
                .checkRepoExist(strings);
    }

    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием: {0}")
    @DisplayName("Поиск репозиториев на GitHub")
    @CsvSource(value = {"influxdata/influxdb", "cucumber/cucumber-jvm", "SeleniumHQ/selenium"})
    public void githubSearchIssueTest(String strings) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(strings)
                .checkRepoExist(strings);
    }
}
