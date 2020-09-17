package com.vld.moneytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class AddItemActivity extends AppCompatActivity {

    public static final String TYPE_KEY = "type";

    private EditText name;
    private EditText price;
    private TextView ruble;
    private Button addButton;

    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.add_item_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        ruble = findViewById(R.id.ruble);
        addButton = findViewById(R.id.add_button);

        type = getIntent().getStringExtra(TYPE_KEY);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                addButton.setEnabled(
                        name.getText().length() != 0 && price.getText().length() != 0
                );

                if (price.getText().length() != 0) {
                    ruble.setTextColor(Color.BLACK);
                } else {
                    ruble.setTextColor(R.color.colorHint);
                }
            }
        };

        name.addTextChangedListener(textWatcher);
        price.addTextChangedListener(textWatcher);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = name.getText().toString();
                String priceValue = price.getText().toString();

                Item item = new Item(nameValue, priceValue, type);

                Intent intent = new Intent();
                intent.putExtra("item", item);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
