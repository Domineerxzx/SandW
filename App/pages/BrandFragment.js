/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/6
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text,Dimensions,StyleSheet, View, TouchableHighlight, NativeModules, Image, ScrollView} from "react-native";
import ScrollViewGetGoodInfo from "./ScrollViewGetGoodInfo";
import ActionButton from "react-native-action-button";


export default class BrandFragment extends Component{

    constructor() {
        super();
        this.state={
            getjson:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.getGoodInfo((result) => {this.setState({getjson:result})});
        NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.vlaues);
    }
    render(){
        if (this.state.getjson === "???") {
            return(
                <View>
                    <Text>
                        啥也没有
                    </Text>
                </View>
            )
        }else {
            let parse = JSON.parse(this.state.getjson);
            return(
                <View>
                    <View style={styles.AllTheView}>
                        <View style={{backgroundColor:"#fff"}}>
                            <Image style={styles.TheBackButton} source={require('../imges/back.png')}/>
                        </View>
                        <ScrollView>
                            <ScrollViewGetGoodInfo name={this.state.getjson}/>
                        </ScrollView>
                        <View style={styles.ActionButtonStylesView}>
                            <TouchableHighlight style={styles.ActionButtonStyles}>
                                <Text style={{fontWeight:"bold",fontSize:15,color:"#fff"}}>
                                    加入购物袋
                                </Text>
                            </TouchableHighlight>
                        </View>


                    </View>
                </View>
            )
        }

    }

}
const styles = StyleSheet.create({
    AllTheView:{
        flexDirection:"column",
        backgroundColor:"#00000000"
    },
    TheBackButton:{
        width:30,height:30,resizeMode:"contain"
    },
    ActionButtonStylesView:{
        position:"absolute",
        marginTop:510,
        marginLeft:(Dimensions.get('window').width-280)/2,
    },
    ActionButtonStyles:{
        height:46,
        width:280,
        backgroundColor:"#000",
        flexDirection:"column",
        alignItems:"center",
        justifyContent:'center'
        // position:"absolute",
        // marginTop:Dimensions.get('window').height-200
    }
});