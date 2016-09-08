package com.tutor93.tugasfrensky;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by indra on 08/09/2016.
 */
public class Add_employee extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private EditText edJoinDate;
    private Button adCamera;
    private ImageView mProfile_pict;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);

        edJoinDate = (EditText) findViewById(R.id.addemployee_joindate);
        adCamera = (Button) findViewById(R.id.add_picture);
        mProfile_pict = (ImageView) findViewById(R.id.profile_pict);

        adCamera.setOnClickListener(this);

        edJoinDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Add_employee.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        edJoinDate.setText(date);
    }

    /*ambil camera source developer.android
    * fungsi: ambil camera dari
    *
    * inget inget... bisi butuh
    * */
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mProfile_pict.setImageBitmap(imageBitmap);
        }
    }
    /*ambil camera dari */

    @Override
    public void onClick(View view) {
        if(view == adCamera){
            dispatchTakePictureIntent();
        }else{

        }
    }
}
