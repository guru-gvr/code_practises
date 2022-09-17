package com.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemsLearning {

    public static void main(String[] args) throws IOException {

        Path path= FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
        Path filePath= FileSystems.getDefault().getPath("files","Sub_Directory.txt");
        printFile(filePath);
        printFile(Paths.get("/home/guru/learning/three.txt"));

        System.out.println(Paths.get(" ").toAbsolutePath());

        Path randomPath = Paths.get("Random","work");
        System.out.println(Files.exists(randomPath.toAbsolutePath()));

    }
    private static void printFile(Path path) throws IOException {
        try(BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }

        }
    }
}
