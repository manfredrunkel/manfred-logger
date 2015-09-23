package com.manfred.framework.db;

public final class Cluster {

	private static final com.datastax.driver.core.Cluster cluster;

	public static String clusterIP = "localhost";

	static {
		cluster = com.datastax.driver.core.Cluster.builder().addContactPoint(clusterIP).build();
	}

	public static com.datastax.driver.core.Cluster getCluster() {
		return cluster;
	}

}
