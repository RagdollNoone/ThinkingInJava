package DesignPattern.FacadePattern;

public class FacadePattern {
    public static void TestFacadePattern(String[] args) {
        System.out.println("Test FacadePattern Result: ");

        Amplifier amplifier = new Amplifier();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, dvdPlayer, screen);

        homeTheaterFacade.playMovie();
        homeTheaterFacade.endMovie();

        System.out.println("############### END ###############");
        System.out.println();
    }
}
