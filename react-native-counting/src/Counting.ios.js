
import React, { Component, PropTypes } from 'react';
import { requireNativeComponent,NativeModules } from 'react-native';

var Count = requireNativeComponent('Counting', Counting);
var CountManager = NativeModules.CountingManager;

export default class Counting extends Component {
  static defaultProps = {
    text:'0',
    fontProperty:{
      fontSize:17,
      textAlignment:'center',
      boldSystem:false,
      method:'Linear'
    },
    textColor:'black'
  }

  static propTypes = {
    text:PropTypes.string,
    fontProperty:PropTypes.element,        
    textColor:PropTypes.string, 
    onFinish:PropTypes.func
  }
  
  countingStart(start,end,duration){
    CountManager.startValue(start,end,duration);
  }
  
render() {
    return <Count {...this.props}/>;
  }
}


