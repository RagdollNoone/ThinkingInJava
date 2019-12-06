package Object;

public class ObjectTest implements Cloneable {
    // clone Test
    private CloneData cd;

    public CloneData getCd() {
        return cd;
    }

    public void setCd(CloneData cd) {
        this.cd = cd;
    }

    public ObjectTest() {
        this.cd = new CloneData();
    }

    @Override
    protected ObjectTest clone() throws CloneNotSupportedException {
        ObjectTest ret = (ObjectTest) super.clone();
        CloneData cdClone = this.cd.clone();
        ret.setCd(cdClone);

        return ret;
    }

    private static void testCase1() {
        ObjectTest ot1 = new ObjectTest();
        try {
            ObjectTest ot2 = ot1.clone();
            System.out.println("ot1 == ot2 ? " + ot1.equals(ot2));
            System.out.println("ot1.cd == ot2.cd " + ot1.getCd().equals(ot2.getCd()));

            ot2.getCd().setAge(18);
            System.out.println("ot1.age == ot2.age ? " + (ot1.getCd().getAge() == ot2.getCd().getAge()));
            System.out.println("ot1.age = " + ot1.getCd().getAge());

            ot2.getCd().setName("Michael");
            System.out.println("ot1.name == ot2.name ? " + (ot1.getCd().getName() == ot2.getCd().getName()));
            System.out.println("ot1.name = " + ot1.getCd().getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testCase1();
    }
}
