package marcin;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Run {
    public static void main(String[]args){
        final Deque<String> blockingQueue = new ConcurrentLinkedDeque<String>();

        new Thread(new TaskProducer(blockingQueue)).start();
        new Thread(new TaskProducer(blockingQueue)).start();

        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
    }
}
