package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Collectible;

public interface CollectionsDao {


	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(int id);
}
