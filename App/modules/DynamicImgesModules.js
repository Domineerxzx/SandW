/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight, ScrollView, NativeModules} from "react-native";


export default class DynamicImgesModules extends Component {

    // constructor() {
    //     super();
    //     this.state = {
    //         Tshirtvlaues:"???"
    //     }
    // }
    //
    // componentWillMount() {
    //     NativeModules.AransModules.getGoodsInfo((result) => {this.setState({Tshirtvlaues:result})});
    //     NativeModules.AransModules.SEND_LOG("这是第一次"+this.state.Tshirtvlaues);
    // }

    _onPressGetId(str){
        this.props.callback(str)
    }


    getItem() {
        let list = this.props.name;//TODO==图片未上传

        let arr = [];
        for (let i = 0; i < list.itemInfo.length; i++) {
            let infoList = list.itemInfo[i];
            arr.push(
                <TouchableHighlight onPress={() => {
                    this._onPressGetId(list.itemInfo[i].id.toString());
                    NativeModules.AransModules.startGoodInfoActivity()
                }}>
                    <View key={i}
                          style={{width: Dimensions.get('window').width / 2 - 20, flexDirection: 'column'}}>
                        <Image
                            style={{width: Dimensions.get('window').width / 2 - 20, height: 200}}
                            source={{uri: infoList.photoDoc+"/1.png"}}/>
                        <View style={{alignItems: 'center'}}>
                            <Text style={{fontWeight: 'bold', fontSize: 20}}>{infoList.brandName}</Text>
                            <Text style={{fontWeight: 'bold'}}>{infoList.money}</Text>
                        </View>
                    </View>
                </TouchableHighlight>
            );
        }
        return arr;
    }

    render() {

        return (

            <View style={{margin: 10, marginTop: 20, alignItems: 'stretch', flexDirection: 'row', flexWrap: 'wrap'}}>
                {this.getItem()}
            </View>
        );


    }
}