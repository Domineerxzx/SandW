import { AppRegistry } from 'react-native';
import NavigatorManager from "./App/pages/NavigatorManager";
import xuzhanxin from "./App/modules/xuzhanxin";
import JumpNextActivity from "./App/modules/JumpNextActivity";

// AppRegistry.registerComponent('SandW', () => NavigatorManager);
AppRegistry.registerComponent('SandW',()=>JumpNextActivity);
AppRegistry.registerComponent('SandW1',()=>xuzhanxin);