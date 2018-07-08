/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";

import Swiper from 'react-native-swiper';
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight, NativeModules} from "react-native";

let beanJson = require("../data/bean.json");

export default class BigDataSwiperModules extends Component{




    render(){
        return(
            <View style={{width:Dimensions.get('window').width,height:300,backgroundColor:"#FFF"}}>
                <Swiper style={{backgroundColor:"#FFF",width:Dimensions.get('window').width,height:300}}>
                    {this.renderSwiper(this.props.name.photoDoc)}
                </Swiper>
            </View>
        )
    }
    renderSwiper(beans){
        let banners=[];
        for (let i=0;i<4;i++){

            let bean = beans+"/"+(i+1).toString()+".png";
            NativeModules.AransModules.SEND_LOG("========这是图片链接地址========="+bean);


            banners.push(
                <View key={i}
                    style={{flexDirection:"row",
                        backgroundColor:"#FFF",
                        alignItems:"center",
                        justifyContent:'center',width:Dimensions.get('window').width,height:300}}>
                    <Image style={{resizeMode:"contain",width:Dimensions.get('window').width,height:300}} source={{uri:bean}}/>
                </View>
            )
        }
        return banners;
    }

}
