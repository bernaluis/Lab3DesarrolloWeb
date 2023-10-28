package com.mitocode.service.impl;

import com.mitocode.model.Player;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPlayerRepo;
import com.mitocode.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl extends CRUDImpl<Player,Integer> implements IPlayerService {
    @Autowired
    private IPlayerRepo repo;
    @Override
    protected IGenericRepo<Player, Integer> getRepo() {
        return repo;
    }
}
