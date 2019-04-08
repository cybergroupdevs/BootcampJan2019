import {  ToastAndroid} from 'react-native';
import {ADD_PLACE,DELETE_PLACE} from '../actions/actionTypes';
const initialState={
    places:[]
} 

const reducers = (state = initialState ,action)=>{
      switch (action.type){
          case ADD_PLACE:
            ToastAndroid.show("Successfully Added", ToastAndroid.SHORT)
            return {
                ...state,
                places:state.places.concat({
                    key: Math.random().toString(),
                    name: action.placeName,
                    image: {
                      uri:"https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681"
                    }
                  })
            };
            case DELETE_PLACE:
                 ToastAndroid.show("Successfully Deleted", ToastAndroid.SHORT)
                 return{
                     ...state,
                     places: state.places.filter(place=>{
                         return place.key !== action.placeKey;
                     })
                       
                 };
            // case SELECT_PLACE:
            //     return{
            //         ...state,
            //         selectedPlace: state.places.find(place =>{
            //             return place.key===action.placeKey;
            //         })
            //     };
            // case DESELECT_PLACE:
            //     return {
            //         ...state,
            //         selectedPlace:null
            //     };

          default:
             return state;
      }
};

export default reducers;