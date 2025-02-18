// 16 feb 2025
import java.util.Scanner;
public class array {
    public static void main(String[] args){
     //  Creating an array
    int marks[] = new int[5];
    String numbers[] = {"abc", "def"};
    // default for int values in array is zero, an empty 
    // character in case of char and ans empty string in 
    // case of string data structure.

    System.out.println(numbers[0]);
    Scanner sc = new Scanner(System.in);
    marks[0] = sc.nextInt();
    marks[1] = sc.nextInt();
    marks[2] = marks[1] = 90;
    sc.close();
    System.out.println(marks[0]);
    System.out.println(marks[1]);
    System.out.println(marks[2]);
    // length of array
    System.out.println("Length of array "+ marks.length);
    }
   
}
