package Reports.Reporters.HtmlTestReporter;

import java.io.IOException;

public abstract class AbstractVideoEnabledDifidoReporter extends AbstracrDifidoReporter {
//    private bool enabled = true;
//
//    public override void StartTest(ReporterTestInfo testInfo)
//    {
//        base.StartTest(testInfo);
//        if (!enabled)
//        {
//            return;
//        }
//        try
//        {
//            VideoRecorderKeeper.Instance().StartRecording();
//
//        }
//        catch(Exception e)
//        {
//            base.Report("Failed starting video file due to " + e.Message, ". Disabling video reports", ReporterTestInfo.TestStatus.warning, ReportElementType.regular);
//            enabled = false;
//        }
//
//    }
//
//    public override void EndTest(ReporterTestInfo testInfo)
//    {
//        if (enabled)
//        {
//            try
//            {
//                if (testInfo.Status != ReporterTestInfo.TestStatus.success)
//                {
//                    string videoFileName = VideoRecorderKeeper.Instance().SaveRecording();
//                    base.Report("Test Flow Video", videoFileName, ReporterTestInfo.TestStatus.failure, ReportElementType.lnk);
//                }
//                else
//                {
//                    VideoRecorderKeeper.Instance().DumpRecording();
//                }
//
//            }
//            catch(Exception e)
//            {
//                base.Report("Failed saving video file due to " + e.Message ,null, ReporterTestInfo.TestStatus.warning, ReportElementType.regular);
//            }
//
//        }
//
//        base.EndTest(testInfo);


 //   }

//    public abstract void Init(String outputFolder) throws IOException;
}
