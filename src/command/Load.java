package command;
import main.Commands;
import main.Person;
import main.Persons;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
/**
 * Команда 'load'. Загружает коллекцию из файла.
 * @author Matvei Baranov
 */
public class Load extends Command{
    private final Commands commands;
    private final Persons persons;

    public Load(Commands commands,Persons persons){
        super("load","загрузить коллекцию из файла (xml)");
        this.commands=commands;
        this.persons=persons;
    }
    /**
     * Загружает коллекцию из файла.
     * @param filename имя файла
     */
    public void loadXML(String filename){
        persons.clear();
        persons.startLoad();
        try {
            File xmlFile = new File(filename);
            FileInputStream inputStream = new FileInputStream(xmlFile);
            BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
            bufferedStream.mark(bufferedStream.available( ));

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(bufferedStream);
            String currentElement;
            String currentText = "";
            String x="";
            String y="";
            String strid="";
            while(reader.hasNext()) {
                int next = reader.next();
                if(next == XMLStreamConstants.CHARACTERS){
                    currentText=reader.getText();
                }
                else
                if(next == XMLStreamConstants.END_ELEMENT){
                    currentElement = reader.getLocalName();
                    switch(currentElement){
                        case "id":
                            strid=currentText;
                            break;
                        case "name":
                            commands.xmlstr[0]=currentText;
                            break;
                        case "x":
                            x=currentText;
                            break;
                        case "y":
                            y=currentText;
                            break;
                        case "Coordinates":
                            commands.xmlstr[1]=x;
                            commands.xmlstr[2]=y;
                            break;
                        case "creationDate":
                            commands.xmlstr[10]=currentText;
                            break;
                        case "height":
                            commands.xmlstr[3]=currentText;
                            break;
                        case "weight":
                            commands.xmlstr[4]=currentText;
                            break;
                        case "passportID":
                            commands.xmlstr[5]=currentText;
                            break;
                        case "eyeColor":
                            commands.xmlstr[6]=currentText;
                            break;
                        case "z":
                            commands.xmlstr[9]=currentText;
                            break;
                        case "Location":
                            commands.xmlstr[7]=x;
                            commands.xmlstr[8]=y;
                            break;
                        case "Person":
                            if (Person.validateID(strid)){
                                commands.insert(Integer.parseInt(strid),false,false,false,true);
                            }
                            else{
                                System.out.println("XML Загрузка. Ошибка ID "+strid);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            reader.close();
            bufferedStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println("Ошибка загрузки! "+e);
        }
    }

    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            loadXML("persons.xml");
        }
        else{
            loadXML(parametr);
        }
        return false;
    }
}
