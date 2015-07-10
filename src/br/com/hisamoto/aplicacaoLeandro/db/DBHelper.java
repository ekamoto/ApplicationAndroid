package br.com.hisamoto.aplicacaoLeandro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Leandro Shindi
 * @version 1.0 29/06/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Nome do banco de dados
    private static final String NOME_BANCO = "banco_leandro";

    // Versão atual do banco de dados
    private static final int VERSAO_BANCO = 1;

    public DBHelper(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE usuario( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT " +
                ", nome TEXT NOT NULL" +
                ", email TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IS EXISTS usuario";
        db.execSQL(sql);
        onCreate(db);
    }
}
