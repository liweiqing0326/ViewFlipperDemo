package lwq.com.flipperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Norma1Activity extends AppCompatActivity {

    @BindView(R.id.flipper)
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_norma1);
        ButterKnife.bind(this);
        flipper.startFlipping();
    }
}
