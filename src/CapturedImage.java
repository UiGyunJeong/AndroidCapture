import java.io.IOException;

public class CapturedImage {

	private String makeName(boolean numbering, String shortName, String number){
		String fullName=null;				
		if(numbering == true){
			fullName = shortName+number;
		}else{
			fullName = shortName;
		}	
		return fullName;
	}
	
	private String makePath(String path, String fullName){
		String fullPath=null;
		fullPath = path+fullName;
		return fullPath;
	}
	
	private boolean captureImage(String fullPath, String fullName){
		String[] captureCmd = new String[3];
		String[] pullCmd = new String[4];
		
		captureCmd[0]="adb shell screencap -p /sdcard/";
		captureCmd[1]=fullName;
		captureCmd[2]=".png";
		
		pullCmd[0] = "adb pull /sdcard/";
		pullCmd[1] = fullName;
		pullCmd[2] = ".png";
		pullCmd[3] = " " + fullPath;
		pullCmd[4] = "'\'" + fullName;
		
		try {
			Process p = Runtime.getRuntime().exec(captureCmd);
			p = Runtime.getRuntime().exec(pullCmd);
			this.deleteImageFromPhone(p, fullName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
