package com.example.trending;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;
import java.lang.*;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity<adapter> extends AppCompatActivity
{
    List list = new ArrayList<String>();
    HashMap<Integer,String> hm=new HashMap<Integer,String>();
    ListView lv;
    String url="https://gh-trending-api.herokuapp.com/developers";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.lv);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myapi api=retrofit.create(myapi.class);
        Call<List<model>> call=api.getmodels();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data=response.body();
                for(int i=0; i<data.size();i++) {
                    hm.put(data.get(i).getRank(),data.get(i).getUsername()+" "+data.get(i).getrN()+" "+data.get(i).getUrl()+" "+data.get(i).getDesc()+" "+data.get(i).getLang()+" "+data.get(i).getlC()+" "+data.get(i).gettS()+" "+data.get(i).getForks()+" "+data.get(i).getSS()+" "+data.get(i).getSince()+" "+data.get(i).getbB());
                }
                TreeMap<Integer,String> tm = new TreeMap<>();
                tm.putAll(hm);
                for (Map.Entry<Integer,String> entry : tm.entrySet()) {
                    list.add(String.valueOf(entry.getKey()) + " " + entry.getValue());
                }
            }




            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });
        String str[] = (String[]) list.toArray(new String[list.size()]);
        List ls = new ArrayList<String>();
        for(int i=0;i<str.length;i++) {
            String[] sp = str[i].split("\\s+");
            list.add(sp[2]+"\nsp[4]"+"\nsp[3]"+"\nsp[5]"+"  sp[7]"+"  sp[8]");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ls);
        lv.setAdapter(adapter);

    }
}