import React,{Component} from 'react';
import {View,Button,StyleSheet,ScrollView} from 'react-native';
import {connect} from 'react-redux';
import PlaceInput from '../../component/PlaceInput/PlaceInput';
import MainText from '../../component/UI/MainText/MainText';
import HeadingText from '../../component/UI/HeadingText/HeadingText';
import PickImage from '../../component/PickImage/PickImage';
import PickLocation from '../../component/PickLocation/PickLocation';


import { addPlace } from '../../store/actions/index';




class SharePlaceScreen extends Component {
    state={
        placeName:""
    };
    constructor(props){
        super(props);
        this.props.navigator.setOnNavigatorEvent(this.onNavigatorEvent);
    }
    onNavigatorEvent = event => {
        if(event.type==="NavBarButtonPress"){
            if(event.id==="sideDrawerToggle"){
                this.props.navigator.toggleDrawer({
                    side: "left"
                });
            }
        }
    }
    placeNameChangeHandler = (val) =>{
        this.setState({
           placeName:val
        });
    }
    placeAddedHandler = () =>{
        if(this.state.placeName.trim()!==""){
            this.props.onAddPlace(this.state.placeName);
        }
    };
    render(){
        return(
            <ScrollView>
                <View style={styles.container}>
                   <MainText>
                       <HeadingText>Share a Place with us!</HeadingText>
                    </MainText> 
                   <PickImage />
                   <PickLocation />
                   <PlaceInput 
                       placeName={this.state.placeName} 
                       onChangeText={this.placeNameChangeHandler} 
                    />
                   <Button 
                       title="Share the Place!" 
                       onPress={this.placeAddedHandler} 
                     />
                </View>
            </ScrollView>
        );
    }
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        alignItems:"center"
    }
});
const mapDispatchToProps = dispatch => {
    return {
        onAddPlace: (placeName) => dispatch(addPlace(placeName))
    }
}

export default connect(null,mapDispatchToProps)(SharePlaceScreen);