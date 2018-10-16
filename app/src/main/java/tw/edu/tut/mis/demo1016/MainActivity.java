package tw.edu.tut.mis.demo1016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> mList;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 資料    <---- 介面卡 ----->    畫面
        //List          Adapter         ListView

        //原來在這裡... mList
        mList = new ArrayList<>();
        //新增測試資料
        mList.add( "Apple" );
        mList.add( "Banana" );
        mList.add( "Cat" );

        //原來在這裡... ArrayAdapter<String> mAdapter;
        mAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, mList );

        ListView mLV;
        mLV = findViewById(R.id.listView);
        mLV.setAdapter( mAdapter );
        mLV.setOnItemClickListener(mCli);  //點選項目
        mLV.setOnItemLongClickListener(mDel); //長按項目

        Button bt;
        bt = findViewById(R.id.button);
        bt.setOnClickListener(mAdd);
    }

    //點選項目
    AdapterView.OnItemClickListener mCli = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String s;
            // s = (String)mList.get(position);
            // s = (String)mAdapter.getItem(position);
            s = (String)parent.getItemAtPosition(position);

            Toast.makeText( MainActivity.this, "點選:"+s, Toast.LENGTH_LONG )
                    .show();
        }
    };


    //長按項目後 刪除
    AdapterView.OnItemLongClickListener mDel = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            //方法1
            String s;
            // s = (String)mAdapter.getItem(position);
            s = (String)parent.getItemAtPosition(position);
            mAdapter.remove(s);
            //方法2
            // mList.remove( position );
            // mAdapter.notifyDataSetChanged();

            return true;  // 表示已經處理了長按的動作 true  未處理(完成) false

        }
    };



    View.OnClickListener mAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //找到輸入格子
            EditText ed;
            ed = findViewById(R.id.editText);
            //取得輸入的內容
            String s;
            s = ed.getText().toString();
            //把內容加到清單中
            //方法1
            //mAdapter.add( s );
            mAdapter.insert( s, 0 );
            //方法2
            //mList.add( s );
            //mList.add( 0, s );
            //mAdapter.notifyDataSetChanged();
        }
    };

}

