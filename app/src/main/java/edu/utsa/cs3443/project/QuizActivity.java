package edu.utsa.cs3443.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import edu.utsa.cs3443.project.model.Quiz;

public class QuizActivity extends AppCompatActivity {
    private ArrayList<Quiz> quizSet = new ArrayList<Quiz>();
    private Quiz quizObj = new Quiz("","");
    private int currentIndex = 0;
    private int correct = 0;
    private String check;
    Button button, button2,button3;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizObj.loadQuestions(this);
        quizSet = quizObj.getQuiz();
        textView = findViewById(R.id.textView5);
        editText = findViewById(R.id.editTextTextMultiLine);
        button = findViewById(R.id.button4);
        button2 = findViewById(R.id.button6);
        button3 = findViewById(R.id.button7);
        textView.setText(quizSet.get(currentIndex).getQuestion());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if(currentIndex < quizSet.size()){
                    textView.setText(quizSet.get(currentIndex).getQuestion());
                } else {
                    textView.setText("Quiz finished\nYou got "+ correct +" questions correct");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = editText.getText().toString();
                if(check.equals(quizSet.get(currentIndex).getAnswer()) == true){
                    textView.setText("Correct!");
                    correct++;
                } else {
                    textView.setText("Incorrect, correct answer was:\n" + quizSet.get(currentIndex).getAnswer());
                }
            }
        });
    }
}