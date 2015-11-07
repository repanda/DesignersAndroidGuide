package com.example.ibagn.deletemedication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        Intent intent = getIntent();
        int layot_type = intent.getIntExtra("layou_type", 0);
        ScrollView sv =(ScrollView)findViewById(R.id.scrollView_vertical);
        HorizontalScrollView hv =(HorizontalScrollView)findViewById(R.id.scrollView_horisontal);

        LinearLayout linearLayout = new LinearLayout(this);


        if (layot_type == 1) {
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            hv.addView(linearLayout);
            getSupportActionBar().setSubtitle("Linear Layout - Horisontal");
        }else{
            if (layot_type == 0) {
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                sv.addView(linearLayout);
                getSupportActionBar().setSubtitle("Linear Layout - Vertical");
            }
        }
        ArrayList<Integer> list = (ArrayList<Integer>) intent.getIntegerArrayListExtra("widgets_selected");

        ArrayList<View> widgets = new ArrayList<View>();


        for (int i = 0; i < list.size(); i++){
            switch (list.get(i)) {
                case (0):
                    TextView tv = new TextView(this);
                    tv.setText("TextView");
                    tv.setLongClickable(true);
                    widgets.add(tv);

                    break;
                case (1):
                    EditText ed = new EditText(this);
                    ed.setHint("Type here ");
                    ed.setLongClickable(true);
                    widgets.add(ed);
                    break;
                case (2):
                    Spinner spinner = new Spinner(this);
                    spinner.setLongClickable(true);
                    List<String> l = new ArrayList<String>();
                    l.add("element 1");
                    l.add("element 2");
                    l.add("element 3");
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, l);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(dataAdapter);
                    widgets.add(spinner);
                    break;
                case (3):
                    TimePicker tp = new TimePicker(this);
                    tp.setMinimumWidth(80);
                    tp.setMinimumHeight(80);
                    widgets.add(tp);
                    break;
                case (4):
                    DatePicker dp = new DatePicker(this);
                    dp.setMinimumWidth(80);
                    dp.setMinimumHeight(80);
                    widgets.add(dp);
                    break;
                case (5):
                    Button button = new Button(this);
                    button.setText("Click me !");
                    widgets.add(button);
                    break;
                case (6):
                    CheckBox checkBox = new CheckBox(this);
                    widgets.add(checkBox);
                    break;
                case (7):
                    RadioButton radioButton = new RadioButton(this);
                    widgets.add(radioButton);
                    break;
                case (8):
                    Switch sw = new Switch(this);
                    widgets.add(sw);
                    break;
                case (9):
                    ImageView imageView = new ImageView(this);
                    imageView.setImageResource(R.drawable.imageview);
                    widgets.add(imageView);
                    break;
                case (10):
                    ProgressBar progressBar = new ProgressBar(this);
                    progressBar.setProgress(30);
                    widgets.add(progressBar);
                    break;
                case (11):
                    SeekBar seekBar = new SeekBar(this);
                    widgets.add(seekBar);
                    break;
                case (12):
                    EditText ed3 = new EditText(this);
                    ed3.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
                    ed3.setLongClickable(true);
                    widgets.add(ed3);
                case (13):
                    EditText ed2 = new EditText(this);
                    ed2.setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
                    ed2.setHint("Type here ");
                    ed2.setLongClickable(true);
                    widgets.add(ed2);
                    break;
                default:
                    break;


            }
    }

        LinearLayout.LayoutParams linearParams;
        View v;
        for(int i=0;i<list.size();i++) {

           linearParams = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


            v = widgets.get(i);
            widgets.get(i).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                   // v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            linearLayout.addView(v, linearParams);
        }

    }
    @Override
    public void onBackPressed()
    {
        // code here to show dialog

        Intent i = new Intent( LinearActivity.this, MainActivity.class);
        startActivity(i);
        // optional depending on your needs
    }

}
