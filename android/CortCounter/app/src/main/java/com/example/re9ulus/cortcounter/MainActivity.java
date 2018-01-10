package com.example.re9ulus.cortcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teamAPlusThreePoints(View view) {
        team_a_score += 3;
        updateTeamAScore();
    }

    public void teamAPlusTwoPoints(View view) {
        team_a_score += 2;
        updateTeamAScore();
    }

    public void teamAFreeThrow(View view) {
        team_a_score += 1;
        updateTeamAScore();
    }

    private void updateTeamBScore() {
        TextView team_b_score_view = (TextView) findViewById(R.id.team_b_score);
        team_b_score_view.setText("" + team_b_score);
    }

    public void teamBPlusThreePoints(View view) {
        team_b_score += 3;
        updateTeamBScore();
    }

    public void teamBPlusTwoPoints(View view) {
        team_b_score += 2;
        updateTeamBScore();
    }

    public void teamBFreeThrow(View view) {
        team_b_score += 1;
        updateTeamBScore();
    }

    private void updateTeamAScore() {
        TextView team_a_score_view = (TextView) findViewById(R.id.team_a_score);
        team_a_score_view.setText("" + team_a_score);
    }

    public void resetScores(View view) {
        team_a_score = 0;
        team_b_score = 0;
        updateTeamAScore();
        updateTeamBScore();
    }

    private int team_a_score = 0;
    private int team_b_score = 0;
}
