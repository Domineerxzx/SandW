/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/6
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text,Dimensions, View, TouchableHighlight, NativeModules, Image, ScrollView} from "react-native";
import ScrollViewGetGoodInfo from "./ScrollViewGetGoodInfo";


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
                        <View>
                            <Image style={styles.TheBackButton} source={require('../imges/back.png')}/>
                        </View>
                        <ScrollView>
                            <ScrollViewGetGoodInfo/>
                        </ScrollView>
                        <View style={styles.ActionButtonStylesView}>
                            <ActionButton style={styles.ActionButtonStyles}>
                                <Text style={{color:"#fff"}}>
                                    添加购物车
                                </Text>
                            </ActionButton>
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
        marginTop:500,
        marginLeft:(Dimensions.get('window').width-240)/2,
    },
    ActionButtonStyles:{
        height:60,
        width:240,
        backgroundColor:"#000",
        // position:"absolute",
        // marginTop:Dimensions.get('window').height-200
    }
});