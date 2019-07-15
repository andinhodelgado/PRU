package br.com.usinasantafe.pru.to.tb.estaticas;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.usinasantafe.pru.pst.Entidade;

/**
 * Created by anderson on 06/09/2017.
 */
@DatabaseTable(tableName="tbturmaest")
public class TurmaTO extends Entidade {

    private static final long serialVersionUID = 1L;

    @DatabaseField(id=true)
    private Long idTurma;
    @DatabaseField
    private Long codTurma;
    @DatabaseField
    private String descrTurma;

    public TurmaTO() {
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Long getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Long codTurma) {
        this.codTurma = codTurma;
    }

    public String getDescrTurma() {
        return descrTurma;
    }

    public void setDescrTurma(String descrTurma) {
        this.descrTurma = descrTurma;
    }
}
