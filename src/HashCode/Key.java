package HashCode;

import java.util.HashMap;

public class Key {
    private Integer key;

    public Key(Integer key) {
        this.key = key;
    }

    public Integer getId() {
        return key;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return key.hashCode();
//        return (this.key * this.key) % 5;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        if (null != obj && obj instanceof Key) {
            Key key = (Key)obj;
            if (this.getId().equals(key.getId())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HashMap<Key, String> hm = new HashMap<>();
        Key k1 = new Key(1);
        Key k2 = k1;
        Key k3 = new Key(1);

        System.out.println("k1 = " + k1.hashCode());
        System.out.println("k2 = " + k2.hashCode());
        System.out.println("k3 = " + k3.hashCode());


        hm.put(k1, "String value of k1");
        System.out.println("k2 = " + hm.get(k2));
        System.out.println("k3 = " + hm.get(k3));
    }
}

