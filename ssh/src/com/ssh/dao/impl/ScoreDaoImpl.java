package com.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.dao.ScoreDao;
import com.ssh.model.Score;

/**
 * 
 * 对学生录入、查询、修改操作的Dao处理类
 * 
 */
@Component("scoreDao")
public class ScoreDaoImpl extends SuperDao<Score> implements ScoreDao {

	public ScoreDaoImpl() {
		super(Score.class);
	}

	// 录入学生成绩
	public void addScore(int sid, int cid, double score) {
		System.out.println("----sid=" + sid);
		System.out.println("----cid=" + cid);
		System.out.println("----score=" + score);
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("insert into score (student_id,course_id,score) values (");
		buffer.append(sid);
		buffer.append(",");
		buffer.append(cid);
		buffer.append(",");
		buffer.append(score);
		buffer.append(")");
		this.getHibernateTemplate().getSessionFactory().openSession()
				.createSQLQuery(buffer.toString()).executeUpdate();
	}

	// 通过id查询学生成绩
	public Score getScoreByid(Integer id) {
		try {
			return super.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 通过教师id查询学生成绩列表
	public List<Score> getScoreByTeacherId(Integer id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Score s where s.course.teacher.id=");
		buffer.append(id);
		try {
			return super.find(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 修改学生成绩
	public void updateScoreById(int id, double score) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update score s set s.score=");
		buffer.append(score);
		buffer.append(" where s.id=");
		buffer.append(id);
		this.getHibernateTemplate().getSessionFactory().openSession()
				.createSQLQuery(buffer.toString()).executeUpdate();
	}

}
