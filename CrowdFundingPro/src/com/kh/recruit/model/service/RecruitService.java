package com.kh.recruit.model.service;


import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Attachment;
import com.kh.recruit.model.dao.RecruitDao;
import com.kh.recruit.model.vo.RecruitCode;
import com.kh.recruit.model.vo.RecruitMember;
import com.kh.recruit.model.vo.Recruitment;

public class RecruitService {
	
	public int insertRecruitment(Recruitment r) {
		Connection conn = getConnection();
		
		int result = new RecruitDao().insertRecruitment(conn, r);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new RecruitDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Recruitment> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		
		ArrayList<Recruitment> list = new RecruitDao().selectList(conn, startRow, endRow);
		
		close(conn);
		
		return list;
	}

	public ArrayList<RecruitCode> selectRecruitCode() {
		Connection conn = getConnection();
		
		ArrayList<RecruitCode> list = new RecruitDao().selectRecruitCode(conn);
		
		close(conn);
		
		return list;
	}

	public Recruitment selectRecruitment(int rid) {
		Connection conn = getConnection();
		
		Recruitment r = new RecruitDao().selectRecruitment(conn, rid);
		
		close(conn);
		
		return r;
	}

	public int updateRecruitment(Recruitment r) {
		Connection conn = getConnection();
		
		int result = new RecruitDao().updateRecruitment(conn, r);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteRecruitment(int id) {
		Connection conn = getConnection();
		
		int result = new RecruitDao().deleteRecruitment(conn, id);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<String> selectAllTitle() {
		Connection conn = getConnection();
		
		ArrayList<String> list = new RecruitDao().selectAllTitle(conn);
		
		close(conn);
		
		return list;
	}

	public int insertRecruitMember(RecruitMember rm, Attachment at, String title) {
		Connection conn = getConnection();
		
		int result1 = new RecruitDao().insertRecruitMember(conn, rm);
		int result3 = 1;

		if (at != null) {
			result3 = new RecruitDao().insertAttachment(conn, at);			
		}
		
		if (result1 * result3 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		Recruitment r =  new RecruitDao().findRecruitmentWithTitle(conn, title);
		
		rm = new RecruitDao().findRecruitMemberWithEmail(conn, rm.getEmail());
		
		int result2 = new RecruitDao().insertRecruitStatus(conn, r, rm);;
		int result4 = 1;
		
		if (at != null) {
			at = new RecruitDao().findAttachmentWithOriginName(conn, at.getOriginName());
			result4 = new RecruitDao().insertPortfolio(conn, rm, at);
		}
		
		if (result1 * result2 * result3 * result4 > 0) {
			commit(conn);
		} else {
			rollback(conn);
			if (result1 * result3 > 0) {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return result1 * result2 * result3 * result4;
	}

	public int getListCountWithCode(String code) {
		Connection conn = getConnection();
		
		int listCount = new RecruitDao().getListCountWithCode(conn, code);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Recruitment> selectListWithCode(int startRow, int endRow, String code) {
		Connection conn = getConnection();
		
		ArrayList<Recruitment> list = new RecruitDao().selectListWithCode(conn, startRow, endRow, code);
		
		close(conn);
		
		return list;
	}

	
}