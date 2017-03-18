package br.fabio.professor.multiplaspassagensdeinformao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSenha;
    private EditText txtRedigite;
    private EditText txtEmail;
    private TextView txvMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Início");

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtRedigite = (EditText) findViewById(R.id.txtRedigite);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txvMensagem = (TextView) findViewById(R.id.txvMensagem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 111, 0, "Novo");    //grupo, id, ordem, texto
        menu.add(0, 222, 1, "Listar");
        menu.add(0, 333, 2, "Configurações");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 111:
                Toast.makeText(this, "Novo", Toast.LENGTH_SHORT).show();
                break;
            case 222:
                Toast.makeText(this, "Listar", Toast.LENGTH_SHORT).show();
                break;
            case 333:
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void salvar(View v){
        String senha = txtSenha.getText().toString();
        String redigite = txtRedigite.getText().toString();
        if(senha.equals(redigite)){
            String nome = txtNome.getText().toString();
            String email = txtEmail.getText().toString();
            txvMensagem.setText("");

            Intent i = new Intent(MainActivity.this, ExibirActivity.class);
            i.putExtra("nome", nome);
            i.putExtra("senha", senha);
            i.putExtra("email", email);
            startActivity(i);
        } else{
            txvMensagem.setText("As senhas devem ser iguais!");
        }
    }
}