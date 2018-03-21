package Lab4;

import services.Helper;

public class Company {
    private QueueList<WareHouse> wareHouses;

    public Company() {
        this.wareHouses = new QueueList<WareHouse>();

        int wareHousesNumber = Helper.getRandomIntInRange(1, 20);

        for (int i = 0; i < wareHousesNumber; i++) {
            this.wareHouses.insert(new WareHouse());
        }
    }

    public double getIncome() {
        double income = 0;

        for (int i = 0; this.wareHouses != null && i < this.wareHouses.getSize(); i++) {
            WareHouse wareHouse = this.wareHouses.get(i);
            System.out.println("Warehouse " + i + " | clients: " + wareHouse.getClientsNumber());
            income += wareHouse.getIncome();
            System.out.println("warehouse " + i + " total:" + wareHouse.getIncome());
        }

        return income;
    }
}
