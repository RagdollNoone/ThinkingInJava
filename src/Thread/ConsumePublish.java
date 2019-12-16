package Thread;

public interface ConsumePublish {
    void addConsumer(Observer o);
    void removeConsumer(Observer o);
}
