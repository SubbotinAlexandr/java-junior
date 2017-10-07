package NetworkingDemo;
import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try (
                Socket connection = new Socket("localhost", 9999);
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        connection.getOutputStream())));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        connection.getInputStream())))
        ){
            //Теперь что-нибудь запишем в сокет, получим и выведем в консольку
            out.write("Hello!!");
            out.newLine();
            out.flush();

            System.out.println(">>>> " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
