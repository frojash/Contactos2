package net.rohisa.contactos2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private DatePicker dpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            String nombre1 = parametros.getString(getResources().getString(R.string.pnombre));
            String telefono1 = parametros.getString(getResources().getString(R.string.ptelefono));
            String email1 = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion1 = parametros.getString(getResources().getString(R.string.pdescrpcion));
            String fecha1 = parametros.getString(getResources().getString(R.string.pfecha));

            etNombre = (EditText) findViewById(R.id.etNombre);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            dpFecha = (DatePicker) findViewById(R.id.dpFecha);

            etNombre.setText(nombre1);
            etTelefono.setText(telefono1);
            etEmail.setText(email1);
            etDescripcion.setText(descripcion1);

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(df.parse(fecha1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dpFecha.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Confirmacion.class);
                etNombre = (EditText) findViewById(R.id.etNombre);
                etEmail = (EditText) findViewById(R.id.etEmail);
                etTelefono = (EditText) findViewById(R.id.etTelefono);
                etDescripcion = (EditText) findViewById(R.id.etDescripcion);
                dpFecha = (DatePicker) findViewById(R.id.dpFecha);

                int dia = dpFecha.getDayOfMonth();
                int mes = dpFecha.getMonth();
                int anno = dpFecha.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(anno, mes, dia);
                Date fechaDate = calendar.getTime();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaTexto = sdf.format(fechaDate);

                intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescrpcion), etDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), fechaTexto);

                startActivity(intent);
            }
        });
    }
}

