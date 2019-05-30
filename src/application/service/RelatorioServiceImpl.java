package application.service;

import application.data.dao.TipoDao;
import application.data.dao.base.BaseDao;

public class RelatorioServiceImpl {

    private BaseDao  dao;

    public RelatorioServiceImpl() {
        dao = new TipoDao();
    }


}
