package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur extends Thread {
    private ServerSocket serverSocket;
    private static final List<Connexion> connexions = new ArrayList<>();

    public Serveur() throws IOException {
        serverSocket = new ServerSocket(60000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                synchronized (connexions){
                    connexions.add(new Connexion(client));
                    connexions.get(connexions.size()-1).start();
                }
            } catch (IOException e) {
                System.out.println("Fermeture du serveur");
                fermerStocketEcoute();
            }
            System.out.println("Nombre de connexion(s) : " + connexions.size());
        }
    }

    private void fermerStocketEcoute() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized List<Connexion> getConnexions() {
        return new ArrayList<>(connexions);
    }

    public static void main(String[] args) {
        try {
            Serveur serv = new Serveur();
            serv.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static synchronized void removeConnexion(Connexion connexion) {
        connexions.remove(connexion);
    }
}
