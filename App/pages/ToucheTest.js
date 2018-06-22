/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/6/22
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text, TextInput, TouchableHighlight, View} from "react-native";

export default class TestTouchable extends Component{


    constructor() {
        super();

        this.state ={

            value:"aaa"

        }

    }
    changeValues(e){
        this.setState({
            value: e.nativeEvent.text
        })
    }
    getValues(){
        this.setState({
            value:this.state.vlaue
        })
    }

    render(){
        return(
            <View>


                <TextInput onChangeText={(text) => this.setState({value: text})}  >

                </TextInput>
                <Text >
                    {this.state.value}
                </Text>
            </View>
        );
    }
}