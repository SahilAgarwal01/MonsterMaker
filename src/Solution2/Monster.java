package Solution2;

import java.util.*;


public class Monster {
    public static void main(String[] args) {
    	BabyMonster bm = new BabyMonster();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the no. of monsters you want to create:");
        int n = scanner1.nextInt();
        scanner1.nextLine();
        List<ParentMonster> monsters = new ArrayList<>();


        // Create monsters with user input
        for (int i = 0; i < n; i++) {
            monsters.add(createMonster(scanner1, "Monster " + (i + 1)));
        }


        // Create babies by combining traits
        Set<ParentMonster> babies = bm.createBabies(monsters);


        // Display traits of the baby monsters
        System.out.println("\nBaby Monsters Traits:");
        for (ParentMonster babyMonster : babies) {
            bm.displayMonsterTraits(babyMonster);
        }
    }


    private static ParentMonster createMonster(Scanner scanner, String monsterName) {
        System.out.println("Enter traits for " + monsterName + ":");
        System.out.print("Eye Color: ");
        String eyeColor = scanner.nextLine();


        System.out.print("Feather Color: ");
        String featherColor = scanner.nextLine();


        System.out.print("Magical Abilities: ");
        String magicalAbilities = scanner.nextLine();


        System.out.print("Size: ");
        int size = scanner.nextInt();


        System.out.print("Strength: ");
        int strength = scanner.nextInt();
        System.out.print("Durability: ");
        int durability = scanner.nextInt();
        System.out.print("Weakness: ");
        scanner.nextLine();
        String weakness = scanner.nextLine();
        System.out.print("Aggression Level: ");
        int aggressionLevel = scanner.nextInt();
        scanner.nextLine();
        return new ParentMonster(eyeColor, featherColor, magicalAbilities, size,
                strength, durability, weakness, aggressionLevel);
    }
}