import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapturedImage {
	
	private String fullName;
	private String fullPath;
	
	public CapturedImage(boolean numbering, String shortName, String number, String path){
		this.fullName = this.makeName(numbering, shortName, number);
		this.fullPath= this.makePath(path, this.fullName);
		System.out.println(this.fullPath);
		this.captureImage(this.fullPath, this.fullName);
	}

	private String makeName(boolean numbering, String shortName, String number){
		String fullName=null;				
		if(numbering == true){
			fullName = shortName+number;
		}else{
			fullName = shortName;
		}
		fullName = fullName+".png";
		return fullName;
	}
	
	private String makePath(String path, String fullName){
		String fullPath=null;
		fullPath = path+fullName+"\\";
		return fullPath;
	}
	
	private boolean captureImage(String fullPath, String fullName){
		String[] captureCmd = new String[3];
		String[] pullCmd = new String[3];
		
		captureCmd[0]=System.getProperty("user.dir") + "\\adb\\adb.exe shell";
		captureCmd[1]="screencap -p /sdcard/";
		captureCmd[2]=fullName;
		
		pullCmd[0] = "adb pull /sdcard/";
		pullCmd[1] = fullName;
		pullCmd[2] = " " + fullPath;
		
		System.out.println(captureCmd[0]);
		
		Process process = null;
		
		try {
			process = Runtime.getRuntime().exec("adb shell screencap -p /sdcard/abc.png");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			System.out.println(buffer.readLine());
			
			Runtime.getRuntime().exec("adb pull /sdcard/abc.png c:\\abc.png");
			
			System.out.println(buffer.readLine());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ProcessBuilder proc = new ProcessBuilder(captureCmd[0], captureCmd[1], captureCmd[2]);
		proc.command(pullCmd);
		//this.deleteImageFromPhone(p, fullName);
		return true;
	}
	
	private boolean deleteImageFromPhone(Process p, String fullName){
		String[] deleteCmd = new String[3];
		deleteCmd[0] = "rm /sdcard/";
		deleteCmd[1] = fullName;
		deleteCmd[2] = ".png";
		
		try {
			p = Runtime.getRuntime().exec(deleteCmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private void showImage(){
		
	}
}
