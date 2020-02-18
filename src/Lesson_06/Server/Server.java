package Lesson_06.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


    public class Server {
        private Vector<ClientHandler> clients;

        public Server() {
            clients = new Vector<>();
            ServerSocket server = null;
            Socket socket = null;

            try {
                server = new ServerSocket(8189);
                System.out.println("Сервер запустился");

                while (true) {
                    socket = server.accept();
                    System.out.println("Клиент подключился");
                    clients.add(new ClientHandler(socket, this));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void broadcastMsg(String msg){
            for (ClientHandler c: clients ) {
                c.sendMsg(msg);
            }
        }
    }

