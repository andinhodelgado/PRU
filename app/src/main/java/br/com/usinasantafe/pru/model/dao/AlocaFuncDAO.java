package br.com.usinasantafe.pru.model.dao;

import br.com.usinasantafe.pru.model.bean.variaveis.AlocaFuncBean;
import br.com.usinasantafe.pru.model.bean.variaveis.BoletimBean;
import br.com.usinasantafe.pru.util.Tempo;

public class AlocaFuncDAO {

    public AlocaFuncDAO() {
    }

    public void alocaFunc(BoletimBean boletimBean) {
        AlocaFuncBean alocaFuncBean = new AlocaFuncBean();
        alocaFuncBean.setIdBolAlocaFunc(boletimBean.getIdBol());
        alocaFuncBean.setIdExtBolAlocaFunc(boletimBean.getIdExtBol());
        alocaFuncBean.setMatricFuncAlocaFunc(boletimBean.getIdLiderBol());
        alocaFuncBean.setDthrAlocaFunc(Tempo.getInstance().data());
        alocaFuncBean.setTipoAlocaFunc(1L);
        alocaFuncBean.insert();
    }



}
