package command;
import main.Persons;
/**
 * Команда 'max_by_id'. Вывести объект из коллекции с максимальным id.
 * @author Matvei Baranov
 */
public class MaxByID extends Command{
    private final Persons persons;
    public MaxByID(Persons persons) {
        super("max_by_id", "вывести объект из коллекции с максимальным id");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.MaxByID();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
