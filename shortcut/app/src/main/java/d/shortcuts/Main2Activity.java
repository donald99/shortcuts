package d.shortcuts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.tv_show_info);

        if (getIntent() != null) {
            String string = getIntent().getStringExtra("info");
            textView.setText(string);
        }
    }
}
