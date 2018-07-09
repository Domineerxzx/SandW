import { AppRegistry } from 'react-native';
import NavigatorManager from "./App/pages/NavigatorManager";
import xuzhanxin from "./App/modules/xuzhanxin";
import ToucheTest from "./App/pages/ToucheTest";
import DynamicImgesModules from "./App/modules/DynamicImgesModules";
import DescriptionTheFragment from "./App/pages/DescriptionTheFragment";
import BuyALLPages from "./App/pages/BuyALLPages";
import DescriptionFragment from "./App/pages/DescriptionFragment";

// AppRegistry.registerComponent('SandW', () => NavigatorManager);
AppRegistry.registerComponent('SandW',()=>NavigatorManager);
AppRegistry.registerComponent('SandW_Des',()=>DescriptionFragment);
AppRegistry.registerComponent('SandW_BR',()=>DynamicImgesModules);
AppRegistry.registerComponent('SandW3',()=>DynamicImgesModules);
AppRegistry.registerComponent('SandW4',()=>ToucheTest);
AppRegistry.registerComponent('BuyALLPages',()=>BuyALLPages);