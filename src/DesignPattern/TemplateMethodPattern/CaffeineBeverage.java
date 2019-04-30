package DesignPattern.TemplateMethodPattern;

public abstract class CaffeineBeverage {
    protected abstract void brew();
    protected abstract void addCondiments();

    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (needAddCondiments())
            addCondiments();
    }


    protected void boilWater() {
        System.out.println("CaffeineBeverage boilWater");
    }

    protected void pourInCup() {
        System.out.println("CaffeineBeverage pourInCup");
    }

    // hook function
    protected boolean needAddCondiments() {
        return true;
    }

}
