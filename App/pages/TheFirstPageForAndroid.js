/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Image, Dimensions, ScrollView, StyleSheet, Text, View, TouchableHighlight} from "react-native";
import SwiperModules from "../modules/SwiperModules";
import DynamicImgesModules from "../modules/DynamicImgesModules";
import DataSwiperModules from "../modules/DataSwiperModules";


export default class TheFirstPageForAndroid extends Component {

    static jumpOnclick(){
        alert("???")
    }


    render() {
        return (
            <View>
                <ScrollView>
                    <View style={styles.allTheView}>
                        <View style={styles.ADBG}>
                            <Text style={styles.ADTest}>年 度 特 惠 S A L E | 高 达 5 0 % O F F</Text>
                        </View>
                        <View style={styles.BuyJewelryView}>
                            <Text style={styles.BuyJewelry}>
                                选购首饰
                            </Text>
                            <DataSwiperModules style={styles.SwiperView}/>
                        </View>
                        <View style={{justifyContent:'space-between',flexDirection:'row'}}>
                            <Text style={{marginRight:20,color:'#000', fontSize:15,fontWeight:'bold'}}>特别为您推荐的上衣</Text>
                            <View  style={{marginRight:20,justifyContent:'flex-end'}}>
                                <TouchableHighlight onPress={TheFirstPageForAndroid.jumpOnclick()}>
                                <Text>选购全部 ></Text>
                                </TouchableHighlight>
                            </View>
                        </View>
                        <View style={{flexDirection:'column',alignItems:'center'}}>
                            <DynamicImgesModules style={{flexDirection:'row'}}/>
                        </View>
                    </View>

                </ScrollView>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    allTheView: {
        paddingLeft: Dimensions.get('window').width * 0.03,
        backgroundColor: "#FFFFFF",
        flexDirection: 'column',
        justifyContent: 'center'
    },

    ADBG: {

        width: Dimensions.get('window').width - 20,
        alignItems:'center',
        marginTop:20,
        height: 40,
        backgroundColor: "#e2e2e2",


    },
    ADTest: {
        alignItems: 'center',
        marginTop:10,
        color: "#fc5d6e",
        justifyContent: 'center',
        flexDirection: 'row'
    },
    BuyJewelryView:{
        marginTop:20,
        alignItems:'center',
    },
    BuyJewelry:{
        fontSize:20,
        fontWeight:"bold",
        flexDirection: 'row',
        justifyContent: 'center',
        color:"#000"
    },
    SwiperView:{
        marginTop:50
    }


});