package command;
import main.Persons;
/**
 * Команда 'average_of_weight'. Вывести среднее значение поля weight для всех элементов коллекции.
 * @author Matvei Baranov
 */
public class AverageOfWeight extends Command{
    private final Persons persons;
    public AverageOfWeight(Persons persons) {
        super("average_of_weight", "вывести среднее значение поля weight для всех элементов коллекции");
        this.persons = persons;
    }
    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            persons.AverageOfWeight();
        }
        else
        {
            System.out.println("У этой команды не должно быть параметров!");
        }
        return false;
    }
}
