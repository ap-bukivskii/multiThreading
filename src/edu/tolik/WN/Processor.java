package edu.tolik.WN;

import java.io.RandomAccessFile;

public class Processor extends Thread {
	Data data;
	String file;
	
	public Processor(Data data, String file) {
		this.data = data;
		this.file = file;
	}
	
	public void run() {
		System.out.println("Waiting for data...");
		
		synchronized (data) {
			try {
				data.wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		
		System.out.println("Got data. Processing it...");
		
		byte[] buf = data.get();
		
		for (int i = 0; i < buf.length; i++)
			buf[i]++;
		
		try {
			RandomAccessFile f = new RandomAccessFile(file, "rw");
			try {
				f.write(buf);
			} finally {
				f.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
