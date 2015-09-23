package com.manfred.business.log.dao.impl;

import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.business.log.dao.ISaveLogDAO;
import com.manfred.framework.app.ApplicationTypes;
import com.manfred.framework.db.dao.DBApi;

public class SaveLogDAOImpl extends DBApi implements ISaveLogDAO {

	public void persistLog(ApplicationTypes application, LogVO message) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO keyLogger.LOG ");
		sql.append("(APPLICATION, DATE,MESSAGE,TYPE, ID) ");
		sql.append("VALUES ( ");
		sql.append("'" + message.getApplication() + "',");
		sql.append("'" + message.getExecutedTime().getTime() + "',");
		sql.append("'" + message.getMessage() + "',");
		sql.append("'" + message.getLogType() + "',");
		sql.append("" + "uuid()" + ")");

		execute(sql.toString());
	}

}
