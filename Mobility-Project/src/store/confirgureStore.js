import { createStore, combineReducers} from 'redux';

import placesReducers from './reducers/places';

const rootReducer = combineReducers({
   places: placesReducers 
});

const configureStor = () =>{
    return createStore(rootReducer);
};

export default configureStor;