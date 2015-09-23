package com.manfred.framework.db;

import com.datastax.driver.core.Session;

public final class SessionManager {

	private static com.datastax.driver.core.Session session = Cluster.getCluster().connect();

	public static Session getSession() {
		return session;
	}

}
