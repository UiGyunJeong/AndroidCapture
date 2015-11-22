import java.io.File;


public class ManageData {
	
	private String dbName;
	private String name;
	private int number;
	private String location;
	
	public ManageData(){
		//DB파일이 없으면 Default로 만들고, 있으면 내용 확인하기
		
	}
	
	private void makeDB(String location, String dbName){
		File db = new File(location + dbName);
		
	}
	
	private void write(){
		
	}
	
	private void read(){
		
	}

}
