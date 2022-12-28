package com.example.androidlab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CharSequence NoneValue = "None";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addOnClickListenerOnOutput();
    }

    private void addOnClickListenerOnOutput()    {
        Button okButton = findViewById(R.id.response_button);
        okButton.setOnClickListener(view -> {
            CharSequence orderedFlowers = ((EditText) findViewById(R.id.flower)).getText();
            if (orderedFlowers.length() == 0)
            {
                orderedFlowers = NoneValue;a
            }
            CharSequence selectedPrice = getSelectButtonTextByRadioGroupId(R.id.priceRadioGroup);
            CharSequence selectedColor = getSelectButtonTextByRadioGroupId(R.id.colorRadioGroup);

            CharSequence output = String.format("You have made an order! \n Flowers - %s, \n Color - %s," +
                    " \n Price range - %s", orderedFlowers, selectedColor, selectedPrice);

            TextView outputTextView = findViewById(R.id.outputTextView);
            outputTextView.setText(output);
        });
    }

    @NonNull
    private CharSequence getSelectButtonTextByRadioGroupId(int radioGroupId)    {
        RadioGroup radioGroup = findViewById(radioGroupId);
        RadioButton selectedButton = findViewById(radioGroup.getCheckedRadioButtonId());

        return selectedButton == null ? NoneValue : selectedButton.getText();
    }

}
