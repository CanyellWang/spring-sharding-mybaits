package com.snowcattle.demo.entity;


public abstract class AbstractShardingTable {

    private Integer sharding_table_index;

    public Integer getSharding_table_index() {
        return sharding_table_index;
    }

    public void setSharding_table_index(Integer sharding_table_index) {
        this.sharding_table_index = sharding_table_index;
    }
}
