/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */
import React, {Component} from "react";

import {Button, Text, TouchableHighlight, View} from "react-native";
import {Navigator} from "react-native-deprecated-custom-components";

import DataSwiperModules from "../modules/DataSwiperModules";
import ActionFragment from "./ActionFragment";

export default class FirstPage extends Component{
    render(){
        let defaultName = 'firstPageName';
        let defaultComponent = ActionFragment;

        return(
            <Navigator
                initialRoute = {{name: defaultName,component : defaultComponent}}
                configureScene = {(route)=>{return Navigator.SceneConfigs.FloatFromRight}
                }
                renderScene = {(route,navigator)=>{
                    let Component = route.component;
                    /*alert(route.toString()+"==="+Component);*/
                    return <Component{...route.params} navigator={navigator}/>
                }}
            />
        );
    }
}