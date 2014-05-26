
package es.gob.afirma.signfolder.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "mobileError", targetNamespace = "urn:juntadeandalucia:cice:pfirma:mobile:type:v2.0")
public class MobileException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private MobileError faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public MobileException(String message, MobileError faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public MobileException(String message, MobileError faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: es.gob.afirma.signfolder.client.MobileError
     */
    public MobileError getFaultInfo() {
        return faultInfo;
    }

}
