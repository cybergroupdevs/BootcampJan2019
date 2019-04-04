import React ,{Component} from 'react';
import {View,StyleSheet,TextInput,Button,ToastAndroid} from 'react-native';

class PlaceInput extends Component {
    state={
        placeName:""
    };
    placeNameChanged = (val)=>{
        this.setState({
           placeName:val
        });
    }; 
    placeSubmitHandler = () => {
        if(this.state.placeName.trim()===""){
          return;
        }
        ToastAndroid.show("Successfully Added", ToastAndroid.SHORT)
        this.props.onPlaceAdded(this.state.placeName);
    };
    render() {
        return (
             <View style={styles.inputContainer}>
                <TextInput 
                  underlineColorAndroid="black"//put the underline 
                  style={{width:300}}
                  placeholder="enter user name"
                  value={this.state.placeName}
                  onChangeText={this.placeNameChanged}
                  style={styles.placeInput}
                />
                <Button
                  title="Add"
                  style={styles.placeButton}
                  onPress={this.placeSubmitHandler}
                />
             </View>
        );
      }
}

const styles = StyleSheet.create({
    inputContainer:{
        width:"100%",
        flexDirection:"row",
        justifyContent:"space-between",
        alignItems:"center"
      },
      placeInput:{
        width:"70%"
      },
    placeButton:{
      width:"30%"  
    }
    });
       
export default PlaceInput;
    