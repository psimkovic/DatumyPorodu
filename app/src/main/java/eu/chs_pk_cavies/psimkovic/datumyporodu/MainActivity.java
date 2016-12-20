package eu.chs_pk_cavies.psimkovic.datumyporodu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity {

    private SimpleDateFormat dateFormatter;
    private Calendar newDate = Calendar.getInstance();
    private DatePicker datePicker;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private TextView txtVerzia;
    public String versionName;
    private String[] arraySpinner;
    Button GoToNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

        findViewsById();

        datePicker.init(
                newDate.get(Calendar.YEAR),
                newDate.get(Calendar.MONTH),
                newDate.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        setDateTimeField();
                    }
                });
        try {
            versionName = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        txtVerzia.setText(getString(R.string.lblAuthor) + ", " + getString(R.string.lblAppVersion) + " " + versionName);
        setDateTimeField();

        GoToNewActivity = (Button)findViewById(R.id.button);
        GoToNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }

        });

        this.arraySpinner = new String[] {
                "59 "+getString(R.string.lblDni),
                "60 "+getString(R.string.lblDni),
                "61 "+getString(R.string.lblDni),
                "62 "+getString(R.string.lblDni),
                "63 "+getString(R.string.lblDni),
                "64 "+getString(R.string.lblDni),
                "65 "+getString(R.string.lblDni),
                "66 "+getString(R.string.lblDni),
                "67 "+getString(R.string.lblDni),
                "68 "+getString(R.string.lblDni),
                "69 "+getString(R.string.lblDni),
                "70 "+getString(R.string.lblDni),
                "71 "+getString(R.string.lblDni),
                "72 "+getString(R.string.lblDni),
                "73 "+getString(R.string.lblDni),
                "74 "+getString(R.string.lblDni)
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Calendar c5 = Calendar.getInstance();
                c5.setTime(newDate.getTime());
                c5.add(Calendar.DATE, Integer.parseInt(arraySpinner[position].replace(" "+getString(R.string.lblDni),"")));
                String newDateStr5 = dateFormatter.format(c5.getTime());
                editText5.setText(newDateStr5);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

    }

    private void findViewsById() {
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setInputType(InputType.TYPE_NULL);

        editText3 = (EditText) findViewById(R.id.editText3);
        editText3.setInputType(InputType.TYPE_NULL);

        editText4 = (EditText) findViewById(R.id.editText4);
        editText4.setInputType(InputType.TYPE_NULL);

        editText5 = (EditText) findViewById(R.id.editText5);
        editText5.setInputType(InputType.TYPE_NULL);

        txtVerzia = (TextView) findViewById(R.id.txtVerzia);
        txtVerzia.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        newDate.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

        Calendar c2 = Calendar.getInstance();
        c2.setTime(newDate.getTime());
        c2.add(Calendar.DATE, 59);
        String newDateStr2 = dateFormatter.format(c2.getTime());
        editText2.setText(newDateStr2);

        Calendar c3 = Calendar.getInstance();
        c3.setTime(newDate.getTime());
        c3.add(Calendar.DATE, 68);
        String newDateStr3 = dateFormatter.format(c3.getTime());
        editText3.setText(newDateStr3);

        Calendar c4 = Calendar.getInstance();
        c4.setTime(newDate.getTime());
        c4.add(Calendar.DATE, 74);
        String newDateStr4 = dateFormatter.format(c4.getTime());
        editText4.setText(newDateStr4);

    }

}
