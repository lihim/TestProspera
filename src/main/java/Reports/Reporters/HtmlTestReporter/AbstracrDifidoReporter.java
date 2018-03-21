package Reports.Reporters.HtmlTestReporter;

import Reports.IReporter;
import Reports.Reporters.HtmlTestReporter.Model.Extention.Execution;
import Reports.Reporters.HtmlTestReporter.Model.Extention.Machine;
import Reports.Reporters.HtmlTestReporter.Model.Extention.Scenario;
import Reports.Reporters.HtmlTestReporter.Model.Extention.Test;
import Reports.Reporters.HtmlTestReporter.Model.Test.ReportElement;
import Reports.Reporters.HtmlTestReporter.Model.Test.TestDetails;
import lombok.Getter;
import org.joda.time.*;

import java.io.File;
import java.util.Random;


public abstract class AbstracrDifidoReporter {//extends IReporter {

    private Execution execution;
    private Test currentTest;
    private int index;
    private String executionUid;
    private TestDetails testDetails;
    private Machine machine;
 //   private Stopwatch stopwatch;
//
    public void Init(String outputFolder)
    {
        GenerateUid();
    //    machine = new Machine(System.getenv(machine.getName()));
        execution = new Execution();
        execution.AddMachine(machine);
        MachineWasAdded(machine);
     //   stopwatch = new Stopwatch();
    }

    private void GenerateUid()
    {
        executionUid = new Random().nextInt( 1000) + (DateTime.now()).toString(); //TimeSpan.TicksPerMinute).toString();
    }

    public  void StartTest(IReporter.ReporterTestInfo testInfo)
    {

     //   currentTest = new Test(index, testInfo.getTestName(), executionUid + "-" + index);
        currentTest.timestamp = DateTime.now().toString("yyyy/MM/dd HH:mm:ss");
        currentTest.className = testInfo.FullyQualifiedTestClassName;
        String scenarioName = testInfo.FullyQualifiedTestClassName.split(".")[testInfo.FullyQualifiedTestClassName.split(".").length - 2];
        Scenario scenario;
        if (machine.IsChildWithNameExists(scenarioName))
        {
            scenario = (Scenario)machine.GetChildWithName(scenarioName);
        }
        else
        {
            scenario = new Scenario(scenarioName);
            if (machine.children != null)
            {
                // We need to copy all the properties from the first scenario.
                // Failing to do so will cause that the tests in the ElsaticSearch, for example, will not have properties.
        //        scenario.scenarioProperties = ((Scenario)machine.children[0]).scenarioProperties;
            }
            machine.AddChild(scenario);

        }
        scenario.AddChild(currentTest);
        ExecutionWasAddedOrUpdated(execution);
  //      testDetails = new TestDetails(testInfo.getTestName, currentTest.uid);
        testDetails.descriptio = testInfo.FullyQualifiedTestClassName;
 //       testDetails.timestamp = DateTime.now.toString("yyyy/MM/dd HH:mm:ss");
    }

    public  void EndTest(IReporter.ReporterTestInfo testInfo)
    {
        TestDetailsWereAdded(testDetails);
        currentTest.status = testInfo.Status.toString();
        currentTest.duration = testInfo.DurationTime;
        testDetails.duration = testInfo.DurationTime;
        ExecutionWasAddedOrUpdated(execution);
        index++;
    }


    public void Report(String title, String message, IReporter.ReporterTestInfo.TestStatus status, IReporter.ReportElementType type)
    {
        ReportElement element = new ReportElement();
        if (null == testDetails)
        {
            //Console.WriteLine("HTML reporter was not initiliazed propertly. No reports would be created.");
            return;
        }
        testDetails.AddReportElement(element);
        element.title = title;
        element.message = message;
   //     element.time = DateTime.now.toString("HH:mm:ss");
        element.status = status.toString();
        element.typ = type.toString();

        if (type == IReporter.ReportElementType.lnk || type == IReporter.ReportElementType.img)
        {
//            if (File.Exists(message))
//            {
//                String fileName = FileWasAdded(testDetails, message);
//                if (fileName != null)
//                {
//                    element.message = fileName;
//                }
//
//
//            }
        }
        // The stopwatch is an important mechanism that helps when test is creating a large number of message in short time intervals.
//        if (!stopwatch.IsRunning)
//        {
//            stopwatch.Start();
//        }
//        else
//        {
//            if (stopwatch.ElapsedMilliseconds <= 100)
//            {
//                return;
//            }
//        }
//        stopwatch.Restart();
//        TestDetailsWereAdded(testDetails);
    }

    public void AddTestProperty(String propertyName, String propertyValue)
    {
        if (null == testDetails)
        {
            //Console.WriteLine("HTML reporter was not initiliazed propertly. No reports would be created.");
            return;
        }
        testDetails.AddProperty(propertyName, propertyValue);
        TestDetailsWereAdded(testDetails);
    }


    protected abstract void TestDetailsWereAdded(TestDetails testDetails);

    protected abstract void ExecutionWasAddedOrUpdated(Execution execution);

    protected abstract String FileWasAdded(TestDetails testDetails, String file);

    protected abstract void MachineWasAdded(Machine machine);


    public  void StartSuite(String suiteName, int testCount)
    {
        machine.plannedTests = testCount;
    }

    {
    }

    public  void EndRun()
    {
    }


@Getter
    protected String ExecutionUid;
    @Getter
    protected Execution CurrentExecution;



}
