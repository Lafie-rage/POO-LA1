package client;

import model.Message;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.SocketException;

public class Ecouteur extends Thread {
    ObjectInputStream reader;
    JTextArea textArea;

    public Ecouteur(ObjectInputStream reader, JTextArea textArea) {
        this.reader = reader;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        Object msg;
        try {
            while (!Thread.currentThread().isInterrupted() && (msg = reader.readObject()) != null) {
                if(msg instanceof Message) {
                    System.out.println("Client : " + msg);
                    textArea.append(msg + "\n");
                }
            }
        } catch (IOException e) {
            if (e instanceof SocketException) {
                this.interrupt();
                return;
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.interrupt();
    }
}
