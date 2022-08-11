package haqnawaz.org.a20220815db;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourseActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button updateCourseBtn;
    private DBHelper dbHandler;
    EditText NameEdt, RollEdt;
    String Name, RollNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_page);

        // initializing all our variables.
        NameEdt = findViewById(R.id.idEdtName);
        RollEdt = findViewById(R.id.idEdtRollNo);

        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);

        // on below line we are initialing our dbhandler class.
        dbHandler = new DBHelper(UpdateCourseActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
//        Name = getIntent().getStringExtra("name");
//        RollNo = getIntent().getStringExtra("RollNo");


        // setting data to edit text
        // of our update activity.
//        NameEdt.setText(Name);
//        RollEdt.setText(RollNo);


        // adding on click listener to our update course button.

}
