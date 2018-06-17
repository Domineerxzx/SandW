/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";

import Swiper from 'react-native-swiper';
import {Text, Dimensions, StyleSheet, View, Image} from "react-native";

let beanJson = require("../data/bean.json");


export default class DataSwiperModules extends Component{


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

            let bean = beans[i];

            banners.push(
                <View key={i}
                      style={{width:400 ,height:200}}>
                    <Text>{bean.title}</Text>
                    <Image source={{uri:bean.imgUrl}}/>
                </View>
            )
        }
        return banners;
    }

}
