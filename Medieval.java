import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Medieval {
    public static void main(String[] args) throws IOException {
        System.out.println("~ Medieval Times ~");
        File file;
        Scanner scan;
        Scanner userScan;
        PrintWriter output;
        
        try {

            userScan = new Scanner(System.in);

            menu();
            char function = userScan.nextLine().charAt(0);
            
            if (function != 'x') {
                if (function == 'c') {
                    System.out.println("What file name would you like to save to?");
                    String fileName = userScan.nextLine();
                    file = new File(fileName);
                    output = new PrintWriter(new FileWriter(file, true));
                    FileWriter fw = new FileWriter(file, true);

                    System.out.println("What is the name of your game?");
                    String gameName = userScan.nextLine();
                    output.println(gameName);
                    ArrayList<String> gameInfo = new ArrayList<String>();

                    int i = 1;
                    while (i <= 4) {
                        System.out.println("Character #" + i + " :");
                        System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                        String type = userScan.nextLine();
                        Character char1 = new Character(type);
                        System.out.println("What would you like to name your character?");
                        String name1 = userScan.nextLine();
                        i++;

                        output.println(char1.toString());
                        fw.write(char1.toString());
                        System.out.println(char1.toString());


                        System.out.println("Character #" + i + " :");
                        System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                        String type2 = userScan.nextLine();
                        Character char2 = new Character(type2);
                        System.out.println("What would you like to name your character?");
                        String name2 = userScan.nextLine();
                        i++;

                        output.println(name2 + ", " + char2);
                        gameInfo.add(char2.toString());


                        System.out.println("Character #" + i + " :");
                        System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                        String type3 = userScan.nextLine();
                        Character char3 = new Character(type3);
                        System.out.println("What would you like to name your character?");
                        String name3 = userScan.nextLine();
                        i++;

                        output.println(name3 + ", " + char3);
                        gameInfo.add(char3.toString());


                        System.out.println("Character #" + i + " :");
                        System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                        String type4 = userScan.nextLine();
                        Character char4 = new Character(type4);
                        System.out.println("What would you like to name your character?");
                        String name4 = userScan.nextLine();
                        i++;

                        output.println(name4 + ", " + char4);
                        gameInfo.add(char4.toString());

                    }
                }
            } else if (function == 'v') {
                System.out.println("Which file would you like to check?");
                String fname = userScan.nextLine();

                file = new File(fname);
                Scanner fileScan = new Scanner(file);

                int errors = 0;

                

            } else if (function == 'r') {
                System.out.println("Which game are you editing?");
                String fname = userScan.nextLine();
                File changedFile = new File(fname);
                Scanner fileScan = new Scanner(file);
                System.out.println("Which character would you like to reroll? (1-4)");
                String reChar = userScan.nextLine();
                String oldFile = "";
                String s;
                String[] split = null;
                ArrayList<String> names = new ArrayList<String>();

                FileReader fr = new FileReader(changedFile);
                BufferedReader br = new BufferedReader(fr);
                while ((s=br.readLine()) != null) {
                    split = s.split(",");
                    for (String word : split) {
                        if (word.equals(reChar)) {
                            names.add(split[0].toLowerCase());
                            System.out.println(word);
                        }
                    }
                }

                String line = br.readLine();
                while (line != null) {
                    oldFile = oldFile + line + System.lineSeparator();
                    line = br.readLine();
                }

                String newContent = oldFile.replaceAll(oldFile, newStuff);
                

            } else if (function == 'x') {
                userScan.close();
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            System.exit(0);
        }
    }

    public static void menu() {
        System.out.println("\n|| Menu ||");
        System.out.println("\n\t➼ Create a new game (c) \n\t➼ Validate a save file (v) \n\t➼ Reroll/randomize an existing character (r) \n\t➼ Quit (x)");
    }

}