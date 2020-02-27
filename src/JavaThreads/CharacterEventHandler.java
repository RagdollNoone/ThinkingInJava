package JavaThreads;

import java.util.Vector;

public class CharacterEventHandler {
    private Vector<CharacterListener> listeners = new Vector<>();

    public void addCharacterListener(CharacterListener cl) {
        listeners.add(cl);
    }

    public void removeCharacterListener(CharacterListener cl) {
        listeners.remove(cl);
    }

    public void fireNewCharacter(CharacterSource source, int c) {
        CharacterEvent ce = new CharacterEvent(source, c);

        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).newCharacter(ce);
        }
    }
}
