
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList <String> minecraftItems = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean goAgain = true;
        String userChoice;
        minecraftItems.addAll(Arrays.asList("Rubby","Raw Rubby", "Rawer Rubby", "Rubby Sword", "Rubby Pickaxe", "Rubby Axe"));
        printList();
        do {
            userChoice = InputHelper.getRegExString(scan,"Options: \nA  -  Add an item to the list    \nD  -  Delete an item from the list   \nP  -  Print the list    \nQ  -  Quit the program","[AaDdPpQq]");
            if(userChoice.equalsIgnoreCase("a")){
                addItem();
            } else if (userChoice.equalsIgnoreCase("d")){
                deleteItem();
            } else if (userChoice.equalsIgnoreCase("p")){
                printList();
            } else if (userChoice.equalsIgnoreCase("q")){
                goAgain = quitProgramm();
            }



        } while(goAgain);
    }

    private static void addItem (){
        minecraftItems.add(InputHelper.getNonZeroLenString(scan,"Enter in a Minecraft Item"));
    }
    private static void deleteItem (){
        int index = InputHelper.getRangedInt(scan,"What number item do you want to get rid of ", 1,minecraftItems.size())-1;
        minecraftItems.remove(index);
    }

    private static void printList() {
        for(int i = 0; i < minecraftItems.size(); i++) {
            System.out.println(i+1 + " - " + minecraftItems.get(i));
        }
    }

    private static boolean quitProgramm (){
        return InputHelper.getYNConfirm(scan,"Are you sure you want to quit? [Y/N].");
    }
}