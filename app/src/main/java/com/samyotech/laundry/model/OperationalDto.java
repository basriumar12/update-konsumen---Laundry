package com.samyotech.laundry.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OperationalDto implements Serializable {

	@SerializedName("hari")
	private String hari;

	@SerializedName("jam_buka")
	private String jamBuka;

	@SerializedName("jam_tutup")
	private String jamTutup;

	@SerializedName("shop_id")
	private String shopId;

	@SerializedName("id")
	private String id;

	@SerializedName("status")
	private String status;

	public String getHari(){
		return hari;
	}

	public String getJamBuka(){
		return jamBuka;
	}

	public String getJamTutup(){
		return jamTutup;
	}

	public String getShopId(){
		return shopId;
	}

	public String getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}
}