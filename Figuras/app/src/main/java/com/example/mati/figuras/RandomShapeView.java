package com.example.mati.figuras;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class RandomShapeView extends View {
    private Integer[] mBackgrounds =
            { Color.CYAN, Color.GRAY, Color.LTGRAY,Color.MAGENTA, Color.YELLOW, Color.WHITE };
    private Paint[] mForegrounds =
            { makePaint(Color.BLACK), makePaint(Color.BLUE),makePaint(Color.GREEN), makePaint(Color.RED)};
    private String mMessage = "Android";

    public RandomShapeView(Context context) {
        super(context);
    }
    public RandomShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(UtilsRandom.randomElement(mBackgrounds));
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int avgShapeWidth = viewWidth/5;
        for(int i=0; i<20; i++) {
            drawRandomCircle(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomRect(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomText(canvas, viewWidth, viewHeight, avgShapeWidth);
        }
    }
    private Paint makePaint(int color) {
        Paint p = new Paint();
        p.setColor(color);
        return(p);
    }
    private Bitmap makeBitmap(int bitmapId) {
        return(BitmapFactory.decodeResource(getResources(), bitmapId));
    }

    private void drawRandomCircle(Canvas canvas, int viewWidth,
                                  int viewHeight, int avgShapeWidth) {
        float x = UtilsRandom.randomFloat(viewWidth);
        float y = UtilsRandom.randomFloat(viewHeight);
        float radius = UtilsRandom.randomFloat(avgShapeWidth/2);
        Paint circleColor = UtilsRandom.randomElement(mForegrounds);
        canvas.drawCircle(x, y, radius, circleColor);
    }

    private void drawRandomRect(Canvas canvas, int viewWidth,
                                int viewHeight, int avgShapeWidth) {
        float left = UtilsRandom.randomFloat(viewWidth);
        float top = UtilsRandom.randomFloat(viewHeight);
        float width = UtilsRandom.randomFloat(avgShapeWidth);
        float right = left + width;
        float bottom = top + width;
        Paint squareColor = UtilsRandom.randomElement(mForegrounds);
        canvas.drawRect(left, top, right, bottom, squareColor);
    }

    private void drawRandomText(Canvas canvas, int viewWidth,
                                int viewHeight, int avgShapeWidth) {
        float x = UtilsRandom.randomFloat(viewWidth);
        float y = UtilsRandom.randomFloat(viewHeight);
        float textSize = UtilsRandom.randomFloat(avgShapeWidth);
        Paint textPaint = UtilsRandom.randomElement(mForegrounds);
        textPaint.setTextSize(textSize);
        canvas.drawText(mMessage, x, y, textPaint);
    }
}
