package Task.Pro;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomViewGroup extends LinearLayout{
     public CheckBox cb;
     public TextView text;
     public ImageView image;
	public CustomViewGroup(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		//gan giao dien trong listview cho class
	 LayoutInflater li=(LayoutInflater) this.getContext()
	                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 li.inflate(R.layout.listview, this, true);
	 
	 //lay ve cai view qua id
	 cb=(CheckBox) findViewById(R.id.checkBox1);
	 image=(ImageView) findViewById(R.id.imageviewappandpro);
	 text=(TextView) findViewById(R.id.textView1);
	 
	
	}

}
