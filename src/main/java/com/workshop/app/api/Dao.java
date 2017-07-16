package com.workshop.app.api;

import java.util.List;

public interface Dao {
	public int save(DataFromJdbc data);
	public int update(DataFromJdbc data);
	public int delete(int id);
	public int getById(int id);
	public List<DataFromJdbc> getData();
}
