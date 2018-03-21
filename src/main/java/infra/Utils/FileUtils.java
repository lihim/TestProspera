//package infra.Utils;
//
//import javafx.scene.shape.Path;
//
//public class FileUtils {
////    public static String CreateTempFolder()
////    {
////        String tempDirectory = Path.Combine(Path.GetTempPath(), Path.GetRandomFileName());
////        Directory.CreateDirectory(tempDirectory);
////        return tempDirectory;
////    }
////
//    public static void DirectoryCopy(String sourceDirName, String destDirName, bool copySubDirs)
//    {
//        // Get the subdirectories for the specified directory.
//        DirectoryInfo dir = new DirectoryInfo(sourceDirName);
//        DirectoryInfo[] dirs = dir.GetDirectories();
//
//        if (!dir.Exists)
//        {
//            throw new DirectoryNotFoundException(
//                    "Source directory does not exist or could not be found: "
//                            + sourceDirName);
//        }
//
//        // If the destination directory doesn't exist, create it.
//        if (!Directory.Exists(destDirName))
//        {
//            Directory.CreateDirectory(destDirName);
//        }
//
//        // Get the files in the directory and copy them to the new location.
//        FileInfo[] files = dir.GetFiles();
//        foreach (FileInfo file in files)
//        {
//            String temppath = Path.Combine(destDirName, file.Name);
//            file.CopyTo(temppath, false);
//        }
//
//        // If copying subdirectories, copy them and their contents to new location.
//        if (copySubDirs)
//        {
//            foreach (DirectoryInfo subdir in dirs)
//            {
//                String temppath = Path.Combine(destDirName, subdir.Name);
//                DirectoryCopy(subdir.FullName, temppath, copySubDirs);
//            }
//        }
//    }
//}
