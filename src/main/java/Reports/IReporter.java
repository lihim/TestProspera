package Reports;


import lombok.*;

public interface IReporter {
    void Init(String outputFolder);

    void StartTest(ReporterTestInfo testInfo);

    void EndTest(ReporterTestInfo testInfo);

    void EndRun();

    void StartSuite(String suiteName, int testCount);

    void EndSuite(String suiteName);

    void Report(String title, String message, ReporterTestInfo.TestStatus status, ReportElementType type);

    void AddTestProperty(String propertyName, String propertyValue);


    public enum ReportElementType
    {
        regular,step,lnk,img,startLevel,stopLevel
    }

    public class ReporterTestInfo
    {
        public enum TestStatus
        {
            success, failure, error, warning, bug
        }
        
        private String testName;
        private String fullyQualifiedTestClassName;
        private TestStatus status;
        private String suiteName;
        private long durationTime;


        @Getter
        @Setter
        private String TestName;

        @Getter
        @Setter
        public String FullyQualifiedTestClassName;

        @Getter
        @Setter
        public TestStatus Status;

        @Getter
        @Setter
        public String SuiteName;

        @Getter
        @Setter
        public long DurationTime;
    }
}
