package practice;

import java.io.IOException;
import java.util.Scanner;

public class RuntimeClass {
    static int count=0;

    public static void main(String[] args) throws IOException {
        Runtime runtime=Runtime.getRuntime();




        while (true){
            Process process=runtime.exec("notepad.exe");
            Scanner scanner=new Scanner(System.in);
//            scanner.nextLine();
            System.out.println(++count);
//            process.destroy();
        }
    }
}
