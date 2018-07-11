/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/9
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text,Dimensions,StyleSheet, View, TouchableHighlight, NativeModules, Image, ScrollView} from "react-native";
import DynamicImgesModules from "../modules/DynamicImgesModules";

export default class BuyALLPages extends Component{

    constructor() {
        super();
        this.state = {
            vlaues:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.getSelectAll((result) => {this.setState({vlaues:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }

    // componentDidMount() {
    //      this.setState({json:JSON.parse(this.state.Tshirtvlaues)});
    // }
    componentDidMount(){
        NativeModules.AransModules.SEND_LOG("这是render结束"+this.state.vlaues);

    }
    _onPressGetId(str){
        NativeModules.AransModules.setCommodityId(str)
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
                <ScrollView>

                    <DynamicImgesModules callback={this._onPressGetId.bind(this)} name={parse.rangeSearch}/>

                </ScrollView>
            )
        }
    }
}