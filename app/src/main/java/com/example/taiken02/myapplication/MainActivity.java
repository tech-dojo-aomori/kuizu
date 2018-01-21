package com.example.taiken02.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String[]> quizList;
    String[] QUIZ ={"鮫島和人","管俊男","ラキーム・ジャクソン","カイル・バローン"}; //　問題
    int tap = 0;                             // 現在の正解数
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizList = new ArrayList<>();
        quizList.add(new String[]{"鮫島和人","管俊男","ラキーム・ジャクソン","カイル・バローン"});
        quizList.add(new String[]{"鮫島和人2","管俊男2","ラキーム・ジャクソン2","カイル・バローン2"});
        quizList.add(new String[]{"鮫島和人3","管俊男3","ラキーム・ジャクソン3","カイル・バローン3"});
        showQuiz();
    }

    // ボタンチェック  /////////////////////////
    public void onButton( View v){
        // タップされたボタンの文字を取得
        String text =  ((Button)v).getText().toString();

        // 正解処理 ( 問題と比較 ）
        Log.e("MainActivity","tap:"+tap+" quizList.get(count)[tap]:"+quizList.get(count)[tap]+" text:"+text);
        if( text.equals(quizList.get(count)[tap])){

            v.setEnabled(false);    // ボタンをクリック不可
            tap++;                  // 正解数UP
            ((TextView)findViewById(R.id.tv)).setText( tap+"問正解！！");  // 正解表示

            // 全問正解の処理
            if(tap >= 4){
                ((TextView)findViewById(R.id.tv)).setText("ゲームクリア");
                count++;
                tap = 0;
                showQuiz();
            }
        }
        // 不正解処理
        else {
            ((TextView)findViewById(R.id.tv)).setText("ゲームオーバー");
            ((Button)findViewById(R.id.b0)).setEnabled(false);
            ((Button)findViewById(R.id.b1)).setEnabled(false);
            ((Button)findViewById(R.id.b2)).setEnabled(false);
            ((Button)findViewById(R.id.b3)).setEnabled(false);

        }
    }

    private void showQuiz() {
        // 出題（シャッフル）//////////////////////////
        List<String> list = Arrays.asList(quizList.get(count).clone());
        Collections.shuffle(list);
        ((Button)findViewById(R.id.b0)).setText(list.get(0));
        ((Button)findViewById(R.id.b1)).setText(list.get(1));
        ((Button)findViewById(R.id.b2)).setText(list.get(2));
        ((Button)findViewById(R.id.b3)).setText(list.get(3));
        ((Button)findViewById(R.id.b0)).setEnabled(true);
        ((Button)findViewById(R.id.b1)).setEnabled(true);
        ((Button)findViewById(R.id.b2)).setEnabled(true);
        ((Button)findViewById(R.id.b3)).setEnabled(true);

    }
}