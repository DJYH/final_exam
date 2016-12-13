package com.example.sm.problem2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

import static com.example.sm.problem2.R.layout.list_view_item_layout;

public class MyBaseAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{

    Context mContext = null;
    ArrayList<Employee> mData = null;
    LayoutInflater mLayoutInflater = null;
    public int selected_position;

    MyBaseAdapter(  Context context, ArrayList<Employee> data){
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Employee employee = (Employee) parent.getItemAtPosition(position);

        String name = employee.getName();
        Integer age = employee.getAge();
        Integer salary = employee.getSalary();
        EditText edit_name = (EditText) view.getRootView().findViewById(R.id.edit_name);
        EditText edit_age = (EditText) view.getRootView().findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) view.getRootView().findViewById(R.id.edit_salary);
        edit_name.setText(name);
        edit_age.setText(age.toString());
        edit_salary.setText(salary.toString());
        this.selected_position = position;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(Employee employee){
        mData.add(employee);
        notifyDataSetChanged();
    }

    public void delete(int index){
        mData.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //somthing
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(list_view_item_layout, parent, false);

        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득

        TextView nameTextView = (TextView) convertView.findViewById(R.id.text_employeeName);
        TextView ageTextView = (TextView) convertView.findViewById(R.id.text_employeeAge);
        TextView salTextView = (TextView) convertView.findViewById(R.id.text_employeeSalary);

        Employee listViewItem = mData.get(position);

        // 아이템 내 각 위젯에 데이터 반영

        nameTextView.setText(listViewItem.getName());
        ageTextView.setText(String.valueOf(listViewItem.getAge()));
        salTextView.setText(String.valueOf(listViewItem.getSalary()));

        return convertView;
    }
}



