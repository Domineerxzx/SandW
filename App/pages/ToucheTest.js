/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/6/22
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {NativeModules, Text, TextInput, TouchableHighlight, View} from "react-native";
export default class ToucheTest extends Component{

    constructor() {
        super();
        this.state = {
            vlaues:"",
            json:""
        }
    }

    componentWillUnmount() {
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})}).then(
                this.setState({json:JSON.parse(this.state.vlaues)})
        )
    }


    render(){
        this.componentWillUnmount();
            return(
                <View>
                    <Text>
                        {this.state.json}
                        {/*{this.state.json.recommendationInfo.itemInfo[0].brandName}*/}
                    </Text>
                </View>
        )
    }

}