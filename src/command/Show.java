package command;
import main.Persons;
/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author Matvei Baranov
 */
public class Show extends Command{
    private final Persons persons;
    public Show(Persons persons) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.show();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
