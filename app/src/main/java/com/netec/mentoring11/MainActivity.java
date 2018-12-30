package com.netec.mentoring11;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.netec.mentoring11.db.DBHelper;
import com.netec.mentoring11.db.EstructuraDB;
import com.netec.mentoring11.modelo.Alumno;
import com.netec.mentoring11.util.GeneraAlumnos;

import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = ">>>>>";
    private Button btLilstar, btCUD, btListar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // carga();

        btCUD = (Button) findViewById(R.id.btCUD);
        btLilstar = (Button) findViewById(R.id.btListar);
        btListar2 = (Button) findViewById(R.id.btListar2);

        final Intent i1 = new Intent(MainActivity.this, CUDActivity.class);
        final Intent i3 = new Intent(MainActivity.this, LAActivity.class);
        Intent i2 = new Intent(MainActivity.this, ListarActivity.class);

        btCUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }
        });

        btListar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i3);
            }
        });

        btLilstar.setOnClickListener(v -> startActivity(i2));
    }

    private void carga() {
        List<Alumno> lista = GeneraAlumnos.getInstancia().getAlumnos();
        ContentValues values = new ContentValues();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        for (Alumno aa : lista) {
            values.clear();
            values.put(EstructuraDB.COL1_ID, aa.getId());
            values.put(EstructuraDB.COL2_NOMBRE, aa.getNombre());
            values.put(EstructuraDB.COL3_CORREO, aa.getCorreo());
            values.put(EstructuraDB.COL4_CALIFICACION, aa.getCalificacion());
            values.put(EstructuraDB.COL5_PROFESOR, aa.getProfesor());

            long rowid = db.insert(EstructuraDB.NOMBRE_TABLA, null, values);

            if (rowid > 0) {
                Toast.makeText(this, "carga() " + rowid, Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "carga() " + rowid);
            }
        }
        db.close();
    }
}
