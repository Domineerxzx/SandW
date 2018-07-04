/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/5
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text, View,  TouchableHighlight, NativeModules} from "react-native";

export default class JumpNextActivity extends Component{

    render(){
        return(
            <View>
                <TouchableHighlight onPress={() => {NativeModules.AransModules.startNextActivity()}}>
                    <Text style={{fontSize:20}}>
                        TOUCH ME
                    </Text>
                </TouchableHighlight>
            </View>
        );
    }

}