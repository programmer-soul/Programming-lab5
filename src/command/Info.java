package command;
import main.Persons;
/**
 * Команда 'info'. Выводит информацию о коллекции.
 * @author Matvei Baranov
 */
public class Info extends Command{
    private final Persons persons;
    public Info(Persons persons) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.info();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
