package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText customerName;
    EditText phoneNum;
    EditText amtPeople;
    DatePicker datePicker;
    TimePicker timePicker;
    CheckBox cbSmoking;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customerName = findViewById(R.id.customerName);
        phoneNum = findViewById(R.id.phoneNum);
        amtPeople = findViewById(R.id.amtPeople);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        cbSmoking = findViewById(R.id.cbSmoking);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnReset = findViewById(R.id.btnReset);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = customerName.getText().toString();
                String smoke = "";

                if (cbSmoking.isChecked()){
                    smoke = "Yes";
                }else{
                    smoke = "No";
                }

                String hour = timePicker.getCurrentHour().toString();
                String min = timePicker.getCurrentMinute().toString();

                if (hour.length() == 1){
                    hour = "0" + hour;
                }

                if (min.length() == 1) {
                    min = "0" + min;
                }

                if (name.isEmpty() || phoneNum.length() != 8 || amtPeople.length() == 0){

                    Toast.makeText(MainActivity.this, "One or more of the information is empty", Toast.LENGTH_SHORT).show();

                }else{

                    String firstName = "Name: " + customerName.getText();
                    String secondPhone = "Phone: " + phoneNum.getText();
                    String thirdGuest = "No. Of Guest: " + amtPeople.getText();
                    String date = "Date: " + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();
                    String time = "Time: " + hour + ":" + min;
                    String smoking = "Smoking: " + smoke;

                    Toast.makeText(MainActivity.this, firstName + "\n" + secondPhone + "\n" + thirdGuest + "\n" + date + "\n" + time + "\n" + smoking, Toast.LENGTH_SHORT).show();

                }



            }
        });

    }
}
