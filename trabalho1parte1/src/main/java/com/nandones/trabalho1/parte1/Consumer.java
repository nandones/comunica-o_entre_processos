package com.nandones.trabalho1.parte1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NANDONES
 */
public class Consumer implements Runnable {

    public static void lerPorSegundo() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Valor atualizado: " + main.valor);
        }
    }

    @Override
    public void run() {

        System.out.println("entrou");
        lerPorSegundo();
    }

}
