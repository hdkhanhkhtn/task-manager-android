package Task.Pro;


import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ApplicationManager extends Activity{

	
	ArrayList<ListViewWork> array;
	ListAdapter arrayAdapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.application);
		
		refesh();

         }


	public void refesh() {
		ListViewWork listwork;
		Drawable icon = null;
		String name = null;
		
        array =new ArrayList<ListViewWork>();
        arrayAdapter= new ListApdapter(this, R.layout.listview, array);

        //tao mot list view cho danh sach application            
        final ListView list=(ListView) findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        
		final Button endTask = (Button) this.findViewById(R.id.button_end);
		
		final PackageManager pacma;
		final ActivityManager acma;
		final List<RunningTaskInfo> list_run_task;
		
		
		pacma = getPackageManager();
		acma = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		list_run_task = acma.getRunningTasks(30);
		
		
		
		for (int i = 0; i < list_run_task.size(); i++) {
			try {

				CharSequence c = pacma.getApplicationLabel(pacma.getApplicationInfo(
						list_run_task.get(i).baseActivity.getPackageName(),
						PackageManager.GET_META_DATA));

				name = c.toString();


				icon = pacma.getApplicationIcon(list_run_task.get(i).baseActivity
						.getPackageName());

				listwork = new ListViewWork(icon, name, false, list_run_task.get(i).id);
				listwork.setProcessName(list_run_task.get(i).baseActivity.getPackageName());

				listwork.setBaseActivity(list_run_task.get(i).baseActivity.getClassName());

			    array.add(listwork);
			    list.setAdapter(arrayAdapter);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
		}


		OnClickListener end= new OnClickListener() {
			
			public void onClick(View v) {
				
				for (int i = 0; i <array.size(); i++) {
					if (array.get(i).isChecked()) {
						if (array.get(i).getProcessName()
								.compareTo("app.tab") == 0) {
							System.exit(1);
					} else {
							acma.killBackgroundProcesses(array.get(i)
									.getProcessName());
							//activityMan.restartPackage(listItem.get(i).getProcessName());
							Log.d("kill",array.get(i).getProcessName());
						}
						array.remove(i);
					}

				}
				list.setAdapter(arrayAdapter);
			}
		};
		endTask.setOnClickListener(end);

	}//end of function
}//end of class

