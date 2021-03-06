package aa_stem.finallogscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class BasicSetup extends AppCompatActivity {
    TextView viewpromptMedName;
    EditText inputmedicineName;
    TextView viewpromptDoseAmt;
    EditText inputdosageAmount;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicsetup);
        viewpromptMedName = (TextView) findViewById(R.id.promptMedName);
        inputmedicineName = (EditText) findViewById(R.id.medicineName) ;
        viewpromptDoseAmt = (TextView) findViewById(R.id.promptDoseAmt);
        inputdosageAmount = (EditText) findViewById(R.id.dosageAmount) ;



        //Create Button
        Button btnVerifyInput = (Button) findViewById(R.id.btnVerifyInput);

        //button click event
        btnVerifyInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(BasicSetup.this);

                alertDialog.setTitle("Create Alert");
                alertDialog.setMessage("Are you sure you want to continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),CreatePhoneNumber.class);
                        startActivity(i);
                    }
                });

                alertDialog.show();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}


