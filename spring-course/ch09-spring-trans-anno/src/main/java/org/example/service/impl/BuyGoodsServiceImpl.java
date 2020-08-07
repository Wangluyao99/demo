package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.exception.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /**rollbackFor:表示发生指定异常一定回滚
     * 处理逻辑：1、Spring框架会先检查异常是否是rollbackFor列表中的属性值，如果是，不管什么类型直接回滚
     *          2、抛出异常不在rollbackFor列表中，spring会判断是否是RuntimeException,如果是，一定回滚
     */
    /**@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {NullPointerException.class,NotEnoughException.class})
         Transactional放在public方法上，也可以放在类上。注解方式基于aop的环绕通知。
    */
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("buy方法开始");
        /**记录销售信息，想sale表添加记录*/
        Sale sale=new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        /**更新库存*/
        /**根据goodsId查询商品*/
        Goods goods=goodsDao.selectGoods(goodsId);
        if (goods ==null){
            //商品不存在
            throw new NullPointerException(goodsId+"商品不存在");
        }else if (goods.getAmount()<nums){
            //商品库存不足
            throw new NotEnoughException("编号是："+goodsId+",商品不存在");
        }
        //修改库存
        Goods buyGoods=new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("buy方法结束");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
