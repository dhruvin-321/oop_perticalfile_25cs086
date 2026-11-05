class MessageBuffer {

    private String message;
    private boolean hasData = false;

    public synchronized String consume() {

        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        String result = message;

        System.out.println("Consumed: " + result);

        hasData = false;
        notify();

        return result;
    }

    public synchronized void produce(String message) {

        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.message = message;

        System.out.println("Produced: " + message);

        hasData = true;
        notify();
    }
}


class ProducerTask implements Runnable {

    private MessageBuffer buffer;

    public ProducerTask(MessageBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            String message = "Message " + i;

            buffer.produce(message);
        }
    }
}


class ConsumerTask implements Runnable {

    private MessageBuffer buffer;

    public ConsumerTask(MessageBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            buffer.consume();
        }
    }
}


public class ProducerConsumer {

    public static void main(String[] args) {

        MessageBuffer buffer = new MessageBuffer();

        Thread producerThread =
                new Thread(new ProducerTask(buffer));

        Thread consumerThread =
                new Thread(new ConsumerTask(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
