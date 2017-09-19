package com.example.gstcalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText value;
    float f1;
    TextView result;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value = (EditText) findViewById(R.id.editText2);
        result = (TextView) findViewById(R.id.textView2);
        Button calc = (Button) findViewById(R.id.calculate);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        TextView marqueetxt = (TextView) findViewById(R.id.marquetxt);
        marqueetxt.setSelected(true);
        marqueetxt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        marqueetxt.setSingleLine(true);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager) MainActivity.this.getSystemService(INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(value.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (TextUtils.isEmpty(value.getText().toString())) {
                    value.setError("value cannot be null");
                } else {
                    f1 = Float.parseFloat(value.getText().toString());
                    if (rb1.isChecked()) {
                        Toast.makeText(MainActivity.this, "yeah", Toast.LENGTH_SHORT).show();
                        f1 = (float) (f1 + (f1 * (.05)));
                        calculate(f1);

                    } else if (rb2.isChecked()) {
                        Toast.makeText(MainActivity.this, "yeah2", Toast.LENGTH_SHORT).show();
                        f1 = (float) (f1 + (f1 * (.12)));
                        calculate(f1);
                    } else if (rb3.isChecked()) {
                        Toast.makeText(MainActivity.this, "yeah3", Toast.LENGTH_SHORT).show();
                        f1 = (float) (f1 + (f1 * (.18)));
                        calculate(f1);
                    } else if (rb4.isChecked()) {
                        Toast.makeText(MainActivity.this, "yeah43", Toast.LENGTH_SHORT).show();
                        f1 = (float) (f1 + (f1 * (.28)));

                        calculate(f1);
                    }
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            MainActivity.this.finish();
            return true;
        }

        if (id == R.id.rate_us) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=nextbigdev.ssiet.dell.ssiet")));
            return true;
        }
        if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "The Shri Shankaracharya Institute of Engineering and Technology (SSIET): https://play.google.com/store/apps/details?id=nextbigdev.ssiet.dell.ssiet");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void calculate(float f1) {

        result.setText(f1 + "====");

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder b1 = new AlertDialog.Builder(MainActivity.this);
        b1.setMessage("are you sure to exit");
        b1.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.cancel();
                //startActivity(getIntent());
                //Main2Activity.this.finish();
            }
        });
        b1.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                MainActivity.this.finish();
            }
        });
        b1.show();
    }


    public void btnclk(View view) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
    int id=view.getId();
        switch (id) {
            case R.id.button:
                //Toast.makeText(this, "5%", Toast.LENGTH_SHORT).show();
                intent.putExtra("btn","5");
                startActivity(intent);
                break;
            case R.id.button2:
                Toast.makeText(this, "12%", Toast.LENGTH_SHORT).show();
                intent.putExtra("btn","12");
                startActivity(intent);
                break;
            case R.id.button3:
                Toast.makeText(this, "18%", Toast.LENGTH_SHORT).show();
                intent.putExtra("btn","18");
                startActivity(intent);
                break;

            case R.id.button4:
                Toast.makeText(this, "28%", Toast.LENGTH_SHORT).show();
                intent.putExtra("btn","28");
                startActivity(intent);
                break;

        }

    }
}
