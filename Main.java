import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Toy> toys = new ArrayList<>();
        ToysList lists = new ToysList(toys);
        Integer totalAmount = lists.fillList();
        Integer total;
        do {
            total = lists.inputNum("Введите количество розыгрышей (не более " + totalAmount + ")");
        } while (total > totalAmount);

        for (int index = 0; index < total; index++) {
            Toy choiceToy;
            do {
                String name = lists.getName();
                choiceToy = lists.getToy(name);
            } while (choiceToy == null);
            System.out.println("--------------------------");
            System.out.println("Выиграна игрушка \"" + choiceToy.name + "\", осталось: " + choiceToy.amount + ".");
            WriteFile.writeFile(choiceToy, "log.txt");
        }
    }
}
