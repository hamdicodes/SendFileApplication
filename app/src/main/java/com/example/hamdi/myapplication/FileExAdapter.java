package com.example.hamdi.myapplication;

import android.app.AppComponentFactory;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FileExAdapter extends BaseAdapter {
    ArrayList<FileEx> fileExList=new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;

    public FileExAdapter(ArrayList<FileEx> fileExList, Context context) {
        this.fileExList = fileExList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fileExList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//uzanti kontrolu yapılıyor...
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater= LayoutInflater.from(context);
        View hucre=layoutInflater.inflate(R.layout.hucre,null);
        ImageView imageView =hucre.findViewById(R.id.img);
        TextView txtBaslik =(TextView) hucre.findViewById(R.id.txtBaslik);

        FileEx fileEx=fileExList.get(position);
        txtBaslik.setText(fileEx.getIsim());

        if("png".toUpperCase().equals(fileEx.getUzanti().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.png);
        }
        else if("jpg".toUpperCase().equals(fileEx.getUzanti().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.jpg);
        }
        else if("pdf".toUpperCase().equals(fileEx.getUzanti().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.pdf);
        }
        else if("excel".toUpperCase().equals(fileEx.getUzanti().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.excel);
        }
        else if("txt".toUpperCase().equals(fileEx.getUzanti().toUpperCase())){
            imageView.setBackgroundResource(R.mipmap.txt);
        }
        else{
            if(fileEx.isKlasorMu()){
                imageView.setBackgroundResource(R.mipmap.folder);
            }
            else{
                imageView.setBackgroundResource(R.mipmap.unknown);
            }
        }
        return hucre;
    }
}
