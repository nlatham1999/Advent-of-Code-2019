import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String args[]){

//        URL path =  Main.class.getResource("tests.txt");
        File file = new File("src/tests");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Tuple> collisions = new ArrayList<Tuple>();
        ArrayList<Tuple> path = new ArrayList<Tuple>();
        String firstPath = sc.nextLine();
        String secondPath = sc.nextLine();

        int x = 0;
        int y = 0;
        for(int i = 0; i < firstPath.length(); i++){
            char direction = firstPath.charAt(i);
            i++;
            int num = 0;
            while(i < firstPath.length() && Character.isDigit(firstPath.charAt(i))){
                num = num*10 + (firstPath.charAt(i)-'0');
                i++;
            }
            while(num > 0){
                Tuple temp = new Tuple(x, y);
                path.add(temp);
                num--;
                if(direction == 'U'){
                    y++;
                }else if(direction == 'D'){
                    y--;
                }else if(direction == 'R'){
                    x++;
                }else if(direction == 'L'){
                    x--;
                }
            }
        }


        System.out.println("test2");
        x = 0;
        y = 0;
        for(int i = 0; i < secondPath.length(); i++) {
            char direction = secondPath.charAt(i);
            i++;
            int num = 0;
            while (i < secondPath.length() && Character.isDigit(secondPath.charAt(i))) {
                num = num * 10 + (secondPath.charAt(i) - '0');
                i++;
            }
            System.out.println("test2.2 " + i + " " + secondPath.length() + " " + direction + " " + num);
            while(num > 0){
                for(int j = 0; j < path.size(); j++){
                    Tuple temp = path.get(j);
                    if((temp.x == x) && (temp.y == y) && (x != 0) && (y != 0)){
                        Tuple coll = new Tuple(x, y);
                        collisions.add(coll);
                    }

                }
                num--;
                if(direction == 'U'){
                    y++;
                }else if(direction == 'D'){
                    y--;
                }else if(direction == 'R'){
                    x++;
                }else if(direction == 'L'){
                    x--;
                }
            }
        }
        System.out.println("test3");

        x = 0;
        y = 0;
        int shortest = abs(collisions.get(0).x) + abs(collisions.get(0).y);
        for(int i = 0; i < collisions.size(); i++){
            if(abs(collisions.get(i).x) + abs(collisions.get(i).y) < shortest) {
                shortest = abs(collisions.get(i).x) + abs(collisions.get(i).y);
                y = abs(collisions.get(i).y);
                x = abs(collisions.get(i).x);
            }
        }
        System.out.println(shortest);
    }

    private static class Tuple{
        public final int x;
        public final int y;
        public Tuple(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
