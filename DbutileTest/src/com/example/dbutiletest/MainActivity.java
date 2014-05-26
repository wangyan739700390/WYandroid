package com.example.dbutiletest;

import java.util.ArrayList;
import java.util.List;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button btn_zeng, btn_delete, btn_update, btn_cha;
	EditText ed_zeng, ed_delete, ed_update, ed_cha;
	DbUtils dbUtils;
	DaoMethod daoMethod;
	DownLaodInfo zeng_Info = new DownLaodInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_zeng = (Button) findViewById(R.id.btn_zeng);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		btn_update = (Button) findViewById(R.id.btn_update);
		btn_cha = (Button) findViewById(R.id.btn_cha);
		ed_zeng = (EditText) findViewById(R.id.ed_zeng);
		ed_delete = (EditText) findViewById(R.id.ed_delete);
		ed_update = (EditText) findViewById(R.id.ed_update);
		ed_cha = (EditText) findViewById(R.id.ed_cha);
		daoMethod = DaoMethod.getInstance(this);
		dbUtils = daoMethod.getDaoMethod();
		oncClickMethod();

	}

	private void intdate() throws DbException {
		zeng_Info.setTitle(ed_zeng.getText().toString());
		zeng_Info.setId("xx");

	}

	private void oncClickMethod() {
		btn_zeng.setOnClickListener(this);
		btn_delete.setOnClickListener(this);
		btn_update.setOnClickListener(this);
		btn_cha.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_zeng:// 增
			try {
				intdate();
				daoMethod.setDownLoadInfo(zeng_Info);
				Toast.makeText(this, "增", 7000).show();
			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.btn_delete:// 删
			try {
				List<DownLaodInfo> list = daoMethod.getDownLoadInfoAll();
				if (list != null && list.size() > 0) {
					for (DownLaodInfo downLaodInfo : list) {
						//daoMethod.deleteDownLoadInfo(downLaodInfo);
						dbUtils.delete(downLaodInfo);
						Toast.makeText(this,
								"删" + downLaodInfo.getTitle().toString(), 7000)
								.show();
					}
				}
			} catch (DbException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case R.id.btn_update:// 改
			try {
				DownLaodInfo Info=new DownLaodInfo();
				Info.setTitle(ed_update.getText().toString());
				List<DownLaodInfo>list=daoMethod.getDownLoadInfoAll();
				if(list!=null&&list.size()>0){
					for(DownLaodInfo downLaodInfo:list){
						if(downLaodInfo.getTitle().equals("你妹")){
							daoMethod.upDataDownLoadInfo(Info);
						}
					}
				}
			} catch (DbException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case R.id.btn_cha:
			try {
				List<DownLaodInfo> list2 = daoMethod.getDownLoadInfoAll();
				if (list2 != null && list2.size() > 0) {
					for (DownLaodInfo downLaodInfo :list2) {
						Toast.makeText(this,
								"查" + downLaodInfo.getTitle().toString(), 7000)
								.show();
					}
				}

			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}
	}
}
