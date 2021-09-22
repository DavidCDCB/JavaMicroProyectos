package javaduino;

import Arduino.Arduino;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import static java.awt.image.ImageObserver.ERROR;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN
 */
public class JavaDuino {

    Arduino objArduino = new Arduino();
    private OutputStream output = null;
    SerialPort serialPort;
    public final String Puerto = "COM1";
    public final int tiempo = 2000;
    public final int data = 9600;
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
        }
    };

    public void conexSimple() {

        try {
            objArduino.ArduinoRXTX(Puerto, tiempo, data, evento);
        } catch (Exception ex) {
            mostrarError("Error en la coneccion");
            System.exit(ERROR);
        }
    }

    public void conex() {

        CommPortIdentifier puertoID = null;
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
        while (puertoEnum.hasMoreElements()) {
            CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            if (Puerto.equals(actualPuertoID.getName())) {
                puertoID = actualPuertoID;
                break;
            }
        }
        if (puertoID == null) {
            mostrarError("Error en la coneccion");
            System.exit(ERROR);
        }

        try {
            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), tiempo);
            serialPort.setSerialPortParams(data, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            output = serialPort.getOutputStream();
        } catch (Exception e) {
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }

    }

    public void enviarDatosSimple(String datos) {
        try {
            objArduino.SendData(datos);
        } catch (Exception e) {
            mostrarError("Error al enviar datos");
            System.exit(ERROR);
        }
    }

    public void enviarDatos(String datos) {
        try {
            output.write(datos.getBytes());
        } catch (Exception e) {
            mostrarError("ERROR DE DATOS");
            System.exit(ERROR);
        }
    }

    public String recibirDatos() {
        String res = "";
        SerialPortEventListener event = new SerialPortEventListener() {
            @Override
            public void serialEvent(SerialPortEvent spe) {
                if (objArduino.MessageAvailable() == true) {
                    String res = objArduino.PrintMessage();
                }
            }
        };
        return res;
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error de conexion", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {

    }
}
