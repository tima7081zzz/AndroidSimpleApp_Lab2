package com.example.androidlab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {

    public ContentFragment() {
        super(R.layout.fragment_content);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    public void outputOrder(CharSequence orderedFlowers, CharSequence selectedColor, CharSequence selectedPrice) {
        CharSequence output = String.format("You have made an order! \n Flowers - %s, \n Color - %s," + " \n Price range - %s", orderedFlowers, selectedColor, selectedPrice);

        TextView outputTextView = getView().findViewById(R.id.outputTextView);
        outputTextView.setText(output);
    }

    public void outputNonFilledError(CharSequence fieldName)
    {
        CharSequence output = String.format("Please fill field - %s", fieldName);

        TextView outputTextView = getView().findViewById(R.id.outputTextView);
        outputTextView.setText(output);
    }
}
