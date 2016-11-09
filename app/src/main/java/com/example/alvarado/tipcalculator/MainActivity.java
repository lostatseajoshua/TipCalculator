package com.example.alvarado.tipcalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayTipAmountFromView(String billText, String tipText) {
        Double billAmount = null;
        Double tipPercentage = null;

        try {
            billAmount = Double.parseDouble(billText);
        } catch (NumberFormatException e) {
            displayInvalidInputToast("Bill Amount");
        }

        try {
            tipPercentage = Double.parseDouble(tipText);
        } catch (NumberFormatException e) {
            displayInvalidInputToast("Tip Amount");
        }

        if (billAmount != null && tipPercentage != null) {
            double tip = TipCalculator.getPercentageOfNumber(tipPercentage, billAmount);
            TextView tipTextView = (TextView) findViewById(R.id.tipTextView);
            tipTextView.setText(String.format("%.0f", tipPercentage) + "% tip for $" + String.format("%.2f", billAmount)  + " is: $" + String.format("%.2f", tip));
        }
    }

    private void displayInvalidInputToast(String forView) {
        Toast.makeText(this, "Invalid input " + forView, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    private String getBillAmountFromView() {
        EditText billEditText = (EditText) findViewById(R.id.billAmountEditText);
        return billEditText.getText().toString();
    }

    @NonNull
    private String getTipPercentageView() {
        EditText tipEditText = (EditText) findViewById(R.id.tipAmountEditText);
        return tipEditText.getText().toString();
    }

    public void onCalculateButtonTap(View view) {
        displayTipAmountFromView(getBillAmountFromView(), getTipPercentageView());
    }
}
