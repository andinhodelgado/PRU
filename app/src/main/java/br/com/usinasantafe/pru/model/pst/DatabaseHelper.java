package br.com.usinasantafe.pru.model.pst;
 
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.usinasantafe.pru.model.bean.estaticas.AmostraFitoBean;
import br.com.usinasantafe.pru.model.bean.estaticas.AtividadeBean;
import br.com.usinasantafe.pru.model.bean.estaticas.CaracOrganFitoBean;
import br.com.usinasantafe.pru.model.bean.estaticas.EquipBean;
import br.com.usinasantafe.pru.model.bean.estaticas.FuncBean;
import br.com.usinasantafe.pru.model.bean.estaticas.LiderBean;
import br.com.usinasantafe.pru.model.bean.estaticas.OSBean;
import br.com.usinasantafe.pru.model.bean.estaticas.OrganFitoBean;
import br.com.usinasantafe.pru.model.bean.estaticas.ParadaBean;
import br.com.usinasantafe.pru.model.bean.estaticas.RFuncaoAtivParBean;
import br.com.usinasantafe.pru.model.bean.estaticas.ROSAtivBean;
import br.com.usinasantafe.pru.model.bean.estaticas.ROCAFitoBean;
import br.com.usinasantafe.pru.model.bean.estaticas.TalhaoBean;
import br.com.usinasantafe.pru.model.bean.estaticas.TipoApontBean;
import br.com.usinasantafe.pru.model.bean.estaticas.TurmaBean;
import br.com.usinasantafe.pru.model.bean.variaveis.AlocaFuncBean;
import br.com.usinasantafe.pru.model.bean.variaveis.AmostraPerdaBean;
import br.com.usinasantafe.pru.model.bean.variaveis.AmostraSoqueiraBean;
import br.com.usinasantafe.pru.model.bean.variaveis.ApontRuricolaBean;
import br.com.usinasantafe.pru.model.bean.variaveis.BoletimRuricolaBean;
import br.com.usinasantafe.pru.model.bean.variaveis.CabecFitoBean;
import br.com.usinasantafe.pru.model.bean.variaveis.CabecPerdaBean;
import br.com.usinasantafe.pru.model.bean.variaveis.CabecSoqueiraBean;
import br.com.usinasantafe.pru.model.bean.variaveis.ConfigBean;
import br.com.usinasantafe.pru.model.bean.variaveis.RespFitoBean;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	public static final String FORCA_DB_NAME = "pru_db";
	public static final int FORCA_BD_VERSION = 3;

	private static DatabaseHelper instance;
	
	public static DatabaseHelper getInstance(){
		return instance;
	}
	
	public DatabaseHelper(Context context) {

		super(context, FORCA_DB_NAME, null, FORCA_BD_VERSION);;

		instance = this;
		
	}

	@Override
	public void close() {
		super.close();
		instance = null;
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource cs) {
		
		try{

			TableUtils.createTable(cs, AmostraFitoBean.class);
			TableUtils.createTable(cs, AtividadeBean.class);
			TableUtils.createTable(cs, CaracOrganFitoBean.class);
			TableUtils.createTable(cs, EquipBean.class);
			TableUtils.createTable(cs, FuncBean.class);
			TableUtils.createTable(cs, LiderBean.class);
			TableUtils.createTable(cs, OrganFitoBean.class);
			TableUtils.createTable(cs, OSBean.class);
			TableUtils.createTable(cs, ParadaBean.class);
			TableUtils.createTable(cs, RFuncaoAtivParBean.class);
			TableUtils.createTable(cs, ROCAFitoBean.class);
			TableUtils.createTable(cs, ROSAtivBean.class);
			TableUtils.createTable(cs, TalhaoBean.class);
			TableUtils.createTable(cs, TipoApontBean.class);
			TableUtils.createTable(cs, TurmaBean.class);

			TableUtils.createTable(cs, AlocaFuncBean.class);
			TableUtils.createTable(cs, AmostraPerdaBean.class);
			TableUtils.createTable(cs, AmostraSoqueiraBean.class);
			TableUtils.createTable(cs, ApontRuricolaBean.class);
			TableUtils.createTable(cs, BoletimRuricolaBean.class);
			TableUtils.createTable(cs, CabecFitoBean.class);
			TableUtils.createTable(cs, CabecPerdaBean.class);
			TableUtils.createTable(cs, CabecSoqueiraBean.class);
			TableUtils.createTable(cs, ConfigBean.class);
			TableUtils.createTable(cs, RespFitoBean.class);

		}
		catch(Exception e){
			Log.e(DatabaseHelper.class.getName(),
					"Erro criando banco de dados...",
					e);
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db,
			ConnectionSource cs,
			int oldVersion,
			int newVersion) {
		
		try {

			if((oldVersion <= 2) && (newVersion > 2)){

				TableUtils.dropTable(cs, AmostraFitoBean.class, true);
				TableUtils.dropTable(cs, AtividadeBean.class, true);
				TableUtils.dropTable(cs, CaracOrganFitoBean.class, true);
				TableUtils.dropTable(cs, EquipBean.class, true);
				TableUtils.dropTable(cs, FuncBean.class, true);
				TableUtils.dropTable(cs, LiderBean.class, true);
				TableUtils.dropTable(cs, OrganFitoBean.class, true);
				TableUtils.dropTable(cs, OSBean.class, true);
				TableUtils.dropTable(cs, ParadaBean.class, true);
				TableUtils.dropTable(cs, RFuncaoAtivParBean.class, true);
				TableUtils.dropTable(cs, ROCAFitoBean.class, true);
				TableUtils.dropTable(cs, ROSAtivBean.class, true);
				TableUtils.dropTable(cs, TalhaoBean.class, true);
				TableUtils.dropTable(cs, TipoApontBean.class, true);
				TableUtils.dropTable(cs, TurmaBean.class, true);

				TableUtils.dropTable(cs, AlocaFuncBean.class, true);
				TableUtils.dropTable(cs, AmostraPerdaBean.class, true);
				TableUtils.dropTable(cs, AmostraSoqueiraBean.class, true);
				TableUtils.dropTable(cs, ApontRuricolaBean.class, true);
				TableUtils.dropTable(cs, BoletimRuricolaBean.class, true);
				TableUtils.dropTable(cs, CabecFitoBean.class, true);
				TableUtils.dropTable(cs, CabecPerdaBean.class, true);
				TableUtils.dropTable(cs, CabecSoqueiraBean.class, true);
				TableUtils.dropTable(cs, ConfigBean.class, true);
				TableUtils.dropTable(cs, RespFitoBean.class, true);

				/////////////////////////////////////////////////////////////////

				TableUtils.createTable(cs, AmostraFitoBean.class);
				TableUtils.createTable(cs, AtividadeBean.class);
				TableUtils.createTable(cs, CaracOrganFitoBean.class);
				TableUtils.createTable(cs, EquipBean.class);
				TableUtils.createTable(cs, FuncBean.class);
				TableUtils.createTable(cs, LiderBean.class);
				TableUtils.createTable(cs, OrganFitoBean.class);
				TableUtils.createTable(cs, OSBean.class);
				TableUtils.createTable(cs, ParadaBean.class);
				TableUtils.createTable(cs, RFuncaoAtivParBean.class);
				TableUtils.createTable(cs, ROCAFitoBean.class);
				TableUtils.createTable(cs, ROSAtivBean.class);
				TableUtils.createTable(cs, TalhaoBean.class);
				TableUtils.createTable(cs, TipoApontBean.class);
				TableUtils.createTable(cs, TurmaBean.class);

				TableUtils.createTable(cs, AlocaFuncBean.class);
				TableUtils.createTable(cs, AmostraPerdaBean.class);
				TableUtils.createTable(cs, AmostraSoqueiraBean.class);
				TableUtils.createTable(cs, ApontRuricolaBean.class);
				TableUtils.createTable(cs, BoletimRuricolaBean.class);
				TableUtils.createTable(cs, CabecFitoBean.class);
				TableUtils.createTable(cs, CabecPerdaBean.class);
				TableUtils.createTable(cs, CabecSoqueiraBean.class);
				TableUtils.createTable(cs, ConfigBean.class);
				TableUtils.createTable(cs, RespFitoBean.class);

			}

		} catch (Exception e) {
			Log.e(DatabaseHelper.class.getName(), "Erro atualizando banco de dados...", e);
		}
		
	}

}
