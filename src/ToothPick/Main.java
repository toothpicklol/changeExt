package ToothPick;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static int count=0;
    public static void readFile(String filepath) throws IOException {

        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {

                count++;
                System.out.println(file.getAbsolutePath());
            }
            else if (file.isDirectory()) {
                String[] fileList = file.list();
                assert fileList != null;
                for (String s : fileList) {
                    File readFile = new File(filepath + "//" + s);
                    if (!readFile.isDirectory()) {
                        count++;
                        String filename=readFile.getName();
                        if (filename.contains(".")) {
                            filename = filename.substring(0, filename.lastIndexOf('.'));
                        }
                        filename += "." + "jpg";

                        readFile.renameTo(new File(readFile .getParentFile(), filename));
                        System.out.println(readFile.getAbsolutePath());

                        //}


                    } else if (readFile.isDirectory()) {
                        readFile(filepath + "//" + s);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readFile()   Exception:" + e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        try {
            readFile("F:/driver/a");


        } catch (IOException ex) {
            System.out.println("error");
        }
        System.out.println(count);


    }

}
