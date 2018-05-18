package in.mjtech.libraries;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimePicker extends android.support.v7.widget.AppCompatEditText implements View.OnClickListener {

    int FORMAT = 0;
    Context context;

    public DateTimePicker(Context context) {
        super(context);
        this.context = context;
        super.setOnClickListener(this);
        super.setFocusable(false);
    }

    public DateTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DateTimePicker);
        FORMAT = a.getInteger(R.styleable.DateTimePicker_format, 0);
        a.recycle();
        this.context = context;
        super.setOnClickListener(this);
        super.setFocusable(false);
    }

    public DateTimePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DateTimePicker);
        FORMAT = a.getInteger(R.styleable.DateTimePicker_format, 0);
        a.recycle();
        this.context = context;
        super.setOnClickListener(this);
        super.setFocusable(false);
    }

    @Override
    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance();
        final int mYear = calendar.get(Calendar.YEAR);
        final int mMonth = calendar.get(Calendar.MONTH);
        final int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        if (FORMAT == 1) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datepicker, int year, int month, int day) {
                    month++;
                    int finalMonth = month;
                    String dateTime = new StringBuilder().append(day).append("-").append(finalMonth).append("-").append(year).toString();
                    try {
                        String dt = new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("d-M-yyyy", Locale.ENGLISH).parse(dateTime));
                        ((EditText) v).setText(dt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } ,mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (FORMAT == 2) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(context,  new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute1) {
                    String dateTime = new StringBuilder().append(hourOfDay).append(":").append(minute1).append(":00").toString();
                    try {
                        String dt = new SimpleDateFormat("HH:mm:ss").format(new SimpleDateFormat("H:m:ss", Locale.ENGLISH).parse(dateTime));
                        ((EditText) v).setText(dt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }, hour, minute, true);
            timePickerDialog.show();
        } else {
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datepicker, final int year, int month, final int day) {
                    month++;
                    final int finalMonth = month;
                    TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute1) {
                            String dateTime = new StringBuilder().append(day).append("-").append(finalMonth).append("-").append(year).append(" ").append(hourOfDay).append(":").append(minute1).append(":00").toString();
                            try {
                                String dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new SimpleDateFormat("d-M-yyyy H:m:ss", Locale.ENGLISH).parse(dateTime));
                                ((EditText) v).setText(dt);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }, hour, minute, true);
                    timePickerDialog.show();
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    public String getDate(String resultFormat) throws ParseException {
        String existingFormat = "dd-MM-yyyy HH:mm:ss";
        if (FORMAT == 1) {
            existingFormat = "dd-MM-yyyy";
        } else if (FORMAT == 2) {
            existingFormat = "HH:mm:ss";
        }
        return new SimpleDateFormat(resultFormat).format(new SimpleDateFormat(existingFormat, Locale.ENGLISH).parse(this.getText().toString()));
    }

    public Date getDate() throws ParseException {
        String existingFormat = "dd-MM-yyyy HH:mm:ss";
        if (FORMAT == 1) {
            existingFormat = "dd-MM-yyyy";
        } else if (FORMAT == 2) {
            existingFormat = "HH:mm:ss";
        }
        return new SimpleDateFormat(existingFormat, Locale.ENGLISH).parse(this.getText().toString());
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    public void setFormat(int f){
        this.FORMAT=f;
    }
    public int getFormat(){
        return this.FORMAT;
    }
}
