package net.rohisa.contactos2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Confirmacion extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle parametros = getIntent().getExtras();
        String nombre2 = parametros.getString(getResources().getString(R.string.pnombre)).toString();
        String telefono2 = parametros.getString(getResources().getString(R.string.ptelefono)).toString();
        String email2 = parametros.getString(getResources().getString(R.string.pemail)).toString();
        String descripcion2 = parametros.getString(getResources().getString(R.string.pdescrpcion)).toString();
        String fecha2 = parametros.getString(getResources().getString(R.string.pfecha)).toString();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = new Date();

        try {
            date = format.parse(fecha2);
        } catch (ParseException e) {
        }

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvNombre.setText(nombre2);
        tvNombre.setTag(nombre2);
        tvFecha.setText("Fecha Nacimiento: " + fecha2);
        tvFecha.setTag(fecha2);
        tvTelefono.setText("Tel.: " + telefono2);
        tvTelefono.setTag(telefono2);
        tvEmail.setText("Email: " + email2);
        tvEmail.setTag( email2);
        tvDescripcion.setText("Descripcion: " + descripcion2);
        tvDescripcion.setTag( descripcion2);
    }


    public void EditarDatos(View v) {

        Intent intent = new Intent(Confirmacion.this, MainActivity.class);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvFecha = (TextView) findViewById(R.id.tvFecha);

        intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getTag().toString());
        intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getTag().toString());
        intent.putExtra(getResources().getString(R.string.pdescrpcion), tvDescripcion.getTag().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefono.getTag().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), tvFecha.getTag().toString());

        startActivity(intent);

    }
}
