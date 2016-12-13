package com.example.sm.problem3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CustomerThread> list = new ArrayList<CustomerThread>();
        Manager manager = new Manager();

        for(int i = 0 ; i < 10 ; i++){
            Customer customer = new Customer("Customer" + i);
            CustomerThread ct = new CustomerThread(customer);
            list.add(ct);
            manager.add_customer(customer);
            ct.start();
        }


        for(CustomerThread ct : list){

            try {
                ct.sleep(1000);
               ct.start();
                // need something here
            } catch (InterruptedException e) { }
        }

        manager.sort();

        MyBaseAdapter adapter = new MyBaseAdapter(this, manager.list);
        ListView listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);


    }
}

class CustomerThread extends Thread{

    Customer customer;

    CustomerThread(Customer customer){
        this.customer = customer;
    }
    // need something here
    @Override
    public void run() {
        customer.work();
    }
}

abstract class Person{

    static int money = 100000; //남은돈
    int spent_money = 0; //쓴돈
    abstract void work();

}


class Customer extends Person{

    String name;
    Customer(String name){
        this.name = name;
    }
    Customer() {}
    void setMoney(int money) {
        this.money = money;
    }
    int getMoney () {
        return money;
    }
    void work() {
        money -= spent_money;
    }
    // need something here
}


class Manager extends Person{
    ArrayList <Customer> list = new ArrayList<Customer>();
    Customer temp = new Customer();
    void add_customer(Customer customer) {
        list.add(customer);
    }

    void sort(){ // 직접 소팅 알고리즘을 이용하여 코딩해야함. 자바 기본 정렬 메소드 이용시 감

        // need something here
      for (int i = 0 ; i < 10 ; i ++) {
          for ( int j = 0 ; j < 9 ; j ++) {
              if(list.get(j).getMoney() > list.get(j+1).getMoney()) {
                  temp = list.get(j);
                  list.set(j,list.get(j+1));
                  list.set(j+1,temp);
              }
          }
      }

    }

    @Override
    void work() {
        sort();
    }
}

// need something here

