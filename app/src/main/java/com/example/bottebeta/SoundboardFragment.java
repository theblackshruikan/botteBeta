package com.example.bottebeta;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.Date;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.bottebeta.databinding.SoundboardFragmentBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoundboardFragment extends Fragment {
    private SoundboardFragmentBinding binding;
    int NOMBRE_SONS_BUTTON_1 = 9;
    int NOMBRE_SONS_BUTTON_2 = 0;
    int NOMBRE_SONS_BUTTON_3 = 3;
    int NOMBRE_SONS_BUTTON_4 = 0;

    MediaPlayer mp;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = SoundboardFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        //prepareButton2(view, savedInstanceState);
        //prepareButton4(view, savedInstanceState);

        prepareButton(view, savedInstanceState, samplesButton1(), NOMBRE_SONS_BUTTON_1, binding.button1);
        prepareButton(view, savedInstanceState, samplesButton3(), NOMBRE_SONS_BUTTON_3, binding.button3);

        /*binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SoundboardFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/testeuralpha")));
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://discord.gg/cJXjNC8")));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private int getRandom(int upperbound) {
        int random = 0;
        Random rand = new Random();
        Date date = new Date();
        long milliSec = date.getTime()/ 100000000000L;

        for (long i = 0; i < milliSec; i++){
            random = rand.nextInt(upperbound);
        }

        return random;
    }

    private void prepareButton(@NonNull View view, Bundle savedInstanceState, List<Integer> samples, int upperbound, Button button){
        super.onViewCreated(view, savedInstanceState);

        int int_random = getRandom(upperbound);
        mp = MediaPlayer.create(getApplicationContext(),samples.get(int_random));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int int_random = getRandom(upperbound);
                mp = MediaPlayer.create(getApplicationContext(),samples.get(int_random));
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                }
                mp.start();

                //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //                        .setAction("Action", null).show();
            }
        });
    }

    private List<Integer> samplesButton1(){
        List<Integer> samples = new ArrayList<>();
        samples.add(R.raw.colis);
        samples.add(R.raw.criss);
        samples.add(R.raw.fuc);
        samples.add(R.raw.mere);
        samples.add(R.raw.sacr);
        samples.add(R.raw.sacracul);
        samples.add(R.raw.sib);
        samples.add(R.raw.taba);
        samples.add(R.raw.weyons);

        return samples;
    }

    private List<Integer> samplesButton3(){
        List<Integer> samples = new ArrayList<>();
        samples.add(R.raw.chanvre);
        samples.add(R.raw.film);
        samples.add(R.raw.quarantaine);

        return samples;
    }

    public Context getApplicationContext() {
        return this.getContext();
    }
}