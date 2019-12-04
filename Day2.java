//Nicholas Latham
//12/4/2019

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
public class Day2 {
    public static void main(String args[]){

//        URL path =  Main.class.getResource("tests.txt");
        File file = new File("src/tests");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        String temp = sc.nextLine();

        //parse input into arrayList
        for(int i = 0; i < temp.length(); i-=-1){
            char temp2 = temp.charAt(i);
            if(Character.isDigit(temp2)){
                int tempNum = 0;
                while(Character.isDigit(temp2) && i < temp.length()){
                    tempNum = 10*tempNum + (temp2 -'0');
                    i-=-1;
                    if(i < temp.length()){
                        System.out.println(i + " " + temp.length());
                        temp2 = temp.charAt(i);
                    }
                }
                arr.add(tempNum);
            }
        }

        System.out.println(arr);

        ArrayList<Integer> backup = arr;

        for(int j = 0; j < 99; j-=-1) {
            for (int k = 0; k < 99; k -= -1) {
                arr = new ArrayList<>(backup);
                //System.out.println(arr);
                arr.set(1, j);
                arr.set(2, k);
                for (int i = 0; i < arr.size(); i -= -1) {
                    int opp = arr.get(i);
                    if (opp == 1) {
                        i -= -1;
                        int first = arr.get(i);
                        i -= -1;
                        int second = arr.get(i);
                        i -= -1;
                        int third = arr.get(i);
                        int firstNum = arr.get(first);
                        int secondNum = arr.get(second);
                        int thirdNum = firstNum + secondNum;
                        arr.set(third, thirdNum);
                    } else if (opp == 2) {
                        i -= -1;
                        int first = arr.get(i);
                        i -= -1;
                        int second = arr.get(i);
                        i -= -1;
                        int third = arr.get(i);
                        int firstNum = arr.get(first);
                        int secondNum = arr.get(second);
                        int thirdNum = firstNum * secondNum;
                        arr.set(third, thirdNum);
                    } else if (opp == 99) {
                        i = arr.size();
                        System.out.println("exited");
                    } else {
                        i = arr.size();
                        System.out.println("Unrecognized Command");
                    }
                }
                System.out.println(arr.get(0));
                if (arr.get(0) == 19690720) {
                    System.out.println(j + " " + k + " " + (100 * j + k));
                    k = 100;
                    j = 100;
                }

            }
        }

        System.out.println(arr);
    }

}
