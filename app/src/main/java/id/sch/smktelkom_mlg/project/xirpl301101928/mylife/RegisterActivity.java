package id.sch.smktelkom_mlg.project.xirpl301101928.mylife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
=======
/**
 * Created by Mufidatun Nabilah on 11/23/2016.
 */
>>>>>>> origin/master

public class RegisterActivity extends ActionBarActivity {
    private static final String mypref = "Mypref";
    SharedPreferences sp;
    EditText edtn;
    EditText edtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        edtn = (EditText) findViewById(R.id.editText1);
        edtp = (EditText) findViewById(R.id.editText2);
        sp = getSharedPreferences(mypref, Context.MODE_PRIVATE);
    }

    public void register(View v) {
        String name = edtn.getText().toString();
        String pass = edtp.getText().toString();
        if (name.trim().equals("") || pass.trim().equals("")) {
            Toast.makeText(getApplication(), "Please Wite a name and password", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences.Editor edt = sp.edit();
            edt.putString("name", edtn.getText().toString());
            edt.putString("pass", edtp.getText().toString());
            edt.putBoolean("register", true);
            edt.putBoolean("visit", true);
            edt.commit();
            Intent in = new Intent(RegisterActivity.this, MainActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in);
            finish();
        }
    }


}
<<<<<<< HEAD
=======

>>>>>>> origin/master
