package com.cheat.menu;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.IBinder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;
public class ESPOverlayService extends Service {
    private WindowManager wm;
    private SurfaceView surfaceView;
    private Paint paint;
    @Override
    public void onCreate() {
        super.onCreate();
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        surfaceView = new SurfaceView(this);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            android.graphics.PixelFormat.TRANSLUCENT
        );
        wm.addView(surfaceView, params);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        Toast.makeText(this, "ESP Overlay Started", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        if (surfaceView != null) wm.removeView(surfaceView);
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) { return null; }
}
