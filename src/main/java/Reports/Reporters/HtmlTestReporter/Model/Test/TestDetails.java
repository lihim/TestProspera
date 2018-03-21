package Reports.Reporters.HtmlTestReporter.Model.Test;


import lombok.*;

import java.util.*;

public class TestDetails {

    @Getter
    @Setter
    public String name;


    @Getter
    @Setter
    public String descriptio;


    @Getter
    @Setter
    public String timestamp;


    @Getter
    @Setter
    public long duration;

    @Getter
    @Setter
    public String uid ;
    public Map<String, String> parameters;
    public Map<String, String> properties;
    public List<ReportElement> reportElements;


    public TestDetails()
    {
    }

    public TestDetails(String name, String uid)
    {
        this.name = name;
        this.uid = uid;
    }


    public void AddReportElement(ReportElement reportElement)
    {
        if (null == reportElements)
        {
            reportElements = new ArrayList<>();
        }
        reportElements.add(reportElement);

    }


    public void AddProperty(String key, String value)
    {
        if (null == properties)
        {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }


    public void AddParameter(String key, String value)
    {
        if (null == parameters)
        {
            parameters = new HashMap<>();
        }
        parameters.put(key, value);
    }

}
