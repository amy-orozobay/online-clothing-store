package com.onlineclothingstore.runners;

import org.junit.platform.suite.api.*;

        import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api")  // way to API feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.onlineclothingstore.api.stepdefinitions")  // package with API steps
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/CucumberReports/api_report.json")  // separate report for API
@IncludeTags("API")  // runs tests only with tag @API
public class SmokeRunnerApi {
}
