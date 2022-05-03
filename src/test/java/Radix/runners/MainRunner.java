package Radix.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "Radix/stepDefs",
        dryRun = false,
        tags = "@wip"
)
public class MainRunner {

}
