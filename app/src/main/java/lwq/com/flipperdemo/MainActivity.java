package lwq.com.flipperdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_normal)
    Button btnNormal;
    @BindView(R.id.btn_custom)
    Button btnCustom;
    @BindView(R.id.btn1)
    Button btn1;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=this;
    }

    @OnClick({R.id.btn_normal, R.id.btn_custom,R.id.btn1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(mContext,Norma1Activity.class));
                break;
            case R.id.btn_custom:
                startActivity(new Intent(mContext, CustomFlipperActivity.class));
                break;
            case R.id.btn1:
                startActivity(new Intent(mContext, NormalFlipperActivity.class));
                break;
        }
    }
}
