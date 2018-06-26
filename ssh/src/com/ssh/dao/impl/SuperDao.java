package com.ssh.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @Description：DAO业务公共方法
 */
public class SuperDao<T> extends HibernateDaoSupport {
	private Class<?> clazz = null;

	public SuperDao(final Class<?> clazz) {
		this.clazz = clazz;
	}

	protected SessionFactory sessionFactory = super.getSessionFactory();

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory)
			throws Exception {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 持久化一个
	 * 
	 * @param object
	 * @return
	 */
	public Integer save(final T t) throws Exception {
		return (Integer) getHibernateTemplate().save(t);
	}

	/**
	 * 删除一个
	 * 
	 * @param entity
	 */
	public void delete(final Object entity) throws Exception {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 更新一个数据
	 * 
	 * @param o
	 */
	public void update(final Object o) throws Exception {
		getHibernateTemplate().update(o);
		getHibernateTemplate().flush();
	}

	/**
	 * 根据传入的map更新部分字段
	 * 
	 * @param field
	 *            更新字段Map
	 * @param t
	 *            对象
	 * @param condition
	 *            条件Map
	 * @return
	 */
	public int updateByMap(Map<String, Object> field, final T t,
			Map<String, Object> condition) {
		int fSize = field.size();
		int cSize = condition.size();
		int f = 0, c = 0;// 记遍历map的次数
		String name = t.getClass().getSimpleName();// 对象名
		int len = name.length();
		StringBuffer table = new StringBuffer();// 用于保存对象转化后的表名
		table.append(name.substring(0, 1).toLowerCase());
		for (int i = 1; i < len; i++) {
			if (name.substring(i, i + 1).equals(
					name.substring(i, i + 1).toUpperCase())) {// 如果对象名中存在大写字母转为小写+“_”
				table.append("_");
				table.append(name.substring(i, i + 1).toLowerCase());
			} else {
				table.append(name.substring(i, i + 1));
			}
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("update " + table.toString() + " set ");
		for (Map.Entry<String, Object> m : field.entrySet()) {
			buffer.append(m.getKey().toString());
			buffer.append(" = '");
			buffer.append(m.getValue().toString());
			f++;
			if (f < fSize) {
				buffer.append("',");
			} else {
				buffer.append("'");
			}
		}
		buffer.append(" where ");
		for (Map.Entry<String, Object> m1 : condition.entrySet()) {
			buffer.append(m1.getKey().toString());
			buffer.append(" = '");
			buffer.append(m1.getValue().toString());
			c++;
			if (c < cSize) {
				buffer.append("' and ");
			} else {
				buffer.append("'");
			}
		}
		return super.getSession().createQuery(buffer.toString())
				.executeUpdate();
	}

	/**
	 * 获取一个对象
	 * 
	 * @param clazz
	 * @param id
	 */
	public T get(final int id) throws Exception {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	/**
	 * HQL查询
	 * 
	 * @param hql
	 */
	public List<T> find(final String hql) throws Exception {
		getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find(hql);
	}

	/**
	 * HQL分页查询
	 * 
	 * @param hql
	 * @param page
	 * @param pageSize
	 */
	public List<T> findByPage(final String hql, int page, int pageSize)
			throws Exception {
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * pageSize); // 开始记录
		query.setMaxResults(pageSize); // 查询多少条
		return query.list();
	}

	/**
	 * 获取这个表数据总量
	 * 
	 * @param tableName
	 */
	public List<T> findAll(final String tableName) throws Exception {
		getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find("from " + tableName);
	}

	/**
	 * SQL查询
	 * 
	 * @param hql
	 */
	public List<Object[]> sqlQuery(final String sql) throws Exception {
		return super.getSession().createSQLQuery(sql).list();
	}

	/**
	 * SQL查询分页
	 * 
	 * @param hql
	 */
	public List<Object[]> sqlQueryPage(final String sql, final int pageNum,
			final int pageSize) throws Exception {
		Query query = super.getSession().createSQLQuery(sql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 获取这个表数据总量
	 * 
	 * @param tableName
	 */
	public Integer getSize(final String tableName) throws Exception {
		getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find("from " + tableName).size();
	}

	/**
	 * 登录验证
	 * 
	 * @param hql
	 * @param condition
	 * @return
	 */
	public Object check(String hql, Object[] condition) {
		Object obj = null;
		try {
			Query query = getSession().createQuery(hql);
			if (condition.length != 0)
				for (int i = 0; i < condition.length; i++)
					query.setParameter(i, condition[i]);
			obj = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
