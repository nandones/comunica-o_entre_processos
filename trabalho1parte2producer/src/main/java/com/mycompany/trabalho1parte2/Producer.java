package com.mycompany.trabalho1parte2;

import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A classe producer corresponde ao servidor.<br>
 * Por isso, execute primeiro esta aplicação<br>
 * antes do consumer.
 *
 * @author NANDONES
 */
public class Producer {

    public static ServerSocket serverSocket;
    public static int valor = 0;
    public static DataOutputStream out;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("[PRODUCER] aguardando conexão do consumer");
            Socket socket = serverSocket.accept();
            System.out.println("[PRODUCER] conectado ao consumer");
            out = new DataOutputStream(socket.getOutputStream());//canal de com para enviar
        } catch (IOException ex) {
            System.out.println("deu pau no outputstream");
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                out.writeInt(valor);
                out.flush(); // Garante que os dados foram enviados
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("deu pau na thread.sleep");
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            valor++;
        }

    }
}
