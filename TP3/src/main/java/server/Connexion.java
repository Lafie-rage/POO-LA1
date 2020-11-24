package server;

import model.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Connexion extends Thread {
    private Serveur server;
    private Socket client;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private String id;

    public Connexion(Socket client, Serveur server) throws IOException {
        this.server = server;
        this.client = client;
        // write
        writer = new ObjectOutputStream(this.client.getOutputStream());
        // read
        reader = new ObjectInputStream(this.client.getInputStream());
    }

    private synchronized void envoyerMessage(Object message) throws IOException {
        writer.writeObject(message);
        writer.flush();
    }

    @Override
    public void run() {
        Object msg;
        try {
            while ((msg = reader.readObject()) != null) {
                System.out.println("Serveur : " + msg);
                for (Connexion client : server.getConnexions())
                    client.envoyerMessage(msg);
            }
            // Si null, on coupe la connexion
            client.close();
            server.removeConnexion(this);
        } catch (IOException e) {
            if (e instanceof SocketException) {
                try {
                    client.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                finally {
                    server.removeConnexion(this);
                }
                return;
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setId(String id) {
        this.id = id;
    }
}
