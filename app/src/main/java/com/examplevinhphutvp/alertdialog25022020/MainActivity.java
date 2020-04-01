package com.examplevinhphutvp.alertdialog25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mBtnAlert;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlert = findViewById(R.id.buttonAlert);

        mBtnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("thông báo mới");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                //Mảng con vật
                 final String[] arrayAnimals = {"Mèo","Chó","Heo","Gà","Voi","Ngựa"};
                 final boolean[] arrayCheckedItem = {false,false,false,false,false,false};
                // Single choice
 //               builder.setSingleChoiceItems(arrayAnimals, -1, new DialogInterface.OnClickListener() {
 //               @Override
 //                   public void onClick(DialogInterface dialog, int which) {
 //                      index = which;
 //                   }
 //               });
//                builder.setPositiveButton("Chọn", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,arrayAnimals[index] , Toast.LENGTH_SHORT).show();
//                    }
//                });
                // Multiple choice

                builder.setMultiChoiceItems(arrayAnimals, arrayCheckedItem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                builder.setPositiveButton("Chọn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String value = "";
                        for (int y = 0 ; y < arrayAnimals.length; y++){
                            if (arrayCheckedItem[y]){
                                value += arrayAnimals[y];
                            }
                        }
                        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });
    }
}
