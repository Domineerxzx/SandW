/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/6/25
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";
import {Text, NativeModules, View,TouchableHighlight} from "react-native";

export default class GetAndroidData extends Component{
    render(){

        this.call_button();
        return(
            <View>
                    <Text>
                        ONCLICK
                        {NativeModules.AransModules.AransData}
                    </Text>
            </View>
        )
    }


    call_button(){

        NativeModules.AransModules.giveRnData()
    }

    /*onPress={this.call_button()}*/
}