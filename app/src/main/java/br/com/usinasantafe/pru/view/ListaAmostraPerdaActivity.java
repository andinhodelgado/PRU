package br.com.usinasantafe.pru.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.usinasantafe.pru.PRUContext;
import br.com.usinasantafe.pru.R;
import br.com.usinasantafe.pru.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pru.model.bean.estaticas.FuncBean;
import br.com.usinasantafe.pru.model.bean.estaticas.OSBean;

public class ListaAmostraPerdaActivity extends ActivityGeneric {

    private PRUContext pruContext;
    private ListView amostraListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_amostra_perda);

        TextView textViewColhedora = (TextView) findViewById(R.id.textViewColhedora);
        TextView textViewAuditor = (TextView) findViewById(R.id.textViewAuditor);
        TextView textViewSecao = (TextView) findViewById(R.id.textViewSecao);
        TextView textViewFrente = (TextView) findViewById(R.id.textViewFrente);
        Button buttonInserirAmostra = (Button) findViewById(R.id.buttonInserirAmostra);
        Button buttonExcluirAnalise = (Button) findViewById(R.id.buttonExcluirAnalise);
        Button buttonFecharAnalise = (Button)  findViewById(R.id.buttonFecharAnalise);
        Button buttonParadaPerda = (Button)  findViewById(R.id.buttonParadaPerda);

        pruContext = (PRUContext) getApplication();

        EquipBean equipBean = pruContext.getPerdaCTR().getEquip();
        textViewColhedora.setText(equipBean.getNroEquip() + " - " + equipBean.getDescrClasseEquip());

        FuncBean funcBean = pruContext.getPerdaCTR().getFunc();
        textViewAuditor.setText("AUDITOR: " + funcBean.getMatricFunc() + " - " + funcBean.getNomeFunc());

        OSBean osBean = pruContext.getPerdaCTR().getOS();
        textViewSecao.setText("SECAO: " + osBean.getCodSecao() + " - " + osBean.getDescrSecao());
        textViewFrente.setText(osBean.getDescrFrente());


        ArrayList<String> itens = new ArrayList<String>();
        for (int i = 0; i < pruContext.getConfigCTR().getConfig().getPontoAmostraConfig(); i++) {
            int pos = i + 1;
            itens.add("AMOSTRA " + pos);
        }

        AdapterList adapterList = new AdapterList(this, itens);
        amostraListView = (ListView) findViewById(R.id.listViewAmostra);
        amostraListView.setAdapter(adapterList);

        amostraListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> l, View v, int position,
                                    long id) {

                pruContext.setPosPontoAmostra(Long.valueOf(position) + 1);
                Intent it = new Intent(ListaAmostraPerdaActivity.this,  ListaQuestaoPerdaActivity.class);
                startActivity(it);

            }

        });

        buttonInserirAmostra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pruContext.setVerPosTela(9);
                pruContext.setPosQuestao(1);
                Intent it = new Intent(ListaAmostraPerdaActivity.this, QuestaoPerdaActivity.class);
                startActivity(it);

            }
        });

        buttonExcluirAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(ListaAmostraPerdaActivity.this);
                alerta.setTitle("ATENÇÃO");
                alerta.setMessage("DESEJAR REALMENTE EXCLUIR ESSE ANALISE?");

                alerta.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        pruContext.getPerdaCTR().delPerda();

                        Intent it = new Intent(ListaAmostraPerdaActivity.this, MenuMotoMecActivity.class);
                        startActivity(it);
                        finish();

                    }

                });

                alerta.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }

                });

                alerta.show();

            }
        });

        buttonFecharAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!pruContext.getPerdaCTR().verCabecAberto()){

                    String mensagem = "POR FAVOR, INSIRA AMOSTRA ANTES DE ENVIAR OS DADOS.";

                    AlertDialog.Builder alerta = new AlertDialog.Builder( ListaAmostraPerdaActivity.this);
                    alerta.setTitle("ATENÇÃO");
                    alerta.setMessage(mensagem);

                    alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alerta.show();

                }
                else{

                    pruContext.getPerdaCTR().fecharCabecPerda();
                    Intent it = new Intent( ListaAmostraPerdaActivity.this, MenuMotoMecActivity.class);
                    startActivity(it);
                    finish();

                }

            }
        });

        buttonParadaPerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pruContext.setVerPosTela(15);
                Intent it = new Intent(ListaAmostraPerdaActivity.this, OSActivity.class);
                startActivity(it);
                finish();

            }
        });

    }

    public void onBackPressed()  {
    }

}