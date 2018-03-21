package Reports.Reporters.HtmlTestReporter.Model.Extention;

import lombok.Getter;
import lombok.Setter;

import java.util.Dictionary;

public class Scenario extends NodeWithChildren {

    @Getter
    @Setter
    public Dictionary<String, String> scenarioProperties;

    public Scenario()
    {
        type = "scenario";
        status = "success";
    }

    public Scenario(String name){
        super(name);
        type = "scenario";
        status = "success";
    }


}
