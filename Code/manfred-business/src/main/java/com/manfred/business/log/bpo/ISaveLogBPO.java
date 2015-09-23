package com.manfred.business.log.bpo;

import com.manfred.business.log.bpo.vo.LogVO;
import com.manfred.framework.app.ApplicationTypes;

public interface ISaveLogBPO {

	void persistLog(ApplicationTypes application, LogVO message);

}
