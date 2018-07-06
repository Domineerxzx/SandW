import { AppRegistry } from 'react-native';
import NavigatorManager from "./App/pages/NavigatorManager";
import xuzhanxin from "./App/modules/xuzhanxin";
import ToucheTest from "./App/pages/ToucheTest";
import DynamicImgesModules from "./App/modules/DynamicImgesModules";

// AppRegistry.registerComponent('SandW', () => NavigatorManager);
AppRegistry.registerComponent('SandW',()=>NavigatorManager);
AppRegistry.registerComponent('SandW1',()=>DynamicImgesModules);
AppRegistry.registerComponent('SandW2',()=>ToucheTest);
AppRegistry.registerComponent('SandW3',()=>DynamicImgesModules);