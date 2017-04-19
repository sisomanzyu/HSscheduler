package com.sp_angle.app.hsscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by watanabe-takumi on 2017/04/18.
 */

public class SelectSubject extends AppCompatActivity {

    Intent intent;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_subect);

        intent =new Intent();
        intent.setClassName("com.sp_angle.app.hsscheduler","com.sp_angle.app.hsscheduler.MainActivity");
        setResult(1,intent);
    }
    public void returnSubject(String subject){
        intent.putExtra("Subject",subject);
        finishActivity();
    }

    public void finishActivity(){
        setResult(1,intent);
        finish();
    }

    public void onClickGenbun(View view){
        returnSubject("genbun");
    }

    public void onClickKoten(View view){
        returnSubject("koten");
    }

    public void onClickSuu1(View view){
        returnSubject("suu1");
    }

    public void onClickSuuA(View view){
        returnSubject("suuA");
    }

    public void onClickEihyou1(View view){
        returnSubject("eihyou1");
    }

    public void onClickKomyuei1(View view){
        returnSubject("komyuei1");
    }

    public void onClickTiri(View view){
        returnSubject("tiri");
    }

    public void onClickSeibutu(View view){
        returnSubject("seibutu");
    }

    public void onClickKagaku(View view){
        returnSubject("kagaku");
    }

    public void onClickNihonsi(View view){
        returnSubject("nihonsi");
    }

    public void onClickTaiiku(View view){
        returnSubject("taiiku");
    }

    public void onClickHoken(View view) { returnSubject("hoken"); }

    public void onClickSyakaitozyouhou(View view){
        returnSubject("syakaitozyouhou");
    }

    public void onClickOnbisyo(View view){
        returnSubject("onbisyo");
    }

    public void onClickSougou(View view){
        returnSubject("sougou");
    }

    public void onClickHr(View view){
        returnSubject("hr");
    }

    public void onClickDelete(View view){ returnSubject("");}

    public void onClickBack(View view){
        finishActivity();
    }
}