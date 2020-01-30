package ca.georgebrown.pawluk.nestedlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view)
    {


        //This references the Edit Text in from the VIEW Layout
        EditText txtName = (EditText) findViewById(R.id.txtName);
        //This gets the text that the user entered from the view and assigns it to a string variable
        String name =  txtName.getText().toString();

        EditText txtMessage = (EditText) findViewById(R.id.txtMessage);
        //This gets the text that the user entered from the view and assigns it to a string variable
        String message =  txtMessage.getText().toString();


        RadioButton radioButtonYesCall = (RadioButton) findViewById(R.id.rdoYesCall);
        RadioButton radioButtonNoCall = (RadioButton) findViewById(R.id.rdoNoCall);

        /*
        RadioButton radioButtonYesEmail = (RadioButton) findViewById(R.id.rdoYesEmail);
        RadioButton radioButtonNoEmail = (RadioButton) findViewById(R.id.rdoNoEmail);*/

        String messageToSend="";
        if(radioButtonYesCall.isChecked())
        {
            messageToSend="AS YOU INDICATED, YOU DO WANT US TO CALL YOU";
        }

        if(radioButtonNoCall.isChecked())
        {
            messageToSend="AS YOU INDICATED, YOU DO NOT WANT US TO CALL YOU";
        }




        //This Creates an Intent.
        /*
            Intents are used to start a new activity and send data to a particular activity
         */
        Intent messageIntent = new Intent(this, SubmittedActivity.class);

        /*
            This allows me to send two individual pieces of data with the intent
        messageIntent.putExtra("personName",name);
        messageIntent.putExtra("callMessage",message);
        */
        Bundle intentBundle = new Bundle();
        intentBundle.putString("personName",name);
        intentBundle.putString("callMessage",messageToSend);

        messageIntent.putExtras(intentBundle);


        startActivity(messageIntent);

    }
}
