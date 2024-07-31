package edu.utsa.cs3443.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.utsa.cs3443.project.model.Quiz;

public class FlashcardAddFragment extends Fragment {

    private EditText questionInput, answerInput;
    private Button button,button2;

    public FlashcardAddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashcard_add, container, false);
        questionInput = view.findViewById(R.id.editTextText);
        answerInput = view.findViewById(R.id.editTextText2);
        button = view.findViewById(R.id.addCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = questionInput.getText().toString();
                String answer = answerInput.getText().toString();
                Quiz card = new Quiz(question, answer);
                Quiz.getInstance().addFlashcard(card);
            }
        });

        button2 = view.findViewById(R.id.clearCard);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quiz.getInstance().clearFlashcards();
            }
        });
        return view;
    }
}
