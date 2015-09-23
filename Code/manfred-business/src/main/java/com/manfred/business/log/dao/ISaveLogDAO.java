package com.manfred.business.log.dao;

import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.framework.app.ApplicationTypes;

public interface ISaveLogDAO {

	void persistLog(ApplicationTypes application, LogVO message);
}
