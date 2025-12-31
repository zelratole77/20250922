package web.com.springweb.a04_file;

import java.util.Date;

public class FileInfo {
	// fno fname regdte uptdte etc
	private int fno;
	private String fname;
	private String fpath;
	private Date regdte;
	private Date uptdte;
	private String etc;
	public FileInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public FileInfo(String fname, String fpath, String etc) {
		this.fname = fname;
		this.fpath = fpath;
		this.etc = etc;
	}

	public FileInfo(int fno, String fname, String fpath, Date regdte, Date uptdte, String etc) {
		this.fno = fno;
		this.fname = fname;
		this.fpath = fpath;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.etc = etc;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
}
