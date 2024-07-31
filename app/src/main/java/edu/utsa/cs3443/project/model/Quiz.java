package edu.utsa.cs3443.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.res.AssetManager;

import edu.utsa.cs3443.project.QuizActivity;

public class Quiz {
    private String question;
    private String answer;
    private static Quiz instance;
    ArrayList<Quiz> flashcards = new ArrayList<Quiz>();
    ArrayList<Quiz> quizSet = new ArrayList<Quiz>();
    public Quiz(String question,String answer){
        this.question = question;
        this.answer = answer;
    }
    public static synchronized Quiz getInstance() {
        if (instance == null) {
            instance = new Quiz(null,null);
        }
        return instance;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    public String toString(){
        return getQuestion() + "\n" + getAnswer();
    }
    public ArrayList<Quiz> getQuiz(){
        return quizSet;
    }
    public void addQuizQuestion(Quiz quiz){
        quizSet.add(quiz);
    }
    public ArrayList<Quiz> getFlashcardList() {
        return flashcards;
    }

    public void addFlashcard(Quiz flashcard) {
        flashcards.add(flashcard);
    }

    public void clearFlashcards(){
        flashcards.clear();
    }

    public void loadQuestions(QuizActivity activity){
        AssetManager manager = activity.getAssets();
        try {
            InputStream quizFile =manager.open("Questions.csv");
            Scanner scanner = new Scanner(quizFile);
            while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            String question = tokens[0];
            String answer = tokens[1];
            Quiz token = new Quiz(question,answer);
            quizSet.add(token);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
