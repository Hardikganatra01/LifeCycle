package androidstudio.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class A extends AppCompatActivity {


    public String TAG = "VAIO";

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        textView= (TextView) findViewById(R.id.input);
        Log.d(TAG, "onCreate: ");

        //the second way to restore values
        if (savedInstanceState != null) {
            CharSequence value = savedInstanceState.getCharSequence("key");
            textView.setText(value);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putCharSequence("key",textView.getText());
        
    }

    //the first way to restore values
   /* @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        CharSequence value=savedInstanceState.getCharSequence("key");
        textView.setText(value);
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void launchAlertDialog(View view) {
        new AlertDialog.Builder(this)
                .setMessage("hello from AlertDialog")
                .show();
    }

    public void launchDialogFragment() {
        MyDialog myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(), "my_dialog");
    }

    public void increment(View view) {
        TextView textView = (TextView) findViewById(R.id.input);
        String string = (String) textView.getText();
        if (string != null && !string.isEmpty()) {
            int value = Integer.parseInt(string);
            value += 1;
            textView.setText(value + "");
        }
    }

    public static class MyDialog extends DialogFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setText(R.string.hello_c);
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setBackgroundColor(getResources().getColor(R.color.black));
            return textView;
        }
    }

    public void launchActivity(View view) {
        Intent intent=new Intent(this,B.class);
        startActivity(intent);

    }

    public void launchDialog(View view) {
        /*Intent intent=new Intent(this,C.class);
        startActivity(intent);*/
        /*launchAlertDialog(view);*/
        launchDialogFragment();
    }
}
