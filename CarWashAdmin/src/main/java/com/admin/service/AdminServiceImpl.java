package com.admin.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.exception.WashpackNotFoundException;
import com.admin.models.WashPacks;
import com.admin.models.WasherLeaderboard;
import com.admin.repo.AdminRepository;
import com.admin.repo.WasherLeaderboardRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private WasherLeaderboardRepository washerLeaderboardRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public WashPacks addNewWashPack(WashPacks pack) {

		Random random = new Random();
		pack.setPackname(pack.getPackname());
		pack.setAmount(pack.getAmount());
		pack.setDescription(pack.getDescription());
		pack.setId(random.nextInt(9999));

		return adminRepository.save(pack);
	}
	

	@Override
	public List<WashPacks>getByName(String name) {
		List<WashPacks> packs=adminRepository.findByPackname(name);
		if(packs==null) {
			throw new WashpackNotFoundException("Not found");
		}
		return packs;
	}
	


	@Override
	public WashPacks findWashpacksById(int packId) {
		WashPacks packs=adminRepository.findById(packId).orElseThrow(()->new WashpackNotFoundException("Not found"));
		return packs;
	}

	

	public WasherLeaderboard addNewWasherToLeaderboard(WasherLeaderboard washerLeaderboard) {
		WasherLeaderboard washerLeaderboard2 = new WasherLeaderboard();
		washerLeaderboard2.setWasherName(washerLeaderboard.getWasherName());
		washerLeaderboard2.setWaterSavedInliters(washerLeaderboard.getWaterSavedInliters());
		return washerLeaderboardRepository.save(washerLeaderboard2);
	}

	

	@Override
	public WashPacks editWashPack(WashPacks washPacks) {
		adminRepository.findById(washPacks.getId()).orElseThrow(()->new WashpackNotFoundException("Not Found"));
		return adminRepository.save(washPacks);
	}

	
	

	@Override
	public List<WashPacks>getAllWashpacks(){
		return adminRepository.findAll();
	}


	@Override
	public List<WasherLeaderboard> getWasherLeaderboard() {
		return washerLeaderboardRepository.findAll();
	}

	
	@Override
	public void deleteWashpackById(int id)throws WashpackNotFoundException {
		if(adminRepository.findById(id).isPresent()) {
			adminRepository.deleteById(id);
		}
		else {
			throw new WashpackNotFoundException("Washpack with ID : " + id + " not found");
		}
		
	}
	
	
	@Override
	public WasherLeaderboard addToLeaderboard(WasherLeaderboard leaderboard) {
		//WasherLeaderboard leaderboard2 = new WasherLeaderboard();
		leaderboard.setRank(leaderboard.getRank());
		leaderboard.setWasherName(leaderboard.getWasherName());
		leaderboard.setWaterSavedInliters(leaderboard.getWaterSavedInliters());
		washerLeaderboardRepository.save(leaderboard);
		return leaderboard;
	}
	
	
}
