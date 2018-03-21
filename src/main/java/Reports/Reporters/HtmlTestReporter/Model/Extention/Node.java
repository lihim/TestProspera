package Reports.Reporters.HtmlTestReporter.Model.Extention;
import Reports.Reporters.HtmlTestReporter.Model.Status;
import lombok.*;

public  abstract class Node {


    private String statusValue = "success";

    @Getter
    @Setter
    public String name;

    public String status;

    public String getStatus(){
        return statusValue;
    }

    public void setStatus(String value){
            if (statusValue == null) {
                statusValue = value;
                if (parent != null) {
                    parent.status = value;
                }
                return;
            }
            Status currentStatus = (Status) Enum.valueOf(Status.class, statusValue);
            Status newStatus = (Status) Enum.valueOf(Status.class, value);
            if (currentStatus.compareTo(newStatus) < 0) {
                statusValue = value;
                if (parent != null) {
                    parent.status = value;
                }


            }
        }



    @Getter
    @Setter
    public String type;

   // [ScriptIgnoreAttribute]
   @Getter
   @Setter
    public NodeWithChildren parent;


    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

}