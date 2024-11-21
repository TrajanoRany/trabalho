package com.example.appunhas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.database.sqlite.SQLiteDatabase; //Banco de dados
import android.database.Cursor; //NAvegar entre os cadastros
import android.widget.*;

import java.util.jar.Attributes;


public class MainActivity extends AppCompatActivity {

    EditText et_nome,et_telefone;
    Button btn_sair,btn_salvar,btn_ver;

    SQLiteDatabase db=null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_telefone = (EditText) findViewById(R.id.et_telefone);
        btn_salvar = (Button) findViewById(R.id.bnt_salvar);
        btn_ver = (Button) findViewById(R.id.btn_ver);
        btn_sair = (Button) findViewById(R.id.btn_sair);

        abrirbanco();
        abriroucriartabela();
        fecharDB();



    }

    public void abrirbanco() {
        try {
            db = openOrCreateDatabase("bancoagenda", MODE_PRIVATE,null);
        } catch (Exception ex) {
            msg("ERRO AO ABRIR OU CRIAR BANCO DE DADOS");
        }finally {
            msg("bd aberto");
        }
    }

    public void abriroucriartabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY,nome TEXT,fone TEXT);");

        }catch (Exception ex){
            msg("ERRO AO CRIAR TABELA");

        }
    }

    public void fecharDB(){
        db.close();

    }


    public void inserirregistro(View v){

        String st_nome,st_fone;
        st_nome=et_nome.getText().toString();
        st_fone=et_telefone.getText().toString();
        if(st_nome=="" || st_fone == ""){
            msg("campos nao podem está vazios, preencha");
            return;

        }
        abrirbanco();
        try {
            db.execSQL("INSERT INTO contatos (nome,fone) VALUES('"+st_nome+"','"+st_fone+"')");
        } catch (Exception ex){

            msg("Erro ao tentar inserir esse agendamento ;) " );
        }finally{
            msg(" O seu agendamento realizado com sucesso :D");
        }

        fecharDB();
    }

    public void abrir_tela_consulta (View v) {
        Intent it_tela_consulta = new Intent(this, TELACONSULTA.class);
        startActivity(it_tela_consulta);
    }
    public void fecha_tela (View v){
        this.finish();
    }
    public void msg(String txt){
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK",null);
        adb.show();

    }
}

