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
                    Character characterset = new Character("null");
                    characterset.setCount();
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

                    output.println("\n" + name1 + "," + char1);
                    System.out.println(char1);


                    System.out.println("Character #2:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char2 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name2 = userScan.nextLine();

                    output.println("\n" + name2 + "," + char2);


                    System.out.println("Character #3:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char3 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name3 = userScan.nextLine();

                    output.println("\n" + name3 + "," + char3);


                    System.out.println("Character #4:");
                    System.out.println("What type of character? (knight, peasant, cleric, mage, or courtier?)");
                    type = userScan.nextLine();
                    Character char4 = new Character(type);
                    System.out.println("What would you like to name your character?");
                    String name4 = userScan.nextLine();

                    output.println("\n" + name4 + "," + char4);

                    output.close();

                } else if (function == 'v') {
                    System.out.println("Which file would you like to check?");
                    String fileName = userScan.nextLine();

                    file = new File(fileName);
                    Scanner fileScan = new Scanner(file);

                    int errors = 0;

                    System.out.println("\n");
                    fileScan.nextLine();
                    while (fileScan.hasNextLine()) {
                        ArrayList<String> info = new ArrayList<String>();
                        String current = fileScan.nextLine();
                        System.out.println(current);

                        for (String word : current.split(",")) {
                            info.add(word);
                        }

                        if (!charCheck(info)) {
                            errors++;
                        }

                        System.out.println("Errors: " + errors);
                    }

                    if (errors > 0) {
                        System.out.println("\nThere are errors in your file.");
                    } else {
                        System.out.println("\nThere are no errors with your file.");
                    }

                    fileScan.close();

                } else if (function == 'r') {
                    System.out.println("Which game are you editing?");
                    String fname = userScan.nextLine();
                    File changedFile = new File(fname);
                    String oldFile = "";
                    String[] split = null;
                    Scanner fileScan = new Scanner(changedFile);

                    ArrayList<String> names = new ArrayList<String>();
                    while (fileScan.hasNextLine()) {
                        String line = fileScan.nextLine();
                        split = line.split(",");
                        names.add(split[0].toLowerCase());
                        System.out.println(line);
                    }

                    names.remove(0);

                    System.out.println("Which character would you like to reroll?");
                    String reChar = userScan.nextLine();

                    for (int i = 0; i < changedFile.length()-1; i++ ) {
                        if (reChar.toLowerCase().equals(names.get(i))) {
                            int match = i;
                            Character newChar = new Character();
                            String newStuff = reChar + "," + newChar;
                            ArrayList<String> oldContent = new ArrayList<String>();

                            FileReader fr = new FileReader(changedFile);
                            BufferedReader br = new BufferedReader(fr);
                            String line = br.readLine();
                            while (line != null) {
                                oldFile = oldFile + line + System.lineSeparator();
                                oldContent.add(line);
                                line = br.readLine();
                            }

                            String oldStuff = oldContent.get(match + 1);
                            String oldStuffString = String.join("\n", oldContent);

                            String newContent = oldStuffString.replaceAll(oldStuff, newStuff);
                            FileWriter writer = new FileWriter(changedFile);
                            writer.write(newContent);

                            br.close();
                            writer.close();

                            System.out.println("Character has been rerolled");
                        } else {
                            System.out.println("Character not found!");
                        }
                        fileScan.close();
                    }
                }
            } else if (function == 'x') {
                userScan.close();
                System.exit(0);
            } else {
                System.out.println("Not a valid option");
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

    public static boolean charCheck(ArrayList<String> info) {
        int statsumm = 0;

        if (info.size() < 7) {
            return false;
        } else if (info.size() == 7) {
            statsumm = Integer.parseInt(info.get(2)) + Integer.parseInt(info.get(3)) + Integer.parseInt(info.get(4)) + Integer.parseInt(info.get(5)) + Integer.parseInt(info.get(6));

        }

        if (statsumm > 28 || statsumm < 8) {
            return false;
        } else if ((info.get(1)).equals("knight") && (Integer.parseInt(info.get(2)) >= 11 || Integer.parseInt(info.get(2)) <= 6)) {
            return false;
        } else if ((info.get(1)).equals("peasant") && (Integer.parseInt(info.get(3)) >= 11 || Integer.parseInt(info.get(3)) <= 6)) {
            return false;
        }  else if ((info.get(1)).equals("cleric") && (Integer.parseInt(info.get(4)) >= 11 || Integer.parseInt(info.get(4)) <= 6)) {
            return false;
        }  else if ((info.get(1)).equals("mage") && (Integer.parseInt(info.get(5)) >= 11 || Integer.parseInt(info.get(5)) <= 6)) {
            return false;
        } else if ((info.get(1)).equals("courtier") && (Integer.parseInt(info.get(6)) >= 11 || Integer.parseInt(info.get(6)) <= 6)) {
            return false;
        } else if ((info.get(1)).equals("knight") || (info.get(1)).equals("peasant") || (info.get(1)).equals("cleric") || (info.get(1)).equals("mage") || (info.get(1)).equals("courtier")) {
            return true;
        }
        return false;
    }

}