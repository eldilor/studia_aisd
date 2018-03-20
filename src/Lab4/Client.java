package Lab4;

import services.Helper;

public class Client {
    private String name;
    private QueueList<OrderItem> order;

    public Client() {
        this.name = this.generateRandomName();
        this.order = new QueueList<OrderItem>();

        int ordersNumber = Helper.getRandomIntInRange(1, 20);

        for (int i = 0; i < ordersNumber; i++) {
            this.order.insert(new OrderItem());
        }
    }

    private String generateRandomName() {
        return "Client " + Helper.getRandomIntInRange(1, 100);
    }

    public QueueList<OrderItem> getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }
}
