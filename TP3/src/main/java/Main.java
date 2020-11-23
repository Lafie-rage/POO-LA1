import client.TestClient;
import server.TestServeur;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestServeur monThread = new TestServeur();
        monThread.start();
        TestClient client = new TestClient();
        client.connect();
    }
}
