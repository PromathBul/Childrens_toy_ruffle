import java.io.IOException;
import java.io.FileWriter;

/*
 * Статический метод записи выпавшей игрушки в txt файл
 */
public class WriteFile {
    public static void writeFile(Toy toy, String nameFile) {
        try (FileWriter fw = new FileWriter(nameFile, true)) {
            fw.write("Выиграна игрушка \"" + toy.name + "\", осталось: " + toy.amount);
            fw.append('\n');
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
