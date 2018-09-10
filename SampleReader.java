import java.util.Scanner;
import java.io.*;

public class SampleRead{

    // sample program to read words from text file called "input.txt"
    // and put in array.

    public static void main(String[] args) throws IOException {

        String word;
        int nWords = 0;
        final int SIZE = 200;
        String[] text = new String[SIZE];
  
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNext()){
            word = sc.next();
            System.out.println(word); // echo check for debugging
            text[nWords++] = word; // put word in list
            /* NOTE line above does not check to ensure nWords < array length */
        }// end while

        sc.close();
    }// end main

}// end class SampleReader
