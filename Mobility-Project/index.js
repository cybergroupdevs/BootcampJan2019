
import React from 'react';
import {AppRegistry} from 'react-native';
import {Provider} from 'react-redux';
import App from './App';
import configureStore from './src/store/confirgureStore';

const store = configureStore();

const RNRedux = ()=>{
    <Provider store ={store}>
       <App />
    </Provider>
}
//import {name as appName} from './app.json';

AppRegistry.registerComponent("deepak", () => RNRedux);
