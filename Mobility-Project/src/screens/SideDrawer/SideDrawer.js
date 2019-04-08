import React,{Component} from 'react';
import {View,Text,Dimensions,StyleSheet,Image} from 'react-native';


class SlideDrawer extends Component {
    render(){
        return(
            <View style={[styles.container,
                  {width: Dimensions.get('window').width * 0.8} ]}>
                <View>
                    <Text style={{fontSize:20}} >Welcome </Text>
                    
                    <Image
                       style={{marginTop:20,width : 100, height : 101, borderRadius:50}} 
                       source = {require('../../assets/dp.jpg')}>
                   </Image>
                </View>
            </View>
        );
    }
}
const styles=StyleSheet.create({
    container :{
        paddingTop:22,
        backgroundColor:"white",
        flex:1,
        padding:5
    }
});

export default SlideDrawer;