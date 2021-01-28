package com.example.cyrex;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.media.Image;
import android.media.SubtitleData;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.w3c.dom.Text;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main);
        getIncomingIntent();
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra(("imageB")) && getIntent().hasExtra("title") ){
            String title = getIntent().getStringExtra("title");
            int imageB = getIntent().getIntExtra("imageB",1);
            String subText = getIntent().getStringExtra("subText");
            String subText2 = getIntent().getStringExtra("subText2");
            String desc = getIntent().getStringExtra("description");
            String trailer = getIntent().getStringExtra("trailer");
            String youtubeId = getIntent().getStringExtra("youtubeId");
            String url = getIntent().getStringExtra("web_url");
            setImage(imageB,title,subText,subText2,desc,trailer,youtubeId, url);
        }
    }
    private void setImage(int imageB, String title, String subtext, String subtext2, String desc,String trailer,String youtubeId, String URL){
        TextView aTitle = findViewById(R.id.synopsis);
        aTitle.setText(title);
        ImageView image = findViewById(R.id.coverImage);
        image.setImageResource(imageB);
        TextView SubText = findViewById(R.id.subText);
        SubText.setText(subtext);
        TextView SubText2 = findViewById(R.id.subText2);
        SubText2.setText(subtext2);
        TextView Desc = findViewById(R.id.description);
        Desc.setText(desc);
        TextView trailers = findViewById(R.id.trailer);
        trailers.setText(trailer);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo(youtubeId, 0);

            }
        });
        Button btn = findViewById(R.id.Button);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
            startActivity(intent);
        });
        RatingBar ratingBar = findViewById(R.id.ratingBar2);
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) ->
                Toast.makeText(getApplicationContext(), "You have already rated", Toast.LENGTH_SHORT).show());
    }
}
