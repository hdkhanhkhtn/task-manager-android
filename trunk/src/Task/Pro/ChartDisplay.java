package Task.Pro;

import java.io.InputStream;

import view.CPUView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ChartDisplay extends Activity{
	CPUView cpuview;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thunghiemchart);
		TextView x=(TextView) findViewById(R.id.memorythunghiem);
        x.setText(getCPUinfo());
		
		
		
	}
	
	private String getMemoryInfo(){
        ProcessBuilder cmd;
        String result = new String();
        try{
            String[] args = {"/system/bin/cat", "/proc/meminfo "};
            cmd = new ProcessBuilder(args);
            java.lang.Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while(in.read(re) != -1){
                result = result + new String(re);
            }
        in.close();
        } catch(Exception ex){
        ex.printStackTrace();
        }
        return result;
    }
	
	private String getCPUinfo(){
        ProcessBuilder cmd;
        String result="";
        try{
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            cmd = new ProcessBuilder(args);
            java.lang.Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while(in.read(re) != -1){
                result = result + new String(re);
            }
            in.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
