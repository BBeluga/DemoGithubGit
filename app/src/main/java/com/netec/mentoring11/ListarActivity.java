package com.netec.mentoring11;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.netec.mentoring11.db.DBHelper;
import com.netec.mentoring11.db.EstructuraDB;

public class ListarActivity extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        tv = (TextView) findViewById(R.id.tvListar);
        consultar();
    }

    private void consultar() {
        Context contexto = getApplicationContext();
        Uri uri = Uri.parse ("content://" + "gruposalinas" + "/" + "CalificacionesCP");

        Cursor cursor = contexto.getContentResolver().query(uri,
                null,null,null,null);

        if (cursor!=null) {

            while (cursor.moveToNext()){
                tv.append( cursor.getInt(0) + " ");
                tv.append( cursor.getString(1) + " ");
                tv.append( cursor.getFloat(3) + "\n");
            }
        } else {
            Toast.makeText(contexto, "Consultar() invalido", Toast.LENGTH_LONG ).show();
        }
    }

    private void consultarLocal() {
        DBHelper helper= new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        // select * from calificaciones
        Cursor cursor = db.query(EstructuraDB.NOMBRE_TABLA, null,null,null,null,null,null);

        while (cursor.moveToNext()) {
            tv.append(cursor.getInt(0) + " ");
            tv.append(cursor.getString(1) + " ");
            tv.append(cursor.getFloat(3) + "\n");
        }

        cursor.close();
        db.close();
        helper.close();
    }
}
