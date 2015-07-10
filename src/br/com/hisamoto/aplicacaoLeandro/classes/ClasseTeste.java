package br.com.hisamoto.aplicacaoLeandro.classes;

import android.content.ContentValues;
import br.com.hisamoto.aplicacaoLeandro.ApplicationContextProvider;
import br.com.hisamoto.aplicacaoLeandro.db.DBHelper;
import br.com.hisamoto.aplicacaoLeandro.model.UsuarioModel;
import br.com.hisamoto.modulo.ModuloTesteAbstract;

/**
 * @author Leandro Shindi
 * @version 1.0 10/07/15.
 *
 */
public class ClasseTeste extends ModuloTesteAbstract {

    private DBHelper db;
    private UsuarioModel model;

    public ClasseTeste() {

        db = new DBHelper(ApplicationContextProvider.getContext());

        // Model
        model = new UsuarioModel(ApplicationContextProvider.getContext());
    }

    @Override
    public void processar() {

    }

    public void inicio() {

        inicioModulo();
    }

    @Override
    public void cadastrarUsuario(String nome, String email) {

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNome(nome);

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());

        Boolean ret = model.inserirUsuario(values);
    }
}
