package Chapter11.exercise;

import static Common.Print.*;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface RagdollCat {
} // new add

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError

    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots, RagdollCat {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;

        try {
            c = Class.forName("Chapter11.exercise.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces())
            printInfo(face);

        Class up = c.getSuperclass();
        Object obj = null;

        try {
            // NoSuchMethodError Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
/* Output:
Class name: typeinfo.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : typeinfo.toys.FancyToy
Class name: typeinfo.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : typeinfo.toys.HasBatteries
Class name: typeinfo.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : typeinfo.toys.Waterproof
Class name: typeinfo.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : typeinfo.toys.Shoots
Class name: typeinfo.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : typeinfo.toys.Toy
*///:~
