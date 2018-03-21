package Reports;

public interface IReportDispatcher {

    void StartTest(IReporter.ReporterTestInfo testInfo);

    void EndTest(IReporter.ReporterTestInfo testInfo);

    void StartSuite(String suiteName, int testCount);

    void EndSuite(String suiteName);

    void ReportError( Object[] ... args);

    void Report(Object[] ... args );

    void Report(String title);

    void Report(String title, String message);

    void Report(String title, String message, boolean status);

    void Report(String title, String message, IReporter.ReporterTestInfo.TestStatus status);

    void Report(String title, String message, IReporter.ReporterTestInfo.TestStatus status, IReporter.ReportElementType type);

    void ReportFile(String title, String filePath);

    void ReportImage(String title, String filePath);
    void Warning(String title);

    void Step(String title);

    void AddTestProperty(String propertyName, String propertyValue);

    void EndRun();
}
