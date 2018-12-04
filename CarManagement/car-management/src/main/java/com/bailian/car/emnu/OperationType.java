package com.bailian.car.emnu;

public enum OperationType {
	ADD("add"), DELETE("delete"), UPDATE("update"), QUERY("query"), LOGIN("login"), LOGINOUT("loginout"), OTHERT(
			"other"), APPLY("apply");
	private String type;

	private OperationType(String type) {
		this.type = type;
	}

	@SuppressWarnings("unused")
	private String getType() {
		return type;
	}
}
