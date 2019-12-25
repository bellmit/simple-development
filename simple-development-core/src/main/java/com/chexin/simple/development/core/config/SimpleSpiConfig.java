package com.chexin.simple.development.core.config;

/**
 * 组件发现接口
 *
 * @author liko wang
 * @param <T>
 */
public interface SimpleSpiConfig<T,M> {
    /**
     * 获取组件配置
     *
     * @param t
     * @return
     */
    Class<M> getConfigClass(T t);
}
