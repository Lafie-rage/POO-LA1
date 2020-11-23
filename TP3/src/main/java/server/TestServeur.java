package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServeur extends Thread {
    @Override
    public void run() {
        System.out.println("Création du socket");
        try (ServerSocket serverSocket = new ServerSocket(60000)) {
            System.out.println("Attente d'une connexion");
            try (Socket client = serverSocket.accept();
                 InputStreamReader input = new InputStreamReader(client.getInputStream());
                 BufferedReader reader = new BufferedReader(input)) {
                String line = reader.readLine();
                System.out.println("Acception d'un client");
                System.out.println("Message : " + line);
            }
            System.out.println("Fin de la connexion");
        } catch (IOException e) {
            System.err.println("Le port 60000 est déjà utilisé !");
        }
        System.out.println("Fermeture du serveur");
    }
}
