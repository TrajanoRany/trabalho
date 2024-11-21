package com.example.appunhas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TELACONSULTA extends AppCompatActivity {

    EditText et_nome,et_telefone;
    Button btn_voltar,btn_proxim,btn_anterior;
    SQLiteDatabase db=null;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telaconsulta);

        et_nome=(EditText) findViewById(R.id.et_nome);
        et_telefone=(EditText) findViewById(R.id.et_telefone);
        btn_anterior=(Button)  findViewById(R.id.btn_anterior);
        btn_proxim=(Button) findViewById(R.id.btn_proximo);
        btn_voltar=(Button) findViewById(R.id.btn_voltar);

       buscardados();





}
        public void fecha_tela (View v){
            this.finish();
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

    public void fecharDB(){
        db.close();

    }


}

 public void proximoregist(){
cursor.moveToNext();


}

public void registroanterio(View v){
 cursor.moveToPrevious();





}




public void mostrardados(){

    et_nome.setText(cursor.getString(cursor.getColumnIndex("nome")));
    et_telefone.setText(cursor.getString(cursor.getColumnIndex("fone")));

}




public void msg(String txt){
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK",null);
        adb.show();

    }

    private class string {
     int nome, fone;






    }
}
