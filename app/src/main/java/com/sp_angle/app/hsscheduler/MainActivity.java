package com.sp_angle.app.hsscheduler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable{

    Bundle thisInstance;

    SharedPreferences schedule;
    SharedPreferences.Editor editor;
    String textViewKey;

    private TextView mTextMessage;
    TextView textView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_taskList:
                    mTextMessage.setText(R.string.title_taskList);
                    return true;
                case R.id.navigation_event:
                    mTextMessage.setText(R.string.title_event);
                    return true;
                case R.id.navigation_taskAdd:
                    mTextMessage.setText(R.string.title_taskAdd);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisInstance=savedInstanceState;
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        saveSchedule();
        loadSchedule();
    }

    public void setSubject(){
        Intent intent = new Intent();
        intent.setClassName("com.sp_angle.app.hsscheduler","com.sp_angle.app.hsscheduler.SelectSubject");
        startActivityForResult(intent,1);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent intent){

        super.onActivityResult(requestCode,resultCode,intent);
        String subject=intent.getStringExtra("Subject");
        if(subject!=null) {
            changeSubject(subject);
        }
    }

    public void saveSchedule(){
         schedule = getSharedPreferences("schedule",MODE_PRIVATE);
         editor = schedule.edit();
    }

    public void loadSchedule(){
        String coordinateSchedule[] = {"mon_1","mon_2","mon_3","mon_4","mon_5","mon_6","mon_0"
                ,"tue_1","tue_2","tue_3","tue_4","tue_5","tue_6","tue_0"
                ,"wed_1","wed_2","wed_3","wed_4","wed_5","wed_6","wed_0"
                ,"thu_1","thu_2","thu_3","thu_4","thu_5","thu_6","thu_0"
                ,"fri_1","fri_2","fri_3","fri_4","fri_5","fri_6","fri_0"
                ,"sat_1","sat_2","sat_3","sat_4","sat_5","sat_6","sat_0"};
        int cordinateSchedleTextId[]= {R.id.mon_1,R.id.mon_2,R.id.mon_3,R.id.mon_4,R.id.mon_5,R.id.mon_6,R.id.mon_0
                ,R.id.tue_1,R.id.tue_2,R.id.tue_3,R.id.tue_4,R.id.tue_5,R.id.tue_6,R.id.tue_0
                ,R.id.thu_1,R.id.thu_2,R.id.thu_3,R.id.thu_4,R.id.thu_5,R.id.thu_6,R.id.thu_0
                ,R.id.wed_1,R.id.wed_2,R.id.wed_3,R.id.wed_4,R.id.wed_5,R.id.wed_6,R.id.wed_0
                ,R.id.fri_1,R.id.fri_2,R.id.fri_3,R.id.fri_4,R.id.fri_5,R.id.fri_6,R.id.fri_0
                ,R.id.sat_1,R.id.sat_2,R.id.sat_3,R.id.sat_4,R.id.sat_5,R.id.sat_6,R.id.sat_0};

        for(int i=0;i<42;i ++){
            String str=schedule.getString(coordinateSchedule[i],"");
            TextView tv = (TextView)findViewById(cordinateSchedleTextId[i]);
            tv.setText(str);
        }

    }

    public void saveSchedule(String subject){
        editor.putString(textViewKey,subject);
        editor.commit();
    }

    public void changeSubject(String subject){
        switch (subject){
            case "genbun":
                textView.setText(R.string.genbun);
                saveSchedule(getResources().getString(R.string.genbun));
                break;
            case "koten":
                textView.setText(getResources().getString(R.string.koten));
                saveSchedule(subject);
                break;
            case "suu1":
                textView.setText(R.string.suu1);
                saveSchedule(getResources().getString(R.string.suu1));
                break;
            case "suuA":
                textView.setText(R.string.suuA);
                saveSchedule(getResources().getString(R.string.suuA));
                break;
            case "eihyou1":
                textView.setText(R.string.eihyou1);
                saveSchedule(getResources().getString(R.string.eihyou1));
                break;
            case "komyuei1":
                textView.setText(R.string.komyuei1);
                saveSchedule(getResources().getString(R.string.komyuei1));
                break;
            case "tiri":
                textView.setText(R.string.tiri);
                saveSchedule(getResources().getString(R.string.tiri));
                break;
            case "seibutu":
                textView.setText(R.string.seibutu);
                saveSchedule(getResources().getString(R.string.seibutu));
                break;
            case "kagaku":
                textView.setText(R.string.kagaku);
                saveSchedule(getResources().getString(R.string.kagaku));
                break;
            case "nihonsi":
                textView.setText(R.string.nihonsi);
                saveSchedule(getResources().getString(R.string.nihonsi));
                break;
            case "taiiku":
                textView.setText(R.string.taiiku);
                saveSchedule(getResources().getString(R.string.taiiku));
                break;
            case "hoken":
                textView.setText(R.string.taiiku);
                saveSchedule(getResources().getString(R.string.hoken));
                break;
            case "syakaitozyouhou":
                textView.setText(R.string.syakaitozyouhou);
                saveSchedule(getResources().getString(R.string.syakaitozyouhou));
                break;
            case "onbisyo":
                textView.setText(R.string.onbisyo);
                saveSchedule(getResources().getString(R.string.onbisyo));
                break;
            case "sougou":
                textView.setText(R.string.sougou);
                saveSchedule(getResources().getString(R.string.sougou));
                break;
            case "hr":
                textView.setText(R.string.hr);
                saveSchedule(getResources().getString(R.string.hr));
                break;
            case "":
                textView.setText("");
                saveSchedule(subject);
                break;
        }
    }

    public void onClickMon1(View view){
        textView =(TextView)findViewById(R.id.mon_1);
        textViewKey = ("mon_1");
        setSubject();
    }
    public void onClickMon2(View view){
        textView =(TextView)findViewById(R.id.mon_2);
        textViewKey = ("mon_2");
        setSubject();
    }
    public void onClickMon3(View view){
        textView =(TextView)findViewById(R.id.mon_3);
         textViewKey = ("mon_3");
        setSubject();
    }
    public void onClickMon4(View view){
        textView =(TextView)findViewById(R.id.mon_4);
         textViewKey = ("mon_4");
        setSubject();
    }
    public void onClickMon5(View view){
        textView =(TextView)findViewById(R.id.mon_5);
         textViewKey = ("mon_5");
        setSubject();
    }
    public void onClickMon6(View view){
        textView =(TextView)findViewById(R.id.mon_6);
         textViewKey = ("mon_6");
        setSubject();
    }
    public void onClickMon0(View view){
        textView =(TextView)findViewById(R.id.mon_0);
         textViewKey = ("mon_0");
        setSubject();
    }
    public void onClickTue1(View view){
        textView =(TextView)findViewById(R.id.tue_1);
         textViewKey = ("tue_1");
        setSubject();
    }
    public void onClickTue2(View view){
        textView =(TextView)findViewById(R.id.tue_2);
         textViewKey = ("tue_2");
        setSubject();
    }
    public void onClickTue3(View view){
        textView =(TextView)findViewById(R.id.tue_3);
         textViewKey = ("tue_3");
        setSubject();
    }
    public void onClickTue4(View view){
        textView =(TextView)findViewById(R.id.tue_4);
         textViewKey = ("tue_4");
        setSubject();
    }
    public void onClickTue5(View view){
        textView =(TextView)findViewById(R.id.tue_5);
         textViewKey = ("tue_5");
        setSubject();
    }
    public void onClickTue6(View view){
        textView =(TextView)findViewById(R.id.tue_6);
         textViewKey = ("tue_6");
        setSubject();
    }
    public void onClickTue0(View view){
        textView =(TextView)findViewById(R.id.tue_0);
         textViewKey = ("tue_0");
        setSubject();
    }
    public void onClickWed1(View view){
        textView =(TextView)findViewById(R.id.wed_1);
         textViewKey = ("wed_1");
        setSubject();
    }
    public void onClickWed2(View view){
        textView =(TextView)findViewById(R.id.wed_2);
         textViewKey = ("wed_2");
        setSubject();
    }
    public void onClickWed3(View view){
        textView =(TextView)findViewById(R.id.wed_3);
         textViewKey = ("wed_3");
        setSubject();
    }
    public void onClickWed4(View view){
        textView =(TextView)findViewById(R.id.wed_4);
         textViewKey = ("wed_4");
        setSubject();
    }
    public void onClickWed5(View view){
        textView =(TextView)findViewById(R.id.wed_5);
         textViewKey = ("wed_5");
        setSubject();
    }
    public void onClickWed6(View view){
        textView =(TextView)findViewById(R.id.wed_6);
         textViewKey = ("wed_6");
        setSubject();
    }
    public void onClickWed0(View view){
        textView =(TextView)findViewById(R.id.wed_0);
         textViewKey = ("wed_0");
        setSubject();
    }
    public void onClickThu1(View view){
        textView =(TextView)findViewById(R.id.thu_1);
         textViewKey = ("thu_1");
        setSubject();
    }
    public void onClickThu2(View view){
        textView =(TextView)findViewById(R.id.thu_2);
         textViewKey = ("thu_2");
        setSubject();
    }
    public void onClickThu3(View view){
        textView =(TextView)findViewById(R.id.thu_3);
         textViewKey = ("thu_3");
        setSubject();
    }
    public void onClickThu4(View view){
        textView =(TextView)findViewById(R.id.thu_4);
         textViewKey = ("thu_4");
        setSubject();
    }
    public void onClickThu5(View view){
        textView =(TextView)findViewById(R.id.thu_5);
         textViewKey = ("thu_5");
        setSubject();
    }
    public void onClickThu6(View view){
        textView =(TextView)findViewById(R.id.thu_6);
         textViewKey = ("thu_6");
        setSubject();
    }
    public void onClickThu0(View view){
        textView =(TextView)findViewById(R.id.thu_0);
         textViewKey = ("thu_0");
        setSubject();
    }
    public void onClickFri1(View view){
        textView =(TextView)findViewById(R.id.fri_1);
         textViewKey = ("fri_1");
        setSubject();
    }
    public void onClickFri2(View view){
        textView =(TextView)findViewById(R.id.fri_2);
         textViewKey = ("fri_2");
        setSubject();
    }
    public void onClickFri3(View view){
        textView =(TextView)findViewById(R.id.fri_3);
         textViewKey = ("fri_3");
        setSubject();
    }
    public void onClickFri4(View view){
        textView =(TextView)findViewById(R.id.fri_4);
         textViewKey = ("fri_4");
        setSubject();
    }
    public void onClickFri5(View view){
        textView =(TextView)findViewById(R.id.fri_5);
         textViewKey = ("fri_5");
        setSubject();
    }
    public void onClickFri6(View view){
        textView =(TextView)findViewById(R.id.fri_6);
         textViewKey = ("fri_6");
        setSubject();
    }
    public void onClickFri0(View view){
        textView =(TextView)findViewById(R.id.fri_0);
         textViewKey = ("fri_0");
        setSubject();
    }
    public void onClickSat1(View view){
        textView =(TextView)findViewById(R.id.sat_1);
         textViewKey = ("sat_1");
        setSubject();
    }
    public void onClickSat2(View view){
        textView =(TextView)findViewById(R.id.sat_2);
         textViewKey = ("sat_2");
        setSubject();
    }
    public void onClickSat3(View view){
        textView =(TextView)findViewById(R.id.sat_3);
         textViewKey = ("sat_3");
        setSubject();
    }
    public void onClickSat4(View view){
        textView =(TextView)findViewById(R.id.sat_4);
         textViewKey = ("sat_4");
        setSubject();
    }
    public void onClickSat5(View view){
        textView =(TextView)findViewById(R.id.sat_5);
         textViewKey = ("sat_5");
        setSubject();
    }
    public void onClickSat6(View view){
        textView =(TextView)findViewById(R.id.sat_6);
         textViewKey = ("sat_6");
        setSubject();
        
    }
    public void onClickSat0(View view){
        textView =(TextView)findViewById(R.id.sat_0);
         textViewKey = ("sat_0");
        setSubject();
    }




}
