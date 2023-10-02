package com.admin.service;

import java.util.List;

import com.admin.exception.WashpackNotFoundException;
import com.admin.models.Customer;
import com.admin.models.WashPacks;
import com.admin.models.Washer;
import com.admin.models.WasherLeaderboard;

public interface AdminService {

	public WashPacks addNewWashPack(WashPacks pack);
	
	public List<WashPacks> getByName(String name);
	
	public WashPacks findWashpacksById(int packId);
	
	public WashPacks editWashPack(WashPacks washPacks);
	

	
	public WasherLeaderboard addToLeaderboard(WasherLeaderboard leaderboard);
		
	public void deleteWashpackById(int id)throws WashpackNotFoundException;
	
	public List<WashPacks> getAllWashpacks();
	
	public List<WasherLeaderboard> getWasherLeaderboard();
 

	
}
