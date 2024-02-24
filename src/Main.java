import main.Commands;
import java.util.*;
/**
 * Программа Lab5
 * @author Matvei Baranov
 * @version 2.0
 */
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Commands commands= new Commands();
        String comstr="";
        System.out.println("Программа Lab5. Введите help для вывода справки!");
        boolean exit=false;
        if (args.length>0){
            exit=commands.execute("load "+String.join(" ", args),false);
        }
        while (!exit) {
            boolean enter=false;
            while (!enter) {
                try
                {
                    comstr = scanner.nextLine();
                    if (!comstr.isEmpty()){
                        enter=true;
                    }
                }
                catch(InputMismatchException ex) {
                    System.out.println("Ошибка ввода");
                }
            }
            exit=commands.execute(comstr,false);
        }

    }

}