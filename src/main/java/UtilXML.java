import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;

public class UtilXML {

  //=======================================================================================
  // DOCUMENT TO STRING
  //=======================================================================================
  public static String documentToString(Document document) throws Exception {

    DOMSource          domSource          = new DOMSource(document);

    StringWriter       stringWriter       = new StringWriter();
    StreamResult       streamResult       = new StreamResult(stringWriter);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer        transformer;
                       transformer        = transformerFactory.newTransformer();
                       transformer.transform(domSource, streamResult);

    //RETURN STRING
    return stringWriter.toString();

  }

  //================================================================================
  // DOCUMENT TO FILE
  //================================================================================
  public static void documentToFile(String fileName, Document document) throws Exception {

    //OPEN FILE FOR WRITING
    OutputStream       outputStream       = new FileOutputStream(fileName);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer        transformer        = transformerFactory.newTransformer();
                       transformer.transform(new DOMSource(document), new StreamResult(outputStream));

  }

}
