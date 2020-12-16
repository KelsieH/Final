import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;

public class Character {
    private int strength;
    private int toughness;
    private int intelligence;
    private int magic;
    private int influence;
    private String name;
    private String type;
    private int knights, peasants, clerics, mages, courtiers;
    Random rand = new Random();

    public Character(String type) {
        this.type = type;
        if (type == "knight") {
            if (knights <= 2) {
                this.strength = rand.nextInt(4) + 7;
                this.toughness = rand.nextInt(6);
                this.intelligence = rand.nextInt(6);
                this.magic = rand.nextInt(6);
                this.influence = rand.nextInt(6);
                int statsum = strength + toughness + intelligence + magic + influence;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
                knights++;
            } else {
                System.out.println("You already have two knights! Choose a different type of character.");
            }
        } else if (type == "peasant") {
            if (peasants <= 2) {
                this.strength = rand.nextInt(6);
                this.toughness = rand.nextInt(4) + 7;
                this.intelligence = rand.nextInt(6);
                this.magic = rand.nextInt(6);
                this.influence = rand.nextInt(6);
                int statsum = strength + toughness + intelligence + magic + influence;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
                peasants++;
            } else {
                System.out.println("You already have two peasants! Choose a different type of character.");
            }
        } else if (type == "cleric") {
            if (clerics <= 2) {
                this.strength = rand.nextInt(6);
                this.toughness = rand.nextInt(6);
                this.intelligence = rand.nextInt(4) + 7;
                this.magic = rand.nextInt(6);
                this.influence = rand.nextInt(6);
                int statsum = strength + toughness + intelligence + magic + influence;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
                clerics++;
            } else {
                System.out.println("You already have two clerics! Choose a different type of character.");
            }
        } else if (type == "mage") {
            if (mages <= 2) {
                this.strength = rand.nextInt(6);
                this.toughness = rand.nextInt(6);
                this.intelligence = rand.nextInt(6);
                this.magic = rand.nextInt(4) + 7;
                this.influence = rand.nextInt(6);
                int statsum = strength + toughness + intelligence + magic + influence;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
                mages++;
            } else {
                System.out.println("You already have two mages! Choose a different type of character.");
            }
        } else if (type == "courtier") {
            if (courtiers <= 2) {
                this.strength = rand.nextInt(6);
                this.toughness = rand.nextInt(6);
                this.intelligence = rand.nextInt(6);
                this.magic = rand.nextInt(6);
                this.influence = rand.nextInt(4) + 7;
                int statsum = strength + toughness + intelligence + magic + influence;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
                courtiers++;
            } else {
                System.out.println("You already have two courtiers! Choose a different type of character.");
            }
        } else {
            System.out.println("Please enter a valid character type.");
        }
    }

    public void reroll() {
        if (type == "knight") {
            this.strength = rand.nextInt(4) + 7;
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type == "peasant") {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(4) + 7;
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type == "cleric") {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(4) + 7;
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type == "mage") {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(4) + 7;
            this.influence = rand.nextInt(6);
        } else if (type == "courtier") {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(4) + 7;
        }
    }

    public String toString() {
        return "\n" + name + ", " + type + ", " + strength + ", " + toughness + ", " + intelligence + ", " + influence; 
    }

}