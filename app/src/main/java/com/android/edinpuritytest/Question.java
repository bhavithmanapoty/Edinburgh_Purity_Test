package com.android.edinpuritytest;

public class Question {
    String num = null;
    String question = null;
    boolean selected = false;

    public Question(String num, String question, boolean selected) {
        super();
        this.num = num;
        this.question = question;
        this.selected = selected;
    }

    public String getNum() {
        return num;
    }
    public void setCode(String num) {
        this.num = num;
    }
    public String getQuestion() {
        return question;
    }
    public void setName(String question) {
        this.question = question;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
