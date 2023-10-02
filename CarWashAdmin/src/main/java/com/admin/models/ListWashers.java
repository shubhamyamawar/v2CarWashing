package com.admin.models;



import java.util.List;

import lombok.Data;

@Data
public class ListWashers {

	private List<Washer> list;

	public List<Washer> getList() {
		return list;
	}

	public void setList(List<Washer> list) {
		this.list = list;
	}
	
	
	
}

