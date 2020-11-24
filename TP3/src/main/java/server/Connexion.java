package server;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Connexion extends Thread {
    private Serveur server;
    private Socket client;
    private BufferedReader reader;
    private PrintWriter writer;

    private String id;

    public Connexion(Socket client, Serveur server) throws IOException {
        this.server = server;
        this.client = client;
        // read
        InputStreamReader input = new InputStreamReader(this.client.getInputStream());
        reader = new BufferedReader(input);
        // write
        OutputStreamWriter output = new OutputStreamWriter(this.client.getOutputStream());
        writer = new PrintWriter(output);
    }

    private synchronized void envoyerMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    @Override
    public void run() {
        String msg;
        try {
            while ((msg = reader.readLine()) != null) {
                System.out.println("Serveur : " + msg);
                if (msg.equals("CONNEXION_CLOSED")) {
                    client.close();
                    server.removeConnexion(this);
                    return;
                }
                for (Connexion client : server.getConnexions())
                    client.envoyerMessage(msg);
            }

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
        }
    }

    public synchronized void setId(String id) {
        this.id = id;
    }
}
