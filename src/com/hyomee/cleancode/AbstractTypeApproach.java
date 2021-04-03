package com.hyomee.cleancode;

import java.util.*;

/**
 * 함수 외부에서 결정된 값을 함수 내부에서 사용 할 떄 객체 타입을 맞추거나 변환을 해서 사용 하는 경우
 * 외부에서 다양하게 사용 할 수 있도록 추상 타입을 사용 하므로 유연한 코드를 만등 수 있다.
 */
public class AbstractTypeApproach {

    public static void main(String[] agrs) {

        ArrayList<ProductVO> productVOArrayList = new ArrayList<>();

        productVOArrayList.add(new ProductVO("0001", "요금상품"));
        productVOArrayList.add(new ProductVO("0002", "부가상품"));

        List<ProductVO> productVOList = new ArrayList<>();

        productVOList.add(new ProductVO("0001", "요금상품"));
        productVOList.add(new ProductVO("0002", "부가상품"));

        /**
         * 결정된 타입을 통한 코드
         */
        Product product = new Product();
        product.setProductLikedList(productVOArrayList);
        // 오류 product.setProductLikedList(productVOList);

        LinkedList<ProductVO> productVOLinkedList = product.getProductList();
        // 오류 ArrayList<ProductVO> productVOLinkedList1 = product.getProductList();

        /**
         * 추상 타입을 통한 코드
         */
        ProductForAbstractType productForAbstractType = new ProductForAbstractType();
        // 원하는 Type으로 파라메터 생성 해서 보내면 됨
        productForAbstractType.setProducCollection(productVOArrayList);
        productForAbstractType.setProducCollection(productVOList);

        // 원하는 Type로 작업
        LinkedList<ProductVO> productList = product.getProductList();

    }


}

/**
 * 결정된 Type으로 만들 객체
 * -
 */
class Product {
   private LinkedList<ProductVO> productLikedList = new LinkedList();

   public void setProductLikedList(ArrayList<ProductVO> productArrayList) {
       productLikedList.addAll(productArrayList);
   }

   public LinkedList<ProductVO> getProductList() {
       LinkedList<ProductVO> productVOList = new LinkedList<>();
       for (ProductVO productVO : productLikedList) {
           productVOList.add(productVO);
       }
       return productVOList;
   }
}

class ProductForAbstractType {
    private List<ProductVO> productLikedList = new LinkedList();

    public void setProducCollection(Collection<ProductVO> productVOCollection) {
        productLikedList.addAll(productVOCollection);
    }

    public List<ProductVO> getProductList() {
        LinkedList<ProductVO> productVOList = new LinkedList<>();
        for (ProductVO productVO : productLikedList) {
            productVOList.add(productVO);
        }
        return productVOList;
    }
}

class ProductVO {

    private String productId;
    private String productName;

    ProductVO(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}