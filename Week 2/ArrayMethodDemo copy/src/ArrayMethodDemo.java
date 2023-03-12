import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayMethodDemo {

    public static void aboveAVG(ArrayList<Integer> input){
        ArrayList<Integer> averageList = new ArrayList<>();
        double avg = input.stream().mapToInt(a -> a).sum() / (input.toArray().length);
        for (int i = 1; i <= input.toArray().length-1; i ++){
            if (input.get(i) > avg){
                averageList.add(input.get(i));
            }
        }
        System.out.println(averageList);
    }

    public static void theList(ArrayList<Integer> input){
        System.out.println(input);
    }
    public static void sum(ArrayList<Integer> input){

        System.out.println("The total sum is " + input.stream().mapToInt(a -> a).sum());

    }
    public static void reverse(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<>(input);
        Collections.reverse(output);
        System.out.println("List in reverse order is " + output);
    }
    public static void twelve(ArrayList<Integer> input){
        ArrayList<Integer> newOne = new ArrayList<>();
        for (int i = 0; i <= input.toArray().length-1; i++){
            if (input.get(i) < 12){
                newOne.add(input.get(i));
            }
            }
        if (newOne.toArray().length==0){
            System.out.println("No numbers below 12.");
        }else {
                System.out.println("All numbers below 12 are " +  newOne);
        }

        }



    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter up to 10 integers or enter 99999 to exit. ");
        System.out.print("Enter number >> ");
        int number = input.nextInt();
        int count = 0;
        while (number != 99999 && count < 10){

            numList.add(number);

            System.out.print("Enter number >> ");
            number = input.nextInt();
            count ++;

        }
        theList(numList);
        sum(numList);
        reverse(numList);
        twelve(numList);
        aboveAVG(numList);




    }
}