import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static java.lang.Math.abs;
public class Main{

    public static void main(String []args){
        int count = 0;

        //checks for pairs
        for(int i = 137683; i < 596253; i-=-1){
            String num = Integer.toString(i);
            boolean increases = true;
            boolean occurrenceHappened = false;
            for(int j = 0; j < num.length(); j++){
                int c = 1;
                char p = num.charAt(j);
                j++;
                while(j < num.length() && p == num.charAt(j)){
                    c++;
                    j++;
                }
                j--;
                if(c == 2){
                    occurrenceHappened = true;
                }
            }
            //handles makings sure the numbers increase
            for(int j = 0; j < num.length() - 1; j++){
                if(num.charAt(j) > num.charAt(j+1)){
                    increases = false;
                }
            }
            if(increases && occurrenceHappened){
                System.out.println(num);
                count++;
            }
        }
        System.out.println(count);
    }
}
