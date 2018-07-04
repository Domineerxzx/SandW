package com.triplebro.aran.sandw.utils.aranUtils;

import android.app.Activity;
import android.content.Intent;

import com.triplebro.aran.sandw.activities.MainActivity;
import com.triplebro.aran.sandw.activities.ReactNextAcivity;

/**
 * Created by Aran on 2018/7/5.
 * 那当自己都萎靡到
 * 无法被依靠的时候该如何振作？
 * <p>
 * 除过自己心中笃信的那一点不灭的光亮
 * 我觉得这世间再没有别的东西比它值得被如此依靠。
 */

public class JumpActivity extends Activity {

    public void Jump(){
        Intent intent = new Intent(this, ReactNextAcivity.class);
        startActivity(intent);
    }

}
