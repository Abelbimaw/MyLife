package id.sch.smktelkom_mlg.project.xirpl301101928.mylife;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yukak on 2016/11/23.
 */

public class SettingsViewer extends android.support.v4.app.Fragment {
    private static final String mypref = "Mypref";
    String[] settings = {"Change Password", "LogOut"};
    ListView list;
    SharedPreferences sp;

    public SettingsViewer() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.settings_fragment, container, false);
        list = (ListView) rootview.findViewById(R.id.listsettings);
        list.setAdapter(new settingsadapter());
        sp = getActivity().getSharedPreferences(mypref, 0);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (arg2 == 1) {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("visit", false);
                    edit.commit();
                    getActivity().finish();
                }
                if (arg2 == 0) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity()).setTitle("Please type a new password");
                    final EditText editText = new EditText(getActivity());
                    dialog.setView(editText);
                    dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (editText.getText().toString().trim().equals("")) {
                                Toast.makeText(getActivity(), "Please type a password", Toast.LENGTH_LONG).show();
                            } else {
                                SharedPreferences sp = getActivity().getSharedPreferences("Mypref", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putString("pass", editText.getText().toString());
                                editor.commit();
                                Toast.makeText(getActivity(), "Changed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        });
        return rootview;
    }


    public class settingsadapter extends ArrayAdapter<String> {
        public settingsadapter() {
            super(getActivity(), R.layout.settings_row, R.id.textsettingsrow, settings);
        }

        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView imageviewer = (ImageView) row.findViewById(R.id.imageView1);
            if (position == 0) {
                imageviewer.setImageResource(R.drawable.happy);
            } else if (position == 1) {
                imageviewer.setImageResource(R.drawable.sad);
            } else
                imageviewer.setImageResource(R.drawable.cool);
            TextView tv = (TextView) row.findViewById(R.id.textsettingsrow);
            tv.setText(settings[position]);
            return row;

        }
    }
}
