package br.com.usinasantafe.pru.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import br.com.usinasantafe.pru.PRUContext;
import br.com.usinasantafe.pru.R;
import br.com.usinasantafe.pru.util.ConexaoWeb;
import br.com.usinasantafe.pru.util.VerifDadosServ;

public class OSActivity extends ActivityGeneric {

    private PRUContext pruContext;
    private ProgressDialog progressBar;
    private Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);

        pruContext = (PRUContext) getApplication();

        Button buttonOkOS = (Button) findViewById(R.id.buttonOkPadrao);
        Button buttonCancOS = (Button) findViewById(R.id.buttonCancPadrao);

        buttonOkOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextPadrao.getText().toString().equals("")) {

                    try{

                        Long nroOS = Long.parseLong(editTextPadrao.getText().toString());
                        pruContext.getConfigCTR().setOsConfig(nroOS);

                        ConexaoWeb conexaoWeb = new ConexaoWeb();
                        if (pruContext.getConfigCTR().verOS(nroOS)) {

                            if (conexaoWeb.verificaConexao(OSActivity.this)) {
                                pruContext.getConfigCTR().setStatusConConfig(1L);
                            }
                            else{
                                pruContext.getConfigCTR().setStatusConConfig(0L);
                            }

                            VerifDadosServ.getInstance().setVerTerm(true);

                            Intent it = new Intent(OSActivity.this, ListaAtividadeActivity.class);
                            startActivity(it);
                            finish();

                        } else {

                            if (conexaoWeb.verificaConexao(OSActivity.this)) {

                                progressBar = new ProgressDialog(v.getContext());
                                progressBar.setCancelable(true);
                                progressBar.setMessage("PESQUISANDO OS...");
                                progressBar.show();

                                customHandler.postDelayed(updateTimerThread, 10000);

                                pruContext.getConfigCTR().verOS(editTextPadrao.getText().toString()
                                        , OSActivity.this, ListaAtividadeActivity.class, progressBar);


                            } else {

                                pruContext.getConfigCTR().setStatusConConfig(0L);

                                Intent it = new Intent(OSActivity.this, ListaAtividadeActivity.class);
                                startActivity(it);
                                finish();

                            }

                        }

                    }
                    catch (NumberFormatException e){

                        AlertDialog.Builder alerta = new AlertDialog.Builder( OSActivity.this);
                        alerta.setTitle("ATENÇÃO");
                        alerta.setMessage("VALOR DE OS INCORRETO! FAVOR VERIFICAR.");
                        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alerta.show();

                    }

                }
            }
        });

        buttonCancOS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (editTextPadrao.getText().toString().length() > 0) {
                    editTextPadrao.setText(editTextPadrao.getText().toString().substring(0, editTextPadrao.getText().toString().length() - 1));
                }
            }
        });

    }

    public void onBackPressed()  {
        if(pruContext.getVerPosTela() == 1){
            Intent it = new Intent(OSActivity.this, MenuInicialActivity.class);
            startActivity(it);
            finish();
        }
        else if(pruContext.getVerPosTela() == 14){
            Intent it = new Intent(OSActivity.this, ListaPontosFitoActivity.class);
            startActivity(it);
            finish();
        }
        else if(pruContext.getVerPosTela() == 15){
            Intent it = new Intent(OSActivity.this, ListaAmostraPerdaActivity.class);
            startActivity(it);
            finish();
        }
        else if(pruContext.getVerPosTela() == 16){
            Intent it = new Intent(OSActivity.this, ListaAmostraSoqueiraActivity.class);
            startActivity(it);
            finish();
        }
        else{
            Intent it = new Intent(OSActivity.this, MenuMotoMecActivity.class);
            startActivity(it);
            finish();
        }
    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            if(!VerifDadosServ.getInstance().isVerTerm()) {

                VerifDadosServ.getInstance().cancelVer();
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }

                Intent it = new Intent(OSActivity.this, ListaAtividadeActivity.class);
                startActivity(it);
                finish();

            }

        }
    };

}
