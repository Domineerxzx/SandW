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


    constructor() {
        super();
        this.state = {
            vlaues:"this"
        }
    }

    render(){

        let nativeResult=NativeModules.AransModules.aa;

        return(
            <View>
                <TouchableHighlight onPress={this.getValues(nativeResult).bind(this)}>
                    <Text>
                        aaaa
                    </Text>
                </TouchableHighlight>
                    <Text>
                        SHOW:
                        {this.state.vlaues}
                    </Text>
            </View>
        )
    }

    getValues(nativeResult){
        this.aaa();
        this.setState({vlaues:nativeResult})
    }



    aaa(){
        NativeModules.AransModules.giveRnData()
    }


    call_button(){
        NativeModules.AransModules.rnCallNative("这里是js端传递的数据");
    }
    /*onPress={this.call_button()}*/
}