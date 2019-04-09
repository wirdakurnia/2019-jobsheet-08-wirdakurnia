package com.wirda61.wirdakurnia.tugasretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wirda61.wirdakurnia.tugasretrofit.generator.ServiceGenerator;
import com.wirda61.wirdakurnia.tugasretrofit.model.Fox;
import com.wirda61.wirdakurnia.tugasretrofit.services.FoxsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private ImageView iconImage;
    private FoxsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconImage = findViewById(R.id.image_icon);
        service = ServiceGenerator.createService(FoxsService.class);

        Button moreButton = findViewById(R.id.button_more);

        moreFox();

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreFox();
            }
        });
    }

    private void moreFox() {
        Call<Fox> foxResponse = service.getRandomFox();
        foxResponse.enqueue(new Callback<Fox>() {
            @Override
            public void onResponse(Call<Fox> call, Response<Fox> response) {
                Fox fox = response.body();
                Picasso.get().load(fox.getImage()).into(iconImage);
            }

            @Override
            public void onFailure(Call<Fox> call, Throwable t) {
                Log.e(TAG, t.toString());
                String message = "Failed to get more fox, please check your connection.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
