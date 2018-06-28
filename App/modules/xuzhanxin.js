import React, {Component} from "react";
import {Text, NativeModules, View,TouchableHighlight} from "react-native";



export default class xuzhanxin extends Component {
    constructor() {
        super();
        this.state = {
            name:""
        }
    }

    render() {
        return (
            <View>
                <TouchableHighlight onPress={() => {NativeModules.AransModules.giveRnData((result) => {
                        this.setState({name: result});
                    })}}>
                    <Text>
                        aaaa{this.state.name}
                    </Text>
                </TouchableHighlight>
            </View>
        )
    }
}