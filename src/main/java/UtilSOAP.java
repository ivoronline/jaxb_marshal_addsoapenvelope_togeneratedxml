import org.w3c.dom.Document;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

public class UtilSOAP {

  //=======================================================================================
  // XML DOCUMENT TO SOAP MESSAGE
  //=======================================================================================
  public static SOAPMessage XMLDocumentToSOAPMessage(Document document) throws Exception {

    //ADD SOAP ENVELOPE
    MessageFactory  messageFactory = MessageFactory.newInstance();
    SOAPMessage     soapMessage    = messageFactory.createMessage();
                    soapMessage.getSOAPBody().addDocument(document);

    //RETURN SOAP MESSAGE
    return soapMessage;

  }

  //=======================================================================================
  // SOAP MESSAGE TO SOAP DOCUMENT
  //=======================================================================================
  public static Document SOAPMessageToSOAPDocument(SOAPMessage soapMessage) throws Exception {

    //SOAP MESSAGE TO SOAP DOCUMENT
    Source             src         = soapMessage.getSOAPPart().getContent();
    TransformerFactory tf          = TransformerFactory.newInstance();
    Transformer        transformer = tf.newTransformer();
    DOMResult          result      = new DOMResult();
                       transformer.transform(src, result);
    Document           document    = (Document) result.getNode();

    //RETURN SOAP DOCUMENT
    return document;

  }

}
