package com.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileAndExists {

    public static void main(String[] args) {
  //      try {
//            Path sourceFile = Paths.get(".", "file1.txt");
//            Path copyFile = Paths.get(".", "file1_copy.txt");
//            System.out.println(Files.copy(sourceFile, copyFile));
            // Similarly we can copy directory without files from one location to other location.
//            Path fileToMove = Paths.get(".","file1_copy.txt");
//            Path destination = Paths.get(".","dir1","file1_copy.txt");
//            Files.move(fileToMove,destination, StandardCopyOption.REPLACE_EXISTING);
         //   Files.deleteIfExists(fileToMove);

            // Creating files and Directoriess

//            Path sourceFile = FileSystems.getDefault().getPath(".", "file2.txt");
//            Files.createFile(sourceFile);
//
//            Path sourceDir = FileSystems.getDefault().getPath(".", "dir4");
//            Files.createDirectory(sourceDir);
           // Files.createDirectories(dd);

//      Path fileSize = FileSystems.getDefault().getPath(".", "file2.txt");
//            System.out.println( Files.size(fileSize));
//
//            BasicFileAttributes attrs = Files.readAttributes(fileSize,BasicFileAttributes.class);
//            attrs.size();
//            attrs.lastAccessTime();
        //Filter to iterate only Files.
//         DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//                    @Override
//                    public boolean accept(Path entry) throws IOException {
//                        return Files.isRegularFile(entry);
//                    }
//                };
        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);
       // DirectoryStream.Filter<Path> filter = Files::isRegularFile;
        Path directory = FileSystems.getDefault().getPath("./dir2");
            try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)) {
                for(Path file : contents){
                    System.out.println(file.getFileName());
                }
                String separator = File.separator;

                Files.createTempFile("myapp",".txt");
            }   catch (IOException | DirectoryIteratorException exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }

            // One of the drawbacks in File System is seoarators .
        // To overcome that we can use File.Separator




    }
}
