/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/6
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text, Dimensions, StyleSheet, View, TouchableHighlight, NativeModules, Image, ScrollView} from "react-native";
import ScrollViewGetGoodInfo from "./ScrollViewGetGoodInfo";


export default class DescriptionFragment extends Component {

    constructor() {
        super();
        this.state = {
            getjson: "???",
            updateId: "???",
            updateSize: "???",
            loveId: 0,
            ImgSource: "../imges/love.png"
        }
    }

    changImg(parse,id) {
        if (id === 1) {
            this.setState({loveId: 0});

            NativeModules.AransModules.TanToast("RN移除")


        }
        if (id === 0) {
            this.setState({loveId: 1});
            NativeModules.AransModules.addLovesList(parse.id.toString());
            NativeModules.AransModules.TanToast("RN成功"+parse.id)
        }
    }

    changeTheImgView(id) {
        if (id === 0) {
            return (
                <Image style={styles.TheLoveButton} source={require('../imges/love.png')}/>
            )
        }
        if (id === 1) {
            return (
                <Image style={styles.TheLoveButton} source={require('../imges/loves.png')}/>
            )
        }
    }

    componentWillMount() {
        NativeModules.AransModules.getGoodInfo((result) => {
            this.setState({getjson: result})
        });
    }

    _addIDandSize(size) {

        this.setState({
            updateSize: size
        });
    }

    _addShopBags(id, size) {
        if (id === "???") {
            NativeModules.AransModules.SEND_LOG("错误" + id + "    " + size);

        } else {

            NativeModules.AransModules.addShopBag(id.toString(), null);
            NativeModules.AransModules.SEND_LOG("添加购物袋" + id + "    " + size.toString());
        }

    }


    render() {
        if (this.state.getjson === "???") {
            return (
                <View>
                    <Text>
                        啥也没有
                    </Text>
                </View>
            )
        } else {
            let parse = JSON.parse(this.state.getjson);
            return (
                <View style={{backgroundColor: "#fff"}}>
                    <View style={styles.AllTheView}>
                        <View style={{
                            flexDirection: "row", alignItems: "center",
                            justifyContent: 'center', backgroundColor: "#fff"
                        }}>
                            <Image style={styles.TheBackButton} source={require('../imges/back.png')}/>
                            <Text style={styles.TitleText}>
                                {parse.brandName}
                            </Text>
                            <TouchableHighlight onPress={() => {
                                this.changImg(parse,this.state.loveId)
                            }}>
                                {this.changeTheImgView(this.state.loveId)}
                            </TouchableHighlight>
                            {/*<Image onPress={this.changImg(parse.id)} style={styles.TheLoveButton} source={require(this.state.ImgSource)}/>*/}
                        </View>
                        <ScrollView>
                            <ScrollViewGetGoodInfo callback={this._addIDandSize.bind(this)}
                                                   name={this.state.getjson}/>
                        </ScrollView>
                        <View style={styles.ActionButtonStylesView}>
                            <TouchableHighlight
                                onPress={() => this._addShopBags(parse.id, this.state.updateSize)}
                                style={styles.ActionButtonStyles}>
                                <Text style={{fontWeight: "bold", fontSize: 15, color: "#fff"}}>
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
    TitleText: {
        fontSize: 25,
        color: "#000",
        fontWeight: 'bold'
    },
    AllTheView: {
        flexDirection: "column",
        backgroundColor: "#00000000"
    },
    TheBackButton: {
        width: 30, height: 30, resizeMode: "contain",
        marginRight: 100
    },
    TheLoveButton: {
        width: 30, height: 30, resizeMode: "contain",
        marginLeft: 100
    },
    ActionButtonStylesView: {
        position: "absolute",
        marginTop: 540,
        marginLeft: (Dimensions.get('window').width - 280) / 2,
    },
    ActionButtonStyles: {
        height: 46,
        width: 280,
        backgroundColor: "#000",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: 'center'
        // position:"absolute",
        // marginTop:Dimensions.get('window').height-200
    }
});