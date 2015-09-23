package com.manfred.framework.db.dao;

import com.datastax.driver.core.Session;
import com.manfred.framework.db.SessionManager;

public class DBApi {

	private Session session = SessionManager.getSession();

	public void execute(String sql) {
		try {
			session.execute(sql);
		} catch (Exception e) {
			System.err.println("SQL was not executed against DB. Error:" + e.getMessage());
		}
	}

}
