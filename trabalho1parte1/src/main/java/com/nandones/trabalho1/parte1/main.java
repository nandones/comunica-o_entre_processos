package com.nandones.trabalho1.parte1;

import com.nandones.trabalho1.parte1.Producer;
import com.nandones.trabalho1.parte1.Consumer;

/**
 *
 * @author NANDONES
 */
public class main {
    
    public static int valor = 0;
    
    public static void main (String [] args){
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }
}
