package DesignPattern.CommandPattern;

public class CeilingFan {
    public enum CeilingFanSpeed {
        OFF(-1),
        LOW(0),
        MEDIUM(1),
        HIGH(2);

        private int speed;

        CeilingFanSpeed(int speed) {
            this.speed = speed;
        }

        public int getSpeedValue() {
            return speed;
        }
    }

    private CeilingFanSpeed speed;

    public CeilingFan() {
        speed = CeilingFanSpeed.OFF;
    }

    public void setSpeed(CeilingFanSpeed speed) {
        this.speed = speed;
        System.out.println("Set CeilingFan " + speed.toString());
    }

    public CeilingFanSpeed getSpeed() {
        return speed;
    }
}
