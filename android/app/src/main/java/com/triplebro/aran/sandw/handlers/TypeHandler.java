package com.triplebro.aran.sandw.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import com.triplebro.aran.sandw.adapters.TypeContentAdapter;
import com.triplebro.aran.sandw.beans.TypeInfo;
import com.triplebro.aran.sandw.managers.TypeManager;

import java.util.List;

public class TypeHandler extends Handler {

    private Context context;
    private ListView lv_type;
    private TypeManager typeManager;

    public TypeManager getTypeManager() {
        return typeManager;
    }

    public void setTypeManager(TypeManager typeManager) {
        this.typeManager = typeManager;
    }

    public TypeHandler(Context context, ListView lv_type) {
        this.context = context;
        this.lv_type = lv_type;
    }

    @Override
    public void handleMessage(Message msg) {
        TypeInfo typeInfo = (TypeInfo) msg.obj;
        List<TypeInfo.BigRangeListBean> bigRangeList = typeInfo.getBigRangeList();
        TypeContentAdapter typeContentAdapter = new TypeContentAdapter(context, bigRangeList);
        lv_type.setAdapter(typeContentAdapter);
        context.unbindService(typeManager);
    }
}
