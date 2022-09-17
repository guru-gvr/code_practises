package com.path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PathLearning {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile fileOutputStream = new RandomAccessFile("data.dat","rwd"); FileChannel fileChannel = fileOutputStream.getChannel()){

            byte[] content = "Hello guru".getBytes();
            ByteBuffer byteBuffer = ByteBuffer.wrap(content);
           int numberOfByteWritten = fileChannel.write(byteBuffer);
            System.out.println("Number of bytes written {}"+numberOfByteWritten);
            ByteBuffer byteBuffers = ByteBuffer.allocate(numberOfByteWritten);
            fileChannel.read(byteBuffers);
            System.out.println(new String(byteBuffers.array(),StandardCharsets.UTF_8));

            // when writing integer we need to flip the buffer.

            // Relative Read
//            ByteBuffer intBufffer = ByteBuffer.allocate(200);
//            intBufffer.putInt(400);
//            intBufffer.flip();
//            numberOfByteWritten = fileChannel.write(intBufffer);
//            System.out.println("Number of bytes written {}"+numberOfByteWritten);
//            intBufffer.flip();
//            intBufffer.putInt(400);
//            intBufffer.flip();
//            numberOfByteWritten = fileChannel.write(intBufffer);
//            System.out.println("Number of bytes written {}"+numberOfByteWritten);



//            Path path = Paths.get("random.txt");
//            Files.write(path,"\nLine 4".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(path);
//            for(String line: lines){
//                System.out.println(line);
//            }

        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
