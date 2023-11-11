package wk06_zerobrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class wk06_sslzerobrowser {
	public static void main(String [] args) throws IOException {
		String hostname = "www.google.com";
		int port = 443;
		
		SSLSocketFactory factory = ( SSLSocketFactory ) SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket( hostname, port );
		System.out.println("Connecting....");
		socket.startHandshake(); 
		PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
	    BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
	    if(socket.isConnected()) {
	    	System.out.println( "Connected to " + socket.getInetAddress() + ":" + socket.getPort() + " from " + socket.getLocalAddress() + ":" + socket.getLocalPort() );
	    	System.out.println( "Other info:" + "\n >getHandshakeApplicationProtocol " + socket.getHandshakeApplicationProtocol() + "\n >getTrafficClass "+ socket.getTrafficClass() +"\n >getHandshakeSession " + socket.getHandshakeSession() + "\n >getEnabledCipherSuites" + socket.getEnabledCipherSuites() + "\n >getKeepAlive " + socket.getKeepAlive() + "\n>getNeedClientAuth " + socket.getNeedClientAuth() + "\n >getSSLParameters " +socket.getSSLParameters() + "\n getSupportedCipherSuites>" +socket.getSupportedCipherSuites() + "~~~~~~~~~" );
	    	System.out.println("Press any key to send request..");
	    	System.in.read();
	    	out.println("GET / HTTP/1.1\nHost: " +hostname+":" + port +"\n\n");
	    	String returnMessage;
	    	
	    	while ((returnMessage = in.readLine()) != null){
	    		System.out.println(returnMessage);
	        	
	    	}
	 
	    

	    	

	    	socket.close();
	    	System.exit(0);

	    }
	}
}
