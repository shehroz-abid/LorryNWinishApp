package com.example.lorrynwinsh.DataModels;

/**
 * Created by macbookpro on 10/11/2016.
 */

public class MenuItemModel {

    public MenuItemModel(int iconId, String name){
        setItemIcon(iconId);
        setItemName(name);
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private int itemIcon;
    private String itemName;
}
