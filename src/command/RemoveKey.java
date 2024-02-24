package command;
import main.Person;
import main.Persons;
/**
 * Команда 'remove_key'. Удаляет элемент из коллекции по id.
 * @author Matvei Baranov
 */
public class RemoveKey extends Command{
    private final Persons persons;
    public RemoveKey(Persons persons) {
        super("remove_key {id}","удалить элемент из коллекции по его ключу");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (!parametr.isEmpty()){
            if (Person.validateID(parametr)){
                persons.remove(Integer.parseInt(parametr));
            }
            else{
                System.out.println("Ошибка ID");
            }
        }
        else{
            System.out.println("У этой команды обязательный параметр ID!");
        }
        return false;
    }
}
