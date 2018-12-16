package com.example.hamdi.myapplication;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.content.Intent;

import java.io.File;
import java.util.ArrayList;

public class sendFile extends AppCompatActivity  {
    ArrayList<FileEx> list=new ArrayList<>();
    ArrayList<String> dosyalar=new ArrayList<>();

    GridView gridView;
String PATH="";
Context context=this;
ImageButton btnDocList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_file);
        gridView=(GridView) findViewById(R.id.gridView);
        PATH=Environment.getExternalStorageDirectory().getPath();
        list=getFileList(PATH);
        if(list!=null &&list.size()>0){

            gridView.setAdapter(new FileExAdapter(list,context));
        }


        btnDocList =(ImageButton) findViewById(R.id.btnDocsList);
        btnDocList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                File[] file=  File.listRoots();
                for(int i=0;i<file.length;i++){

                    File[] directory=file[i].listFiles();
                    for(int j=0;j<directory.length;j++){
                        dosyalar.add(directory[j].getAbsolutePath());
                    }
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,dosyalar);
                gridView.setAdapter(adapter);

            }
        });

    }
    
    //parametre olarak yol gelecek geriye arraylist donecek...
    public ArrayList<FileEx>getFileList(String p){
        ArrayList<FileEx> tempList=new ArrayList<>();
    File file =new File(p);  //storage/emulated/0/dosya
    //file bir klasorse icine gir..
    if(file.isDirectory()){
        File[] fArray =file.listFiles();
        if(fArray!=null && fArray.length>0){
             for(int i=0;i<fArray.length;i++){
               //  fArray[İ]=  //storage/emulated/0/dosya
                 FileEx  fexTemp=new FileEx();
                 File fTemp=fArray[i];
                 fexTemp.setIsim(fTemp.getName());
                 fexTemp.setYol(fTemp.getAbsolutePath());
                 fexTemp.setKlasorMu(fTemp.isDirectory());
                 if(fTemp.isDirectory()){
                     fexTemp.setUzanti("");
                 }
                 else {
                     //merhaba.txt
                     fexTemp.setUzanti(fTemp.getName().substring(fTemp.getName().lastIndexOf(".")+1)); //txt

                 }
                 tempList.add(fexTemp);
             }
             return tempList;
        }
        else{
            return  null;
        }
    }
      return  null;
    }
}
