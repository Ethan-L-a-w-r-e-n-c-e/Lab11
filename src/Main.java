
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList <String> currentList = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private static int lines;
    public static void main(String[] args) throws IOException {
        boolean needsSaves = false;
        boolean goAgain = true;
        String userChoice;
        printList();
        do {
            userChoice = InputHelper.getRegExString(scan,"Options: \nA  -  Add an item to the list    \nD  -  Delete an item from the list   \nP  -  Print the list    \nQ  -  Quit the program","[AaDdVvQqOoSsCc]");
            if(userChoice.equalsIgnoreCase("a")){
                addItem();
                needsSaves = true;
            } else if (userChoice.equalsIgnoreCase("d")){
                if(!currentList.isEmpty()){
                    deleteItem();
                    needsSaves = true;
                } else {
                    System.out.println("Your current list is empty");
                }

            } else if (userChoice.equalsIgnoreCase("v")){
                printList();
            } else if (userChoice.equalsIgnoreCase("q")){
                if(needsSaves){
                    if(wantToSave()){
                        save();
                    }
                    needsSaves = false;
                }
                goAgain = !quitProgramm();
            } else if (userChoice.equalsIgnoreCase("o")){
                if(needsSaves){
                    if(wantToSave()){
                        save();
                    }
                    needsSaves = false;
                }
                open();
            } else if (userChoice.equalsIgnoreCase("s")){
                save();
                needsSaves = false;
            } else if ( userChoice.equalsIgnoreCase("c")){
                currentList.clear();
            }



        } while(goAgain);
    }
    private static void save() throws  IOException{
        String fileName = InputHelper.getNonZeroLenString(scan,"Enter a file name(We will add the .txt)") +".txt";
        IOHelper.writeFile(currentList,fileName);
    }

    private static void open() throws  IOException{
        IOHelper.openFile(currentList);
        for(int i = 0; i < currentList.size(); i++) {
            lines++;
        }

    }
    private static boolean wantToSave(){
        return InputHelper.getYNConfirm(scan,"Are you sure you want to save");
    }

    private static void addItem (){
        currentList.add(InputHelper.getNonZeroLenString(scan,"Enter in a Minecraft Item"));
    }
    private static void deleteItem (){
        int index = InputHelper.getRangedInt(scan,"What number item do you want to get rid of ", 1, currentList.size())-1;
        currentList.remove(index);
    }

    private static void printList() {
        for(int i = 0; i < currentList.size(); i++) {
            System.out.println(i+1 + " - " + currentList.get(i));
        }
    }

    private static boolean quitProgramm (){
        return InputHelper.getYNConfirm(scan,"Are you sure you want to quit? [Y/N].");
    }
}