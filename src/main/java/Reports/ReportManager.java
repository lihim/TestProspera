package Reports;


import java.util.ArrayList;
import java.util.List;

public class ReportManager implements IReportDispatcher {


        private static volatile ReportManager instance;
        private static Object syncRoot = new Object();
        private List<IReporter> reporters;
        private String outputFolder;
        private static List<String> errorsList = new ArrayList<>();

        private ReportManager() {
                reporters = new ArrayList<>();
                // reporters.add(new HtmlTestReporter());
                //   reporters.add(new ExcelReporter());
                //   reporters.add(new FailedTestReporter());
                // reporters.add(new RemoteHtmlReporter());
                outputFolder = "C:/logs";// Directory.GetParent(System.IO.Directory.GetCurrentDirectory()).Parent.Parent.FullName + @"/TestResults/Report";
                try {
                        //    System.IO.Directory.CreateDirectory(outputFolder);
                } catch (Exception e) {
                        //    throw new Exception("Failed to create reports output folder", e);
                }


                Init(outputFolder);

        }


        public static ReportManager Instance() {
                if (instance == null) {
                        synchronized (syncRoot) {
                                if (instance == null)
                                        instance = new ReportManager();
                        }
                }
                return instance;
        }

        public void Init(String outputFolder) {
                for (IReporter ireporters : reporters) {
                        synchronized (instance) {
                                ireporters.Init(outputFolder);
                        }
                }
        }

        public void StartTest(IReporter.ReporterTestInfo testInfo) {
                for (IReporter ireporter : reporters) {
                        synchronized (instance) {
                                ireporter.StartTest(testInfo);
                        }
                }
                errorsList.clear();

        }

        //
        public void EndTest(IReporter.ReporterTestInfo testInfo) {
                for (IReporter reporter : reporters) {
                        synchronized (syncRoot) {
                                if (errorsList.size() > 0) {
                                        Report("Errors during the test");//, CollatorUtilities.ConvertListToString(errorsList));
                                }
                                reporter.EndTest(testInfo);
                        }
                }
        }

        private List<Object> ConvertStringArgsToFormatterAndValues(Object[]... args) {
                List<Object> FormatterAndArgs = new ArrayList<>();

                try {
                        FormatterAndArgs.add(args[0].toString());
                        String[] StringArgs = new String[args.length - 1];
                        for (int i = 1; i < args.length; i++) {
                                StringArgs[i - 1] = args[i] != null ? args[i].toString() : "";
                        }
                        FormatterAndArgs.add(StringArgs);
                } catch (Exception ex) {

                        //ErrorFormat("ConvertStringArgsToFormatterAndValues threw exception :{0}", ex);
                }
                return FormatterAndArgs;
        }

        public void StartSuite(String suiteName, int testCount) {
                for (IReporter reporter : reporters) {
                        synchronized (syncRoot) {
                                reporter.StartSuite(suiteName, testCount);
                        }
                }


        }

        public void EndSuite(String suiteName) {
                for (IReporter reporter : reporters) {
                        synchronized (syncRoot) {
                                reporter.EndSuite(suiteName);

                        }

                }

        }

        public void EndRun()
        {
                for (IReporter reporter : reporters)
                {
                      synchronized (syncRoot)
                {
                     reporter.EndRun();

                }

                }
        }

        public void ReportError(Object[] ... args)
        {
                List<Object> info = ConvertStringArgsToFormatterAndValues(args);
                String title = String.format(info.get(0).toString(), (String[])info.get(1));

                synchronized (syncRoot)
                {
                errorsList.add(title);
                }
               // Debug.WriteLine(title);
                Report(title, "");
        }

        public void Report( Object[] ... args)
        {
                List<Object> info = ConvertStringArgsToFormatterAndValues(args);
           Report(String.format(info.get(0).toString(), (String[])info.get(1)), "");
        }


        public void Report(String title)
        {
        //Debug.println(title);
        Report(title, null);
        }

        public void Report(String title, String message)
                {
                Report(title, message, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.regular);
                }

        public void Report(String title, String message, boolean success)
                {
                Report(title, message, success ? IReporter.ReporterTestInfo.TestStatus.success : IReporter.ReporterTestInfo.TestStatus.failure);

                }

        public void Report(String title, String message, IReporter.ReporterTestInfo.TestStatus status)
                {
                Report(title, message, status, IReporter.ReportElementType.regular);
                }

        public void Report(String title, String message, IReporter.ReporterTestInfo.TestStatus status, IReporter.ReportElementType type) {
                for (IReporter reporter : reporters) {
                        synchronized (syncRoot) {

                                //Report.Report(title);
                                reporter.Report(title, message, status, type);
                        }
                }
        }

        public void ReportFile(String title, String filePath) {
                Report(title, filePath, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.lnk);

        }

        public void Step(String title) {
                Report(title, null, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.step);
        }

        public void Warning(String title) {
                Report(title, null, IReporter.ReporterTestInfo.TestStatus.error, IReporter.ReportElementType.step);
        }

        public void ReportImage(String title, String filePath) {
                Report(title, filePath, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.img);
        }

        public void StartLevel(String description) {
                Report(description, null, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.startLevel);
        }

        public void EndLevel() {
                Report(null, null, IReporter.ReporterTestInfo.TestStatus.success, IReporter.ReportElementType.stopLevel);
        }

        public void AddTestProperty(String propertyName, String propertyValue) {
                for (IReporter reporter : reporters) {
                        synchronized (syncRoot) {
                                reporter.AddTestProperty(propertyName, propertyValue);
                        }

                }

        }

}



