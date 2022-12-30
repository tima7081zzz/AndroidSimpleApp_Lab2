package com.example.androidlab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String NoneValue = "None";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        addOnClickListenerOnOutput();
    }


    private void addOnClickListenerOnOutput() {
        Button okButton = findViewById(R.id.response_button);
        okButton.setOnClickListener(v -> {

            ContentFragment fragment = (ContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
            if (fragment == null) {
                return;
            }

            try {
                CharSequence orderedFlowers = getEditTestValueById(R.id.flower);
                CharSequence selectedPrice = getSelectButtonTextByRadioGroupId(R.id.priceRadioGroup);
                CharSequence selectedColor = getSelectButtonTextByRadioGroupId(R.id.colorRadioGroup);

                fragment.outputOrder(orderedFlowers, selectedPrice, selectedColor);

            } catch (NonFilledException e) {
                fragment.outputNonFilledError(e.getMessage());
            }
        });
    }

    @NonNull
    private CharSequence getSelectButtonTextByRadioGroupId(int radioGroupId) throws NonFilledException {
        RadioGroup radioGroup = findViewById(radioGroupId);
        RadioButton selectedButton = findViewById(radioGroup.getCheckedRadioButtonId());

        if (selectedButton == null) {
            throw new NonFilledException(getRequiredFieldNameByRadioGroupId(radioGroupId));
        }

        return selectedButton.getText();
    }

    private CharSequence getEditTestValueById(int id) throws NonFilledException {
        CharSequence orderedFlowers = ((EditText) findViewById(id)).getText();
        if (orderedFlowers.length() == 0) {
            throw new NonFilledException("flower name");
        }

        return orderedFlowers;
    }

    private String getRequiredFieldNameByRadioGroupId(int id) {
        switch (id) {
            case R.id.priceRadioGroup:
                return "price";
            case R.id.colorRadioGroup:
                return "color";
        }
        return NoneValue;
    }
}