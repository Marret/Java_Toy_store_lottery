import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public void changeToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }
    public void listToy(){
        System.out.println(toys);
    }


    public void drawToys() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double randomValue = Math.random() * totalWeight;
        double currentWeight = 0;
        int currentID=0;
        int newQuantity=1;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            currentID=toy.getId();
            if (randomValue <= currentWeight) {
                System.out.println("Поздравляем! Вы выиграли игрушку: " + toy.getName());
                if (toy.getId() == currentID) {
                newQuantity=toy.getQuantity()-1;
                toy.setQuantity(newQuantity);
                return;}
                return;
            }
        }
    }
}