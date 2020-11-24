package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur extends Thread {
    private ServerSocket serverSocket;
    private final List<Connexion> connexions = new ArrayList<>();

    public Serveur() throws IOException {
        serverSocket = new ServerSocket(60000);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket client = serverSocket.accept();
                synchronized (connexions){
                    connexions.add(new Connexion(client, this));
                    connexions.get(connexions.size()-1).start();
                }
            } catch (IOException e) {
                System.out.println("Fermeture du serveur");
                fermerStocketEcoute();
                this.interrupt();
            }
            System.out.println("Nombre de connexion(s) : " + connexions.size());
        }
        fermerStocketEcoute();
        this.interrupt();
    }

    private void fermerStocketEcoute() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized List<Connexion> getConnexions() {
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

    public synchronized void removeConnexion(Connexion connexion) {
        connexions.remove(connexion);
    }
}
