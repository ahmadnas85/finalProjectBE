package com.FinalProject.FinalProject.model;

import java.util.List;

public class OrderAndItemsRequest {
        private Order order;
        private List<ItemInOrder> itemsInOrder;

    public OrderAndItemsRequest(Order order, List<ItemInOrder> itemsInOrder) {
        this.order = order;
        this.itemsInOrder = itemsInOrder;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ItemInOrder> getItemsInOrder() {
        return itemsInOrder;
    }

    public void setItemsInOrder(List<ItemInOrder> itemsInOrder) {
        this.itemsInOrder = itemsInOrder;
    }
}
