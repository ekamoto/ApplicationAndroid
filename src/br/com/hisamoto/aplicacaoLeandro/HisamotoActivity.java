package br.com.hisamoto.aplicacaoLeandro;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import br.com.hisamoto.aplicacaoLeandro.classes.ClasseTeste;
import br.com.hisamoto.aplicacaoLeandro.classes.ModuloAbstract;
import br.com.hisamoto.aplicacaoLeandro.classes.Usuario;
import br.com.hisamoto.aplicacaoLeandro.model.UsuarioModel;
import br.com.hisamoto.modulo.ModuloTeste;
import br.com.hisamoto.modulo.ModuloTesteAbstract;
import br.com.hisamoto.modulo.activity.RetornoActivity;
import java.util.ArrayList;
import java.util.List;

public class HisamotoActivity extends Activity {

    private UsuarioModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Model
        model = new UsuarioModel(getApplicationContext());

        // Setando Recebimento Broadcast
        setRecebimentoBroadcast();

        // Teste broadcast
        acessarModulo();

        // Lista usuários cadastrados
        listarUsuarios();

        // Chamar uma activity e esperar retorno, porém será feito
        // em um activity de um outro módulo,
        acessarActivityModuloComRetorno();

        // Acesso classe abstract
        acessarClasseAbstrata();

        // Acessar banco de dados no módulo
        ClasseTeste testeAcessoBanco = new ClasseTeste();
        testeAcessoBanco.inicio();

        // Lista usuários cadastrados
        listarUsuarios();
    }

    /**
     * Teste classe abstract
     *
     */
    public void acessarClasseAbstrata() {

        ModuloTesteAbstract absModulo = new ModuloAbstract();
        absModulo.start();
    }

    /**
     * Chamada para a activity RetornoActivity do módulo com retorno
     *
     */
    private void acessarActivityModuloComRetorno() {

        Intent i = new Intent(getApplicationContext(), RetornoActivity.class);
        int requestCode = 123;
        startActivityForResult(i, requestCode);
    }

    /**
     * Listar Usuários
     *
     */
    public void listarUsuarios() {

        List<Usuario> list = new ArrayList<Usuario>();
        list = model.getUsuarios();

        for (int i = 0; i < list.size(); i++) {

            Log.i("ListaUsuario", list.get(i).getNome());
        }
    }

    /**
     * Cadastrar Usuário
     *
     */
    public void cadastrarUsuario() {

        Usuario usuario = new Usuario();
        usuario.setEmail("ekamoto.leandro@gmail.com");
        usuario.setNome("Hisamoto");

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());

        Boolean ret = model.inserirUsuario(values);
    }

    /**
     * Setando recebimento Broadcast
     */
    private void setRecebimentoBroadcast() {

        getApplicationContext().registerReceiver(recebimentoBroadcast, new IntentFilter("HisamotoBroadCastModulo"));
    }

    /**
     * Método que acessa o módulo para poder enviar broadcast do módulo
     * para a aplicação (Teste)
     *
     */
    private void acessarModulo() {

        ModuloTeste modulo = new ModuloTeste(getApplicationContext());
        modulo.processoModulo();
    }

    /**
     * Recebe o broadcast do módulo
     *
     */
    private BroadcastReceiver recebimentoBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.i("Ekamoto", "Recebeu o broadcast");
            Toast.makeText(getApplicationContext(), "Chegou o broadcast", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * Callback da chamada da activity RetornoActivity
     *
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        String parametroRecebido = data.getExtras().getString("ParametroRetorno");

        Log.i("ParametroRetorno", "RC[" + requestCode + "] RSC[" + resultCode + "]");
        Log.i("ParametroRetorno", "Dados: " + parametroRecebido);

        Toast.makeText(getApplicationContext(), "RC[" + requestCode + "] RSC[" + resultCode + "]", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Mensagem: " + parametroRecebido, Toast.LENGTH_SHORT).show();
    }
}
