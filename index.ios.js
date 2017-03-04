/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import Counting from './react-native-counting/index';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';



export default class rncount extends Component {

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
    marginTop:59,
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

AppRegistry.registerComponent('rncount', () => rncount);
