[![npm version](https://badge.fury.io/js/react-native-blur.svg)](https://badge.fury.io/js/react-native-blur)

### React Native Counting
Component implementation for Dynamic digital effect.<br>


<img src='http://image18-c.poco.cn/mypoco/myphoto/20170303/17/18509322420170303172443095.gif?311x565_110' />

### 用法
1. npm install react-native-counting --save 
2. react-native link react-native-counting 

### 属性&&方法
* text:String 默认显示的文字
* fontProperty:object  传入一个对象</br> 
     1. fontSize:字体大小(Int)
     2. textAlignment:center || left ||right  对齐方式(string)
     3. boldSystem:是否加粗(bool)
     4. method:动画方式(String) EaseInOut || EaseIn || EaseOut || Linear
* textColor 文字底色(Colo)
* onFinish 完成回调执行的方法(func)


#### Counting:

```javascript
import React, { Component } from 'react';
import Counting from 'react-native-counting';
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

### thanks


