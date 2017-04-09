package classededados;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args)
                    throws UnknownHostException, IOException {
        Socket cliente = new Socket("local host", 9000);
        System.out.println("Cliente conectado com Sucesso!");

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();
    }
}