package com.example.liuhaiyang.materialdesignanimation.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuhaiyang.materialdesignanimation.R;
import com.example.liuhaiyang.materialdesignanimation.adapter.ShareElementAdapter;
import com.example.liuhaiyang.materialdesignanimation.model.ShareElementModel;

import java.util.ArrayList;
import java.util.List;

public class ShareElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShareElementAdapter adapter = new ShareElementAdapter(this);
        adapter.setLoaclListener(new ShareElementAdapter.OnElementItemClickListener() {
            @Override
            public void onElementItemClick(ImageView imageView, TextView textView, ShareElementModel model) {

                Intent intent = new Intent(ShareElementActivity.this, ShareElementDetailActivity.class);
                intent.putExtra("model", model);
//                Pair<View, String> pair1 = new Pair<View, String>(imageView, getString(R.string.shareElement_img));
//                Pair<View, String> pair2 = new Pair<View, String>(textView, getString(R.string.shareElement_txt));
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ShareElementActivity.this, pair1, pair2);

                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(ShareElementActivity.this, imageView, getString(R.string.shareElement_img));

                startActivity(intent, options.toBundle());
            }
        });
        recyclerView.setAdapter(adapter);


        List<ShareElementModel> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ShareElementModel model = new ShareElementModel();
            switch (i) {
                case 0:
                    model.imgRecorce = R.drawable.ic_android_black_24dp;
                    model.name = "Android Project";
                    break;
                case 1:
                    model.imgRecorce = R.drawable.ic_language_black_24dp;
                    model.name = "Google 地球";
                    break;
                case 2:
                    model.imgRecorce = R.drawable.ic_settings_black_24dp;
                    model.name = "Android 设置";
                    break;
                case 3:
                    model.imgRecorce = R.drawable.ic_shop_black_24dp;
                    model.name = "Google Play";
                    break;
            }
            list.add(model);
        }
        adapter.setmDatas(list);
    }

    private void setData() {

    }
}
