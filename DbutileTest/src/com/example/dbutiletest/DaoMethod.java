package com.example.dbutiletest;

import java.util.List;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class DaoMethod {

	private static DaoMethod daotest;
	private DbUtils dbUtils;

	private DaoMethod(Context context) {
		dbUtils = DbUtils.create(context, "daobiao");
	}

	public static DaoMethod getInstance(Context context) {
		if (daotest == null) {
			daotest = new DaoMethod(context);
		}
		return daotest;
	}
	
	public DbUtils getDaoMethod(){
		return dbUtils ;
	}

	/**
	 * 储存下载信息数据。增
	 * 
	 * @param info
	 * @throws DbException
	 */
	public void setDownLoadInfo(DownLaodInfo info) throws DbException {
		dbUtils.save(info);
	}
	/**
	 * 删除一条下载信息。
	 * 
	 * @param info
	 * @throws DbException
	 */
	public void deleteDownLoadInfo(DownLaodInfo info) throws DbException {
		dbUtils.delete(info);
	}

	/**
	 * 更新某一条下载信息。
	 * 
	 * @param info
	 * @throws DbException
	 */
	public void upDataDownLoadInfo(DownLaodInfo info) throws DbException {
		dbUtils.update(info);
	}
	/**
	 * 查询所有下载信息数据。
	 * 
	 * @return
	 * @throws DbException
	 */
	public List<DownLaodInfo> getDownLoadInfoAll() throws DbException {
		return dbUtils.findAll(DownLaodInfo.class);
	}

	

	/**
	 * 通过sql查询。
	 * 
	 * @param sql
	 * @return
	 * @throws DbException
	 */
	public Cursor selectDownLoadInfoForSQL(String sql) throws DbException {
		return dbUtils.execQuery(sql);
	}
}
