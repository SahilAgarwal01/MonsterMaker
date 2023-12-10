package Solution2;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BabyMonster {

    public Set<ParentMonster> createBabies(List<ParentMonster> parents) {
        // set to ensure uniqueness for same set of parents if we want to create multiple babies.
        Set<ParentMonster> babies = new HashSet<>();
        int n = parents.size();
        // Generate multiple unique babies out of many combinations of parent monsters.
        // eg no of parents =3 then combinations are - (1,2),(1,3),(2,3).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
            	ParentMonster parent1 = parents.get(i);
            	ParentMonster parent2 = parents.get(j);


            	ParentMonster babyMonster = ParentMonster.createBabyMonster(parent1, parent2);


                // Ensure uniqueness
                // if that baby is present, create another baby for same parents.
                while (babies.contains(babyMonster)) {


                    babyMonster = ParentMonster.createBabyMonster(parent1, parent2);
                }


                babies.add(babyMonster);
            }
        }




        return babies;
    }


    public void displayMonsterTraits(ParentMonster monster) {
        Field[] fields = ParentMonster.class.getDeclaredFields();


        System.out.println("Monster Traits:");
        for (Field field : fields) {
            field.setAccessible(true);


            try {
                System.out.println(field.getName() + ": " + field.get(monster));
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }
	
}
