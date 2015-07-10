package br.com.hisamoto.aplicacaoLeandro.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.hisamoto.aplicacaoLeandro.classes.Usuario;
import br.com.hisamoto.aplicacaoLeandro.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leandro Shindi
 * @version 1.0 29/06/15.
 */
public class UsuarioModel {

    private DBHelper dbHelper;
    private Context context;

    public UsuarioModel(Context context) {

        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public boolean inserirUsuario(ContentValues values) {

        // Validação de campos e regra de negócio
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        long id = -1;

        try {

            id = db.insert("usuario", null, values);
            db.setTransactionSuccessful();
        } catch (android.database.SQLException e) {

            e.printStackTrace();
        } finally {

            db.endTransaction();
        }

        db.close();

        return id != -1 ? true : false;
    }

    public List<Usuario> getUsuarios() {

        // Validação de campos e regra de negócio
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.beginTransaction();

        List<Usuario> lista = new ArrayList<Usuario>();

        try {

            final Cursor c = db.query("usuario", new String[]{"nome, email"}, null, null, null, null, null);

            if (c != null) {

                c.moveToFirst();

                while (c.isAfterLast() == false) {

                    lista.add(new Usuario(c.getString(0), c.getString(1)));
                    c.moveToNext();
                }
            }


            db.setTransactionSuccessful();
        } catch (android.database.SQLException e) {

            e.printStackTrace();
        } finally {

            db.endTransaction();
        }

        db.close();
        return lista;
    }
}
