package com.zk.myspittr.data;

import com.zk.myspittr.Spittle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpittleRepositoryImpl implements SpittleRepository{
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long spittleId) {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
    }
}
