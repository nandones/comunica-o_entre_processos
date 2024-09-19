package com.mycompany.trabalho1parte2consumer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NANDONES
 */
public class Consumer {

    public static Socket socket;
    public static DataInputStream in;
    public static int valorRecebido;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 12345);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("[CONSUMER] conectado ao producer");
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[CONSUMER] não houve conexão ao producer");
        }
        while (true) {
            try {
                in = new DataInputStream(socket.getInputStream());
                valorRecebido = in.readInt();
            } catch (IOException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Valor recebido do servidor: " + valorRecebido);
        }
    }
}
