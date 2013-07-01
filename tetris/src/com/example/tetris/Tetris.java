package com.example.tetris;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tetris extends Activity {
        
        private TetrisTileView mTetrisView;
       // private TetrisTileView mTetrisView1;
        
        private Button mStartButton;
        private Button mPauseButton;
        private Button mResumeButton;
        private Button mResetButton;
        //private TextView highscore;
        private TextView playerscore;
        
        
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);

        
        mTetrisView = (TetrisTileView) findViewById(R.id.tetris_tile_view);        
        mStartButton = (Button) findViewById(R.id.start_button);
        mStartButton.setFocusable(false);
        mPauseButton = (Button) findViewById(R.id.pause_button);
        mPauseButton.setFocusable(false);
        mPauseButton.setVisibility(View.INVISIBLE);
        mResumeButton = (Button) findViewById(R.id.resume_button);
        mResumeButton.setFocusable(false);
        mResumeButton.setVisibility(View.INVISIBLE);
        mResetButton = (Button) findViewById(R.id.reset_button);
        mResetButton.setFocusable(false);
        //highscore=(TextView) findViewById(R.id.high_score);
        playerscore=(TextView) findViewById(R.id.player_score);
        mResetButton.setVisibility(View.INVISIBLE);
        
        mStartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                mPauseButton.setVisibility(View.VISIBLE);
                mResetButton.setVisibility(View.VISIBLE);                
                String player_score="SCORE "+mTetrisView.player_score;
                playerscore.setText(player_score);
                playerscore.setVisibility(View.VISIBLE);
                mTetrisView.setMode(TetrisTileView.RUNNING);
            }
        });
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                mResumeButton.setVisibility(View.VISIBLE);
                mResetButton.setVisibility(View.VISIBLE);
                String player_score="SCORE "+mTetrisView.player_score;
                playerscore.setText(player_score);                
                playerscore.setVisibility(View.VISIBLE);
                //highscore.setVisibility(View.VISIBLE);
                mTetrisView.setMode(TetrisTileView.PAUSE);
            }
        });
        mResumeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                mPauseButton.setVisibility(View.VISIBLE);
                String player_score="SCORE "+mTetrisView.player_score;
                playerscore.setText(player_score);                
                playerscore.setVisibility(View.VISIBLE);                
                mTetrisView.setMode(TetrisTileView.RUNNING); 
            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                mStartButton.setVisibility(View.VISIBLE);
                mResumeButton.setVisibility(View.INVISIBLE);
                mPauseButton.setVisibility(View.INVISIBLE);
                String player_score="SCORE "+mTetrisView.player_score;
                playerscore.setText(player_score);                
                playerscore.setVisibility(View.VISIBLE);                
                TetrisTileView.mPlayerCount = 0;
                TetrisTileView.mFinishedPlayerCount = 0;                
                mTetrisView.setMode(TetrisTileView.READY);
            }
        });
        
        TetrisTileView.setButtons(mResetButton, mPauseButton);
        
        if (savedInstanceState == null) {
            // We were just launched -- set up a new game
                mTetrisView.setMode(TetrisTileView.READY);
                mTetrisView.setControlMethod(TetrisTileView.CONTROL_TOUCH);
        } else {
            // We are being restored
 
        }
    }
}
