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
            vlaues:"???",
            json:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }

    // componentDidMount() {
    //      this.setState({json:JSON.parse(this.state.vlaues)});
    // }
    componentDidMount(){
        NativeModules.AransModules.SEND_LOG("这是render结束"+this.state.vlaues);

    }

    render() {
        NativeModules.AransModules.SEND_LOG("render"+this.state.vlaues);
        NativeModules.AransModules.SEND_LOG("dsuihfjfhasfhasfsj");
        if (this.state.vlaues==="???"){
            return(
                <View>
                    <Text>
                        无数据
                    </Text>
                </View>
            )
        }else {
            let parse = JSON.parse(this.state.vlaues);
            return (
                <View>
                    <Text>
                        OK{parse.recommendationInfo.itemInfo[0].brandName}
                    </Text>
                </View>
            )
        }
        // let parse = JSON.parse(this.state.vlaues);

    }

}