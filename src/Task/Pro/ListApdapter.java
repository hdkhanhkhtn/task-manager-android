package Task.Pro;


import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ListApdapter extends ArrayAdapter <ListViewWork>{
     ArrayList<ListViewWork> array;
     int resource;
     Context context;
     
	public ListApdapter(Context context, int textViewResourceId,
			ArrayList<ListViewWork> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	      this.context=context;
	      resource = textViewResourceId;
	      array=objects;	
	}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View workView = convertView;
        
        if (workView == null) {
            workView = new CustomViewGroup(getContext());
        }
        
        //Lấy về đối tượng Work hiện tại
        final ListViewWork work = array.get(position);

        if (work != null) {
            TextView text = ((CustomViewGroup) workView).text;
            CheckBox checkWork = ((CustomViewGroup) workView).cb;
            ImageView image =((CustomViewGroup) workView).image;
            //Set sự kiện khi đánh dấu vào checkbox trên list
            checkWork.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                        boolean isChecked) {
                    work.setChecked(isChecked);                    
                }                
            });
            
            //Lấy về nội dung cho TextView và CheckBox dựa vào đối tượng Work hiện tại
            text.setText(work.getContent());
            image.setImageDrawable(work.getIcon());
            checkWork.setChecked(work.isChecked());
            
        }        
        return workView;
    }    
}
