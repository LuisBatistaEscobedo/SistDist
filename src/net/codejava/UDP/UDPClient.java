package net.codejava;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
	
	public static void main(String[] args) {
		
		DatagramSocket aSocket = null;
        Scanner sc = new Scanner(System.in);
        try {
            aSocket = new DatagramSocket();
            byte[] m = null;
            InetAddress aHost = InetAddress.getLocalHost();
            int serverPort = 6789;
            

            while (true) {
                String inp = sc.nextLine();
                m = inp.getBytes();
                DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
                aSocket.send(request);
//                byte[] buffer = new byte[1000];
//                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
//                aSocket.receive(reply);
//                System.out.println("Reply: " + new String(reply.getData()));
                if (inp.equals("bye"))
                    break;
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
            if (sc != null)
                sc.close();
        }


	}

}
