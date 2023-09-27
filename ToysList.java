import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/*
 * Класс для создания списков объектов 
 * и получения нужного объекта из списка с учетом его "веса"
 */
public class ToysList {
    ArrayList<Toy> toys;
    ArrayList<String> frequency;

    public ToysList(ArrayList<Toy> toys) {
        this.toys = toys;
        this.frequency = new ArrayList<>(100);
    }

    /*
     * Возвращает следующий за последним id
     * Если список пуст, то возвращает 1
     */
    public Integer getNextID() {

        if (this.toys.size() == 0)
            return 1;
        return this.toys.get(this.toys.size() - 1).id + 1;
    }

    /*
     * Запрашивает у пользователя и возвращает целое число
     */
    public Integer inputNum(String msg) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.print(msg);
        int num = scanner.nextInt();
        // scanner.close();
        return num;
    }

    /*
     * Запрашивает и возвращает строку
     */
    public String inputString(String msg) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.print(msg);
        String text = scanner.nextLine();
        // scanner.close();
        return text;
    }

    /*
     * Запрашивает значения всех полей для объета класса Toy,
     * содает его и добавляет в список (поле) toys
     * Имя (name) добавляет в список (поле) fraquency столько раз, сколько вес объекта toy
     * Тем самым реализуется в последствии вероятность выпадения конкретной игрушки
     * Такеж метод возвращает общее количество игрушек для дальнейшего контроля количества розыгрышей
     */
    public Integer fillList() {
        Integer totalAmount = 0;
        String answer = this.inputString("Добавить новую игрушку в список? (введите 'нет', чтобы закончить ввод) ");
        int index = 0;
        while (!answer.equals("нет")) {
            Integer id = getNextID();
            String name = this.inputString("Введите наимнование игрушки: ");
            Integer amount = inputNum("Введите количество игрушек: ");
            totalAmount += amount;
            Integer weight = inputNum("Введите частоту выигрыша (вес) игрушки: ");
            Toy toy = new Toy(id, name, amount, weight);
            Integer count = weight + index;
            for (int i = index; i < count; i++, index++) {
                this.frequency.add(name);
            }
            this.toys.add(toy);

            answer = this.inputString("Добавить новую игрушку в список? (введите 'нет', чтобы закончить ввод) ");
        }
        return totalAmount;
    }
    /*
     * Возвращает случайно выбранное имя (name) игрушки из частотного списка frequency
     */
    public String getName() {
        Random random = new Random();
        int index = random.nextInt(this.frequency.size());
        return this.frequency.get(index);
    }

    /*
     * Находит по полю name нужный объект и возвращает его
     * Если после уменьшения значения поля amount его значение становится равным 0,
     * то создается его копию, которая возвращается, а сам объект удаляется из списка
     * В случае нулевого размера списка возвращается null, который обрабатыватеся уже в Main
     */
    public Toy getToy(String name) {
        if (this.toys.size() != 0) {
            for (int i = 0; i < this.toys.size(); i++) {
                if (this.toys.get(i).name.equals(name)) {
                    this.toys.get(i).amount--;
                    if (this.toys.get(i).amount == 0) {
                        Integer id = this.toys.get(i).id;
                        Integer amount = this.toys.get(i).amount;
                        Integer weight = this.toys.get(i).weight;
                        Toy prize = new Toy(id, name, amount, weight);
                        this.toys.remove(i);
                        return prize;
                    }
                    return this.toys.get(i);
                }
            }
        }
        return null;
    }
}
