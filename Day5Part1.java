  //Nicholas Latham
//12/4/2019

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
public class Main{
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
            int negative = 1;
            if(temp2 == '-'){
                negative = -1;
                i++;
                temp2 = temp.charAt(i);
            }
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
                tempNum *= negative;
                arr.add(tempNum);
            }
        }

        System.out.println(arr);

        for(int i = 0; i < arr.size(); i++){
            int opp = arr.get(i);

            //gets the different modes
            ArrayList<Integer> modes = new ArrayList<Integer>();
            String oppString = String.valueOf(opp);
             for(int j = oppString.length()-3; j >= 0; j--){
                modes.add(oppString.charAt(j)-'0');
            }
            if(modes.size() < 3){
                if(modes.size() < 2) {
                    if (modes.size() < 1) {
                        modes.add(0);
                    }
                    modes.add(0);
                }
                modes.add(0);
            }
            opp = oppString.charAt(oppString.length()-1) - '0';
            if (opp == 1) {
                i -= -1;
                int first = arr.get(i);
                i -= -1;
                int second = arr.get(i);
                i -= -1;
                int third = arr.get(i);
                int firstNum;
                int secondNum;
                if(modes.get(0)==0)
                    firstNum = arr.get(first);
                else
                    firstNum = first;
                if(modes.get(1)==0)
                    secondNum = arr.get(second);
                else
                    secondNum = second;
                int thirdNum = firstNum + secondNum;
                arr.set(third, thirdNum);
                System.out.println(first + " " + second + " " + third + " " + firstNum + " " + secondNum + " " + thirdNum + " " + modes);
            } else if (opp == 2) {
                i -= -1;
                int first = arr.get(i);
                i -= -1;
                int second = arr.get(i);
                i -= -1;
                int third = arr.get(i);
                int firstNum;
                int secondNum;
                if(modes.get(0)==0)
                    firstNum = arr.get(first);
                else
                    firstNum = first;
                if(modes.get(1)==0)
                    secondNum = arr.get(second);
                else
                    secondNum = second;
                int thirdNum = firstNum * secondNum;
                arr.set(third, thirdNum);
                System.out.println(first + " " + second + " " + third + " " + firstNum + " " + secondNum + " " + thirdNum + " " + modes);
            } else if (opp == 3){
                sc = new Scanner(System.in);
                int input = sc.nextInt();
                i++;
                int first = arr.get(i);
                arr.set(first, input);
                System.out.println(first + " " + input);
            } else if (opp == 4){
                i++;
                System.out.println("output: " + arr.get(arr.get(i)));
            }
            else if (opp == 99) {
                i = arr.size();
                System.out.println("exited");
            } else {
                i = arr.size();
                System.out.println("Unrecognized Command " + opp);
            }
        }
    }
}
