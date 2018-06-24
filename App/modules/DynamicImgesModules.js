/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight, ScrollView} from "react-native";

let beanJson = require("../data/bean.json");

export default class DynamicImgesModules extends Component{

    getItem(){
        let arr = [];
        for (let i=0;i<beanJson.adInfo.length;i++){
            let infoList =beanJson.adInfo[i];
            arr.push(

                <View key={i}
                      style={{width:Dimensions.get('window').width/2-20,flexDirection:'column'}}>
                    <Image
                        style={{width:Dimensions.get('window').width/2-20,height:200}}
                        source={{uri:infoList.imgUrl}}/>
                    <View style={{alignItems:'center'}}>
                        <Text style={{fontWeight:'bold',fontSize:20}}>{infoList.title1}</Text>
                        <Text style={{fontWeight:'bold'}}>{infoList.title2}</Text>
                    </View>
                </View>

                //  信息加载源    {infoList.imgUrl}
            );
        }
        return arr;


    }
    render(){
        return(

            <View style={{margin:10,marginTop:20,alignItems:'stretch',flexDirection:'row',flexWrap:'wrap'}}>
                {this.getItem()}
            </View>
        );
    }

}