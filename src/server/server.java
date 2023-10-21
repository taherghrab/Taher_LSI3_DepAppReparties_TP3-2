package server;

import ClientProcess.ClientProsses;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread{

    public static void main(String[] args) {
        new server().start();//appel du serveur
    }
    public void run(){
        try {
            //creation objet serversocket
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("demarage de server ");
            while (true){//attendre la connextion du plusieurs client
                Socket s = ss.accept();// Attend qu'un client se connecte et accepte la connexion.
                System.out.println("New client connected.");
                ClientProsses clientProcess = new ClientProsses(s);
                clientProcess.start(); // Démarre un thread pour gérer ce client.
               clientProcess.num();// Appelle la méthode "num" sur l'objet clientProcess
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
