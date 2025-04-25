package com.onlineclothingstore.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui")  // way to UI feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.onlineclothingstore.ui.stepdefinitions") // package with UI steps
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/CucumberReports/ui_report.json") // separate report for UI
@IncludeTags("UI")  // runs tests only with tag @UI

public class SmokeRunnerUi {

}
