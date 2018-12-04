package com.bailian.car.beans;

/**
 * 下载记录实体信息
 */
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.sun.jmx.snmp.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownloadRecord {
	public static final int STATUS_ERROR = 0;
	public static final int STATUS_SUCCESS = 1;
	private String uid;
	private String ip;
	private int port;
	private String ua;
	private String fileName;
	private String filePath;
	private long length;
	private int status;
	@SuppressWarnings("restriction")
	private Timestamp startTime;
	@SuppressWarnings("restriction")
	private Timestamp endTime;

	public DownloadRecord() {
	}

	public DownloadRecord(String fileName, String filePath, HttpServletRequest request) {
		this.uid = UUID.randomUUID().toString().replace("-", "");
		this.fileName = fileName;
		this.filePath = filePath;
		this.ip = request.getRemoteAddr();
		this.port = request.getRemotePort();
		this.ua = this.ua = request.getHeader("user-agent");
		this.startTime = new Timestamp(System.currentTimeMillis());
		
		
	}

}
