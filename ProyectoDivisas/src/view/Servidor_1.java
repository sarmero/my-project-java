package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor_1 implements Observer, Runnable {

    private SVC svc;
    private String nombreProductoActual;


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("pasooooo");
        if (arg instanceof String) {
            nombreProductoActual = (String) arg;
        } else {

            double valor = (double) arg;
            switch (nombreProductoActual) {
                case "Dolar":
                    svc = new SVC();
                    svc.AgregarDivisas(valor);
                    break;
                case "Euro":
                    svc.AgregarDivisas(valor);
                    break;
                case "Libra":
                    svc.AgregarDivisas(valor);
                    break;
                case "Rublo":
                    svc.AgregarDivisas(valor);
                    break;
                case "Yen":
                    svc.AgregarDivisas(valor);
                    break;
            }

        }

    }

    public Servidor_1() {
        
        Cliente c = new Cliente(5000);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
        
        svc = new SVC();
        svc.AgregarDivisas(4700);
        svc.AgregarDivisas(4500);
        svc.AgregarDivisas(3000);
        svc.AgregarDivisas(8000);
        svc.AgregarDivisas(6000);
    }
    
    

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        //puerto de nuestro servidor
        final int PUERTO = 8080;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor 2 iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado serv 2");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());


                
                double envio = in.readDouble();
                int cam = in.readInt();
                
                svc.setDivisa(cam);
                svc.setMonyEnvio(envio);
                out.writeUTF(svc.CambioMony());
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
