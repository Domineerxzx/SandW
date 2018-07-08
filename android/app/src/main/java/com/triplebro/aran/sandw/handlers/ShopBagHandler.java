package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.triplebro.aran.sandw.adapters.ShopBagAdapter;
import com.triplebro.aran.sandw.beans.ShopBagInfo;
import com.triplebro.aran.sandw.managers.ShopBagManager;
import com.triplebro.aran.sandw.properties.AppProperties;
import com.triplebro.aran.sandw.views.InnerListView;

import java.util.List;

public class ShopBagHandler extends Handler {

    private Context context;
    private ShopBagManager shopBagManager;
    private static InnerListView ilv_shop_content;
    private ShopBagAdapter shopBagAdapter;

    public ShopBagHandler(Context context) {
        this.context = context;
    }

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
                shopBagAdapter = new ShopBagAdapter(context, shoppingList);
                ilv_shop_content.setAdapter(shopBagAdapter);
                context.unbindService(shopBagManager);
                break;
            case AppProperties.SHOP_BAG_DELETE:
                List<ShopBagInfo.ShoppingListBean> remove = (List<ShopBagInfo.ShoppingListBean>) msg.obj;
                shopBagAdapter = new ShopBagAdapter(context, remove);
                ilv_shop_content.setAdapter(shopBagAdapter);
                context.unbindService(shopBagManager);
                break;
            case AppProperties.SHOP_BAG_ADD:
                Toast.makeText(context, "添加购物袋成功", Toast.LENGTH_SHORT).show();
                context.unbindService(shopBagManager);
                break;
        }
    }
}
