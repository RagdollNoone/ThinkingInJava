package ThreadBook;

import java.util.*;

public class Animals {
    public int findPairs(Collection<Animal> collection) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        animals = new TreeSet<>(new SpeciesGenderComparator());
        animals.addAll(collection);

        for (Animal a : animals) {
            if (null == candidate || !candidate.isPotentialMate(a)) {
                candidate = a;
            } else {
                numPairs++;
                candidate = null;
            }
        }

        return numPairs;
    }

    public static void main(String[] args) {
        final Animals animals = new Animals();

        List<Animal> list1 = new ArrayList<>();
        List<Animal> list2 = new ArrayList<>();

        list1.add(new Animal(Species.MAN, Gender.MALE));
        list1.add(new Animal(Species.CAT, Gender.MALE));
        list1.add(new Animal(Species.DOG, Gender.MALE));
        list1.add(new Animal(Species.MAN, Gender.FEMALE));

        list2.add(new Animal(Species.MAN, Gender.MALE));
        list2.add(new Animal(Species.MAN, Gender.FEMALE));
        list2.add(new Animal(Species.CAT, Gender.MALE));
        list2.add(new Animal(Species.CAT, Gender.FEMALE));
        list2.add(new Animal(Species.DOG, Gender.MALE));
        list2.add(new Animal(Species.DOG, Gender.FEMALE));

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        print(animals.findPairs(list1));
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("Animals error 1");
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        print(animals.findPairs(list2));
                        Thread.sleep(800);
                    } catch (Exception e) {
                        System.out.println("Animals error 2");
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    private static void print(int num) {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " + thd.getName() + " num : " + num);
    }

    private static class Animal{
        Species species;
        Gender gender;

        public Animal(Species species, Gender gender) {
            this.species = species;
            this.gender = gender;
        }

        public boolean isPotentialMate(Animal other) {
            return this.species.equals(other.species) && !this.gender.equals(other.gender);
        }
    }

    private class SpeciesGenderComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal one, Animal two) {
            int speciesCompare = one.species.compareTo(two.species);
            return (speciesCompare != 0) ? speciesCompare : one.gender.compareTo(two.gender);
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }

    enum Gender{
        MALE,
        FEMALE,
    }

    enum Species {
        MAN,
        CAT,
        DOG,
    }
}
