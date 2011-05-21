package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class Ball extends View{


    private Paint mPaints2;
    private Paint mPaints1;
    private RectF mBigOval;
    private float mStart, mSweep;
    private int mBigIndex;

    public Ball(Context context) {
        super(context);

        mPaints1 = new Paint();
        mPaints2 = new Paint();
        mPaints1.setAntiAlias(true);
        mPaints1.setStyle(Paint.Style.FILL);

        mPaints2 = new Paint(mPaints1);
        mPaints2.setColor(Color.BLUE);
        mBigOval = new RectF(40, 10, 280, 250);
    }

    private void drawArcs(Canvas canvas, RectF oval, boolean useCenter,
            Paint paint) {
        canvas.drawArc(oval, mStart, mSweep, useCenter, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        drawArcs(canvas, mBigOval, true, mPaints2);
        mSweep += 2;
        if (mSweep > 360) {
            mStart += 10;
            if (mStart >= 360) {
                mStart -= 360;
            }
            mBigIndex = (mBigIndex + 1);
        }
        invalidate();
    }
}
