package com.quinbay.springboottraining.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
    public class PurchaseOrder {
     public long getCustomerId() {
         return customerId;
     }

     public void setCustomerId(long customerId) {
         this.customerId = customerId;
     }

     public long getProductId() {
         return productId;
     }

     public void setProductId(long productId) {
         this.productId = productId;
     }

     public long getProductQuantity() {
         return productQuantity;
     }

     public void setProductQuantity(long productQuantity) {
         this.productQuantity = productQuantity;
     }

     private long customerId;
        private long productId;
        private long productQuantity;
    }


