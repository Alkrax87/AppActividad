package com.example.appactividad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment6#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment6 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment6() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment6.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment6 newInstance(String param1, String param2) {
        Fragment6 fragment = new Fragment6();
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
        return inflater.inflate(R.layout.fragment_6, container, false);
    }

    EditText ciudad;
    TextView nombre,clima,humedad,descripcion;
    RequestQueue requestQueue;
    Button busqueda;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ciudad = view.findViewById(R.id.txtBusquedaCiudad);
        nombre = view.findViewById(R.id.txtCiudad);
        clima = view.findViewById(R.id.txtTemperatura);
        humedad = view.findViewById(R.id.txtHumedad);
        descripcion = view.findViewById(R.id.txtDescripcion);

        requestQueue = Volley.newRequestQueue(getActivity());

        busqueda = view.findViewById(R.id.btnBusqueda);
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = ciudad.getText().toString();

                jsonRequest(val);
                geo(val);

            }
        });

    }

    private void geo(String val) {

        String api = "https://api.openweathermap.org/data/2.5/weather?q=" + val + "&appid=4d8fb5b93d4af21d66a2948710284366&units=metric";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObjectlon = new JSONObject(response.getString("coord"));
                    String lonjs = jsonObjectlon.getString("lon");
                    String latjs = jsonObjectlon.getString("lat");
                    descripcion.setText("Lon: " + lonjs + "  -  Lat: " + latjs);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private void jsonRequest(String val) {
        String api = "https://api.openweathermap.org/data/2.5/weather?q=" + val + "&appid=4d8fb5b93d4af21d66a2948710284366&units=metric";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String ciudadname = ciudad.getText().toString().toUpperCase();
                    nombre.setText("Ciudad: " + ciudadname);
                    JSONObject jsonObjectTemp = new JSONObject(response.getString("main"));
                    String temperaturaJS = jsonObjectTemp.getString("temp");
                    clima.setText("Temperatura: " + temperaturaJS +"°");
                    String humedadJS = jsonObjectTemp.getString("humidity");
                    humedad.setText("Humedad: "+humedadJS+"%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
}