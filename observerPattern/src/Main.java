import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Topic topicRegistry = new TopicRegistry();
        Publisher publisher = new Publisher(topicRegistry);

        Customer customer1 = new Customer("customer1");
        Customer customer2 = new Customer("customer2");

        topicRegistry.subscribe("topic1", customer1);
        topicRegistry.subscribe("topic1", customer2);

        publisher.publish("topic1", "No.1 new message");

        topicRegistry.unsubscribe("topic1", customer1);

        publisher.publish("topic1", "No.2 new message");

    }

    public static class Publisher {
        private final Topic topicRegistry;

        public Publisher(Topic topicRegistry) {
            this.topicRegistry = topicRegistry;
        }

        public void publish(String topic, String message) {
            topicRegistry.notifyObservers(topic, message);
        }
    }

    public interface Observer {
        void update(String message);
    }

    public static class TopicRegistry implements Topic {
        private final Map<String, List<Observer>> observers = new HashMap<>();

        @Override
        public void subscribe(String topic, Observer observer) {
            if (!observers.containsKey(topic)) {
                observers.put(topic, new ArrayList<>());
            }
            observers.get(topic).add(observer);
        }

        @Override
        public void unsubscribe(String topic, Observer observer) {
            if (observers.containsKey(topic)) {
                observers.get(topic).remove(observer);
            }
        }

        @Override
        public void notifyObservers(String topic, String message) {
            if (observers.containsKey(topic)) {
                for (Observer observer : observers.get(topic)) {
                    observer.update(message);
                }
            }
        }
    }

    public static class Customer implements Observer {
        private final String name;

        public Customer(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " receive " + message);
        }
    }

    public interface Topic {
        void subscribe(String topic, Observer observer);

        void unsubscribe(String topic, Observer observer);

        void notifyObservers(String topic, String message);
    }

}

