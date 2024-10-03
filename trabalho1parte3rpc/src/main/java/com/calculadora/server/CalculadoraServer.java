package com.calculadora.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;

public class CalculadoraServer {

    // Método de adição
    public int add(int x, int y) {
        return x + y;
    }

    // Método de subtração
    public int subtract(int x, int y) {
        return x - y;
    }

    // Método de multiplicação
    public int multiply(int x, int y) {
        return x * y;
    }

    // Método de divisão
    public double divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Divisão por zero não permitida");
        }
        return (double) x / y;
    }

    public static void main(String[] args) {
        try {
            // Porta do servidor
            int port = 8080;
            WebServer webServer = new WebServer(port);

            // Configuração do servidor XML-RPC
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
            PropertyHandlerMapping phm = new PropertyHandlerMapping();

            // Mapeia a classe CalculadoraServer aos métodos XML-RPC
            phm.addHandler("calculadora", CalculadoraServer.class);

            xmlRpcServer.setHandlerMapping(phm);

            // Configuração adicional do servidor
            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            // Inicia o servidor
            webServer.start();
            System.out.println("Servidor XML-RPC de calculadora iniciado na porta " + port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
