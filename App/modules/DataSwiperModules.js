/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";

import Swiper from 'react-native-swiper';
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight} from "react-native";
import TheFirstPageForAndroid from "../pages/TheFirstPageForAndroid";

let beanJson = require("../data/bean.json");


export default class DataSwiperModules extends Component{
    jumpClick(){
        const{navigator} = this.props;
        /*that存储了上一个this*/
        if(navigator){
            /*push主要掌管页面跳转 返回的component属性决定了呈现哪一个class*/
            navigator.push({
                name : "SecondPageComponent",
                component : TheFirstPageForAndroid,
            })
        }

    }


    render(){

        return(
            <View style={{width:Dimensions.get('window').width,height:200}}>
                <Swiper style={{width:Dimensions.get('window').width,height:200}}>
                    {this.renderSwiper(beanJson.adInfo)}
                </Swiper>
            </View>
        )
    }
    renderSwiper(beans){
        let banners=[];
        for (let i=0;i<beans.length;i++){

            let bean = beans[i].imgUrl;

            banners.push(
                <View key={i}
                      style={{flexDirection:"row",
                          backgroundColor:"#FFF",
                          alignItems:"center",
                          justifyContent:'center',width:Dimensions.get('window').width,height:160}}>
                    <Image style={{marginTop:20,resizeMode:"contain",width:Dimensions.get('window').width,height:160}} source={{uri:bean}}/>
                </View>
            )
        }
        return banners;
    }

}
