package classededados;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(9000);
        System.out.println("ATENÇÃO: Porta 9000 aberta!");

        Socket cliente = servidor.accept();
        System.out.println("Conexão com Cliente estabelecida " +
            cliente.getInetAddress().getHostAddress()
        );

        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

        s.close();
        servidor.close();
        cliente.close();
    }
}