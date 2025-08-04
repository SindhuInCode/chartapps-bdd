package runner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="featureFiles/loginDemo.feature",glue="Cucumber")
public class runnerClass {
 
}

