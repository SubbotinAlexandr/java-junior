package NetworkingDemo;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket connectionListener = new ServerSocket(9999);
        //connectionListener.setSoTimeout(1_000);
        try (
                Socket connection = connectionListener.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        connection.getInputStream())));
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        connection.getOutputStream())))
        ){
            //Теперь что-нибудь запишем в сокет, получим и выведем в консольку
            out.write("resieved: " + in.readLine());
            out.newLine();
            out.flush();

            //System.out.println(">>>> " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
