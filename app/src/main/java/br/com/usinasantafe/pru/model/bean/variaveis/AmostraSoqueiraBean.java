package br.com.usinasantafe.pru.model.bean.variaveis;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pru.model.pst.Entidade;

@DatabaseTable(tableName="tbamostrasoqvar")
public class AmostraSoqueiraBean extends Entidade {

    private static final long serialVersionUID = 1L;

    @DatabaseField(generatedId=true)
    private Long idAmostraSoqueira;
    @DatabaseField
    private Long idCabecAmostraSoqueira;
    @DatabaseField
    private Long seqAmostraSoqueira;
    @DatabaseField
    private Long qtdeSoqueira;
    @DatabaseField
    private Long qtdeArranquio;

    public AmostraSoqueiraBean() {
    }

    public Long getIdAmostraSoqueira() {
        return idAmostraSoqueira;
    }

    public void setIdAmostraSoqueira(Long idAmostraSoqueira) {
        this.idAmostraSoqueira = idAmostraSoqueira;
    }

    public Long getIdCabecAmostraSoqueira() {
        return idCabecAmostraSoqueira;
    }

    public void setIdCabecAmostraSoqueira(Long idCabecAmostraSoqueira) {
        this.idCabecAmostraSoqueira = idCabecAmostraSoqueira;
    }

    public Long getQtdeSoqueira() {
        return qtdeSoqueira;
    }

    public void setQtdeSoqueira(Long qtdeSoqueira) {
        this.qtdeSoqueira = qtdeSoqueira;
    }

    public Long getQtdeArranquio() {
        return qtdeArranquio;
    }

    public void setQtdeArranquio(Long qtdeArranquio) {
        this.qtdeArranquio = qtdeArranquio;
    }

    public Long getSeqAmostraSoqueira() {
        return seqAmostraSoqueira;
    }

    public void setSeqAmostraSoqueira(Long seqAmostraSoqueira) {
        this.seqAmostraSoqueira = seqAmostraSoqueira;
    }
}
