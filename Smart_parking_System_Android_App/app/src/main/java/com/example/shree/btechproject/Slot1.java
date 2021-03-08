package com.example.shree.btechproject;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Slot1 extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    public static final String TAG = "slot1";
    private TextView mDisplayDate;
    private TextView mDisplayTime;
    private TextView slotNo;
    private TextView userName;
    private Button searchButton;
    private Button area1;
    private Button area2;
    private Button area3;
    private Button area4;
    private Button area5;
    private Button area6;
    private Button area7;
    private Button area8;
    private String duration;
    private String UserName;
    private int area,flag=-1;
    /* String[] names ={"30min","1hr","2hr","3hr","4hr"};
     String[] des={"30min","1hr","2hr","3hr","4hr"};*/
    ArrayAdapter<String> adapter;
    Spinner sp;
    TextView description;
    TimePickerDialog timePickerDialog;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String HttpUrl = "http://192.168.43.215/BtechProject/androidcall/Api2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot1);
        Bundle b = getIntent().getExtras();
        mDisplayDate = (TextView) findViewById(R.id.tv);
        mDisplayTime = (TextView) findViewById(R.id.tv3);
        slotNo = (TextView) findViewById(R.id.tv5);
        userName = (TextView) findViewById(R.id.textView2);
        searchButton = (Button) findViewById(R.id.but9);
        area1 = (Button) findViewById(R.id.but10);
        area2 = (Button) findViewById(R.id.but11);
        area3 = (Button) findViewById(R.id.but12);
        area4 = (Button) findViewById(R.id.but13);
        area5 = (Button) findViewById(R.id.but14);
        area6 = (Button) findViewById(R.id.but15);
        area7 = (Button) findViewById(R.id.but16);
        area8 = (Button) findViewById(R.id.but17);
       /* searchButton.setOnClickListener(this);
        area1.setOnClickListener(this);
        area2.setOnClickListener(this);
        area3.setOnClickListener(this);
        area4.setOnClickListener(this);
        area5.setOnClickListener(this);
        area6.setOnClickListener(this);
        area7.setOnClickListener(this);
        area8.setOnClickListener(this);*/
        mDisplayDate.setOnClickListener(this);
        mDisplayTime.setOnClickListener(this);
        slotNo.setText(b.getCharSequence("but5"));
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        userName.setText(String.valueOf(user.getUsername()));
//Toast.makeText(getApplicationContext(),b,Toast.LENGTH_LONG).show();
        requestQueue = Volley.newRequestQueue(Slot1.this);

        progressDialog = new ProgressDialog(Slot1.this);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spn);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("1hr");
        categories.add("2hr");
        categories.add("3hr");
        categories.add("4hr");
        categories.add("5hr");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=1;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area1 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=2;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area2 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=3;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area3 selected", Toast.LENGTH_LONG);
                toast.show(); progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=4;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area4 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=5;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area5 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=6;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area6 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=7;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area7 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        area8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                area=8;flag++;
                Toast toast = Toast.makeText(getApplicationContext(), "Area8 selected", Toast.LENGTH_LONG);
                toast.show();
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                insertBooking();
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user pressed on button register
                //here we will register the user to server
                searchBooking();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        duration = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + duration, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Slot1.this,
                        android.R.style.Theme_DeviceDefault_Wallpaper_NoTitleBar, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //month=month+1;
                        Log.d(TAG, "onDateSet:mm/dd/yyy" + month + "/" + day + "/" + year);
                        //String date= month + "/" + day + "/" + year;
                        mDisplayDate.setText((month + 1) + "/" + day + "/" + year);
                    }
                }, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                dialog.show();


                break;
            case R.id.tv3:
                Calendar cal1 = Calendar.getInstance();
                int _hour = cal1.get(Calendar.HOUR);
                int _minute = cal1.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Slot1.this, android.R.style.Widget_Material_TextView,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour, int minute) {
                                mDisplayTime.setText(hour + ":" + minute);
                            }
                        }, _hour, _minute, true);
                timePickerDialog.show();
                break;
        }
    }
    private void searchBooking(){


    }

    private void insertBooking() {
        final String Date = mDisplayDate.getText().toString().trim();
        final String Time = mDisplayTime.getText().toString().trim();
        final String Duration = duration;
        final String SlotNo = slotNo.getText().toString().trim();
        final String UserName = userName.getText().toString().trim();
        final int F = flag;
        final String Flag = String.valueOf(F);
        final int A = area;
        final String Area = String.valueOf(A);



        //first we will do the validations

        if (TextUtils.isEmpty(Date)) {
            mDisplayDate.setError("Please enter Date");
            mDisplayDate.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Time)) {
            mDisplayTime.setError("Please enter Time");
            mDisplayTime.requestFocus();
            return;
        }


        class InsertClass extends AsyncTask<Object, Object, Void> {

            private ProgressBar progressBar;

            @Override
            protected Void doInBackground(Object... voids) {
                //creating request handler object
                //Toast.makeText(getApplicationContext(), "params ready", Toast.LENGTH_LONG).show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(Slot1.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Slot1.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // RequestHandler requestHandler = new RequestHandler();

                        //creating request parameters
                        HashMap<String, String> params = new HashMap<>();
                        params.put("User", UserName);
                        params.put("SlotNo", SlotNo);
                        params.put("Date", Date);
                        params.put("Time", Time);
                        params.put("Duration", Duration);
                        params.put("Area", Area);
                        params.put("Flag", Flag);


                        //returing the response
                        return params;

                    }
                };
                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(Slot1.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);
                return null;
            }
        }

        InsertClass ic = new InsertClass();
        ic.execute();

    }
}
