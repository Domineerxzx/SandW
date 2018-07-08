package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.triplebro.aran.sandw.adapters.ShopBagAdapter;
import com.triplebro.aran.sandw.beans.ShopBagInfo;
import com.triplebro.aran.sandw.managers.ShopBagManager;
import com.triplebro.aran.sandw.properties.AppProperties;
import com.triplebro.aran.sandw.views.InnerListView;

import java.util.List;

public class ShopBagHandler extends Handler {

    private Context context;
    private ShopBagManager shopBagManager;
    private InnerListView ilv_shop_content;

    public ShopBagHandler(Context context, InnerListView ilv_shop_content) {
        this.context = context;
        this.ilv_shop_content = ilv_shop_content;
    }

    public void setShopBagManager(ShopBagManager shopBagManager) {
        this.shopBagManager = shopBagManager;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case AppProperties.SHOP_BAG_SHOW:
                ShopBagInfo shopBagInfo = (ShopBagInfo) msg.obj;
                List<ShopBagInfo.ShoppingListBean> shoppingList = shopBagInfo.getShoppingList();
                ShopBagAdapter shopBagAdapter = new ShopBagAdapter(context, shoppingList);
                ilv_shop_content.setAdapter(shopBagAdapter);
                break;
        }
    }
}
