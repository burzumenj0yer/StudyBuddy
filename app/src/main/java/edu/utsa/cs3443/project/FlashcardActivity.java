package edu.utsa.cs3443.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlashcardActivity extends AppCompatActivity {

    private Button button, button2, button3;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        button = findViewById(R.id.button);
        button.setText("Add Flashcards");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, new FlashcardAddFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setText("View Flashcards");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, new FlashcardViewFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
