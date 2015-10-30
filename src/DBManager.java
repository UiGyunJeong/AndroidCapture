import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DBManager {

	private String DBName;
	private String name;
	private int number;
	private String location;
	
	public DBManager(String location, String name){
		try {
			OutputStream output = new FileOutputStream("file");
			InputStream input = new FileInputStream("file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void read(){
		
	}
	
	private void write(){
		
	}
	
	private void create(){
		
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
