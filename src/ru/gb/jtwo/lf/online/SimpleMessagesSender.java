package ru.gb.jtwo.lf.online;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public class SimpleMessagesSender {
    public static void main(String[] args) {
        sendMessages();
    }

    private static void sendMessages() {
        Vector<String> msg = generateMessages();
        sender(msg);
    }

    private static void sender(Vector<String> msg) {

        try (Socket s = new Socket("127.0.0.1", 8189)) {
            System.out.println("Socket connected");
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            for (String s1 : msg) {
                out.writeUTF(s1);
                System.out.println("byte written");
                String b = in.readUTF();
                System.out.println("byte received: " + b);
                Thread.sleep(100);
            }
            System.out.println("Заврешили отправку");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Vector<String> generateMessages() {
        Vector<String> msg = new Vector<>();
        for (int i = 0; i < 100; i++) {
            msg.add("String" + i);
        }
        return msg;
    }
}
