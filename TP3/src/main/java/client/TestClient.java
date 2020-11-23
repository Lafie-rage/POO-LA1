package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {
    public void connect() {
        try (Socket clientSocket = new Socket("127.0.0.1", 60000);
             OutputStream output = clientSocket.getOutputStream();
             PrintWriter writer = new PrintWriter(output)) {
            System.out.println("Connexion établie");
            writer.println("Bonjour du client");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
