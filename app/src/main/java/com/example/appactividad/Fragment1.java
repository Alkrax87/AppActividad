package com.example.appactividad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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

    //======================================================================================
    private View view;
    Button btnSuma,btnResta,btnMultiplicacion,btnDivision,btnRaiz,btnPotencia,btnLimpiar,btnInverso,btnDot,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnIgual;
    EditText txtInput;

    double Res = 0;
    String operador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        //Input
        txtInput= view.findViewById(R.id.txtInput);
        //Limpiar
        btnLimpiar= view.findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInput.setText("");
                Res = 0;
            }
        });
        //Operaciones
        btnSuma=(Button) view.findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "+";
                if (txtInput.getText().length() != 0){
                    if (Res == 0){
                        suma(Double.parseDouble(txtInput.getText().toString()));
                        txtInput.setText("");
                    } else {
                        if (txtInput.getText().length() > 0){
                            txtInput.setText("");
                            suma(0);
                        } else {
                            suma(Double.parseDouble(txtInput.getText().toString()));
                        }
                    }
                }
            }
        });
        btnResta=view.findViewById(R.id.btnResta);
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "-";
                if (txtInput.getText().length() != 0){
                    if (Res == 0){
                        resta(Double.parseDouble(txtInput.getText().toString()));
                        txtInput.setText("");
                    } else {
                        if (txtInput.getText().length() > 0){
                            txtInput.setText("");
                            resta(0);
                        } else {
                            resta(Double.parseDouble(txtInput.getText().toString()));
                        }
                    }
                }
            }
        });
        btnMultiplicacion=view.findViewById(R.id.btnMultiplicacion);
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "*";
                if (txtInput.getText().length() != 0){
                    if (Res == 0){
                        multiplicacion(Double.parseDouble(txtInput.getText().toString()));
                        txtInput.setText("");
                    } else {
                        if (txtInput.getText().length() > 0){
                            txtInput.setText("");
                            multiplicacion(1);
                        } else {
                            multiplicacion(Double.parseDouble(txtInput.getText().toString()));
                        }
                    }
                }
            }
        });
        btnDivision=view.findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "/";
                if (txtInput.getText().length() != 0){
                    if (Res == 0){
                        division(Double.parseDouble(txtInput.getText().toString()));
                        txtInput.setText("");
                    } else {
                        if (txtInput.getText().length() > 0){
                            txtInput.setText("");
                            division(1);
                        } else {
                            division(Double.parseDouble(txtInput.getText().toString()));
                        }
                    }
                }
            }
        });
        btnRaiz=view.findViewById(R.id.btnRaiz);
        btnRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double res = Math.sqrt(Double.parseDouble(txtInput.getText().toString()));
                txtInput.setText("" + res);
            }
        });
        btnPotencia=view.findViewById(R.id.btnPotencia);
        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double res = Math.pow(Double.parseDouble(txtInput.getText().toString()),2);
                txtInput.setText("" + res);
            }
        });
        btnInverso=view.findViewById(R.id.btnInverso);
        btnInverso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double res = 1 / Double.parseDouble(txtInput.getText().toString());
                txtInput.setText("" + res);
            }
        });
        //Entradas
        btnDot=view.findViewById(R.id.btnDot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("0.");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+".");
                }
            }
        });
        btn0=view.findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("0");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"0");
                }
            }
        });
        btn1=view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("1");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"1");
                }
            }
        });
        btn2=view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("2");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"2");
                }
            }
        });
        btn3=view.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("3");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"3");
                }
            }
        });
        btn4=view.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("4");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"4");
                }
            }
        });
        btn5=view.findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("5");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"5");
                }
            }
        });
        btn6=view.findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("6");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"6");
                }
            }
        });
        btn7=view.findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("7");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"7");
                }
            }
        });
        btn8=view.findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("8");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"8");
                }
            }
        });
        btn9=view.findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtInput.getText().length() == 0){
                    txtInput.setText("9");
                } else {
                    String content = txtInput.getText().toString();
                    txtInput.setText(content+"9");
                }
            }
        });
        //Resultado
        btnIgual=view.findViewById(R.id.btnIgual);
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == "+") {
                    Res = Res + Double.parseDouble(txtInput.getText().toString());
                    txtInput.setText(String.valueOf(Res));
                } else if (operador == "-") {
                    Res = Res - Double.parseDouble(txtInput.getText().toString());
                    txtInput.setText(String.valueOf(Res));
                } else if (operador == "*") {
                    Res = Res * Double.parseDouble(txtInput.getText().toString());
                    txtInput.setText(String.valueOf(Res));
                } else if (operador == "/") {
                    Res = Res / Double.parseDouble(txtInput.getText().toString());
                    txtInput.setText(String.valueOf(Res));
                }

            }
        });
        return view;
    }

    public double suma(double num){
        Res = Res + num;
        return Res;
    }
    public double resta(double num){
        if (Res == 0){
            Res = num;
        } else {
            Res = Res - num;
        }
        return Res;
    }
    public double multiplicacion(double num){
        if (Res == 0){
            Res = 1;
            Res = Res * num;
        } else {
            Res = Res * num;
        }
        return Res;
    }
    public double division(double num){
        if (num == 0){
            txtInput.setText("No se puede dividir entre 0");
        } else {
            if (Res == 0){
                Res = num;
            } else {
                Res = Res / num;
            }
        }
        return Res;
    }


}