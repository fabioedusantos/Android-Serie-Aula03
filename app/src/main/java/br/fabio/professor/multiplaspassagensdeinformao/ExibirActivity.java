package br.fabio.professor.multiplaspassagensdeinformao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExibirActivity extends AppCompatActivity {

    private TextView txvNome;
    private TextView txvSenha;
    private TextView txvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);

        setTitle("Exibir"); //titulo da janela

        txvNome = (TextView) findViewById(R.id.txvNome);
        txvSenha = (TextView) findViewById(R.id.txvSenha);
        txvEmail = (TextView) findViewById(R.id.txvEmail);

        //"pegamos" os extras enviados da classe MainActivity
        Bundle b = getIntent().getExtras();
        txvNome.setText(b.getString("nome"));
        txvSenha.setText(b.getString("senha"));
        txvEmail.setText(b.getString("email"));
    }
}
