package command;
import main.Persons;
/**
 * Команда 'clear'. Очищает коллекцию.
 * @author Matvei Baranov
 */

public class Clear extends Command{
    private final Persons persons;
    public Clear(Persons persons) {
        super("clear", "очистить коллекцию");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.clear();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
