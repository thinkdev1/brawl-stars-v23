package com.nosteam.nostbrawl.Network;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import com.nosteam.nostbrawl.CsvReader.CsvReader;
import com.nosteam.nostbrawl.Sessions.ClientSession;

public class Server {

	public int serverPort;
	public CsvReader CsvNode;
	public void config(int port, CsvReader CsvNode) {
		serverPort = port;
		this.CsvNode = CsvNode;
	}

	public void Listen() {
		try {

			ServerSocket server = new ServerSocket(serverPort);

			System.out.println("[Status] Server listening on port: " + serverPort + ". Let's play Nost Brawl!");

			while (server.isBound()) {
				Socket client = server.accept();
				new Thread(() -> {
					System.out.println("[Connection] New connection from ip: " + client.getRemoteSocketAddress());
					new ClientSession(client, this.CsvNode).createSession();
				}).start();
				
			}
		} catch (IOException e) {
			System.out.println("[Error] Failed in creating the socket server: " + e.getMessage());
		}
	}
}
