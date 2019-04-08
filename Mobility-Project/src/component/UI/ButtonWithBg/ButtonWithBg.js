import React from 'react';
import {TouchableOpacity,View,Text,StyleSheet} from 'react-native';

const buttonWithBg = (props)=>(
     <TouchableOpacity onPress={props.onPress}>
         <View style={[styles.button, {backgroundColor:props.color}]}>
             <Text style={{fontWeight:'bold'}}>{props.children}</Text>
         </View>
     </TouchableOpacity>
);

const styles=StyleSheet.create({
    button:{
        padding:10,
        margin:5,
        borderRadius:5,
        borderWidth:1,
        borderColor:"black"
        
    }
});
export default buttonWithBg;