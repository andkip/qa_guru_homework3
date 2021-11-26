package com.andrey.tests.parameterizedTests;

import com.andrey.steps.GitHubSteps;
import com.andrey.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@DisplayName("Параметризованные тесты")
public class ParameterizedTests extends BaseTest {

    GitHubSteps gitHubSteps = new GitHubSteps();

    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием: {0}")
    @Tag("smoke")
    @DisplayName("Поиск репозиториев на GitHub")
    @ValueSource(strings = {"influxdata/influxdb", "cucumber/cucumber-jvm", "SeleniumHQ/selenium"})
    public void githubSearchRepoTest(String strings) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(strings)
                .checkRepoExist(strings);
    }

    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием: {0} и проверка текста под названием {1}")
    @Tag("smoke")
    @DisplayName("Поиск репозиториев на GitHub и проверка описания репозитория")
    @CsvSource(value = {
            "influxdata/influxdb|Scalable datastore for metrics, events, and real-time analytics",
            "cucumber/cucumber-jvm|Cucumber for the JVM",
            "SeleniumHQ/selenium|A browser automation framework and ecosystem"
    },
            delimiter = '|')
    public void githubSearchDescriptionTest(String repoName, String repoText) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(repoName)
                .checkRepoExist(repoName)
                .checkTextUnderRepoName(repoText);
    }

    private static Stream<Arguments> githubSearchDescriptionTest2() {
        return Stream.of(
                Arguments.of("influxdata/influxdb", "Scalable datastore for metrics, events, and real-time analytics"),
                Arguments.of("cucumber/cucumber-jvm", "Cucumber for the JVM"),
                Arguments.of("SeleniumHQ/selenium", "A browser automation framework and ecosystem"));
    }

    @MethodSource
    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием: {0} и проверка текста под названием {1}")
    @Tag("smoke")
    @DisplayName("Поиск репозиториев на GitHub и проверка описания репозитория")
    public void githubSearchDescriptionTest2(String repoName, String repoText) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(repoName)
                .checkRepoExist(repoName)
                .checkTextUnderRepoName(repoText);
    }

    @EnumSource(RepoData.class)
    @ParameterizedTest(name = "Поиск репозитория на GitHub с названием и описанием {0}")
    @Tag("smoke")
    @DisplayName("Поиск репозиториев на GitHub и проверка описания репозитория")
    public void githubSearchDescriptionTest3(RepoData repoData) {
        gitHubSteps.openPage()
                .fillSearchAndPressEnter(repoData.getRepoName())
                .checkRepoExist(repoData.getRepoName())
                .checkTextUnderRepoName(repoData.getRepoDescription());
    }
}
