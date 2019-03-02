package com.iamimrankhan95.ticktactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.GridLayout;
public class MainActivity extends AppCompatActivity {
    static int activePlayer=0;
    int[] position={2,2,2,2,2,2,2,2,2};
    int[][] winningSequence={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    protected void placeMark(View view){
        ImageView imageView= (ImageView) view;
        int playedPosition=Integer.parseInt(view.getTag().toString());
        System.out.println(playedPosition);
        if(position[playedPosition]==2){

            imageView.setTranslationX(-1000f);
            position[playedPosition]=activePlayer;
            if(activePlayer==0){


                imageView.setImageResource(R.drawable.x);
                boolean isWinning;
                for(int x=0;x<8;x++){
                    isWinning=true;
                    for(int y=0;y<3;y++){
                        if(position[winningSequence[x][y]] !=activePlayer){
                            isWinning=false;
                            break;
                        }

                    }
                    if(isWinning==true){
                        System.out.println("won");
                        Toast.makeText(this, " 'X' won!",
                                Toast.LENGTH_LONG).show();
                        for(int a=0;a<position.length;a++){
                            position[a]=activePlayer;
                        }
                        break;
                    }
                }
                activePlayer=1;
            }else{
                boolean isWinning;
                for(int x=0;x<8;x++){
                    isWinning=true;
                    for(int y=0;y<3;y++){
                        if(position[winningSequence[x][y]] !=activePlayer){
                            isWinning=false;
                            break;
                        }

                    }
                    if(isWinning==true){
                        System.out.println("won");
                        Toast.makeText(this, " 'O' won!",
                                Toast.LENGTH_LONG).show();
                        for(int a=0;a<position.length;a++){
                            position[a]=activePlayer;
                        }
                        break;
                    }
                }

                imageView.setImageResource(R.drawable.red);
                activePlayer=0;
            }
            imageView.animate().translationXBy(1000f).rotationBy(360).setDuration(300);
            for(int a=0;a<position.length;a++){
                System.out.print(position[a]);
                System.out.print(", ");
            }System.out.println();


        }

    }
    protected void restart(View view){
        System.out.println("restart");

        GridLayout yourLayout = findViewById(R.id.gridLayout);
        cout(String.valueOf(yourLayout.getChildCount()));
        for (int i = 0; i < yourLayout .getChildCount(); i++) {

            View subView = yourLayout .getChildAt(i);

            if (subView instanceof ImageView) {
                ImageView imageView = (ImageView) subView;
                //manipulate the imageView
                imageView.setImageResource(android.R.color.transparent);

            }
        }
        for(int a=0;a<position.length;a++){
            position[a]=2;
        }
    }
    protected void cout(String  x){
        System.out.println(x);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
