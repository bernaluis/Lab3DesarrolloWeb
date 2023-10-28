package com.mitocode.service.impl;

import com.mitocode.model.Position;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPositionRepo;
import com.mitocode.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends CRUDImpl<Position,Integer> implements IPositionService {
    @Autowired
    private IPositionRepo repo;

    @Override
    protected IGenericRepo<Position, Integer> getRepo() {
        return repo;
    }
}
