package Reports.Reporters.HtmlTestReporter.Model.Extention;


import lombok.Getter;
import lombok.Setter;

public class Machine extends NodeWithChildren {
    @Getter
    @Setter
    public int plannedTests;

    public Machine()
    {
        type = "machine";
    }

    public Machine(String name){
        super(name);
        type = "machine";
    }
}
