package com.netec.mentoring11;


import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.netec.mentoring11.db.DBHelper;
import com.netec.mentoring11.db.EstructuraDB;
import com.netec.mentoring11.modelo.Alumno;

public class LAActivity extends ListActivity {

   Alumno[] alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_la);

        consultar();

        setListAdapter(new ArrayAdapter<Alumno>(this, android.R.layout.simple_list_item_1,alumnos));
    }

    private void consultar() {
        DBHelper helper= new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        // select * from calificaciones
        Cursor cursor = db.query(EstructuraDB.NOMBRE_TABLA, null,null,null,null,null,null);

        int n= cursor.getCount();
        alumnos = new Alumno[n];
        int i= 0;
        while (cursor.moveToNext()) {
            Alumno alumno = new Alumno();
            alumno.setId(cursor.getInt(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setCorreo(cursor.getString(2));
            alumno.setCalificacion(cursor.getFloat(3));
            alumno.setProfesor(cursor.getString(4));
            alumnos[i++]= alumno;
        }


        cursor.close();
        db.close();
        helper.close();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this,"onclick(): "+ alumnos[position].getNombre(), Toast.LENGTH_SHORT).show();
    }
}
