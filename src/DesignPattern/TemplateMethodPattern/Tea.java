package DesignPattern.TemplateMethodPattern;

public class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Tea brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Tea addCondiments");
    }

    @Override
    protected boolean needAddCondiments() {
        // add subclass local logic here
        System.out.println("Tea need addCondiments");
        return true;
    }
}
