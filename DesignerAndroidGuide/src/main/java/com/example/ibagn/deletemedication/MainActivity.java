package com.example.ibagn.deletemedication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ListViewAdapter listviewadapter;
    List<Widget> widgets_list = new ArrayList<Widget>();

    Integer[] code;
    String[] names;
    String[] descriptions;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        code = new Integer[] {0,1,2,3,4,5,6,7,8,9,11,12,13};
        names = new String[] { getString(R.string.TEXT_VIEW), getString(R.string.EDIT_TEXT),getString(R.string.SPINNER),
                getString(R.string.TIME_PICKER),getString(R.string.DATE_PICKER),getString(R.string.BUTTON),
                getString(R.string.CHECKBOX), getString(R.string.RADIO_BUTTON), getString(R.string.SWITCH),getString(R.string.IMAGEVIEW),
                getString(R.string.PROGRESS_BAR),getString(R.string.SEEK_BAR),getString(R.string.NUMBER),getString(R.string.PASSWORD)};
        descriptions = new String[] { getString(R.string.TEXT_VIEW_D), getString(R.string.EDIT_TEXT_D),getString(R.string.SPINNER_D),
                getString(R.string.TIME_PICKER_D),getString(R.string.DATE_PICKER_D),getString(R.string.BUTTON_D),
                getString(R.string.CHECKBOX_D), getString(R.string.RADIO_BUTTON_D), getString(R.string.SWITCH_D),getString(R.string.IMAGEVIEW_D),
                getString(R.string.PROGRESS_BAR_D),getString(R.string.SEEK_BAR_D),getString(R.string.NUMBER_D),getString(R.string.PASSWORD_D)};

        images = new int[] { R.drawable.textview, R.drawable.edittext,
                R.drawable.spinner, R.drawable.timepicker,
                R.drawable.datepicker, R.drawable.button, R.drawable.checkbox,
                R.drawable.radiobutton, R.drawable.switch_img,R.drawable.imageview,R.drawable.seekbar,R.drawable.edittext,R.drawable.edittext};

        for (int i = 0; i < images.length-1; i++) {
            Widget widget = new Widget(code[i],names[i],images[i],descriptions[i]);

            widgets_list.add(widget);
        }
            //Set adapter
        list = (ListView) findViewById(R.id.listview);
        listviewadapter = new ListViewAdapter(this, R.layout.listview_item,
                widgets_list);
        list.setAdapter(listviewadapter);


        //set event on long click
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setTextFilterEnabled(true);

        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode,
                                                  int position, long id, boolean checked) {

                final int checkedCount = list.getCheckedItemCount();

                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class
                listviewadapter.toggleSelection(position);
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                SparseBooleanArray selected;
                ArrayList<Integer> widgets_selected;
                switch (item.getItemId()) {
                    case R.id.linear_horisontal:

                        selected = listviewadapter
                                .getSelectedIds();

                        widgets_selected=new ArrayList();
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Widget selecteditem = listviewadapter
                                        .getItem(selected.keyAt(i));
                                // add selected Widget to a list and transmit it to the next activity

                                widgets_selected.add(selecteditem.getCode());



                            }
                            Intent intent = new Intent(MainActivity.this, LinearActivity.class);
                            intent.putExtra("widgets_selected",widgets_selected );
                            intent.putExtra("layou_type",1);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                        //mode.finish();
                        return true;

                    case R.id.linear_vertical:

                                 selected = listviewadapter
                                .getSelectedIds();

                       widgets_selected=new ArrayList();
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Widget selecteditem = listviewadapter
                                        .getItem(selected.keyAt(i));
                                // add selected Widget to a list and transmit it to the next activity

                                widgets_selected.add(selecteditem.getCode());



                            }
                            Intent intent = new Intent(MainActivity.this, LinearActivity.class);
                            intent.putExtra("widgets_selected",widgets_selected );
                            intent.putExtra("layou_type",0 );
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                        //mode.finish();
                        return true;
                    case R.id.relative:

                        selected = listviewadapter
                                .getSelectedIds();

                        widgets_selected=new ArrayList();
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                Widget selecteditem = listviewadapter
                                        .getItem(selected.keyAt(i));
                                // add selected Widget to a list and transmit it to the next activity

                                widgets_selected.add(selecteditem.getCode());



                            }
                            Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
                            intent.putExtra("widgets_selected",widgets_selected );
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                listviewadapter.removeSelection();
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

}
