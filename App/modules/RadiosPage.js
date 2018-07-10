/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/8
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Image,Dimensions, NativeModules, Text, TextInput, TouchableHighlight, View} from "react-native";
import RadioModal from "react-native-radio-master/components/radio";
export default class RadiosPage extends Component{


    constructor() {
        super();
        this.state={
            initId:0,
            initName:'XS'


        }
    }


    _selectRadio(id,name){
        this.setState({initId:id,initName:name});

        this.props.callback(name)
    }

    render(){
        return(
            <View>
                <RadioModal
                    selectionColor={"#000"}
                    selectedValue={this.state.initId}
                    onValueChange={(id,name)=>{this._selectRadio(id,name)}}
                    // onValueChange={(id,name)=>this.setState({initId:id,initName:name})}
                >
                    {this.renderSwiper(this.props.name.sizeStock)}
                </RadioModal>
                <Text>{this.state.initId}</Text>
                <Text>{this.state.initName}</Text>
            </View>
        )
    }

    renderSwiper(json){
        let banners=[];
        for (let i=0;i<json.length;i++){
            let bean=json[i];

            NativeModules.AransModules.SEND_LOG("========这是尺码大小========="+bean.sizeName);
            banners.push(
                <Text value={i} key={i}>    
                    <Text>
                        {bean.sizeName}
                    </Text>
                    <Text>
                           库存：{bean.sizeNum}
                    </Text>
                </Text>
            )
        }
        return banners;
    }
}