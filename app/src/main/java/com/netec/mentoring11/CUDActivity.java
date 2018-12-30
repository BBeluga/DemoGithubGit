package com.netec.mentoring11;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.netec.mentoring11.db.DBHelper;
import com.netec.mentoring11.db.EstructuraDB;
import com.netec.mentoring11.modelo.Alumno;
import com.netec.mentoring11.util.GeneraAlumnos;

import java.util.List;

public class CUDActivity extends Activity implements View.OnClickListener {
    private EditText etid, etnombre, etccorreo, etcali, etprofesor;
    private EditText[] campos;
    private Button btInsertar, btActualizar, btBorrar;
    private static final String TAG = ">>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cud);

        vincular();
        registrarEventos();
    }

    private void vincular() {
        etid = (EditText) findViewById(R.id.etID);
        etnombre = (EditText) findViewById(R.id.etNombre);
        etccorreo = (EditText) findViewById(R.id.etCorreo);
        etcali = (EditText) findViewById(R.id.etCal);
        etprofesor = (EditText) findViewById(R.id.etProfesor);

        btInsertar = (Button) findViewById(R.id.btInsertar);
        btActualizar = (Button) findViewById(R.id.btActuralizar);
        btBorrar = (Button) findViewById(R.id.btBorrar);

        campos = new EditText[]{etid, etnombre, etccorreo, etcali, etprofesor};
    }

    private void registrarEventos() {
        btActualizar.setOnClickListener(this);
        btInsertar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btInsertar:
                insertar();
                break;

            case R.id.btActuralizar:
                actualizar();
                break;
            case R.id.btBorrar:
                borrar();
                break;
        }
    }

    private void insertar() {
        List<Alumno> lista = GeneraAlumnos.getInstancia().getAlumnos();
        ContentValues values = new ContentValues();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        llena(values);

        long rowid = db.insert(EstructuraDB.NOMBRE_TABLA, null, values);

        if (rowid > 0) {
            Toast.makeText(this, "insertar() " + rowid, Toast.LENGTH_SHORT).show();
        } else {
            Log.e(TAG, "insertar() " + rowid);
        }

        db.close();
    }

    private void limpia() {
        for (EditText e : campos) {
            e.setText("");
        }
    }

    private void llena(ContentValues values) {
        values.clear();
        values.put(EstructuraDB.COL1_ID, Integer.parseInt(etid.getText().toString()));
        values.put(EstructuraDB.COL2_NOMBRE, etnombre.getText().toString());
        values.put(EstructuraDB.COL3_CORREO, etccorreo.getText().toString());
        values.put(EstructuraDB.COL4_CALIFICACION, Float.parseFloat(etcali.getText().toString()));
        values.put(EstructuraDB.COL5_PROFESOR, etnombre.getText().toString());

        limpia();
    }

    private void actualizar() {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        llena(values);
        String where = EstructuraDB.COL1_ID + " = ?";
        String[] param = new String[]{values.getAsString(EstructuraDB.COL1_ID)};

        int n = db.update(EstructuraDB.NOMBRE_TABLA, values, where, param);

        if (n != 1) {
            Log.e(TAG, "actualizar() " + n);
        } else {
            Toast.makeText(this, "Registro " + values.get(EstructuraDB.COL1_ID), Toast.LENGTH_SHORT).show();
        }
        db.close();

    }

    private void borrar() {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String where = EstructuraDB.COL1_ID + " = ?";
        String[] param = new String[]{etid.getText().toString()};
        int n = db.delete(EstructuraDB.NOMBRE_TABLA, where, param);
        if (n != 1) {
            Log.e(TAG, "actualizar() " + n);
        } else {
            Toast.makeText(this, "Registro " + param[0], Toast.LENGTH_SHORT).show();
        }
        db.close();
        limpia();
    }
}
