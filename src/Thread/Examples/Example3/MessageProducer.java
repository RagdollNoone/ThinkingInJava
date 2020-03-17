package Thread.Examples.Example3;

import java.util.ArrayList;
import java.util.List;

public class MessageProducer implements Runnable {
    private Message message;

    public MessageProducer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        publishMessages();
    }

    private void publishMessages() {
        List<String> msgs = new ArrayList<>();
        msgs.add("hello");
        msgs.add("current project is complete");
        msgs.add("here is estimation for new project");

        for(String msg : msgs) {
            message.publishMessage(msg);

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {

            }
        }

        message.publishMessage("bye");
        message.setEndIt(true);
    }
}
