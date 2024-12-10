import java.util.Scanner;

public class InputHelper {

    public static int getInt(Scanner scan, String prompt){

        int input = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                input = scan.nextInt();
                valid = true;
            } else {
                System.out.println("You have entered the wrong data type. ");
            }
            scan.nextLine();
        } while (!valid);
        return input;
    }

    public static int getPositiveNonZeroInt(Scanner scan, String prompt){

        int input = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                input = scan.nextInt();
                if(input > 0){
                    valid = true;
                }else {
                    System.out.println("Please enter a number greater than Zero");
                }
            } else {
                System.out.println("You have entered the wrong data type. ");
            }
            scan.nextLine();
        } while (!valid);
        return input;
    }
    public static int getRangedInt(Scanner scan, String prompt,int min, int max){

        int input = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if(scan.hasNextInt()){
                input = scan.nextInt();
                if(input >= min && input <= max){
                    valid = true;
                }else {
                    System.out.println("Please enter a number between " + min + " and " + max +".");
                }
            } else {
                System.out.println("You have entered the wrong data type. ");
            }
            scan.nextLine();
        } while (!valid);
        return input;
    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern){
        String input;
        boolean valid = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if(input.matches(regExPattern)){
                valid= true;
            } else {
                System.out.println("Your input does not match the required pattern. Please try again.");
            }
        } while(!valid);
        return input;
    }

    public  static String getNonZeroLenString(Scanner scan, String prompt){
        String input;
        boolean valid = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if(input.length() > 0){
                valid = true;
            } else {
                System.out.println("Please enter an input that is not enter");
            }
        } while (!valid);
        return input;

    }

    public static double getRangedDouble(Scanner scan, String prompt,double min, double max){

        double input = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()){
                input = scan.nextDouble();
                if(input >= min && input <= max){
                    valid = true;
                }else {
                    System.out.println("Please enter a number between " + min + " and " + max +".");
                }
            } else {
                System.out.println("You have entered the wrong data type. ");
            }
            scan.nextLine();
        } while (!valid);
        return input;
    }

    public static double getDouble(Scanner scan, String prompt){

        double input = 0;
        boolean valid = false;
        System.out.println(prompt);
        do {
            if(scan.hasNextDouble()){
                input = scan.nextDouble();
                valid = true;
            } else {
                System.out.println("You have entered the wrong data type. ");
            }
            scan.nextLine();
        } while (!valid);
        return input;
    }

    public static boolean getYNConfirm(Scanner scan, String prompt){
        String input;
        boolean valid = false;
        boolean yes = false;
        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("y")){
                valid = true;
                yes = true;
            } else if(input.equalsIgnoreCase("n")){
                valid = true;
                yes = false;
            } else {
                System.out.println("Please enter a Y/N");
            }

        } while(!valid);

        return yes;
    }

}