package br.com.hisamoto.aplicacaoLeandro.classes;

import android.widget.Toast;
import br.com.hisamoto.aplicacaoLeandro.ApplicationContextProvider;
import br.com.hisamoto.modulo.ModuloTesteAbstract;

/**
 * @author Leandro Shindi
 * @version 1.0 08/07/15.
 */
public class ModuloAbstract extends ModuloTesteAbstract {

    @Override
    public void cadastrarUsuario(String nome, String email) {}

    @Override
    public void processar() {

        Toast.makeText(ApplicationContextProvider.getContext(), "Acessando classe da aplicação", Toast.LENGTH_SHORT).show();
    }
}
