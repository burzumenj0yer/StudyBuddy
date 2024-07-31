package edu.utsa.cs3443.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.utsa.cs3443.project.model.Quiz;

public class Flashcard_RecyclerviewAdapter extends RecyclerView.Adapter<Flashcard_RecyclerviewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Quiz> cards;
    public Flashcard_RecyclerviewAdapter(Context context, ArrayList<Quiz> cards){
        this.context=context;
        this.cards=cards;
    }

    @NonNull
    @Override
    public Flashcard_RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.flashcard_recycler_view,parent,false);
        return new Flashcard_RecyclerviewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Flashcard_RecyclerviewAdapter.MyViewHolder holder, int position) {
        holder.question.setText(cards.get(position).getQuestion());
        holder.answer.setText(cards.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView question,answer;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textView);
            answer = itemView.findViewById(R.id.textView2);
        }
    }
}
