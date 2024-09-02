package com.example.learningproejct;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerListViewActivity extends AppCompatActivity {

    Button btnOpenDialog;

    ArrayList<ContactModel> arrayList = new ArrayList<ContactModel>();
    RecyclerContactAdapter adapter ;
            RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list_view);
        recyclerView = findViewById(R.id.recycler_view);
        btnOpenDialog = findViewById(R.id.btn_open_dialog);
        Button btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerListViewActivity.this, IntentMainActivity.class);
                startActivity(intent);
            }
        });

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(RecyclerListViewActivity.this);
                dialog.setContentView(R.layout.data_dialog);


                EditText edtName = dialog.findViewById(R.id.edt_name);
                EditText edtEmail = dialog.findViewById(R.id.edt_email);

                Button btnAdd = dialog.findViewById(R.id.btn_submit);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = edtName.getText().toString();
                        String email = edtEmail.getText().toString();
                        if(!name.equals("") && !email.equals("")) {
                            arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, name, email));
                        adapter.notifyItemInserted(arrayList.size()-1);
                        recyclerView.scrollToPosition(arrayList.size()-1);
                        dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AB", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AV", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AD", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AS", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AS", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AF", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AR", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AS", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AQ", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AW", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "EA", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AR", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "RA", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AR", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AT", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "AT", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "TA", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));
        arrayList.add(new ContactModel(R.drawable.ic_dashboard_black_24dp, "A", "Hg@gmail.com"));

        Log.e("TAG", "onCreate: Rinkal"+arrayList.size() );

        adapter = new RecyclerContactAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}