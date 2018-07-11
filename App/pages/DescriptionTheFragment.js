/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/9
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text,Dimensions,StyleSheet, View, TouchableHighlight, NativeModules, Image, ScrollView} from "react-native";
import DynamicImgesModules from "../modules/DynamicImgesModules";

export default class DescriptionTheFragment extends Component{

    constructor() {
        super();
        this.state = {
            vlaues:"???"
        }
    }

    componentWillMount() {
        NativeModules.AransModules.setTitle("休闲运动服#日本西装");
        NativeModules.AransModules.getGoodsInfo((result) => {this.setState({vlaues:result})});
    }


    render() {
        if (this.state.vlaues === "???") {

            return(
                <View>
                    <Image style={{width:Dimensions.get('window').width}} source={require('../imges/01415f5996acdaa8012156038f6b78.gif')}/>
                </View>
            )

        } else {

            return (
                <View>
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
            )
        }
    }
}