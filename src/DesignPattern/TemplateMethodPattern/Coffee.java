package DesignPattern.TemplateMethodPattern;

public class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Coffee brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Coffee addCondiments");
    }

    @Override
    protected boolean needAddCondiments() {
        // add subclass local logic here
        System.out.println("Coffee do not need addCondiments");
        return false;
    }
}
