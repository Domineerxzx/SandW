/**
 *那当自己都萎靡到
 *无法被依靠的时候该如何振作？
 *Creat by Aran  at  2018/7/6
 *除过自己心中笃信的那一点不灭的光亮
 *我觉得这世间再没有别的东西比它值得被如此依靠。
 */

import React, {Component} from "react";
import {Text, Dimensions, StyleSheet, View, Image, TouchableHighlight, ScrollView, NativeModules} from "react-native";

import PopupDialog from "react-native-popup-dialog/src/PopupDialog";
import RadiosPage from "../modules/RadiosPage";
import BigDataSwiperModules from "../modules/BigDataSwiperModules";
export default class ScrollViewGetGoodInfo extends Component{


    constructor() {
        super();
        this.state={
            getTheImg:"???"
        }
    }

    render(){
        let parse = JSON.parse(this.props.name);
        return(
            <ScrollView>
                <View>
                    <BigDataSwiperModules name={parse}
                        style={{
                            flexDirection:"row",
                            alignItems:"center",
                            justifyContent:'center',
                            backgroundColor:"#FFF",
                            height:300}}/>
                    <View style={styles.TitleTextView}>
                        <Text style={styles.TitleText}>
                            {parse.brandName}
                        </Text>
                        <Text style={{color:"#B9B9B9",marginTop:2}}>{parse.shortDescribe}</Text>
                        <View style={{marginTop:2,flexDirection:"row"}}>
                            <Text style={{color:"#ff2d5e"}}>${parse.money}</Text><Text style={{color:"#B9B9B9",marginLeft:10}}>价格已包含关税</Text>
                        </View>
                    </View>
                    <View>
                        <TouchableHighlight onPress={()=>{this.popupDialog.show()}} style={{
                            alignItems:"center",
                            justifyContent:'center', marginTop:20}}>
                            <View style={styles.ChooseSizeView}>
                                <Text style={{marginRight:120}}>
                                    选择您的尺寸
                                </Text>
                                <Image style={{width:20,resizeMode:"contain"}} source={require('../imges/extend.png')}/>
                            </View>
                        </TouchableHighlight>
                        <View style={styles.GoodDescribeTitle}>
                            <Text style={{fontSize:15,fontWeight: 'bold', color:"#000"}}>商品描述</Text>
                            <Text style={styles.DescribeSay}>     Retro-sport Ringer Tee is garment-washed for a soft, favorite tee feel.All-over mini C logo with contrast trim at neckline and sleeves.Fitted cotton-rich tee with raglan sleeves for ease.Signature striped twill tape detail at shoulder.Heritage C patch on sleeve.Please note that due to the garment-wash process, slight variations in color may occur.</Text>
                        </View>
                        <View style={styles.GoodDescribeTitle}>
                            <Text style={{fontSize:15,fontWeight: 'bold', color:"#000"}}>购物须知及无理由免费退货</Text>
                            <View style={{flexDirection:"row",marginTop:20
                            }}>
                                <Image  style={{height:20,width:20,marginRight:10,resizeMode:"contain"}} source={require('../imges/country.png')}/>
                                <Text>商品来自德国</Text>
                            </View>
                            <View>
                                <Text style={{fontSize:12,marginTop:20,fontWeight:"bold",color:"#000"}}>一笔运费，乐享各式精品，百家货源！</Text>
                                <Text style={{fontSize:12,marginTop:10}}>无论您一次向多少间合作店购买几件商品，只需支付一笔运费，即可足不出户乐享全球时尚精品。</Text>
                            </View>
                            <View>
                                <Text style={{fontSize:12,marginTop:20,fontWeight:"bold",color:"#000"}}>14天无理由免费退货（退货含税）</Text>
                                <Text style={{fontSize:12,marginTop:10}}>我们提供全球免费退货服务。</Text>
                                <Text style={{fontSize:12}}>自您签收之日起，您有14天时间无理由退回商品，我们建议再收到商品的7天内，在您的S&W账户上预约免费的“上门提取退货”服务，以确保退货按时抵达原合作伙伴方。</Text>
                                <Text style={{fontSize:12}}>来自中国内地的退货，您的退款将包含下单所支付的关税，一扫海外沟渠的顾虑。</Text>
                            </View>

                        </View>
                        <View style={styles.GoodDescribeTitle}>
                            <Text style={{fontSize:15,fontWeight: 'bold', color:"#000"}}>品牌故事</Text>
                            <Text style={styles.DescribeSay}>Retro-sport Ringer Tee is garment-washed for a soft, favorite tee feel.All-over mini C logo with contrast trim at neckline and sleeves.Fitted cotton-rich tee with raglan sleeves for ease.Signature striped twill tape detail at shoulder.Heritage C patch on sleeve.Please note that due to the garment-wash process, slight variations in color may occur.</Text>
                        </View>

                    </View>
                    <Text style={{fontSize:500}}>
                        垫脚石
                    </Text>
                </View>
                <PopupDialog
                    ref={(popupDialog) => { this.popupDialog = popupDialog; }}
                >
                    <View  style={{padding:20}}>
                        <RadiosPage name={parse}/>
                    </View>
                </PopupDialog>
            </ScrollView>
        )
    }

}

const styles = StyleSheet.create({
    TitleText:{
        fontSize:30,
        color:"#000",
        fontWeight: 'bold'
    },
    TitleTextView:{
        marginTop:10,
        flexDirection:"column",
        alignItems:"center",
        justifyContent:'center'
    },
    ChooseSizeView:{
        borderColor:"#b9b9b9",
        borderRadius:5,
        borderWidth:1,
        width:240,
        height:40,
        flexDirection:"row",
        alignItems:"center",
        justifyContent:'center'
    },
    GoodDescribeTitle:{
        marginLeft:(Dimensions.get('window').width-280)/2,
        marginRight:(Dimensions.get('window').width-280)/2,
        marginTop:20

    },
    DescribeSay:{
        marginTop:10
    }
});