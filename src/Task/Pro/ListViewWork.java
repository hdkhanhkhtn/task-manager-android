package Task.Pro;

import android.graphics.drawable.Drawable;

public class ListViewWork {
  private String text;
  private boolean isChecked;
  private Drawable icon;  
  
  public ListViewWork(String text1){
	  this.text=text1;
	  this.isChecked=false;
  }
  public ListViewWork(Drawable icon,String name,boolean checked,int pid){
		this.icon= icon;
		this.text = name;
		this.isChecked = checked;
		this.pid = pid;
	}
  public String getContent(){
	  return this.text;
  }
  public void settext(String name){
	  text=name;
  }
  
  //set gia tri cua Checkbox
  public void setChecked(boolean isChecked1){
	  this.isChecked=isChecked1;
  }
  public boolean isChecked(){
	  return this.isChecked;
  }
  //them

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}//end


	public Drawable getIcon() {
		return icon;
	}//end
	
	private String processName;	
	private int pid;			
	private String baseActivity;	


	
	//function to set user id of application
	public void setPid(int pId){
		this.pid = pId;
	}//end
	
	//function to get user Id of application
	public int getPid(){
		return this.pid;
	}//end

	// function to set process name / package name of application
	public void setProcessName(String processName) {
		this.processName = processName;
	}//end

	// function to get process name / package name of application
	public String getProcessName() {
		return processName;
	}//end
	
	// function to set Image/Icon for application 

	
	// function to set base Activity's name of application
	public void setBaseActivity(String baseActivity) {
		this.baseActivity = baseActivity;
	}//end
	
	//function to get base Activity's name of application
	public String getBaseActivity() {
		return baseActivity;
	}//end

  
  
}
