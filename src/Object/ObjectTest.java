package Object;

public class ObjectTest implements Cloneable {
    // clone Test
    private class cloneData implements Cloneable{
        private String name;
        private int age;

        public cloneData() {
            this.name = "Dendy";
            this.age = 29;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected cloneData clone() throws CloneNotSupportedException {
            cloneData cd = (cloneData) super.clone();
            this.age = cd.age;
            this.name = cd.name;

            return this;
        }
    }

    private cloneData cd;

    public cloneData getCd() {
        return cd;
    }

    public ObjectTest() {
        this.cd = new cloneData();
    }

    @Override
    protected ObjectTest clone() throws CloneNotSupportedException {
        return (ObjectTest) super.clone();
    }

    private static void testCase1() {
        ObjectTest ot1 = new ObjectTest();
        try {
            ObjectTest ot2 = ot1.clone();
            System.out.println("ot1 == ot2 ? " + ot1.equals(ot2));

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
