
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 8000);
               BufferedWriter writer =
                       new BufferedWriter(
                               new OutputStreamWriter(
                                       socket.getOutputStream()));
               BufferedReader reader =
                       new BufferedReader(
                               new InputStreamReader(
                                       socket.getInputStream()));
               ) {
                    System.out.println("Connected to serveer");
                    String request = "Random number";
                    writer.write (request);
                    writer.newLine();
                    writer.flush();
                    String response  = reader.readLine();
                    System. out.println("Response: " + response);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}