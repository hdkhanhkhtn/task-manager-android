package Task.Pro;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ProcessManager extends Activity{
	ArrayList<ListViewWork> array;
	ListAdapter arrayAdapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.process);
        array =new ArrayList<ListViewWork>();
        arrayAdapter= new ListApdapter(this, R.layout.listview, array);
        
        final ListView list=(ListView) findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        
         String []text = {"Background","PowerAMP","Setting","Google voice","SystemPanel"};
         for(int i=0;i<text.length;i++){
         ListViewWork lvw=new ListViewWork(text[i]);
         array.add(0,lvw);
         list.setAdapter(arrayAdapter);
         }
		
		
		
	}

}
