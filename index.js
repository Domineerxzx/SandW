import { AppRegistry } from 'react-native';
import NavigatorManager from "./App/pages/NavigatorManager";
import xuzhanxin from "./App/modules/xuzhanxin";
import ToucheTest from "./App/pages/ToucheTest";
import DynamicImgesModules from "./App/modules/DynamicImgesModules";
import DescriptionFragment from "./App/pages/DescriptionFragment";
import BrandFragment from "./App/pages/BrandFragment";

// AppRegistry.registerComponent('SandW', () => NavigatorManager);
AppRegistry.registerComponent('SandW',()=>NavigatorManager);
AppRegistry.registerComponent('SandW1',()=>BrandFragment);
AppRegistry.registerComponent('SandW2',()=>DescriptionFragment);
AppRegistry.registerComponent('SandW3',()=>DynamicImgesModules);
AppRegistry.registerComponent('SandW4',()=>ToucheTest);