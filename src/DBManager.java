import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class DBManager {

	private String DBName;
	private String name;
	private int number;
	private String location;
	
	private OutputStream output = null;
	private InputStream input = null;
	private DataOutputStream doutput = null;
	private DataInputStream dinput = null;
	
	public DBManager(String location, String name){
		try {
			output = new FileOutputStream("db.txt");
			input = new FileInputStream("db.txt");
			doutput = new DataOutputStream(output);
			dinput = new DataInputStream(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String readLine(){//read just one line
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
			readLine();//move cursor to nextline
			break;
		default : 
			break;
		}
		return readLine();
	}
		
	private void write(String name, String number){
		try {
			doutput.writeUTF(name + "/n" + number + "/n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void create(){
		
	}
	
	private void closeStream(){
		
	}

	public String getDBName() {
		return DBName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
