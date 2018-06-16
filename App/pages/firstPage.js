/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React from "react";
import {Button, Image, ScrollView, Text, TouchableHighlight, StyleSheet, View} from "react-native";
import * as ToastAndroid from "react-native/Libraries/Components/ToastAndroid/ToastAndroid.android";

export default class Firstpage extends React.Component{


    constructor(aranToast: Firstpage.aranToast) {
        super();
        this.aranToast = aranToast;
        this.state = {
            number:0,
        }
    }

    aranToast: Firstpage.aranToast;

    componentWillMount(){
        let recriveValues = ToastAndroid.Constant;
        return recriveValues;

    }

     static aranToast(){
        /*AransModules.show('Awesome', AransModules.SHORT);*/
         ToastAndroid.show("AAA",ToastAndroid.SHORT)
    }


    render(){
        return(
            <ScrollView>
                <Text>{this.state.number}</Text>
                <View>
                    <TouchableHighlight
                        style={styles.aaaa}
                        onPress={this.aranToast}>
                        <Text>onClick</Text>
                    </TouchableHighlight>
                </View>
                <View>
                    <Image
                        source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image
                        source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                        style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image
                        source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                        style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image
                        source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                        style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                    <Image source={{uri:'http://thethreestooges.cn/aran/cloth.png'}}
                           style={{width: 100, height: 100}}
                    />
                </View>
                <View>
                    <Text>dsygaidgyijbhdusijdgbdufsi</Text>
                    <Text>dsygaidgyijbhdusijdgbdufsi</Text>
                </View>
            </ScrollView>
        );
    }

}
const styles = StyleSheet.create({
   aaaa:{
       backgroundColor: '#ff0d00',
   }
});