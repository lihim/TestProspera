package Reports.Reporters.HtmlTestReporter;

import Reports.Reporters.HtmlTestReporter.Model.Extention.Execution;
import Reports.Reporters.HtmlTestReporter.Model.Test.TestDetails;
import com.sun.deploy.model.Resource;
import com.sun.deploy.model.ResourceObject;
import infra.Utils.JavaScriptSerializer;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public abstract class HtmlTestReporter extends AbstractVideoEnabledDifidoReporter {
//    private final String htmlArchiveFile = "C:/Resources/difido-reports-common.jar";
//    private final String executionModelFileName = "execution.js";
//    private final String testModelFileName = "test.js";
//    private final String testHtmlFileName = "test.html";
//    //private String testFolder;
//    private File currentReportFolder;
//    private String outputFolder;
//    private File testFolder;
//
//
//    public HtmlTestReporter()
//    {
//    }
//
//
//
//    private void CreateTestFolderIfNotExists(String uid) throws IOException {
//        testFolder = new File(currentReportFolder + "/tests/test_" + uid);
//        if (!testFolder.exists())
//        {
//            testFolder.createNewFile();
//           // File.Copy(currentReportFolder + "/" + testHtmlFileName, testFolder + "/" + testHtmlFileName, true);
//        }
//
//    }
//
//
//    @Override
//    public void Init(String outputFolder) throws IOException {
//      //  super.Init(outputFolder);
//        this.outputFolder = outputFolder;
//        this.currentReportFolder = new File(outputFolder + "/current");
//        CreateReportsFolder();
//        InitHtmls();
//    }
//
//
//
//    private void CreateReportsFolder() throws IOException {
//        try
//        {
//            currentReportFolder.mkdir();
//         //   File.createDirectory(currentReportFolder);
//        }
//        catch (Exception e)
//        {
//            throw new IOException("Failed to create reports output folder", e);
//        }
//    }
//
//    private String GetRootFolder()
//    {
//        return System.getProperty("user.dir");
//   //     return Directory.GetParent(System.IO.Directory.GetCurrentDirectory()).Parent.Parent.FullName;
//    }
//
//
//    private void InitHtmls()
//    {
//        File templateFolder = new File(outputFolder + "/htmlTemplate");
//        if (!templateFolder.exists()|| !new File(templateFolder + "/index.html").exists())
//        {
//            try
//            {
//                //Deleting old reports
//                if (templateFolder.exists())
//                {
//                    templateFolder.delete();
//                }
//
//
//                //Re creating the reports output folder
//                templateFolder.createNewFile();
//
//                //Creating temp folder
//                File tempFolder = File.createTempFile("temp", "File");
//                try
//                {
//                    JarFile jar = new JarFile("difido-reports-common.jar");
//                    Enumeration enumEntries = jar.entries();
//                    while(enumEntries.hasMoreElements()) {
//                        JarEntry file = (JarEntry) enumEntries.nextElement();
//                        File f = new File(tempFolder, File.separator + file.getName());
//                        if (file.isDirectory()) {
//                            f.mkdir();
//                            continue;
//                        }
//                        InputStream is = jar.getInputStream(file);
//                        FileOutputStream fos = new FileOutputStream(f);
//                        while (is.available() > 0) {
//                            fos.write(is.read());
//                        }
//                        fos.close();
//                        is.close();
//                    }
//                    jar.close();
////
////
////                    //Extracting the JAR file with the"\difido-reports-common.jar" HTML reports to the temp folder
////                    .WriteAllBytes(tempFolder + @"\difido-reports-common.jar", );
////                    ZipFile.ExtractToDirectory(tempFolder + @"\difido-reports-common.jar", tempFolder);
////
////                    //Copying only the HTML files to the reports output folder
////                    FileUtils.DirectoryCopy(tempFolder + @"\il.co.topq.difido.view", templateFolder, true);
//                }
//                finally
//                {
//                    //Deleting the temporary folder
//                    tempFolder.delete();
//                }
//
//            }
//            catch (IOException e)
//            {
//                //Failed to create or copy files.
//                String str = e.toString();
//            }
//        }
//
//        try
//        {
//            //Deleting old reports
//            currentReportFolder.delete();
//
//            //Re creating the reports output folder
//            currentReportFolder.createNewFile();
//
//          //  FileUtils.DirectoryCopy(templateFolder, currentReportFolder, true);
//
//        }
//        catch (IOException e)
//        {
//            //Failed to create or copy files.
//            String str = e.toString();
//        }
//
//    }
//
//    @Override
//    protected void TestDetailsWereAdded(TestDetails details)
//    {
//
//        try
//        {
//            CreateTestFolderIfNotExists(details.uid);
//            JavaScriptSerializer serializer;
//            serializer.MaxJsonLength = int.MaxValue;
//            String json = "var test=" + serializer.Serialize(details) + ";";
//            System.IO.StreamWriter file = new System.IO.StreamWriter(testFolder + @"\" + testModelFileName);
//            try
//            {
//                file.WriteLine(json);
//            }
//            finally
//            {
//                file.Close();
//            }
//
//        }
//        catch (Exception e)
//        {
//            Console.WriteLine("Failed writing test details due to " + e.Message);
//        }
//
//    }
//
//    protected override void ExecutionWasAddedOrUpdated(Execution execution)
//    {
//        try
//        {
//            JavaScriptSerializer serailizer = new JavaScriptSerializer();
//            String json = "var execution=" + serailizer.Serialize(execution) + ";";
//            System.IO.StreamWriter file = new System.IO.StreamWriter(currentReportFolder + @"\" + executionModelFileName);
//
//            try
//            {
//                file.WriteLine(json);
//            }
//            finally
//            {
//                file.Close();
//            }
//        } catch (Exception e){
//
//            Console.WriteLine("Failed to write execution due to " + e.Message);
//        }
//
//    }
//
//    protected override String HtmlTestReporter(TestDetails testDetails, String file)
//    {
//        CreateTestFolderIfNotExists(testDetails.uid);
//        try
//        {
//            String fileName = Path.GetFileName(file);
//            String fileDestination = testFolder + @"\" + fileName;
//            System.IO.File.Copy(file, fileDestination, true);
//            //We need that the link would be to the file in the report folder
//            return fileName;
//        }
//        catch (IOException e)
//        {
//            Console.WriteLine("Failed adding file to the report due to " + e.Message);
//            return null;
//        }
//    }
//
//        #region unused
//
//    protected override void MachineWasAdded(Machine machine)
//    {
//    }
//        #endregion
}

