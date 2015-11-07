package com.example.ibagn.deletemedication;

/**
 * Created by gabi on 06.11.2015.
 */

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class Test extends Activity {

    LinearLayout contentnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentnView = new LinearLayout(this);

        // SET ORIENTATION TO VERTICAL
        contentnView.setOrientation(LinearLayout.VERTICAL);

        // SET CONTENT VIEW
        setContentView(contentnView);

        // GET LAYOUT FROM XML
        RelativeLayout relativeLayoutFromXml =  (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_relative, contentnView, false);
        // ADD LAYOUT FROM XML TO mainLayout
        contentnView.addView(relativeLayoutFromXml);

        // RELATIVE LAYOUT PROGRAMMATICALLY CREATED
        RelativeLayout relativeLayoutCreatedProgrammatically = this.createRelativeLayoutProgrammatically();

        // ADD LAYOUT TO mainLayout
        contentnView.addView(relativeLayoutCreatedProgrammatically);


        // RELATIVE LAYOUT WITH VIEWS
        RelativeLayout relativeLayoutWithView = this.withChildRelativeLayout();

        // ADD VIEWS IN RELATIVE LAYOUT AND ARRANGE
        arrangedChildView(relativeLayoutWithView);

        // ADD LAYOUT TO mainLayout
        contentnView.addView(relativeLayoutWithView);
    }

    /**
     * Create relative layout programmically
     * @return
     */
    RelativeLayout createRelativeLayoutProgrammatically(){

        RelativeLayout relativeLayout = new RelativeLayout(this);

        // CREATE PARAM FOR SIZE
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 100);

        // APPLY PARAM
        relativeLayout.setLayoutParams(params);

        // SET BACKGROUND COLOR
        relativeLayout.setBackgroundColor(Color.GREEN);

        return relativeLayout;

    }

    /**
     * RelativeLayout with child views
     * @return
     */
    RelativeLayout withChildRelativeLayout(){

        RelativeLayout relativeLayout = new RelativeLayout(this);

        // CREATE PARAM FOR SIZE
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT );

        // APPLY PARAM
        relativeLayout.setLayoutParams(params);

        // SET BACKGROUND COLOR
        relativeLayout.setBackgroundColor(Color.LTGRAY);

        return relativeLayout;
    }
    /**
     * Arranged child views
     */
    private void arrangedChildView(RelativeLayout relativeLayoutWithView){

        Button buttonA = new Button(this);
        Button buttonB = new Button(this);
        Button buttonC = new Button(this);
        Button buttonD = new Button(this);
        Button buttomE = new Button(this);

        EditText editText = new EditText(this);

        // SET TEXT
        buttonA.setText("BUTTON A");
        buttonB.setText("BUTTON B");
        buttonC.setText("BUTTON C");
        buttonD.setText("BUTTON D");
        buttomE.setText("BUTTON E");

        // SET ID. This is important
        buttonA.setId(R.id.i1);
        buttonB.setId(R.id.i2);
        buttonC.setId(R.id.i3);
        buttonD.setId(R.id.i4);
        buttomE.setId(R.id.i5);
        editText.setId(R.id.i6);


        // CREATE PARAM

        RelativeLayout.LayoutParams paramsA = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);


        RelativeLayout.LayoutParams paramsB = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        paramsB.addRule(RelativeLayout.RIGHT_OF, buttonA.getId());

        RelativeLayout.LayoutParams paramsC = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        paramsC.addRule(RelativeLayout.BELOW, buttonA.getId());

        RelativeLayout.LayoutParams paramsD = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        paramsD.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM );

        RelativeLayout.LayoutParams paramsE = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        paramsE.addRule(RelativeLayout.ABOVE, buttonD.getId());

        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        editTextParams.addRule(RelativeLayout.RIGHT_OF, buttomE.getId());
        editTextParams.addRule(RelativeLayout.ABOVE,buttonD.getId());

        // ADD CHILDREN VIEW

        relativeLayoutWithView.addView(buttonA, paramsA);
        relativeLayoutWithView.addView(buttonC, paramsC);
        relativeLayoutWithView.addView(buttonB, paramsB);
        relativeLayoutWithView.addView(buttonD,paramsD);
        relativeLayoutWithView.addView(buttomE, paramsE);
        relativeLayoutWithView.addView(editText, editTextParams);

    }
}