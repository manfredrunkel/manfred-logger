package com.manfred.business.log.bpo;

import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.business.log.dao.ISaveLogDAO;
import com.manfred.business.log.dao.impl.SaveLogDAOImpl;
import com.manfred.framework.app.ApplicationTypes;

public class SaveLogBPOImpl implements ISaveLogBPO {

	public void persistLog(ApplicationTypes application, LogVO message) {
		ISaveLogDAO dao = new SaveLogDAOImpl();
		dao.persistLog(application, message);
	}

}
