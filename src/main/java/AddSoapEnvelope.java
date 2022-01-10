import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPMessage;

public class AddSoapEnvelope {

  //=======================================================================================
  // MAIN
  //=======================================================================================
  public static void main(String[] args) throws Exception {

    //CREATE NEW DOCUMENT
    Document    document       = createDocument();

    //ADD SOAP ENVELOPE
    SOAPMessage soapMessage    = UtilSOAP.XMLDocumentToSOAPMessage (document);
    Document    soapDocument   = UtilSOAP.SOAPMessageToSOAPDocument(soapMessage);

    //SAVE RESULT TO FILE
    UtilXML.documentToFile("src/main/resources/PersonSOAP.xml", soapDocument);

    //DISPLAY RESULT TO CONSOLE
    String      documentString = UtilXML.documentToString(soapDocument);
    System.out.println(documentString);

  }

  //=================================================================================
  // CREATE DOCUMENT
  //=================================================================================
  private static Document createDocument() throws ParserConfigurationException {

    //CREATE DOCUMENT BUILDER
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                           factory.setNamespaceAware(true);
    DocumentBuilder        builder = factory.newDocumentBuilder();

    //CREATE NEW DOCUMENT
    Document               document = builder.newDocument();

    //CREATE <id>
    Element                id = document.createElementNS("http://www.ivoronline.com", "id");
                           id.appendChild(document.createTextNode("1"));

    //CREATE <name>
    Element                name = document.createElementNS("http://www.ivoronline.com", "name");
                           name.appendChild(document.createTextNode("John"));

    //CREATE <age>
    Element                age = document.createElementNS("http://www.ivoronline.com", "age");
                           age.appendChild(document.createTextNode("20"));

    //CREATE <person>
    Element                person = document.createElementNS("http://www.ivoronline.com", "person");
                           person.appendChild(id);
                           person.appendChild(name);
                           person.appendChild(age);

    //SPECIFY ROOT ELEMENT
    document.appendChild(person);

    //RETURN DOCUMENT
    return document;

  }

}
