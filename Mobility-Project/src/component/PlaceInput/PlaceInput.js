import React ,{Component} from 'react';
import {View,StyleSheet,TextInput,Button,ToastAndroid} from 'react-native';
import DefaultInput from '../UI/DefaultInput/DefaultInput';

 const placeInput = (props)=>(
          <DefaultInput 
               placeholder=" Place Name "
               value={props.placeName} 
               onChangeText={props.onChangeText}
          />
   );
    
export default placeInput;
    