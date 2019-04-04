import React,{Component} from 'react';
import {View,Image,Text,StyleSheet,TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';
import {connect} from 'react-redux';
import {deletePlace} from '../../store/actions/index';

class PlaceDetail extends Component {
    placeDeletedHandler = () => {
          this.props.onDeletePlace(this.props.selectedPlace.key);
          this.props.navigator.pop();
    }
    render() {
        return (
            <View style={styels.Container}>
            <View>
              <Image source={this.props.selectedPlace.image} style={styels.placeImage} />
              <Text style={styels.placeName}>{this.props.selectedPlace.name}</Text>
            </View>   
            <View>
               <TouchableOpacity onPress={this.placeDeletedHandler}>
                 <View style={styels.Button}>
                    <Icon size={30} name="ios-trash" color="red" />
                 </View>
               </TouchableOpacity>
              {/* <TouchableOpacity onPress={props.onModalClosed}>
                 <View style={styels.Button}>
                   <Icon size={50} name="ios-close-circle" color="black" />
                 </View>
              </TouchableOpacity> */}
             </View>
         </View>
        );
    }
}

const styels=StyleSheet.create({
    Container:{
        margin:22
    },
    placeImage:{
        width:"100%",
        height:200
    },
    placeName:{
        fontWeight:"bold",
        textAlign:"center",
        fontSize:28
    },
    Button:{
        alignItems:"center"
    }

});


const mapDispatchToProps = dispatch =>{
    return {
        onDeletePlace: (key) => dispatch(deletePlace(key))
    };
};
export default connect(null,mapDispatchToProps)(PlaceDetail);