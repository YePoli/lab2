package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button button;
    TextView textView;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editText1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    // Выбрано "Count Words"
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String inputText = editText1.getText().toString();
                            text example = new text(inputText);
                            int tokens = example.getCountOfTokens();
                            textView.setText("Results: " + tokens);
                            if (editText1.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this,R.string.Warning,Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                } else {
                    // Выбрано "Count Chars"
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override

                        public void onClick(View v) {
                            String inputText = editText1.getText().toString();
                            int chars = inputText.length();
                            textView.setText("Results: " + chars);
                            if (editText1.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this,R.string.Warning,Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Можно оставить пустым
            }
        });




    }
}
