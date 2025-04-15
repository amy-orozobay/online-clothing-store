package com.onlineclothingstore.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ui/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.onlineclothingstore.stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/CucumberReports/report.json")
@IncludeTags("Smoke")
public class SmokeRunner {

}
