package haqnawaz.org.a20220815db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll, buttonDel;
    EditText editName, editRollNumber,delID;
    Switch switchIsActive;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        buttonDel = findViewById(R.id.buttonDel);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        delID = findViewById(R.id.getIDofDel);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper  = new DBHelper(MainActivity.this);
                dbHelper.addStudent(studentModel);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<StudentModel>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                Editable id = delID.getText();
                if(dbHelper.delStudent(id))
                    Toast.makeText(MainActivity.this,"Record deleted sucessfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Error Id not found",Toast.LENGTH_SHORT).show();
            }
        });
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), UpdateCourseActivity.class);

                // below we are passing all our values.
//                i.putExtra("name", );
//                i.putExtra("RollNo", modal.getCourseDescription());


                // starting our activity.
               getApplicationContext().startActivity(i);
            }
        });

    }
}