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


export default class TheFirstPageForAndroid extends Component {

    constructor() {
        super();
        this.state = {
            vlaues:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.setTitle("T恤#高跟鞋");
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }

    _onPressGetId(str){
        NativeModules.AransModules.setCommodityId(str)
    }




    jumpClick(){
        NativeModules.AransModules.setType("短袖");
        NativeModules.AransModules.startSelectAllActivity();
    }


    render() {
        if (this.state.vlaues==="???"){
            return(
                <View>
                    <Image style={{width:Dimensions.get('window').width}} source={require('../imges/01415f5996acdaa8012156038f6b78.gif')}/>
                </View>
            )
        }else {
            let parseJSONList = JSON.parse(this.state.vlaues).recommendationInfo;
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
                            <View style={{justifyContent: 'space-between', flexDirection: 'row'}}>
                                <Text style={{
                                    marginRight: 20,
                                    color: '#000',
                                    fontSize: 15,
                                    fontWeight: 'bold'
                                }}>特别为您推荐的{parseJSONList[0].itemName}</Text>
                                <View style={{marginRight: 20, justifyContent: 'flex-end'}}>
                                    <TouchableHighlight onPress={this.jumpClick.bind(this)}>
                                        <Text>选购全部 ></Text>
                                    </TouchableHighlight>
                                </View>
                            </View>
                            <View style={{flexDirection: 'column', alignItems: 'center'}}>
                                <DynamicImgesModules callback={this._onPressGetId.bind(this)}
                                    name={parseJSONList[0]}
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
                                    <TouchableHighlight onPress={this.jumpClick.bind(this)}>
                                        <Text>选购全部 ></Text>
                                    </TouchableHighlight>
                                </View>
                            </View>
                            <View style={{flexDirection: 'column', alignItems: 'center'}}>
                                <DynamicImgesModules callback={this._onPressGetId.bind(this)}
                                                     name={parseJSONList[1]}
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
      height:100,
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