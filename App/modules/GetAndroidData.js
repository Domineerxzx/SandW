/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/6/25
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";
import {Text, NativeModules,Dimensions, StyleSheet, View, Image, TouchableHighlight} from "react-native";

export default class GetAndroidData extends Component{





    render(){
        return(
            <View>
                <TouchableHighlight onPress={this.call_button.bind(this)}>
                    <Text>
                        ONCLICK
                    </Text>
                </TouchableHighlight>
            </View>
        )
    }
    call_button(){

        NativeModules.AransModules.rnCallNative("nihao")
    }

}