package edu.utsa.cs3443.project;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ListView list;
    private Button button;
    private Button clearButton;
    private Button homeButton;
    private ArrayAdapter<String> itemsAdapter;

    /**
     * Creates To do list and all its features
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        list = findViewById(R.id.list);
        button = findViewById(R.id.button);
        clearButton = findViewById(R.id.clearButton);
        homeButton = findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(itemsAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removeItem(position);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAllItems();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    /**
     * Removes item from items and itemsAdapter
     * @param position
     */
    private void removeItem(int position) {
        Context context = getApplicationContext();
        items.remove(position);
        itemsAdapter.notifyDataSetChanged();
    }

    /**
     *  Adds an item to itemsAdapter
     * @param view
     */
    private void addItem(View view) {
        EditText input = findViewById(R.id.edit_text);
        String itemText = input.getText().toString();

        if (!itemText.isEmpty()) {
            itemsAdapter.add(itemText);
            input.setText("");
        }
    }

    /**
     * Removes all items fro m items and itemsAdapter
     */
    private void removeAllItems() {
        items.clear();
        itemsAdapter.notifyDataSetChanged();
    }
}