package org.example.dao;

import org.example.domain.Goods;

public interface GoodsDao {
    /**更新库存，goods表示本次用户购买商品信息，id，数量*/
    int updateGoods(Goods goods);

    /**查询商品信息*/
    Goods selectGoods(Integer id);
}
