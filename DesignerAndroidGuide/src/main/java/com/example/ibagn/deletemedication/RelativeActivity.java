package com.example.ibagn.deletemedication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RelativeActivity extends AppCompatActivity {
    static int FLAG_ITEM_CLICKED=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        getSupportActionBar().setSubtitle("Relative Layout");
        Intent intent = getIntent();
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.base);
        ArrayList<Integer> list = (ArrayList<Integer>) intent.getIntegerArrayListExtra("widgets_selected");

        ArrayList<View> widgets = new ArrayList<View>();
        //final ArrayList<Position> positions= new ArrayList<Position>();

        for (int i = 0; i < list.size(); i++) {
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
                    tp.setMinimumWidth(40);
                    tp.setMinimumHeight(40);
                    widgets.add(tp);
                    break;
                case (4):
                    DatePicker dp = new DatePicker(this);
                    dp.setMinimumWidth(40);
                    dp.setMinimumHeight(40);
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
        //Pentru un element selectionat
        RelativeLayout.LayoutParams relativeParams;
        View v;

        if (widgets.size() == 1) {


            widgets.get(0).setId(R.id.i1);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

            v = widgets.get(0);
            widgets.get(0).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(0);
                    v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            rl.addView(v, relativeParams);


        }
//Pentru 2 elemente selectionate
        if (widgets.size() == 2) {
            widgets.get(0).setId(R.id.i1);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);


            v = widgets.get(0);
            widgets.get(0).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(0);
                    v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(1).setId(R.id.i2);


            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            v = widgets.get(1);
            v.setLayoutParams(relativeParams);
            widgets.get(1).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(1);
                    v.setBackgroundColor(Color.MAGENTA);
                    return false;
                }


            });
            rl.addView(v);

        }
        //Pentru trei elemente selectionate
        if (widgets.size() == 3) {
            widgets.get(0).setId(R.id.i1);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);


            v = widgets.get(0);
            widgets.get(0).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(0);
                    v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(1).setId(R.id.i2);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.BELOW, R.id.i1);
            v = widgets.get(1);
            widgets.get(1).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(1);
                    v.setBackgroundColor(Color.MAGENTA);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(2).setId(R.id.i3);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.BELOW, R.id.i1);
            v = widgets.get(2);
            widgets.get(2).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    v.setBackgroundColor(Color.BLUE);
                    return false;
                }


            });
            rl.addView(v, relativeParams);

        }
        //Pentru 4 elemente
        if (widgets.size() == 4) {
            widgets.get(0).setId(R.id.i1);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);


            v = widgets.get(0);
            widgets.get(0).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(0);
                    v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(1).setId(R.id.i2);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

            v = widgets.get(1);
            widgets.get(1).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(1);
                   // v.setBackgroundColor(Color.MAGENTA);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(2).setId(R.id.i3);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

            v = widgets.get(2);
            widgets.get(2).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                   // v.setBackgroundColor(Color.BLUE);
                    return false;
                }


            });
            rl.addView(v, relativeParams);

            widgets.get(3).setId(R.id.i4);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

            v = widgets.get(3);
            widgets.get(3).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    v.setBackgroundColor(Color.BLUE);

                    return false;
                }


            });
            rl.addView(v, relativeParams);

        }

        //Pentru 5 elemente
        if (widgets.size() >= 5) {
            Toast.makeText(this.getBaseContext(), "Maximum 5 elements will be displayed, in the orderyou selected them.",
                    Toast.LENGTH_SHORT).show();
            widgets.get(0).setId(R.id.i1);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);


            v = widgets.get(0);
            widgets.get(0).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(0);
                   // v.setBackgroundColor(Color.YELLOW);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(1).setId(R.id.i2);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

            v = widgets.get(1);
            widgets.get(1).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Position p = new Position();
                    p.setVerb(1);
                 //   v.setBackgroundColor(Color.MAGENTA);
                    return false;
                }


            });
            rl.addView(v, relativeParams);
            widgets.get(2).setId(R.id.i3);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

            v = widgets.get(2);
            widgets.get(2).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                 //   v.setBackgroundColor(Color.BLUE);
                    return false;
                }


            });
            rl.addView(v, relativeParams);

            widgets.get(3).setId(R.id.i4);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

            v = widgets.get(3);
            widgets.get(3).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                 //   v.setBackgroundColor(Color.BLUE);

                    return false;
                }


            });
            rl.addView(v, relativeParams);

            widgets.get(4).setId(R.id.i5);
            relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);


            v = widgets.get(4);
            widgets.get(4).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                  //  v.setBackgroundColor(Color.BLUE);

                    return false;
                }


            });
            rl.addView(v, relativeParams);

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_relative, menu);
        onMenuOpened(R.menu.menu_relative, menu);
        //menu.addSubMenu("Relative to One").add("right of");
        // in functie de butonul apasat  menu.getItem(0).setEnabled(false);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        // code here to show dialog

        Intent i = new Intent( RelativeActivity.this, MainActivity.class);
        startActivity(i);
          // optional depending on your needs
    }
    }


