package Reports.Reporters.HtmlTestReporter.Model.Extention;

import lombok.Getter;
import lombok.Setter;

public class Test extends Node {

    @Getter
    @Setter
    public int index ;

    @Getter
    @Setter
    public String uid;

    @Getter
    @Setter
    public long duration;

    @Getter
    @Setter
    public String timestamp;

    @Getter
    @Setter
    public String className;

    public Test()
    {
        type = "test";
        status = "success";
    }

    public Test(int index, String name, String uid){
        super(name);
        this.index = index;
        this.uid = uid;
        type = "test";
        status = "success";

    }
}
