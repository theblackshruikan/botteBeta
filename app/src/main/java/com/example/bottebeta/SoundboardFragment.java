package com.example.bottebeta;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.bottebeta.databinding.SoundboardFragmentBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoundboardFragment extends Fragment {

private SoundboardFragmentBinding binding;
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
        super.onViewCreated(view, savedInstanceState);
        List<Integer> samples = new ArrayList<>();
        samples.add(R.raw.mehr);
        samples.add(R.raw.pussy);
        samples.add(R.raw.liebe);
        int upperbound = 3;
        Random rand = new Random();

        mp = MediaPlayer.create(getApplicationContext(), samples.get(0));


        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    int int_random = rand.nextInt(upperbound);
                    mp = MediaPlayer.create(getApplicationContext(),samples.get(int_random));
                }
                mp.start();

                //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //                        .setAction("Action", null).show();
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SoundboardFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public Context getApplicationContext() {
        return this.getContext();
    }
@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}