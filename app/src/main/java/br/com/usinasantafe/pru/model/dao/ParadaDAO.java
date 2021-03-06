package br.com.usinasantafe.pru.model.dao;

import java.util.List;

import br.com.usinasantafe.pru.model.bean.estaticas.ParadaBean;

public class ParadaDAO {

    public ParadaDAO() {
    }

    public List getParadaList(){
        ParadaBean paradaBean = new ParadaBean();
        return paradaBean.orderBy("codParada", true);
    }

    public ParadaBean getParada(Long idParada){
        ParadaBean paradaBean = new ParadaBean();
        List paradaList = paradaBean.get("idParada", idParada);
        paradaBean = (ParadaBean) paradaList.get(0);
        paradaList.clear();
        return paradaBean;
    }

}
