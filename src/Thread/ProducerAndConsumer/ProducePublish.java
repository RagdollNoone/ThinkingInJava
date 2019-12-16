package Thread.ProducerAndConsumer;

public interface ProducePublish {
    void addProducer(Observer o);
    void removeProducer(Observer o);
}
