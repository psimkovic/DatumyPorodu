package eu.chs_pk_cavies.psimkovic.datumyporodu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
    private TextView txtVerzia;
    public String versionName;
    Button GoToNewActivity;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

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

                // Intent code for open new activity through intent.

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);

            }
        });

    }

    private void findViewsById() {
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setInputType(InputType.TYPE_NULL);

        editText3 = (EditText) findViewById(R.id.editText3);
        editText3.setInputType(InputType.TYPE_NULL);

        editText4 = (EditText) findViewById(R.id.editText4);
        editText4.setInputType(InputType.TYPE_NULL);

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
