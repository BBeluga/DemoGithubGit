package com.netec.mentoring11.db;

public class EstructuraDB {
    public final static String NOMBRE_DATABASE = "proyectofinal.db";
    public final static int VERSION = 1;

    public static final String NOMBRE_TABLA = "calificaciones";
    public static final String COL1_ID = "id";
    public static final String COL2_NOMBRE = "nombre";
    public static final String COL3_CORREO = "correo";
    public static final String COL4_CALIFICACION = "calificacion";
    public static final String COL5_PROFESOR = "profesor";

    private final static String SEP = ", ";
    private final static String TEXT = " TEXT";
    private final static String INT = " INTEGER";
    private final static String FLOAT = " REAL";

    // create table ....
    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + EstructuraDB.NOMBRE_TABLA + " (" +
                    EstructuraDB.COL1_ID + EstructuraDB.INT + " PRIMARY KEY " + EstructuraDB.SEP +
                    EstructuraDB.COL2_NOMBRE + EstructuraDB.TEXT + EstructuraDB.SEP +
                    EstructuraDB.COL3_CORREO + EstructuraDB.TEXT + EstructuraDB.SEP +
                    EstructuraDB.COL4_CALIFICACION + EstructuraDB.FLOAT + EstructuraDB.SEP +
                    EstructuraDB.COL5_PROFESOR + EstructuraDB.TEXT + ")";

    // drop table ...

    public static final String DROP_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraDB.NOMBRE_TABLA;

    private EstructuraDB() {}

}
