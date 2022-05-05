package com.example.appactividad;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    //==============================================
    ImageView btnPrev,btnNext,btnPause,btnPlay,imgSong,btnAutor;
    MediaPlayer mediaPlayer;
    double starttime = 0;
    double finaltime = 0;
    Handler myHandler = new Handler();
    SeekBar seekbar;
    TextView txtTiempo, txtDuracion, txtNombre;
    int songs[] = {R.raw.music1g1,R.raw.music2g1,R.raw.music3g1,R.raw.music4g1,R.raw.music5g1};
    int port[] = {R.drawable.g1b1,R.drawable.g1b2,R.drawable.g1b3,R.drawable.g1b4,R.drawable.g1b5};
    String name[] = {"My Buddy Mike - Mad Love","Kygo - Stargazing", "Ehrling - Sunshine", "Ehrling - Lovesick","MBB - Sax"};
    int index=0;
    int oneTimeOnly = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgSong = view.findViewById(R.id.imgSong);
        btnAutor = view.findViewById(R.id.btnAutor);
        btnPrev = view.findViewById(R.id.btnPrev);
        btnNext = view.findViewById(R.id.btnNext);
        btnPause = view.findViewById(R.id.btnPause);
        btnPlay = view.findViewById(R.id.btnPlay);
        txtTiempo = view.findViewById(R.id.txtTiempo);
        txtNombre = view.findViewById(R.id.txtNombre);
        txtDuracion = view.findViewById(R.id.txtDuracion);
        txtNombre.setText(name[index]);
        mediaPlayer = MediaPlayer.create(getActivity(),songs[index]);
        seekbar = view.findViewById(R.id.seekBar);
        imgSong.setBackgroundResource(port[index]);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                finaltime = mediaPlayer.getDuration();
                starttime = mediaPlayer.getCurrentPosition();
                if (oneTimeOnly == 0){
                    seekbar.setMax((int) finaltime);
                    oneTimeOnly = 1;
                }
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );

                txtTiempo.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                        TimeUnit.MILLISECONDS.toSeconds((long) starttime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime)))
                );
                imgSong.setBackgroundResource(port[index]);
                seekbar.setProgress((int) starttime);
                myHandler.postDelayed(UpdateSongTime,100);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index>4)index=0;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getActivity(), songs[index]);
                finaltime = mediaPlayer.getDuration();
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );
                starttime = mediaPlayer.getCurrentPosition();
                txtNombre.setText(name[index]);
                imgSong.setBackgroundResource(port[index]);
                mediaPlayer.start();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index<0)index=4;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getActivity(), songs[index]);
                finaltime = mediaPlayer.getDuration();
                txtDuracion.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finaltime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime)))
                );
                starttime = mediaPlayer.getCurrentPosition();
                txtNombre.setText(name[index]);
                imgSong.setBackgroundResource(port[index]);
                mediaPlayer.start();
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            txtTiempo.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starttime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime)))
            );
            seekbar.setProgress((int) starttime);
            myHandler.postDelayed(this,100);
        }
    };

    public void autor(View view) {
        if (index == 0){
            Uri url = Uri.parse("https://music.youtube.com/channel/UClrogChduUvmxWsg54rpr-g");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 1){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCkhjJ1ozo9YkGtZ2Vl-QpwA");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 2){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCehltvwFEKIuSpJ0ktRxGpQ");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 3){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCehltvwFEKIuSpJ0ktRxGpQ");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        } else if (index == 4){
            Uri url = Uri.parse("https://music.youtube.com/channel/UCaeGVBkdQVb6IC7tTCHFy7A");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        }
    }

}