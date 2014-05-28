package org.hillel.it.joydi.model.entities;

public enum Months {
	January(0), February(1), March(2), April(3), May(4), June(5), July(6), August(
			7), September(8), October(9), November(10), December(11);

	private int value;

	private Months(int value) {
		this.value = value;

	}

	public int getMonth() {
		return value;
	}
}