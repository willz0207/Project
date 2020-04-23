package com.example.layout;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DatabaseFragment extends Fragment {
    private SQLiteDatabase mydb ;

    private EditText noMhs;
    private EditText namaMhs;
    private EditText phoneMhs;
    private Button buttonSimpan;
    private Button buttonHapus;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_mahasiswa, container, false);
        noMhs = view.findViewById(R.id.noMhs);
        namaMhs = view.findViewById(R.id.namaMhs);
        phoneMhs = view.findViewById(R.id.phoneMhs);
        buttonSimpan = view.findViewById(R.id.simpanButton);
        buttonHapus = view.findViewById(R.id.hapusButton);

        return view;
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        DBHelper dbhelper = new DBHelper(getContext());
        mydb = dbhelper.getReadableDatabase();
    }

    private Cursor getAllItem(){
        return mydb.query(
                DataMahasiswa.mahasiswaEntry.TABLE_NAME,
                null,null,null,null,null,null
        );
    }
}
