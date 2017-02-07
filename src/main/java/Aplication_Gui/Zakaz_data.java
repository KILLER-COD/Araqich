package Aplication_Gui;

public class Zakaz_data {
    private String id;
    private String goods_name;
    private String counts;
    private String sort;
    private String price;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getCounts() {
        return this.counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String toString() {
        return "{id=\'" + this.id + '\'' + ", goods_name=\'" + this.goods_name + '\'' + ", counts=\'" + this.counts + '\'' + ", sort=\'" + this.sort + '\'' + ", price=\'" + this.price + '\'' + '}';
    }

    public Zakaz_data() {
    }
}
