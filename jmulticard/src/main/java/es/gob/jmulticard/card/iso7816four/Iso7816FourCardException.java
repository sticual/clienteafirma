/*
 * Controlador Java de la Secretaría de Estado de Administraciones Públicas
 * para el DNI electrónico.
 *
 * El Controlador Java para el DNI electrónico es un proveedor de seguridad de JCA/JCE 
 * que permite el acceso y uso del DNI electrónico en aplicaciones Java de terceros 
 * para la realización de procesos de autenticación, firma electrónica y validación 
 * de firma. Para ello, se implementan las funcionalidades KeyStore y Signature para 
 * el acceso a los certificados y claves del DNI electrónico, así como la realización 
 * de operaciones criptográficas de firma con el DNI electrónico. El Controlador ha 
 * sido diseñado para su funcionamiento independiente del sistema operativo final.
 * 
 * Copyright (C) 2012 Dirección General de Modernización Administrativa, Procedimientos 
 * e Impulso de la Administración Electrónica
 * 
 * Este programa es software libre y utiliza un licenciamiento dual (LGPL 2.1+
 * o EUPL 1.1+), lo cual significa que los usuarios podrán elegir bajo cual de las
 * licencias desean utilizar el código fuente. Su elección deberá reflejarse 
 * en las aplicaciones que integren o distribuyan el Controlador, ya que determinará
 * su compatibilidad con otros componentes.
 *
 * El Controlador puede ser redistribuido y/o modificado bajo los términos de la 
 * Lesser GNU General Public License publicada por la Free Software Foundation, 
 * tanto en la versión 2.1 de la Licencia, o en una versión posterior.
 * 
 * El Controlador puede ser redistribuido y/o modificado bajo los términos de la 
 * European Union Public License publicada por la Comisión Europea, 
 * tanto en la versión 1.1 de la Licencia, o en una versión posterior.
 * 
 * Debería recibir una copia de la GNU Lesser General Public License, si aplica, junto
 * con este programa. Si no, consúltelo en <http://www.gnu.org/licenses/>.
 * 
 * Debería recibir una copia de la European Union Public License, si aplica, junto
 * con este programa. Si no, consúltelo en <http://joinup.ec.europa.eu/software/page/eupl>.
 *
 * Este programa es distribuido con la esperanza de que sea útil, pero
 * SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de comercialización
 * o idoneidad para un propósito particular.
 */
package es.gob.jmulticard.card.iso7816four;

import java.util.Hashtable;

import es.gob.jmulticard.apdu.StatusWord;

/** Excepci&oacute;n gen&eacute;rica en tarjetas ISO 7816-4.
 * @author Tom&aacute;s Garc&iacute;a-Mer&aacute;s */
public class Iso7816FourCardException extends Exception {

    private static final Hashtable ERRORS = new Hashtable();

    static {
        ERRORS.put(new StatusWord((byte) 0x62, (byte) 0x83), "El fichero seleccionado esta invalidado"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x65, (byte) 0x81), "Fallo en la memoria"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x67, (byte) 0x00), "Longitud incorrecta"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x68, (byte) 0x82), "Securizacion de mensajes no soportada"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x69, (byte) 0x82), "Condiciones de seguridad no satisfechas"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x69, (byte) 0x83), "Metodo de autenticacion bloqueado"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x69, (byte) 0x84), "Dato referenciado invalido"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x69, (byte) 0x85), "Condiciones de uso no satisfechas"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x69, (byte) 0x86), "Comando no permitido (no existe ningun EF seleccionado)"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x80), "Parametros incorrectos en el campo de datos"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x81), "Funcion no soportada."); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x82), "No se encuentra el fichero"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x83), "Registro no encontrado"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x84), "No hay suficiente espacio de memoria en el fichero"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x85), "La longitud de datos (Lc) es incompatible con la estructura TLV"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x86), "parametros incorrectos en P1 P2"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x87), "La longitud de los datos es inconsistente con P1-P2"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x88), "Datos referenciados no encontrados"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x89), "El fichero ya existe"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6A, (byte) 0x8A), "El nombre del DF ya existe"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6B, (byte) 0x00), "Parametro(s) incorrecto(s) P1-P2"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6E, (byte) 0x00), "Clase no soportada"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6D, (byte) 0x00), "Comando no permitido en la fase de vida actual"); //$NON-NLS-1$
        ERRORS.put(new StatusWord((byte) 0x6F, (byte) 0x00), "Diagnostico no preciso"); //$NON-NLS-1$
    }

    private final StatusWord returnCode;

    Iso7816FourCardException(final String desc, final StatusWord retCode) {
        super(desc);
        this.returnCode = retCode;
    }

    Iso7816FourCardException(final StatusWord retCode) {
        super((String) ERRORS.get(retCode));
        this.returnCode = retCode;
    }

    private static final long serialVersionUID = 5935577997660561619L;

    /** Obtiene el c&oacute;digo de finalizaci&oacute;n (en modo de palabra de estado) que caus&oacute; la
     * excepci&oacute;n.
     * @return C&oacute;digo de finalizaci&oacute;n que caus&oacute; la excepci&oacute;n */
    public StatusWord getStatusWord() {
        return this.returnCode;
    }
}
