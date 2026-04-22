package org.baltimorecityschools.gamel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TagActivity extends AppCompatActivity {

    RecyclerView tagRecyclerView;

    TextView tagTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        tagRecyclerView = findViewById(R.id.tagRecyclerView);
        tagTextView = findViewById(R.id.tagTextViewID);

        tagRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        List<Game> tagGameList = new ArrayList<>();
        String tag = getIntent().getStringExtra("tag");

        for (Game game : Allgames.allgames) {
            if (game.getTags() != null && tag != null) {
                for (String gameTag : game.getTags()) {
                    if (gameTag.equals(tag)) {
                        tagGameList.add(game);
                    }
                }
            }
        }
        MyAdapter adapter = new MyAdapter(tagGameList);
        tagRecyclerView.setAdapter(adapter);

        tagTextView.setText(tag);



    }
}