package cn.binux.pojo;

public class Product {
    private Integer productId;

    private String productName;

    private Double productPrice;

    private String productDesc;

    private String productImagePath;

    private Integer storeNum;

    private Integer productStatus;


    public Product(int productId, String productName, double productPrice, String productDesc, String productImagePath,
                   int storeNum, int productStatus) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productImagePath = productImagePath;
        this.storeNum = storeNum;
        this.productStatus = productStatus;
    }

    public Product(int productId, String productName, double productPrice, String productDesc,
                   int storeNum, int productStatus) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.storeNum = storeNum;
        this.productStatus = productStatus;
    }

    public Product(String productName, double productPrice, String productDesc, String productImagePath, int storeNum,
                   int productStatus) {
        super();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productImagePath = productImagePath;
        this.storeNum = storeNum;
        this.productStatus = productStatus;
    }


    public Product() {
        super();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath == null ? null : productImagePath.trim();
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}