package DesignPattern.FacadePattern;

public class Amplifier {
    private DvdPlayer dvdPlayer;

    public void on() {
        System.out.println("Amplifier on");
    }

    public void off() {
        System.out.println("Amplifier off");
    }

    public void setDvdPlayer(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
        if (null != this.dvdPlayer)
            System.out.println("Amplifier setDvdPlayer: setup");
        else
            System.out.println("Amplifier setDvdPlayer: remove");
    }
}
