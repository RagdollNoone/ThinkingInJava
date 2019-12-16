package Thread.ProducerAndConsumer;

public interface ConsumePublish {
    void addConsumer(Observer o);
    void removeConsumer(Observer o);
}
