package tw.edu.tut.mis.demo1016;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Sample> mList;
    MySampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 資料    <---- 介面卡 ----->    畫面
        //List          Adapter         ListView

        //原來在這裡... mList
        mList = new ArrayList<>();
        //新增測試資料
        mList.add( new Sample("張三","062532106","台南市永康區中正路529號") );
        mList.add( new Sample("李四", "0912345678", "台北市") );
        mList.add( new Sample("王五", "0123456", "無名市") );

        //原來在這裡... ArrayAdapter<String> mAdapter;
        mAdapter = new MySampleAdapter( this, R.layout.my_sample_list, mList );

        ListView mLV;
        mLV = findViewById(R.id.listView);
        mLV.setAdapter( mAdapter );

        //新增的按鈕
        //也可以  findViewById(R.id.imageButton).setOnClickListener(mAdd);
        ImageButton ib;
        ib = findViewById(R.id.imageButton);
        ib.setOnClickListener(mAddClick);
    }


    //新增的按鈕 點選時要做的事情
    View.OnClickListener mAddClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent  it = new Intent();
            it.setClass(MainActivity.this, WriteActivity.class);
            it.putExtra("名稱1號","傳過去的值");
            it.putExtra("名稱2號", 3.14159);
            it.putExtra("名稱自己取", 1000);
            startActivity(it);
        }
    };


    //定義自己的 ArrayAdapter     簡化起見，寫成巢狀class (類別裡面的類別)
    class MySampleAdapter extends ArrayAdapter<Sample> {
        int msaResource;
        List<Sample> msaList;
        public MySampleAdapter(Context context, int resource, List<Sample> objects) {
            super(context, resource, objects);
            msaResource = resource;
            msaList = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if( convertView==null ){ //自己產生一個
                convertView = LayoutInflater
                        .from( getContext() )
                        .inflate( msaResource, parent, false );
            }
            //取得清單中 第 position 筆位置的資料
            Sample x = msaList.get( position );
            //把資料填入到清單的畫面中
            TextView tv1, tv2, tv3;
            tv1 = convertView.findViewById( R.id.textView );
            tv2 = convertView.findViewById( R.id.textView2 );
            tv3 = convertView.findViewById( R.id.textView3 );
            tv1.setText( x.getName() );
            tv2.setText( x.getTEL() );
            tv3.setText( x.getAddress() );
            //回傳該筆的畫面View
            return convertView;
        }
    }


}

