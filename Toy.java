/**
 * Класс для объектов-игрушек
 * Поля: идентификатор, имя, количество игрушек и их вес (вероятность выпадения)
 */
public class Toy {
    Integer id;
    String name;
    Integer amount;
    Integer weight;
    
    
    Toy(Integer id, String name, Integer amount, Integer weight) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }
}