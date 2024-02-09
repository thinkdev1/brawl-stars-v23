package com.nosteam.nostbrawl;

import com.nosteam.nostbrawl.Network.Server;
import com.nosteam.nostbrawl.CsvReader.CsvReader;

public class Main {
	public static void main(String[] args) {
	    System.out.println("[Status] Starting server...");
		Server server = new Server();
		CsvReader CsvNode = new CsvReader();
		CsvNode.init("Assets/");
		server.config(9339, CsvNode);
		System.out.println("[Status] Server version: ALPHA");
		server.Listen();
	}
}
