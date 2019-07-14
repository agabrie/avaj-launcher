package com.avaj.misc;

// import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

public class PrintyClass{
	public static File file;
	public static FileWriter pw;

	public static File getFile(){
		return (file);
	}

	public static void setFile(String fileName){
		try{
			file = new File(fileName);
			try {
				pw = /*new PrintWriter(*/new FileWriter(file)/*)*/;
			} catch (Exception e) {
					System.out.println(e);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void setFile(File fileA){
		try{
			file = fileA;
			try {
				pw = /*new PrintWriter(*/new FileWriter(file)/*)*/;
			} catch (Exception e) {
					System.out.println(e);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void writeToFile(String s){
		try {
			pw.write(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void closePrintWriter(){
		if(file.exists()){
			try {
				pw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

































/**************************************** AGABRIE ****************************************/