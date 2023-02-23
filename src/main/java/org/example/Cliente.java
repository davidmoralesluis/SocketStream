package org.example;

import java.io.*;
import java.net.*;


public class Cliente {

    public String response="";
    public Cliente(String mensaje) throws IOException {

        String serverHostname = "localhost";
        int serverPort = 12345;

        Socket clientSocket = new Socket(serverHostname, serverPort);

        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        InputStream in = clientSocket.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        dos.writeUTF(mensaje);
        response = dis.readUTF();

        dos.close();
        dis.close();
        clientSocket.close();

    }

    public String clienteResponde(){
        return response;
    }
}

