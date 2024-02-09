package com.nosteam.nostbrawl.Sessions;

import java.io.*;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.nosteam.nostbrawl.CsvReader.CsvReader;
import com.nosteam.nostbrawl.Sessions.PlayerSession;
import com.nosteam.nostbrawl.Messaging.LogicMessageFactory;

public class ClientSession {

	public PlayerSession player;
	public LogicMessageFactory createMessageByType;
	public DataInputStream reader;
	public DataOutputStream writer;
	public Socket client;

	public ClientSession(Socket socket, CsvReader CsvNode) {
		this.client = socket;
		this.player = new PlayerSession(CsvNode);
		this.createMessageByType = new LogicMessageFactory(this.player);
		try {

			this.reader = new DataInputStream(this.client.getInputStream());
			this.writer = new DataOutputStream(this.client.getOutputStream());

		} catch (IOException e) {
			System.out.println("[Error] Failed to connect from: " + client.getRemoteSocketAddress());
		}
	}
	public void createSession() {


		String peername = client.getRemoteSocketAddress().toString();


		byte[] header, payload;
		int type, length;
		while (true) {
			header = new byte[7];
			try {
				this.reader.read(header);
			} catch (IOException e) {
				break;
			}
			type = (((header[0] & 0xFF) << 8) | (header[1] & 0xFF));
			length = (((header[2] & 0xFF) << 16) | ((header[3] & 0xFF) << 8) | (header[4] & 0xFF));
			payload = new byte[length];
			try {
				this.reader.read(payload);
			} catch (IOException e) {
				break;
			}
			if (type == 0) {
				break;
			}
			this.createMessageByType.process(type, payload, this.writer);
		}
		try {
			this.reader.close();
			this.writer.close();
			this.client.close();
		} catch (IOException e) {
		}
		System.out.println("[Connection] " + peername + " disconnected");
	}
}