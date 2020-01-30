package ca.georgebrown.pawluk.nestedlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubmittedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);

        //Get Intent
        Intent intent = getIntent();

        //Extract bundle out of intent
        Bundle bundle = intent.getExtras();

        String  name = bundle.getString("personName");
        String  message = bundle.getString("callMessage");

        TextView txtHeading = (TextView) findViewById(R.id.txtHeadingInfo);
        TextView txtMessage=  (TextView) findViewById(R.id.txtCallInfo);

        txtHeading.setText("Thank you "+name + " we received your information");
        txtMessage.setText(message);






    }
}
