[![npm version](https://badge.fury.io/js/react-native-blur.svg)](https://badge.fury.io/js/react-native-blur)

### React Native Counting
Component implementation for Dynamic digital effect.<br>


<img src='http://image18-c.poco.cn/mypoco/myphoto/20170303/17/18509322420170303172443095.gif?311x565_110' />

### Content
- [Installation](#installation)
- [Usage example](#usage-example)
- [Component properties](#component-properties)
- [Questions?](#questions)

### Installation
1. Install package via npm:

  ```
  npm install react-native-counting
  ```
2. ## Sorry only support iOS ,Android temporarily cannot use 
3. Link your native dependencies:
  ```
  react-native link react-native-counting
  ```
4. Inside your code include JS part by adding (ES6)

  ```javascript
  import Counting from 'react-native-counting';
  
  ```

5. Compile and have fun!

### Usage example
You can run built-in example via few simple steps:
1. Clone repository
2. Go to `examples/Basic`
3. Run `npm install `
4. Run `react-native run-ios `

#### Counting:

```javascript
import React, { Component } from 'react';
import Counting from './react-native-counting-master/index';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';



export default class nodeforum extends Component {

  constructor(props){
    super(props)
    this.state = {
      finshded:false
    }
  }
  
  _onPressButton(){
    this.counting.countingStart(0,5200.10,3000);
    this.setState({
      finshded:false
    })
  }

  _finish(){
     this.setState({
      finshded:true
    })
  }

  render() {

  const fontProperty = {
      fontSize:35,
      textAlignment:'center',
      boldSystem:false,
      method:'Linear'
  }
  const { finshded } = this.state;
  return (
      <View style={styles.container}>
        <Counting style={styles.counting} text="0.00" ref={(ref) => this.counting = ref} fontProperty={fontProperty} textColor="white" onFinish={this._finish.bind(this)}/>
        <TouchableOpacity onPress={this._onPressButton.bind(this)} style={styles.button}>
          <Text>click Me</Text>
        </TouchableOpacity>
        <Text style={styles.isfinish}>{finshded?"finished":"dnf"}</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
  },
  button:{
    marginTop:20,
  },
  counting:{
    marginTop:60,
    backgroundColor:'black',
    width:180,
    height:150,
    borderRadius:20,
  },
  isfinish:{
    marginTop:20,
    color:'red'
  }
  
});

AppRegistry.registerComponent('nodeforum', () => nodeforum);
```

In this example, `Image` component will be blurred, a `BlurView` content will stay untouched.


### Questions?
Feel free to contact me By qq(452359549)

### Thinks


