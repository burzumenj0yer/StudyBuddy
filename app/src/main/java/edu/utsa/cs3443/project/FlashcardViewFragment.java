package edu.utsa.cs3443.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import edu.utsa.cs3443.project.model.Quiz;

public class FlashcardViewFragment extends Fragment {

    private TextView textView;

    public FlashcardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashcard_view, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        ArrayList<Quiz> cards = Quiz.getInstance().getFlashcardList();
        Flashcard_RecyclerviewAdapter adapter = new Flashcard_RecyclerviewAdapter(getActivity(),cards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}
