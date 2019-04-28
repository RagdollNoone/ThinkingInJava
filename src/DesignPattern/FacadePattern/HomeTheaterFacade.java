package DesignPattern.FacadePattern;

public class HomeTheaterFacade {
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Screen screen;

    public HomeTheaterFacade(Amplifier amplifier,
                             DvdPlayer dvdPlayer,
                             Screen screen) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.screen = screen;
    }

    public void playMovie() {
        amplifier.on();
        amplifier.setDvdPlayer(dvdPlayer);
        screen.down();
        dvdPlayer.on();
        dvdPlayer.play();
    }

    public void endMovie() {
        dvdPlayer.off();
        screen.up();
        amplifier.setDvdPlayer(null);
        amplifier.off();
    }
}
