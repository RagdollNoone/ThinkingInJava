package Thread.Examples.Example3;

/*
    Following example shows how to use condition object for communication between
    two threads when ReentrantLock is used to restrict access to share message object
    which contains methods to publish and view messages.If the last message is not consumed,
    publish-message thread waits using a condition object and calling awaits() on it.
    Similarly, if there is no new message, view-message thread waits using another condition
    object and calling awaits method on it.
*/
public class Example3 {
    public static void main(String[] args) {
        Message msg = new Message();
        Thread messageProducer = new Thread(new MessageProducer(msg));
        Thread messageViewer = new Thread(new MessageViewer(msg));

        messageProducer.start();
        messageViewer.start();
    }
}
