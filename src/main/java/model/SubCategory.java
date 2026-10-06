package model;

public class SubCategory {

    private int id;
    private int categoryId;
    private String subCategoryName;

    public SubCategory() {
    }

    public SubCategory(int id, int categoryId, String subCategoryName) {
        this.id = id;
        this.categoryId = categoryId;
        this.subCategoryName = subCategoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}