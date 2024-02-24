package command;
import main.Persons;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
/**
 * Команда 'save'. Сохраняет коллекцию в файл.
 * @author Matvei Baranov
 */

public class Save extends Command{
    private final Persons persons;
    public Save(Persons persons){
        super("save","сохранить коллекцию в файл (xml)");
        this.persons=persons;
    }
    /**
     * Сохраняет коллекцию в файл
     * @param filename имя файла
     */
    public void saveXML(String filename){
        try {
            File xmlFile = new File(filename);
            OutputStream outputStream = new FileOutputStream(xmlFile);
            XMLStreamWriter out = XMLOutputFactory.newInstance().createXMLStreamWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            out.writeStartDocument("UTF-8", "1.0");
            out.writeCharacters(System.getProperty("line.separator"));
            out.writeStartElement("Persons");
            out.writeCharacters(System.getProperty("line.separator"));
            persons.saveXML(out);
            out.writeEndElement();
            out.writeEndDocument();
            out.flush();
            out.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Ошибка сохранения! "+e);
        }
    }

    @Override
    public boolean execute(String commandName,String parametr,boolean script) {
        if (parametr.isEmpty()){
            saveXML("persons.xml");
        }
        else{
            saveXML(parametr);
        }
        return false;
    }
}
