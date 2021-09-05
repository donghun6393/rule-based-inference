package com.example.socketclient;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private static Preprocessing preprocessing;
    private static Classifier classifier;

    public static void main(String[] args) {
        int portNumber = 7000;
        String[] getData;
        getData = new String[2];
        Measurement[] dataPacket;
        String result_class;
        float[] gyroData;
        float[] accData;
        float[][] totalData = new float[2][];

        int MaxBufferSize = 1024;

        byte[] recvBuffer = new byte[MaxBufferSize];

        try {
            System.out.println("Server start...");
            ServerSocket serverSocket = new ServerSocket(portNumber); //í�¬íŠ¸ë²ˆí˜¸ë¥¼ ë§¤ê°œë³€ìˆ˜ë¡œ ì „ë‹¬í•˜ë©´ì„œ ì„œë²„ ì†Œì¼“ ì—´ê¸°
            System.out.println("Port " + portNumber + " is waiting...");
            classifier = new Classifier();
            preprocessing = new Preprocessing();



            while(true) {
                Socket socket = serverSocket.accept(); //í�´ë�¼ì�´ì–¸íŠ¸ê°€ ì ‘ê·¼í–ˆì�„ ë•Œ accept() ë©�?ì†Œë“œë¥¼ í†µí•´ í�´ë�¼ì�´ì–¸íŠ¸ ì†Œì¼“ ê°�ì²´ ì°¸ì¡°
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();

                System.out.println("Client connected : " + clientHost + ", Port: " + clientPort);

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream()); //ì†Œì¼“ì�˜ ìž…ë ¥ ìŠ¤íŠ¸ë¦¼ ê°�ì²´ ì°¸ì¡°
                Object obj = instream.readObject(); // ìž…ë ¥ ìŠ¤íŠ¸ë¦¼ìœ¼ë¡œë¶€í„° Object ê°�ì²´ ê°€ì ¸ì˜¤ê¸°

                //System.out.println("Data from the client : " + obj.toString()); // ê°€ì ¸ì˜¨ ê°�ì²´ ì¶œë ¥
                //Measurement [] dataPacket = (Measurement[]) obj;
                dataPacket = (Measurement[]) obj;



//
                preprocessing.execute(dataPacket[0], dataPacket[1]);

                classifier.predict(preprocessing);
//
  //              classifier = new Classifier();

    //            result_class = classifier.predict();

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream()); //ì†Œì¼“ì�˜ ì¶œë ¥ ìŠ¤íŠ¸ë¦¼ ê°�ì²´ ì°¸ì¡°
                outstream.writeObject("Result of Prediction"+1); //ì¶œë ¥ ìŠ¤íŠ¸ë¦¼ì—� ì�‘ë‹µ ë„£ê¸°
                outstream.flush(); // ì¶œë ¥p9
                socket.close(); //ì†Œì¼“ í•´ì œ
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}