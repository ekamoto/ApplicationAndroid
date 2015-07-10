package br.com.hisamoto.aplicacaoLeandro;

import android.widget.Toast;

/**
 * @author Leandro Shindi
 * @version 1.0 08/07/15.
 */
public class AplicacaoController {

    public AplicacaoController() { }

    public void processar() {

        Toast.makeText(ApplicationContextProvider.getContext(), "Acesso aplicação", Toast.LENGTH_LONG).show();
    }
}
