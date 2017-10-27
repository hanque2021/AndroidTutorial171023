package com.example.a.t25_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by a on 2017-10-27.
 */

public class BoxDrawingView extends View {
    ArrayList<Box> boxList = new ArrayList<>();
    Box currentBox;
    Paint boxPaint;
    Paint boxBackgroudPaint;

    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        boxPaint = new Paint();
        boxPaint.setColor(0x22ff0000);

        boxBackgroudPaint = new Paint();
        boxBackgroudPaint.setColor(0xffaaaaaa);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawPaint(boxBackgroudPaint);
        for(Box box : boxList){
            float left = Math.min(box.origin.x, box.current.x);
            float right = Math.max(box.origin.x, box.current.x);
            float top = Math.min(box.origin.y, box.current.y);
            float bottom = Math.max(box.origin.y, box.current.y);
            canvas.drawRect(left, top, right,bottom, boxPaint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        PointF curr = new PointF(event.getX(),event.getY());

        Log.d("pos", "x="+curr.x+" y="+curr.y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentBox = new Box(curr);
                boxList.add(currentBox);
                break;
            case MotionEvent.ACTION_UP:
                currentBox = null;
                break;
            case MotionEvent.ACTION_MOVE:
                if(currentBox!=null) {
                    currentBox.current = curr;
                    invalidate();

                }
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("box", "cancel");
                break;
        }
        return true;
    }
}
