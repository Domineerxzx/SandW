import { AppRegistry } from 'react-native';
import TheFirstPageForAndroid from "./App/pages/TheFirstPageForAndroid";
import TestTouchable from "./App/pages/ToucheTest";
import NavigatorManager from "./App/pages/NavigatorManager";
import GetAndroidData from "./App/modules/GetAndroidData";
import DynamicImgesModules from "./App/modules/DynamicImgesModules";
// import App from './App';

// AppRegistry.registerComponent('SandW', () => NavigatorManager);
AppRegistry.registerComponent('SandW',()=>NavigatorManager);
AppRegistry.registerComponent('SandW1',()=>GetAndroidData);