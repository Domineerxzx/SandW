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
const RES_IMGS = [

    'http://thethreestooges.cn/aran/cloth.png',
    'http://thethreestooges.cn/aran/cloth.png',
    'http://thethreestooges.cn/aran/cloth.png',
    'http://thethreestooges.cn/aran/cloth.png',
];
export default class SwiperModules extends Component{
    render(){
        return(
            <Swiper style={styles.SwiperView}>
                <View style={styles.slide1}>
                    <Image resizeMode='stretch'
                           source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}/>
                </View>
                <View style={styles.slide2}>
                    <Image resizeMode='stretch'
                           source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}/>
                </View>
                <View>
                    <Image resizeMode='stretch'
                           style={{height: 100,width:100}}
                           source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}/>
                </View>
            </Swiper>
        );
    }

}
let H = 200;
const styles = StyleSheet.create({

    SwiperView:{
        marginTop:20,
        height:H,
        width:Dimensions.get('window').width
    },
    slide1: {
        height:H,
        justifyContent: 'center',
    },
    slide2: {
        height:H,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#97CAE5'
    },
    slide3: {
        height:H,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#92BBD9'
    },
    text: {
        color: '#fff',
        fontSize: 30,
        fontWeight: 'bold'
    }

});