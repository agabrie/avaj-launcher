package avaj.sim.printyclass;
import java.io.FileWriter;
import java.io.File;
class PrintyClass{
	public static File file;
	public static FileWriter pw;
	// public PrintyClass(){
	// 	setFile("simulation.txt");
	// }
	// public PrintyClass(String fileName){
	// 	setFile(fileName);
	// 	try {
			
	// 		pw = new PrintWriter(new FileWriter(file));
	// 	} catch (Exception e) {
	// 		//TODO: handle exception
	// 	}
	// }
	// public PrintyClass(File file){
	// 	setFile(file);
	// 	try {
			
	// 		pw = new PrintWriter(new FileWriter(file));
	// 	} catch (Exception e) {
	// 		//TODO: handle exception
	// 	}
	// }
	public static File getFile(){
		return (file);
	}
	public static void setFile(String fileName){
		try{
			file = new File(fileName);
			try {
				pw = /*new PrintWriter(*/new FileWriter(file)/*)*/;
			} catch (Exception e) {
					//TODO: handle exception
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
					//TODO: handle exception
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

			//TODO: handle exception
		}
	}
	public static void closePrintWriter(){
		if(file.exists()){
			try {
				
				pw.close();
			} catch (Exception e) {
			System.out.println(e);
				
				//TODO: handle exception
			}
		}
	}
}