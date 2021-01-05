package com.example.android.dbsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBManager dbManager;
    EditText etUsername;
    EditText etPassword;

    int recordId;

    ArrayList<Logins> listloginsData = new ArrayList<Logins>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        dbManager = new DBManager(this);
    }

    public void Save(View view) {
        ContentValues values = new ContentValues();
        values.put(DBManager.ColUsername, etUsername.getText().toString());
        values.put(DBManager.ColPassword, etPassword.getText().toString());

        long ID = dbManager.Insert(values);

        if (ID > 0) {
            Toast.makeText(this, "Data is added and user id: " + ID, Toast.LENGTH_LONG).show();
            ClearAll();
        } else {
            Toast.makeText(this, "Cannot insert user", Toast.LENGTH_LONG).show();
        }
    }

    public void Update(View view) {
    }

    public void Load(View view) {
        LoadElement();
    }

    void LoadElement() {
        //add data and view it
        listloginsData.clear();
//        String[] projection = {"UserName", "Password"}; or null for all columns
        // Search
        String[] selectionArgs = {"%" + etUsername.getText().toString() + "%"};
        Cursor cursor = dbManager.getData(null, "Username like ?", selectionArgs, DBManager.ColUsername);
        if (cursor.moveToFirst()) {
            String tableData = "";
            do {
                listloginsData.add(new Logins(cursor.getInt(cursor.getColumnIndex(DBManager.ColID)),cursor.getString(cursor.getColumnIndex(DBManager.ColUsername)),cursor.getString(cursor.getColumnIndex(DBManager.ColPassword))));
            } while(cursor.moveToNext());
        }
        myadapter = new MyCustomAdapter(listloginsData);

        ListView lvLogins=(ListView)findViewById(R.id.lvLogins);
        lvLogins.setAdapter(myadapter);//intisal with data
        ClearAll();
    }

    private void ClearAll() {
        etUsername.setText("");
        etPassword.setText("");
    }

    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<Logins> listloginsDataAdpater ;

        public MyCustomAdapter(ArrayList<Logins> listnewsDataAdpater) {
            this.listloginsDataAdpater=listnewsDataAdpater;
        }

        @Override
        public int getCount() {
            return listloginsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.listview_detial, null);

            final Logins s = listloginsDataAdpater.get(position);

            TextView tvID = (TextView)myView.findViewById(R.id.tvID);
            tvID.setText(String.valueOf(s.ID));

            TextView tvUsername = (TextView)myView.findViewById(R.id.tvUsername);
            tvUsername.setText(s.Username);

            TextView tvPassword = (TextView)myView.findViewById(R.id.tvPassword);
            tvPassword.setText(s.Password);

            return myView;
        }

    }
}