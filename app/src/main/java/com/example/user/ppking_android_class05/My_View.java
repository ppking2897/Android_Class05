package com.example.user.ppking_android_class05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedList;

public class My_View extends View {
    private LinkedList<LinkedList<HashMap<String,Float>>> lines;

    public My_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);
        lines = new LinkedList<>();
        Log.v("brad", "MyView()");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("brad", "onDraw()");
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(4);
        //canvas.drawCircle(100,100,40, paint);

        for (LinkedList<HashMap<String,Float>> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                float x0 = p0.get("x"), y0 = p0.get("y");
                float x1 = p1.get("x"), y1 = p1.get("y");
                canvas.drawLine(x0, y0, x1, y1, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX(), ey = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            touchDownTask(ex, ey);
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            touchMoveTask(ex, ey);
        }
        return true;
    }
    private void touchDownTask(float ex, float ey){
        LinkedList<HashMap<String,Float>> line = new LinkedList<>();
        HashMap<String,Float> point = new HashMap<>();
        point.put("x", ex); point.put("y", ey);
        line.add(point);
        lines.add(line);
        invalidate();   // Java => repaint()
    }
    private void touchMoveTask(float ex, float ey){
        HashMap<String,Float> point = new HashMap<>();
        point.put("x", ex); point.put("y", ey);
        lines.getLast().add(point);
        invalidate();
    }

    void clear(){
        lines.clear();
        invalidate();
    }
}
