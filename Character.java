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
    private static int knights=0, peasants=0, clerics=0, mages=0, courtiers=0;
    Random rand = new Random();

    public Character(String type) {
        this.type = type;
        if (type.equals("knight")) {
            if (knights < 2) {
                this.strength = rand.nextInt(4) + 7;
                this.toughness = rand.nextInt(6);
                this.intelligence = rand.nextInt(6);
                this.magic = rand.nextInt(6);
                this.influence = rand.nextInt(6);
                int statsum = strength + toughness + intelligence + magic + influence;
                knights++;
                while (statsum > 28 || statsum < 8) {
                    reroll();
                }
            } else {
                System.out.println("You already have two knights! Rolling random...");
            }
        } else if (type.equals("peasant")) {
            if (peasants < 2) {
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
                System.out.println("You already have two peasants! Rolling random...");
            }
        } else if (type.equals("cleric")) {
            if (clerics < 2) {
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
                System.out.println("You already have two clerics! Rolling random...");
            }
        } else if (type.equals("mage")) {
            if (mages < 2) {
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
                System.out.println("You already have two mages! Rolling random...");
            }
        } else if (type.equals("courtier")) {
            if (courtiers < 2) {
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
                System.out.println("You already have two courtiers! Rolling random...");
            }
        } else if (!(type.equals("courtier")) && !(type.equals("mage")) && !(type.equals("cleric")) && !(type.equals("peasant")) && !(type.equals("knight"))) {
            System.out.println("Type does not exist! Rolling random...");
            reroll();
        }
    }

    public void reroll() {
        String[] types = {"knight", "peasant", "cleric", "mage", "courtier"};
        this.type = types[rand.nextInt(4)];
        if (type.equals("knight")) {
            this.strength = rand.nextInt(4) + 7;
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("peasant")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(4) + 7;
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("cleric")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(4) + 7;
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("mage")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(4) + 7;
            this.influence = rand.nextInt(6);
        } else if (type.equals("courtier")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(4) + 7;
        }
    }

    public Character() {
        String[] types = {"knight", "peasant", "cleric", "mage", "courtier"};
        this.type = types[rand.nextInt(4)];

        if (type.equals("knight")) {
            this.strength = rand.nextInt(4) + 7;
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("peasant")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(4) + 7;
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("cleric")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(4) + 7;
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(6);
        } else if (type.equals("mage")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(4) + 7;
            this.influence = rand.nextInt(6);
        } else if (type.equals("courtier")) {
            this.strength = rand.nextInt(6);
            this.toughness = rand.nextInt(6);
            this.intelligence = rand.nextInt(6);
            this.magic = rand.nextInt(6);
            this.influence = rand.nextInt(4) + 7;
        }
    }

    public int getStrength() {
        return this.strength;
    }
    public int getToughness() {
        return this.toughness;
    }
    public int getIntelligence() {
        return this.intelligence;
    }
    public int getMagic() {
        return this.magic;
    }
    public int getInfluence() {
        return this.influence;
    }

    public void setCount() {
        knights = 0;
        peasants = 0;
        clerics = 0;
        mages = 0;
        courtiers = 0;
    }

    public boolean tooMany() {
        if (knights > 2 || peasants > 2 || clerics > 2 || mages > 2 || courtiers > 2) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.type + "," + this.strength + "," + this.toughness + "," + this.intelligence + "," + this.magic + "," + this.influence; 
    }

}