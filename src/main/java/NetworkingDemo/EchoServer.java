package NetworkingDemo;
// Программа, которая состои из замыканий,

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket listener = new ServerSocket(9999)) {
            while(true) {
                Socket client = listener.accept();      //ждем клиентский сокет
                new Thread(new Runnable() {
                    @Override
                    public void run() {                      //Используем Thread
                        clientLoop(client);
                    }
                }).start(); // запускаем анонимную функцию в ните

            }
        } catch (IOException e) {

        }
    }

    private static void clientLoop(Socket client) {
        try (                               //Сделали лямбду
                                            OutputStream outputStream = client.getOutputStream();
                                            InputStream inputStream = client.getInputStream()
        ) {
            while (true) {
                outputStream.write(inputStream.read());
            }
        } catch (IOException e) {

        }
    }
}
