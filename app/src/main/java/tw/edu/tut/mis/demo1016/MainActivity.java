package tw.edu.tut.mis.demo1016;

import android.content.Context;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        mLV.setOnItemClickListener(mCli);  //點選項目
        mLV.setOnItemLongClickListener(mDel); //長按項目

        Button bt;
        bt = findViewById(R.id.button);
        bt.setOnClickListener(mAdd);
    }


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


    //點選項目
    AdapterView.OnItemClickListener mCli = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            String s;
//            // s = (String)mList.get(position);
//            // s = (String)mAdapter.getItem(position);
//            s = (String)parent.getItemAtPosition(position);
//
//            Toast.makeText( MainActivity.this, "點選:"+s, Toast.LENGTH_LONG )
//                    .show();
        }
    };


    //長按項目後 刪除
    AdapterView.OnItemLongClickListener mDel = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//            //方法1
//            String s;
//            // s = (String)mAdapter.getItem(position);
//            s = (String)parent.getItemAtPosition(position);
//            mAdapter.remove(s);
//            //方法2
//            // mList.remove( position );
//            // mAdapter.notifyDataSetChanged();

            return true;  // 表示已經處理了長按的動作 true  未處理(完成) false

        }
    };



    View.OnClickListener mAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            //找到輸入格子
//            EditText ed;
//            ed = findViewById(R.id.editText);
//            //取得輸入的內容
//            String s;
//            s = ed.getText().toString();
//            //把內容加到清單中
//            //方法1
//            //mAdapter.add( s );
//            mAdapter.insert( s, 0 );
//            //方法2
//            //mList.add( s );
//            //mList.add( 0, s );
//            //mAdapter.notifyDataSetChanged();
        }
    };

}

