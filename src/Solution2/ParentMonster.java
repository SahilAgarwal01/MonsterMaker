package Solution2;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Random;

class ParentMonster {
    String eyeColor;
    String featherColor;
    String magicalAbilities;
    int size;
    int strength;


    int  durability;
    String weakness;
    int aggressionLevel;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentMonster monster = (ParentMonster) o;
        return size == monster.size && strength == monster.strength && durability == monster.durability && aggressionLevel == monster.aggressionLevel && Objects.equals(eyeColor, monster.eyeColor) && Objects.equals(featherColor, monster.featherColor) && Objects.equals(magicalAbilities, monster.magicalAbilities) && Objects.equals(weakness, monster.weakness);
    }


    @Override
    public int hashCode() {
        return Objects.hash(eyeColor, featherColor, magicalAbilities, size, strength, durability, weakness, aggressionLevel);
    }


    public ParentMonster() {
        // Default constructor
    }


    public ParentMonster(String eyeColor, String featherColor, String magicalAbilities, int size,
                   int strength, int durability, String weakness, int aggressionLevel) {
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }


    public static ParentMonster createBabyMonster(ParentMonster parent1, ParentMonster parent2) {
    	ParentMonster babyMonster = new ParentMonster();


        // Get all fields using reflection
        Field[] fields = ParentMonster.class.getDeclaredFields();


        // Randomly copy traits from parents to the baby monster
        Random random = new Random();
        for (Field field : fields) {
            field.setAccessible(true);


            try {
                Object parentTrait = random.nextBoolean() ? field.get(parent1) : field.get(parent2);
                field.set(babyMonster, parentTrait);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return babyMonster;
    }
}