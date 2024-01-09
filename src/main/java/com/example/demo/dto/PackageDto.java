package com.example.demo.dto;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Cstomer;
import com.example.demo.entity.PackageHistory;
import com.example.demo.entity.PackageStatus;
import com.example.demo.entity.Poter;

public class PackageDto {
	
	public int id ;
	public String date;
	public String weight;
	public String addressToSend;
	public String fee;
	public String transpoter;
	public String startBranchHandler;
	public String endchBranchHandler;
	public String history;
	
	
	 public PoterDto poterDto;
	 public CustomerDto senderDto;
	 public CustomerDto receiverDto;
	 public BranchDto endBranchDto;
	 public BranchDto startBranchDto;
	 public PackageStatusDto packageStatusDto;
	 public PackageHistoryDto packagehistoryDto;
	 
}
