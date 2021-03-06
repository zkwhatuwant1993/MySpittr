package com.zk.myspittr.data;

import com.zk.myspittr.Spittle;

import java.util.List;

public interface SpittleRepository {
    /**
     *  获取Spittle列表
     * @param max Spittle id的最大值
     * @param count 返回的Spittle个数
     * @return Spittle列表
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     *  根据id获取Spittle
     * @param spittleId id
     * @return spittle
     */
    Spittle findOne(long spittleId);

    /**
     * 保存
     * @param spittle 要保存的数据
     */
    void saveSpittle(Spittle spittle);
}
