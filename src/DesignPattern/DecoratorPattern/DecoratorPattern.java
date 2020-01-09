package DesignPattern.DecoratorPattern;

import DesignPattern.DecoratorPattern.TestCase1.*;
import DesignPattern.DecoratorPattern.TestCase1.Condiment.CondimentDecorator;
import DesignPattern.DecoratorPattern.TestCase1.Condiment.Milk;
import DesignPattern.DecoratorPattern.TestCase1.Condiment.Mocha;
import DesignPattern.DecoratorPattern.TestCase1.Size.Tall;
import DesignPattern.DecoratorPattern.TestCase2.LowerCaseInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class DecoratorPattern {
    public static void TestDecoratorPattern(String[] args) {
        System.out.println("Test DecoratorPattern Result: ");
        TestCase1(args);
        TestCase2(args);
        System.out.println("############### END ###############");
        System.out.println();
    }

    private static void TestCase1(String[] args) {
        System.out.println("Test DecoratorPattern TestCase1 Result: ");
        Beverage darkRoast = new DarkRoast();
        darkRoast = new Milk(darkRoast);
        darkRoast = new Milk(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Tall(darkRoast);

        float cost = darkRoast.cost();
        String description = darkRoast.getDescription();

        System.out.println("cost value is " + cost);
        System.out.println("description is " + description);

        ArrayList<String> descriptionArrayList = new ArrayList<>();
        darkRoast.getPrettyDescription(descriptionArrayList);
        System.out.println(CondimentDecorator.printPrettyDescription(descriptionArrayList));
    }

    private static void TestCase2(String[] args) {
        System.out.println("Test DecoratorPattern TestCase2 Result: ");

        int c;

        try {
            FileInputStream fs = new FileInputStream("resources/LowerCaseInputStream.txt");
            BufferedInputStream bs = new BufferedInputStream(fs);
            LowerCaseInputStream ls = new LowerCaseInputStream(bs);
            InputStream in = new LowerCaseInputStream(ls);

            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }

            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
