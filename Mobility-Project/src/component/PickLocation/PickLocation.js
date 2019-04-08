import React, {Component} from 'react';
import {View,Button,StyleSheet,Text} from 'react-native';

class PickLocation extends Component {
    render(){
        return(
            <View style={styles.conatiner}>
                <View style={styles.placeholder}>
                    <Text> Map </Text>
                </View>
                <View style={styles.button}>
                    <Button title = "Locate Me" onPress={()=>alert("pick location after some time")} />
                </View>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    conatiner:{
        width:"100%",
        alignItems:"center"
    },
    button:{
        margin:8
    },
    placeholder:{
        borderWidth:1,
        borderColor:"black",
        backgroundColor:"#eee",
        width:"80%",
        height:150
    }
});
export default PickLocation;