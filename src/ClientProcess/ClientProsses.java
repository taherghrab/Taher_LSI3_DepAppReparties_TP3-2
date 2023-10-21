package ClientProcess;

import Model.operation;

import java.io.*;
import java.net.Socket;

public  class ClientProsses extends Thread {
    Socket socket;

    public ClientProsses(Socket socket){
        super();
        this.socket = socket;// Initialise la socket pour ce client

    }
    public void num() throws IOException, ClassNotFoundException {

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);
        ObjectInputStream in = new ObjectInputStream(is);
        // Read an object of type 'operation' from the client and cast it
        operation op =  (operation)  in.readObject();// Conversion du type Object vers Operation
        // Extract the operation's operands and the operation code
        int nb1 = op.getOp1();
        int nb2 = op.getOp2();
        int ops =  op.getO();

        int res = 0;
        switch (ops){
            case 1 : res = nb1*nb2; break;
            case 2:  res=nb1-nb2;break;
            case 3:res=nb1/nb2;break;
            case 4: res=nb1+nb2;break;
            default:
                throw new IllegalStateException("Unexpected value: " + ops);
        }
        op.setRes(res);// Le renvoi du même objet vers le client après modification de la propriétés 'Res'
        out.writeObject(op);
    }
}
