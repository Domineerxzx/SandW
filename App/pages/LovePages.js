/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/11
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight, ScrollView, NativeModules} from "react-native";
import DynamicImgesModules from "../modules/DynamicImgesModules";

export default class LovePages extends Component{

    constructor() {
        super();
        this.state = {
            vlaues:"???",
        }
    }

    componentWillMount() {
        NativeModules.AransModules.getLovesList((result) => {this.setState({vlaues:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }


    _onPressGetId(str){
        NativeModules.AransModules.setCommodityId(str);
    }

    render(){
        if (this.state.vlaues === "???") {
         return(
             <View>
                 <Text>
                     无数据
                 </Text>
             </View>
         )
        }
        else {

            let parse = JSON.parse(this.state.vlaues);

            if (parse.collectshow.length===0){
                return(
                    <View style={{alignItems:"center"}}>
                        <Text style={{color:"#7d7d7d"}}>您的心愿单为空~  快去选购商品吧</Text>
                    </View>
                )
            }
            return (
                <ScrollView>
                    <DynamicImgesModules callback={this._onPressGetId.bind(this)}
                        name={parse.collectshow}/>
                    <View style={{height:80}}>

                    </View>
                </ScrollView>
            )
        }
    }

}