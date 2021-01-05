import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteRPC {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl configuracion = new  XmlRpcClientConfigImpl();
        configuracion.setServerURL(new URL("http://localhost:1201"));
        XmlRpcClient cliente = new XmlRpcClient();
        cliente.setConfig(configuracion);

        Scanner leer = new Scanner (System.in) ;
        Object listaNumeros [] = new Object[5];

         for (int x = 0 ; x<5;x++){
             System.out.println("Ingresa el numero");
             listaNumeros[x] = leer.nextDouble();

          }

        Object suma [] = (Object[])cliente.execute("Metodos.ordenar", new Object[]{listaNumeros});

           for (Object x :suma) {
            System.out.println(x.toString());
          }

    }
}
