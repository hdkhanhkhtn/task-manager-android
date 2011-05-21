package Task.Pro;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;
public class Taskmanger extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView cpu=(TextView) findViewById(R.id.cpu);
        cpu.setText("40%");
        TextView memory=(TextView) findViewById(R.id.memory);
        memory.setText("50%");
        TextView network=(TextView) findViewById(R.id.network);
        network.setText("2 kbps");

        
        
        
        
        
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ApplicationManager.class);
        spec = tabHost.newTabSpec("application").setIndicator("App",res.getDrawable(R.drawable.tab_app)).setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, ServiceManager.class);
        spec = tabHost.newTabSpec("service").setIndicator("Service").setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, ChartDisplay.class);
        spec = tabHost.newTabSpec("char").setIndicator("Chart")
                      .setContent(intent);
        tabHost.addTab(spec);


        intent = new Intent().setClass(this, ProcessManager.class);
        spec = tabHost.newTabSpec("process").setIndicator("Process")
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}