package edu.tolik.WN;

public class MyClass {
	public static void main(String[] args) {
		Data data = new Data();
		
		Processor pc = new Processor(data, "out.txt");
		pc.start();
		
		Preparator pr = new Preparator(data, "in.txt");
		pr.start();
	}
}
