import React,{ Component} from 'react';
import {View , Text , Button,TextInput,StyleSheet,ImageBackground} from 'react-native';
import startMainTabs from '../MainTabs/startMainTabs';
import DefaultInput from '../../component/UI/DefaultInput/DefaultInput';
import HeadingText from '../../component/UI/HeadingText/HeadingText';
import MainTetx from '../../component/UI/MainText/MainText';
import backgroundImage from '../../assets/background.jpg';
import ButtonWithBg from '../../component/UI/ButtonWithBg/ButtonWithBg';

class AuthScreen extends Component {
    loginHandler =() => {
        startMainTabs();
    }
    render(){
        return(
           <ImageBackground source={backgroundImage} style={styles.bgImage}>
               <View style={styles.container}>
                  <MainTetx>
                     <HeadingText>Please Log In</HeadingText>
                  </MainTetx>
                  <ButtonWithBg color="#29aaf4" onPress={()=>alert("wait for some time")}>Switch to Sign In</ButtonWithBg> 
                  <View style={styles.inputConatiner}>
                     <DefaultInput 
                          placeholder="Your E-Mail Address"
                          style={styles.input} 
                     />
                     <DefaultInput 
                          placeholder="Password"
                          style={styles.input}
                      />
                     <DefaultInput  
                         placeholder="Confirm Password"
                         style={styles.input}
                      />
                  </View>
                  <ButtonWithBg color="#29aaf4" onPress={this.loginHandler}>Sign Up</ButtonWithBg> 
               </View>
          </ImageBackground>
        );
    }
}
const styles=StyleSheet.create({
    container:{
       flex:1,
       justifyContent:"center",
       alignItems:"center",
    },
    inputConatiner:{
        width:"80%"
    },
    bgImage:{
       width:"100%",
       flex:1
    },
    input:{
        backgroundColor:"#eee",
        borderColor:"#bbb",
        borderRadius:5
    }
});
export default AuthScreen;