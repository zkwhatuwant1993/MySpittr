package com.zk.myspittr.data;

import com.zk.myspittr.Spitter;

public interface SpitterRepository {
    /**
     * 保存Spitter信息
     * @param spitter 要保存的spitter
     * @return 如果保存成功返回true，否则返回false
     */
    public Spitter save(Spitter spitter);

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息对象
     */
    Spitter findByUsername(String username);
}
