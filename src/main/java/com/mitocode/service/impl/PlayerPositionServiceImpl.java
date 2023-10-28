package com.mitocode.service.impl;

import com.mitocode.model.PlayerPosition;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPlayerPositionRepo;
import com.mitocode.service.IPlayerPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPositionServiceImpl extends CRUDImpl<PlayerPosition,Integer> implements IPlayerPositionService {

    @Autowired
    private IPlayerPositionRepo repo;

    @Override
    protected IGenericRepo<PlayerPosition, Integer> getRepo() {
        return repo;
    }
}
