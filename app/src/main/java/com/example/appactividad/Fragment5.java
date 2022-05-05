package com.example.appactividad;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment5.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment5 newInstance(String param1, String param2) {
        Fragment5 fragment = new Fragment5();
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
        return inflater.inflate(R.layout.fragment_5, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton ib1 = view.findViewById(R.id.bnb);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","BNB");
                startActivity(intent);
            }
        });
        ImageButton ib2 = view.findViewById(R.id.avax);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","AVAX");
                startActivity(intent);
            }
        });
        ImageButton ib3 = view.findViewById(R.id.atom);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","ATOM");
                startActivity(intent);
            }
        });
        ImageButton ib4 = view.findViewById(R.id.ada);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","ADA");
                startActivity(intent);
            }
        });
        ImageButton ib5 = view.findViewById(R.id.xtz);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","XTZ");
                startActivity(intent);
            }
        });
        ImageButton ib6 = view.findViewById(R.id.btc);
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","BTC");
                startActivity(intent);
            }
        });
        ImageButton ib7 = view.findViewById(R.id.eth);
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","ETH");
                startActivity(intent);
            }
        });
        ImageButton ib8 = view.findViewById(R.id.eos);
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","EOS");
                startActivity(intent);
            }
        });
        ImageButton ib9 = view.findViewById(R.id.rune);
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SplashCrypto.class);
                intent.putExtra("name","RUNE");
                startActivity(intent);
            }
        });

    }
}