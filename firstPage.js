/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React from "react";
import {Image, Text, View} from "react-native";

export default class Firstpage extends React.Component{
    render(){
        return(
            <View>
                <View>
                    <Text/>
                </View>
                <View>
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                </View>
            </View>
        );
    }

}