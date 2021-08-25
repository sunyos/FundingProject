package com.kh.common.model.vo;

import java.sql.Date;

public class Attachment {
	private int fileNo; // 파일 번호
	private int refNo; // 참조 파트 번호 구분 : 공고 : 1 강의 : 2 펀딩 : 3 회원 : 4 [프로필 이미지]
	private String originName; // 파일 원본명
	private String changeName; // 파일 수정명
	private Date uploadDate; // 파일 업로드일
	private String filePath; // 파일이 저장된 폴더 경로

	public Attachment() {

	}

	public Attachment(int fileNo, int refNo, String originName, String changeName, Date uploadDate, String filePath) {
		this.fileNo = fileNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.uploadDate = uploadDate;
		this.filePath = filePath;
	}

	int getFileNo() {
		return fileNo;
	}

	void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	int getRefNo() {
		return refNo;
	}

	void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	String getOriginName() {
		return originName;
	}

	void setOriginName(String originName) {
		this.originName = originName;
	}

	String getChangeName() {
		return changeName;
	}

	void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	Date getUploadDate() {
		return uploadDate;
	}

	void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	String getFilePath() {
		return filePath;
	}

	void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refNo=" + refNo + ", originName=" + originName + ", changeName="
				+ changeName + ", uploadDate=" + uploadDate + ", filePath=" + filePath + "]";
	}

}
