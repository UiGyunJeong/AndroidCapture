import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class DBManager {

	private String DBName = "db.txt";
	private String fileName;
	private int number;
	private String location;
	private boolean isNumberingUse;
	
	private OutputStream output = null;
	private InputStream input = null;
	private DataOutputStream doutput = null;
	private DataInputStream dinput = null;
	
	public DBManager(String location, String name){
		createFile();
		try {
			createStream();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private String readOneLine(){//read just one line
		Scanner scanner = new Scanner(dinput);
		return scanner.nextLine();
	}
	
	private String read(String what){
		try {
			dinput.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(what){
		case "name" :
			break;
		case "number" : 
			readOneLine();//move cursor to nextline
			break;
		case "isNumberUse" :
			readOneLine();
			readOneLine();
		default : 
			break;
		}
		return readOneLine();
	}
		
	private void write(String name, String number, boolean isNumberingUse){
		try {
			doutput.writeUTF(name + "/n" + number + "/n" + isNumberingUse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createFile(){
		new File(DBName);
	}
	
	private void createStream() throws FileNotFoundException{
		output = new FileOutputStream(DBName);
		input = new FileInputStream(DBName);
		doutput = new DataOutputStream(output);
		dinput = new DataInputStream(input);
	}
	
	private void closeStream() throws IOException{
		dinput.close();
		doutput.close();
		input.close();
		output.close();
		
	}	
}
