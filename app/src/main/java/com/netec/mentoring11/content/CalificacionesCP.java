package com.netec.mentoring11.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.netec.mentoring11.db.DBHelper;
import com.netec.mentoring11.db.EstructuraDB;

public class CalificacionesCP extends ContentProvider {

    public static final String AUTORIDAD = "gruposalinas";

    // URIs
    public static final String uri = "content://" + CalificacionesCP.AUTORIDAD + "/" + "CalificacionesCP";
    public static final Uri CONTENT_URI = Uri.parse(uri); // String -> Uri

    //
    public static final int ALL_ELEMENTS = 1;
    public static final int SINGLE_ELEMENT = 2;

    // UriMatcher
    private static UriMatcher URI_MATCHER = null;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(CalificacionesCP.AUTORIDAD, "CalificacionesCP", CalificacionesCP.ALL_ELEMENTS);
        URI_MATCHER.addURI(CalificacionesCP.AUTORIDAD, "CalificacionesCP/#", CalificacionesCP.SINGLE_ELEMENT);
    }

    private SQLiteDatabase db;

    public CalificacionesCP() {
    }

    @Override
    public boolean onCreate() {
        DBHelper helper = new DBHelper(getContext());
        db = helper.getReadableDatabase();
        return db != null && db.isOpen();
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String id;
        SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();
        qBuilder.setTables(EstructuraDB.NOMBRE_TABLA);

        String sel = selection;
        if (URI_MATCHER.match(uri) == CalificacionesCP.SINGLE_ELEMENT) {
            id = uri.getPathSegments().get(1);
            qBuilder.appendWhere(" id = " + id);
        }

        return qBuilder.query(db, projection, selection, selectionArgs, null, null, null);
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
