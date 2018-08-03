package com.yww.demo1;

public class ProductDao {
    public void save() {
        System.out.println("保存商品...");
    }

    public void update() {
        System.out.println("修改商品...");
    }

    public void delete() {
        System.out.println("删除商品...");
    }

    public String find() {
        System.out.println("查找商品...");

        //int i = 1/0;
        return "返回值";
    }

}
