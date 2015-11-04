package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Collectible;


public interface CollectionsService {


	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(Integer id);
}
