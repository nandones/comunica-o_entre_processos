package com.nandones.trabalho1.parte1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NANDONES
 */
public class Producer implements Runnable {

    public static void incrementarPorSegundo() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            main.valor += 1;
        }
    }

    @Override
    public void run() {
        System.out.println("entrou");
        incrementarPorSegundo();
    }
}
