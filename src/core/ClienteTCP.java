package core;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public void start() {
        //String serverIP = "192.168.1.65";
        String serverIP = "127.0.0.1";
        int puerto = 7000;
        Scanner scanner = new Scanner(System.in);
        PaqueteReq paqueteReq = new PaqueteReq();
        String comando;
        String elemento;
        do {
            System.out.println("Digita un comando (add/remove)");
            comando = scanner.nextLine();
            if (comando.equals("add") || comando.equals("remove")) {
                paqueteReq.setComando(comando);
                System.out.println("Digita un elemento");
                elemento = scanner.nextLine();
                paqueteReq.setElemento(elemento);
                System.out.println("Ejecutando " + comando);
                try {
                    Socket socket = new Socket(serverIP, puerto);
                    ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
                    stream.writeObject(paqueteReq);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else
                System.out.println("Comando no valido.");
        } while (!comando.equals("exit"));
    }
}
