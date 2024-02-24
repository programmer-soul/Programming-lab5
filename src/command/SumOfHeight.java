package command;
import main.Persons;
/**
 * Команда 'sum_of_height'. Вывести сумму значения поля height для всех элементов коллекции.
 * @author Matvei Baranov
 */
public class SumOfHeight extends Command{
    private final Persons persons;
    public SumOfHeight(Persons persons) {
        super("sum_of_height", "вывести сумму значения поля height для всех элементов коллекции");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.SumOfHeight();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
