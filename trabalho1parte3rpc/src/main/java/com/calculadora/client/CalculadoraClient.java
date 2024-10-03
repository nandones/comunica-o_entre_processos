package com.calculadora.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Vector;

public class CalculadoraClient {

    public static void main(String[] args) {
        try {
            // Configuração do cliente
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/RPC2"));
            
            // Criação do cliente
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            // Parâmetros para a operação (exemplo: 5 + 3)
            Vector<Integer> params = new Vector<>();
            params.addElement(5);
            params.addElement(3);

            // Exemplo de adição
            Object result = client.execute("calculadora.add", params);
            System.out.println("Resultado da adição: " + result);

            // Exemplo de subtração
            result = client.execute("calculadora.subtract", params);
            System.out.println("Resultado da subtração: " + result);

            // Exemplo de multiplicação
            result = client.execute("calculadora.multiply", params);
            System.out.println("Resultado da multiplicação: " + result);

            // Exemplo de divisão
            result = client.execute("calculadora.divide", params);
            System.out.println("Resultado da divisão: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
