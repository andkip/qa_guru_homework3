package com.andrey.tests.parameterizedTests;

public enum RepoData {
    INFLUX_REPO("influxdata/influxdb", "Scalable datastore for metrics, events, and real-time analytics"),
    CUCUMBER_REPO("cucumber/cucumber-jvm", "Cucumber for the JVM"),
    SELENIUM_REPO("SeleniumHQ/selenium", "A browser automation framework and ecosystem");

    public String getRepoName() {
        return repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    private final String repoName;
    private final String repoDescription;

    RepoData(String repoName, String repoDescription) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
    }
}
