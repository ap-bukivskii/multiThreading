package edu.tolik.WN;

import java.io.RandomAccessFile;

public class Preparator extends Thread {
	Data data;
	String file;
	
	public Preparator(Data data, String file) {
		this.data = data;
		this.file = file;
	}
	
	public void run() {
		
		byte[] buf;
			
		System.out.println("Data is being prepared....");
		
		try {
			RandomAccessFile fs = new RandomAccessFile(file, "r");
			try {
				buf = new byte[(int)fs.length()];
				fs.read(buf);
			} finally {
				fs.close();
			}
		} catch (Exception ex) {
			buf = null;
		}
			
		synchronized (data) {
			data.set(buf);
			data.notifyAll();
		}
	}
}
