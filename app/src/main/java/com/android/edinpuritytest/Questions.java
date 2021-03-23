package com.android.edinpuritytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Questions extends Activity {

    public static int score = 100;
    Button clearBtn, calcBtn;
    MyCustomAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        clearBtn = (Button)findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=100;
                displayListView();
            }
        });

        calcBtn = (Button)findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreActivity();
            }
        });

        //Generate list View from ArrayList
        displayListView();
    }

    public void displayListView()
    {
        ArrayList<Question> questionList = new ArrayList<Question>();
        Question ques = new Question("1", "1. Been on a date?", false);
        questionList.add(ques);
        ques = new Question("2", "2. Been in a relationship?", false);
        questionList.add(ques);
        ques = new Question("3", "3. Been in love?", false);
        questionList.add(ques);
        ques = new Question("4", "4. Been in a long-distance relationship?", false);
        questionList.add(ques);
        ques = new Question("5", "5. Kissed a non-family member on the lips?", false);
        questionList.add(ques);
        ques = new Question("6", "6. Made out in public?", false);
        questionList.add(ques);
        ques = new Question("7", "7. Kissed horizontally?", false);
        questionList.add(ques);
        ques = new Question("8", "8. Made out with more than 3 people in one night?", false);
        questionList.add(ques);
        ques = new Question("9", "9. Messed with the fire alarms in a student accommodations?", false);
        questionList.add(ques);
        ques = new Question("10", "10. Have your party shut down by the police?", false);
        questionList.add(ques);
        ques = new Question("11", "11. Had a party in the tunnels?", false);
        questionList.add(ques);
        ques = new Question("12", "12. Partied in all the student accommodations?", false);
        questionList.add(ques);
        ques = new Question("13", "13. Attended a theme party hosted by a student?", false);
        questionList.add(ques);
        ques = new Question("14", "14. Went club crawling?", false);
        questionList.add(ques);
        ques = new Question("15", "15. Bribed a bouncer to get into a party?", false);
        questionList.add(ques);
        ques = new Question("16", "16. Cheated on an exam?", false);
        questionList.add(ques);
        ques = new Question("17", "17. Did not attend any classes for more than a week?", false);
        questionList.add(ques);
        ques = new Question("18", "18. Had Covid-19?", false);
        questionList.add(ques);
        ques = new Question("19", "19. Snuck out of your house?", false);
        questionList.add(ques);
        ques = new Question("20", "20. Came to Edinburgh because Oxbridge rejected you?", false);
        questionList.add(ques);
        ques = new Question("21", "21. Been inside the Castle? (and failed your course? Or not.", false);
        questionList.add(ques);
        ques = new Question("22", "22. Stolen the JMCC letters when drunk? (If not, make it a tradition)", false);
        questionList.add(ques);
        ques = new Question("23", "23. Streaked in a student accommodation?", false);
        questionList.add(ques);
        ques = new Question("24", "24. Went skinny dipping in Portebello beach?", false);
        questionList.add(ques);
        ques = new Question("25", "25. Seen a stripper?", false);
        questionList.add(ques);
        ques = new Question("26", "26. Vandalized University property?", false);
        questionList.add(ques);
        ques = new Question("27", "27. Played a drinking game?", false);
        questionList.add(ques);
        ques = new Question("28", "28. Played a game involving stripping?", false);
        questionList.add(ques);
        ques = new Question("29", "29. Been naked while playing truth or dare?", false);
        questionList.add(ques);
        ques = new Question("30", "30. Been drunk?", false);
        questionList.add(ques);
        ques = new Question("31", "31. Woke up in your own puke?", false);
        questionList.add(ques);
        ques = new Question("32", "32. Been drunk on Arthur's Seat?", false);
        questionList.add(ques);
        ques = new Question("33", "33. Been blackout drunk?", false);
        questionList.add(ques);
        ques = new Question("34", "34. Faked sobriety to teachers or parents?", false);
        questionList.add(ques);
        ques = new Question("35", "35. Masturbated?", false);
        questionList.add(ques);
        ques = new Question("36", "36. Masturbated with an inanimate object?", false);
        questionList.add(ques);
        ques = new Question("37", "37. Been caught masturbating?", false);
        questionList.add(ques);
        ques = new Question("38", "38. Given/received a hickey?", false);
        questionList.add(ques);
        ques = new Question("39", "39. Had/given blue balls?", false);
        questionList.add(ques);
        ques = new Question("40", "40. Used a sex toy in bed?", false);
        questionList.add(ques);
        ques = new Question("41", "41. Been walked in on while engaging in a sexual act?", false);
        questionList.add(ques);
        ques = new Question("42", "42. Sent/received underwear pictures?", false);
        questionList.add(ques);
        ques = new Question("43", "43. Sent/received nudes?", false);
        questionList.add(ques);
        ques = new Question("44", "44. Sexted/phone sex?", false);
        questionList.add(ques);
        ques = new Question("45", "45. Seen or read pornographic material?", false);
        questionList.add(ques);
        ques = new Question("46", "46. Paid for porn?", false);
        questionList.add(ques);
        ques = new Question("47", "47. Watched porn with MPS? (Member of Preferred Sex)", false);
        questionList.add(ques);
        ques = new Question("48", "48. Showered with MPS?", false);
        questionList.add(ques);
        ques = new Question("49", "49. Spent the night with MPS?", false);
        questionList.add(ques);
        ques = new Question("50", "50. Given head?", false);
        questionList.add(ques);
        ques = new Question("51", "51. Received head?", false);
        questionList.add(ques);
        ques = new Question("52", "52. Someone else made you orgasm?", false);
        questionList.add(ques);
        ques = new Question("53", "53. Bought birth control", false);
        questionList.add(ques);
        ques = new Question("54", "54. Had sex?", false);
        questionList.add(ques);
        ques = new Question("55", "55. Have an unusual fetish?", false);
        questionList.add(ques);
        ques = new Question("56", "56. Had BDSM sex?", false);
        questionList.add(ques);
        ques = new Question("57", "57. Explored your sexuality at University?", false);
        questionList.add(ques);
        ques = new Question("58", "58. Had sex 3 or more times in a night?", false);
        questionList.add(ques);
        ques = new Question("59", "59. Car sex?", false);
        questionList.add(ques);
        ques = new Question("60", "60. Had sex outdoors?", false);
        questionList.add(ques);
        ques = new Question("61", "61. Had sex in public?", false);
        questionList.add(ques);
        ques = new Question("62", "62. Had sex with an RA/Warden/CST?", false);
        questionList.add(ques);
        ques = new Question("63", "63. Had sex in the University Library?", false);
        questionList.add(ques);
        ques = new Question("64", "64. Engaged in a sexual activity during class?", false);
        questionList.add(ques);
        ques = new Question("65", "65. Used handcuffs/blindfolds?", false);
        questionList.add(ques);
        ques = new Question("66", "66. Joined the mile high club?", false);
        questionList.add(ques);
        ques = new Question("67", "67. Had a threesome?", false);
        questionList.add(ques);
        ques = new Question("68", "68. Had an orgy?", false);
        questionList.add(ques);
        ques = new Question("69", "69. ?", false);
        questionList.add(ques);
        ques = new Question("70", "70. Had STI/STD test?", false);
        questionList.add(ques);
        ques = new Question("71", "71. Body count is greater than 5?", false);
        questionList.add(ques);
        ques = new Question("72", "72. Had a sex tape of you made?", false);
        questionList.add(ques);
        ques = new Question("73", "73. Had period sex?", false);
        questionList.add(ques);
        ques = new Question("74", "74. Had anal sex?", false);
        questionList.add(ques);
        ques = new Question("75", "75. Bought a pregnancy test?", false);
        questionList.add(ques);
        ques = new Question("76", "76. Been/gotten someone pregnant?", false);
        questionList.add(ques);
        ques = new Question("77", "77. Had a crush on a teacher?", false);
        questionList.add(ques);
        ques = new Question("78", "78. Slept with a professor for marks?", false);
        questionList.add(ques);
        ques = new Question("79", "79. Gotten with 2+ people in the same group?", false);
        questionList.add(ques);
        ques = new Question("80", "80. Had sex with a stranger you met within 24 hours?", false);
        questionList.add(ques);
        ques = new Question("81", "81. Can't remember the name of the person you last slept with?", false);
        questionList.add(ques);
        ques = new Question("82", "82. Cheated/cheated with/cheated on??", false);
        questionList.add(ques);
        ques = new Question("83", "83. Gotten back/hooked up with an ex?", false);
        questionList.add(ques);
        ques = new Question("84", "84. Had a friends with benefits?", false);
        questionList.add(ques);
        ques = new Question("85", "85. Walked an hour or more to get drugs?", false);
        questionList.add(ques);
        ques = new Question("86", "86. Smoked weed in the tunnels?", false);
        questionList.add(ques);
        ques = new Question("87", "87. Gotten high on Arthur's Seat?", false);
        questionList.add(ques);
        ques = new Question("88", "88. Walked in front of the police high?", false);
        questionList.add(ques);
        ques = new Question("89", "89. Done edibles?", false);
        questionList.add(ques);
        ques = new Question("90", "90. Hit a bong?", false);
        questionList.add(ques);
        ques = new Question("91", "91. Been cross-faded?", false);
        questionList.add(ques);
        ques = new Question("92", "92. Attended a class high/drunk?", false);
        questionList.add(ques);
        ques = new Question("93", "93. Played sports high/drunk?", false);
        questionList.add(ques);
        ques = new Question("94", "94. Driven high/drunk?", false);
        questionList.add(ques);
        ques = new Question("95", "95. Drugs stronger than weed?", false);
        questionList.add(ques);
        ques = new Question("96", "96. LSD/MDMA at a rave?", false);
        questionList.add(ques);
        ques = new Question("97", "97. Had a fake ID?", false);
        questionList.add(ques);
        ques = new Question("98", "98. Had your fake ID confiscated by the police?", false);
        questionList.add(ques);
        ques = new Question("99", "99. Had the police called on you?", false);
        questionList.add(ques);
        ques = new Question("100", "100. Ran from the police?", false);
        questionList.add(ques);

        dataAdapter = new MyCustomAdapter(this, R.layout.question_info, questionList);
        ListView listView = (ListView) findViewById(R.id.qList);
        listView.setAdapter(dataAdapter);


    }

    private class MyCustomAdapter extends ArrayAdapter<Question>
    {
        private ArrayList<Question> questionList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Question> questionList) {
            super(context, textViewResourceId, questionList);
            this.questionList = new ArrayList<Question>();
            this.questionList.addAll(questionList);
        }

        private class ViewHolder {
            TextView num;
            CheckBox question;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if(convertView==null)
            {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.question_info, null);

                holder = new ViewHolder();
                holder.num = (TextView) convertView.findViewById(R.id.num);
                holder.question = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.question.setOnClickListener( new View.OnClickListener() {

                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Question question = (Question) cb.getTag();
                        question.setSelected(cb.isChecked());

                        checkScore(question);
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Question question = questionList.get(position);
            holder.question.setText(" (" +  question.getNum() + ")");
            holder.question.setText(question.getQuestion());
            holder.question.setChecked(question.isSelected());
            holder.question.setTag(question);

            return convertView;
        }
    }

    public void openScoreActivity(){
        Intent intent = new Intent(this, ScoreScreen.class);
        startActivity(intent);
    }

    public void checkScore(Question ques)
    {
        if(ques.isSelected())
            score--;
        else
            score++;
    }

}

