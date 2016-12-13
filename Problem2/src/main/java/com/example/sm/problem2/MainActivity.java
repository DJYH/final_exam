package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here
        ArrayList<Employee> emp_list = new ArrayList<Employee>();

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);

        EditText edit_age = (EditText) findViewById(R.id.edit_age);

        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee;

        switch (v.getId()){
            case R.id.btn_inc: // 증가버튼 클릭

                // need something here
                break;

            case R.id.btn_dec: //감소버튼 클릭
                // need something here
                break;

            case R.id.btn_store: //생성
                String nametxt = String.valueOf(edit_name.getText());
                String agetxt = String.valueOf(edit_age.getText());
                String salarytxt = String.valueOf(edit_salary.getText());
                Employee employee01 = new Employee(nametxt, Integer.parseInt(agetxt),Integer.parseInt(salarytxt));

                // need something here
                break;

            case R.id.btn_modify: //수정
                // need something here
                break;

            case R.id.btn_delete: //삭제
                // need something here
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
