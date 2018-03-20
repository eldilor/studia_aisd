package Lab4;

import services.Helper;

public class WareHouse {
    private QueueList<Client> orders;

    public WareHouse() {
        this.orders = new QueueList<Client>();

        int clientsNumber = Helper.getRandomIntInRange(1, 20);

        for (int i = 0; i < clientsNumber; i++) {
            this.orders.insert(new Client());
        }
    }

    public void completeOrders() {
        for (int i = 0; this.orders != null && i < this.orders.getSize(); i++) {
            Client client = this.orders.get(i);
            QueueList<OrderItem> order = client.getOrder();
            int clientOrderSum = 0;

            for (int j = 0; order != null && j < order.getSize(); j++) {
                OrderItem orderItem = order.get(j);
                clientOrderSum += orderItem.getTotal();
            }

            System.out.println("Zamówienie zrealizowane: \t" + client.getName() + "\t do zapłaty: " + clientOrderSum);
        }
    }
}
