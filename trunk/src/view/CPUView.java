package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CPUView extends View{
	Canvas canvas;
	Context c;
	Path pathCircle;
	//Bitmap bmp= Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
	float use;
	float total;
	Paint paint;
	Paint userpaint;
	Paint chart;
	Paint tpaint;
	public CPUView(Context context, AttributeSet attrs) throws Exception {
		super(context, attrs);
		paint= new Paint();
		paint.setColor(Color.GREEN);
		userpaint =new Paint();
		userpaint.setColor(Color.RED);
		chart=new Paint();
		tpaint =new Paint();
		//canvas= new Canvas(bmp);
	}
	
	public void set(float _use, float _total) {
		use = _use;
		total= _total;
		invalidate();
	}
	public int getpercent(){
		
	if(total!=0)return (int) ((use/total)*190)+1;
	else return 0;
	}
	protected void onDraw(Canvas canvas) {						
		
		//canvas.drawBitmap(bmp, 0, 0, null);		
		canvas.drawRect(10, 10,190, 20, paint);
		canvas.drawLine(10,10,190,10, userpaint);
		canvas.drawLine(10, 20,190,20, userpaint);
		canvas.drawLine(10, 10, 10, 20, userpaint);
		canvas.drawLine(190, 10,190, 20, userpaint);
		
//		canvas.drawRect(10, 10,getpercent(),20, userpaint);
//		pathCircle=new Path();
//		pathCircle.addCircle(90,40, 20,Direction.CW);
//		  chart.setColor(Color.YELLOW);//Set màu cho hình tròn
//		  chart.setShadowLayer(50, 0, +50, Color.YELLOW);//set bóng đổ
//		  chart.setStyle(Style.STROKE);//set phong cách cho hình, STROKE: Viền xuông, FILL: Đậm đặc
//          chart.setFlags(50);
		  
		  //		  tpaint.setColor(Color.RED);
//		  tpaint.setTextSize(20);//Set cỡ chữ
//		  tpaint.setStyle(Style.FILL);
//		  tpaint.setShadowLayer(5, 0, -2, Color.WHITE);
		  //Kẻ các đường hình học trên Canvas (Lớp khung trong suốt để vẽ đồ hoạ)
		//Vẽ đường hình học là đường tròn (circle), và mang các đặc tính style của cPaint
//		canvas.drawPath(pathCircle, chart);
//		canvas.drawTextOnPath(VIEW_LOG_TAG, pathCircle, 0, +20, tpaint);
		
		//canvas.drawCircle(90,40, 20, paint);
	  //  canvas.drawPath(pathCircle, userpaint);
		 
         RectF arcRect = new RectF(10,10,20,20);
             canvas.drawArc(arcRect,20,230,true,userpaint);

	}
	
	protected void onMeasure(int width, int height) {
		this.setMeasuredDimension(320, 70);
	}
	
	
	

}
