import React, {Component} from 'react';
import {View,Image,Button,StyleSheet} from 'react-native';
import imagePlaceholder from '../../assets/beautyImage.jpg';

class PickImage extends Component {
    render(){
        return(
            <View style={styles.conatiner}>
                <View style={styles.placeholder}>
                    <Image source={imagePlaceholder} style={styles.previewImage} />
                </View>
                <View style={styles.button}>
                    <Button title = "Pick Image" onPress={()=>alert("pick image after some time")} />
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
    },
    previewImage:{
        width:"100%",
        height:"100%"
    }
});
export default PickImage;