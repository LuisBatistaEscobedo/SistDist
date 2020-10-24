package TCP;
import java.net.*;
import java.io.*;

public class JavaServer {
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(4999);
		Socket s = ss.accept();
		
		System.out.println("Conexión exitosa");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("Client : "+ str);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println();
		pr.flush();
		
		s.close();
		ss.close();
	}

}
