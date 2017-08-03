package gerenciamentoderede;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
public class Cliente {

    public static void main(String[] args) {
        Socket sk = null;
        DataInputStream in = null;
        DataOutputStream   out = null;
        Scanner reader = new Scanner(System.in);
        try {
            sk = new Socket("localhost", 3312);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out = new DataOutputStream(sk.getOutputStream());
            in = new DataInputStream(sk.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("Digite o primeiro numero :");
            int n1 = reader.nextInt();
            System.out.println("Digite o segundo numero ");
            int n2 = reader.nextInt();
            System.out.println("Escolha a operação"
                    + "\n1 : +"
                    + "\n2 : -"
                    + "\n3 : *"
                    + "\n4 : /");
            int operacao = reader.nextInt();
            out.writeInt(n1);
            out.writeInt(n2);
            out.writeInt(operacao);
            String res = in.readUTF();
            System.out.println("Resposta = " + res);
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}