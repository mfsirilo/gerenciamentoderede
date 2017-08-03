package gerenciamentoderede;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Servidor {
    public boolean finaliza = true;
    int cont = 0;

    public static void main(String[] args) {
        new thread(new Rumable() {
            @Override
            public void run() {
                while(finaliza) {
                    cont++;
                    
                }
            }
        })









        ServerSocket server = null;
        Socket sk = null;
        DataInputStream in = null;
        DataOutputStream ou = null;
        try {
            server = new ServerSocket(3312);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //=============================================     
        try {
            sk = server.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //===============================================
        try {
            in = new DataInputStream(sk.getInputStream());
            ou = new DataOutputStream(sk.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int n1 = in.readInt();
            int n2 = in.readInt();
            int operacao = in.readInt();
            switch(operacao){
                case 1:
                    ou.writeUTF("Resultado: " + (n1+n2));
                    break;
                case 2:
                    ou.writeUTF("Resultado: " + (n1-n2));
                    break;
                case 3:
                    ou.writeUTF("Resultado: " + (n1*n2));
                    break;
                case 4:
                    ou.writeUTF("Resultado: " + (n1/n2));
                    break;
        }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int n3 = in.readInt();
            int n4 = in.readInt();
            ou.writeUTF("Resultado da Subtracao " + (n3-n4));
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
    