package edu.utsa.cs3443.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.cardButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchFlashcard();
            }
        });

        button2= findViewById(R.id.quizButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchQuiz();
            }
        });

        button3=findViewById(R.id.todoButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            launchList();
            }
        });
    }
    public void launchFlashcard(){
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
    }
    public void launchQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
    public void launchList(){
        Intent intent = new Intent(this, ToDoActivity.class);
        startActivity(intent);
    }
}