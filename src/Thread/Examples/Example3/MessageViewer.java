package Thread.Examples.Example3;

public class MessageViewer implements Runnable {
    private Message message;

    public MessageViewer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        while(!message.isEndIt()) {
            message.viewMessage();
        }
    }
}
