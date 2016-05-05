package elite.polito.it.myfirstandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Interface definition for a callback to be invoked when a view is clicked
    public void onClickFunction(View view)
    {
        //get an instance of each graphical element defined in the layout
        EditText etNum1 = (EditText) findViewById(R.id.etNum1);
        EditText etNum2 = (EditText) findViewById(R.id.etNum2);
        TextView tvResult = (TextView) findViewById(R.id.etResults);
        int num1 = 0;
        int num2 = 0;
        //check if the user actually inserted a number
        if (etNum1.getText().length()>0)
            num1 = Integer.parseInt(etNum1.getText().toString());
        if (etNum2.getText().length()>0)
            num2 = Integer.parseInt(etNum2.getText().toString());
        int result = 0;
        String operation = ""; //near the string "Result" we want to print the performed operation
        switch (view.getId()){
            case R.id.addButton:
                operation = "(op: "+num1+"+"+num2+")";
                result = num1 + num2;
                break;
            case R.id.minusButton:
                operation = "(op: "+num1+"-"+num2+")";
                result = num1 - num2;
                break;
            case R.id.divButton:
                if (num2!=0) {

                    operation = "(op: "+num1+"/"+num2+")";
                    result = num1 / num2;
                }
                else
                {
                    operation = "";
                    //A toast provides simple feedback about an operation in a small popup
                    Toast toast = Toast.makeText(this, "It is not possible to divide by 0", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
            case R.id.mulButton:
                operation = "(op: "+num1+"*"+num2+")";
                result = num1 * num2;
                break;
        }
        //set the result in the right textView
        tvResult.setText(String.valueOf(result));

        //write the performed operation near the "Result" label
        TextView tvResultLabel = (TextView) findViewById(R.id.tvResultLabel);
        tvResultLabel.setText("Result "+operation);
    }

}
