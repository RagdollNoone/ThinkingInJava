package Object;

public class CloneData implements Cloneable {
    private String name;
    private int age;

    public CloneData() {
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
    protected CloneData clone() throws CloneNotSupportedException {
        return (CloneData) super.clone();
    }
}
