package lwq.com.flipperdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NormalFlipperActivity extends AppCompatActivity implements View.OnTouchListener {


    @BindView(R.id.flipper)
    ViewFlipper flipper;
    private GestureDetector mDetector;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_flipper);
        ButterKnife.bind(this);
        context = this;

        flipper.setOnTouchListener(this);
        mDetector = new GestureDetector(context, new simpleGestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

        //不知道为什么，不加上onDown函数的话，onFling就不会响应，真是奇怪
        @Override
        public boolean onDown(MotionEvent e) {
            Toast.makeText(context, "ondown", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // Fling left
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                flipper.showNext();
                Toast.makeText(context, "Fling Left", Toast.LENGTH_SHORT).show();
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                // Fling right
                flipper.showPrevious();
                Toast.makeText(context, "Fling Right", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }
}
