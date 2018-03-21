package Reports.Reporters.HtmlTestReporter.Model.Extention;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Execution {

    @Getter
    @Setter
    public List<Machine> machines;

    public void AddMachine(Machine machine)
    {
        if (machines == null)
        {
            machines = new ArrayList<Machine>();
        }
        machines.add(machine);
    }

    public Machine GetLastMachine()
    {
        if (null == machines)
        {
            return null;
        }
        return machines.get(machines.size()-1);
    }
}

