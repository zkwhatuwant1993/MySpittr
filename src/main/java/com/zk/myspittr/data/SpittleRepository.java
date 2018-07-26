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
}
