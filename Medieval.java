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

                    System.out.println("What is the name of your game?");
                    String gameName = userScan.nextLine();
                    output.println(gameName);

                    System.out.println("Character #1:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    String type = userScan.nextLine();
                    Character char1 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name1 = userScan.nextLine();

                    output.println(name1 + char1);
                    System.out.println(char1);


                    System.out.println("Character #2:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char2 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name2 = userScan.nextLine();

                    output.println(name2 + char2);


                    System.out.println("Character #3:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char3 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name3 = userScan.nextLine();

                    output.println(name3 + char3);


                    System.out.println("Character #4:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char4 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name4 = userScan.nextLine();

                    output.println(name4 + char4);

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

                Character newChar = new Character();
                String newStuff = reChar + "," + newChar;

                String newContent = oldFile.replaceAll(oldFile, newStuff);
                FileWriter writer = new FileWriter(changedFile);
                writer.write(newContent);

                br.close();
                writer.close();

                System.out.println("Character has been rerolled");

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