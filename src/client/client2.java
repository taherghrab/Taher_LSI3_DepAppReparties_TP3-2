package client;

import Model.operation;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client2 {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("je suis un client 2 non connecté ");
        //connexion au serveur
        InetAddress ia = InetAddress.getByName("10.26.12.228");
        InetSocketAddress isa = new InetSocketAddress(ia,1234);
        Socket s = new Socket();
        s.connect(isa);
        //Socket s = new Socket("localhost", 1234);
        System.out.println("je suis client 2 connecté ");
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        ObjectInputStream in = new ObjectInputStream(is);//lire l'objet
        ObjectOutputStream out = new ObjectOutputStream(os);//Utilisation de ObjectOutputStream pour pouvoir convertir un objet (Serializable) à un fichier binair
        //ObjectOutputStream oos = new (os);
        Scanner scanner = new Scanner(System.in);
        System.out.println("choisir le premier valeur ");
        int nb =scanner.nextInt();
        int x;
        //verification de l'operation seulement 4 operation
        do {
            System.out.println("choisir un nombre 1:multiplication  2:soustraction 3:division 4:addition");
            x = scanner.nextInt();
        }while(x>4 || x<1);
        //pw.println(x);
        int y;
        System.out.println("choisr le deuxieme nombre ");
        y=scanner.nextInt();

        operation v1 = new operation(nb,y,x,0);//creation instance  a partir de la saisie de l'utilisateur
        out.writeObject(v1);
        operation p = (operation) in.readObject();
        System.out.println("le resultat:"+p.getRes());
        s.close();//deconnexion
    }
}