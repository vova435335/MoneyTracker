package com.vld.moneytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    private EditText name;
    private EditText price;
    private EditText ruble;
    private Button addButton;

    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        setTitle(R.string.add_item_title);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        ruble = findViewById(R.id.ruble);
        addButton = findViewById(R.id.add_button);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(name.getText().length() != 0 && price.getText().length() != 0){
                    addButton.setEnabled(true);
                } else {
                    addButton.setEnabled(false);
                }

                if(price.getText().length() != 0){
                    ruble.setText(R.string.ruble);
                } else {
                    ruble.setText("");
                }
            }
        };

        name.addTextChangedListener(textWatcher);
        price.addTextChangedListener(textWatcher);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = name.getText().toString();
                String itemPrice = price.getText().toString();
            }
        });

    }
}
