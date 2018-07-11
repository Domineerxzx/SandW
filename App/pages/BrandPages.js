/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {
    Image,
    Alert,
    Dimensions,
    ScrollView,
    StyleSheet,
    Text,
    View,
    TouchableHighlight,
    NativeModules
} from "react-native";
import DynamicImgesModules from "../modules/DynamicImgesModules";
import DataSwiperModules from "../modules/DataSwiperModules";
import App from "./App";
import TheNextPage from "./TheNextPage";


export default class BrandPages extends Component {

    constructor() {
        super();
        this.state = {
            vlaues:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.setTitle("连衣裙#手包");
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }

    _onPressGetId(str){
        NativeModules.AransModules.setCommodityId(str);
    }

    _OnPressGetJson(str){
        NativeModules.AransModules.setTitle("T恤#高跟鞋");
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})});

    }




    jumpClick(str){
        NativeModules.AransModules.setType(str);
        NativeModules.AransModules.startSelectAllActivity();
    }


    render() {
        if (this.state.vlaues==="???"){
            return(
                <View style={{
                    flexDirection: "row", alignItems: "center",
                    justifyContent: 'center'
                }}>
                    <Image style={{marginTop:(Dimensions.get('window').width-50)/2,width:100,height:100,resizeMode: "contain"}} source={require('../imges/wait.png')}/>
                </View>
            )
        }else {
            let parseJSONList = JSON.parse(this.state.vlaues).recommendationInfo;
            return (
                <View>
                    <ScrollView>
                        <View style={styles.allTheView}>
                            <View style={{justifyContent: 'space-between', flexDirection: 'row'}}>
                                <Text style={{
                                    marginRight: 20,
                                    color: '#000',
                                    fontSize: 15,
                                    fontWeight: 'bold'
                                }}>特别为您推荐的{parseJSONList[0].itemName}</Text>
                                <View style={{marginRight: 20, justifyContent: 'flex-end'}}>
                                    <TouchableHighlight onPress={()=>{this.jumpClick(parseJSONList[0].itemName)}}>
                                        <Text>选购全部 ></Text>
                                    </TouchableHighlight>
                                </View>
                            </View>
                            <View style={{marginTop:20,flexDirection: 'column', alignItems: 'center'}}>
                                <DynamicImgesModules callback={this._onPressGetId.bind(this)}
                                    name={parseJSONList[0].itemInfo}
                                                     style={{flexDirection: 'row'}}/>
                            </View>
                            <View style={{justifyContent: 'space-between', flexDirection: 'row'}}>
                                <Text style={{
                                    marginRight: 20,
                                    color: '#000',
                                    fontSize: 15,
                                    fontWeight: 'bold'
                                }}>特别为您推荐的{parseJSONList[1].itemName}</Text>
                                <View style={{marginRight: 20, justifyContent: 'flex-end'}}>
                                    <TouchableHighlight onPress={()=>{this.jumpClick(parseJSONList[1].itemName)}}>
                                        <Text>选购全部 ></Text>
                                    </TouchableHighlight>
                                </View>
                            </View>
                            <View style={{flexDirection: 'column', alignItems: 'center'}}>
                                <DynamicImgesModules callback={this._onPressGetId.bind(this)}
                                                     name={parseJSONList[1].itemInfo}
                                                     style={{flexDirection: 'row'}}/>
                            </View>
                        </View>



                        <View style={styles.dianjiaoshi}>

                        </View>



                    </ScrollView>
                </View>
            );
        }
    }
}
const styles = StyleSheet.create({
    dianjiaoshi:{
      height:210,
    },
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