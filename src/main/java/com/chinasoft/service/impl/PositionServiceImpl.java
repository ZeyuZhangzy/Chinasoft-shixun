package com.chinasoft.service.impl;

import com.chinasoft.mapper.PositionMapper;
import com.chinasoft.pojo.Position;
import com.chinasoft.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper posMapper;


    public List<Position> selectAll() {
        return posMapper.selectAll();
    }

    public void deletePos(List<Long> ids) {
        posMapper.deletePos(ids);
    }

    public void insertPos(Position position) {
        posMapper.insertPos(position);
    }

    public void updatePos(Position position) {
        posMapper.updatePos(position);
    }

    public Position selectPosById(Long id){
        return posMapper.selectPosById(id);
    }

    public int countPos(){ return posMapper.countPos();}

    public List<Position> selectPosByPage(int page) {
        return posMapper.selectPosByPage(page);
    }

    public List<Position> searchPos(String name){
        return posMapper.searchPos(name);
    }
}
