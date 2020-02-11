package JavaThreads.chapter2;

public class CharacterEvent {
    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource cs, int c) {
        this.source = cs;
        this.character = c;
    }
}
