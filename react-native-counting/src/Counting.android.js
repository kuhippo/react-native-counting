
import React, { Component, PropTypes } from 'react';
import { requireNativeComponent,NativeModules } from 'react-native';

var Count = requireNativeComponent('SwipeMenuListView', Counting);
var CountManager = NativeModules.SwipeMenuListView;

export default class Counting extends Component {
  
  static defaultProps = {
    text:'0',
    fontProperty:{
      fontSize:17,
      textAlignment:'center',
      boldSystem:false,
      method:'Linear'
    },
    
  }

  static propTypes = {
    text:PropTypes.string,
    fontProperty:PropTypes.element,
    onFinish:PropTypes.func
  }
  
  
  countingStart(start,end,duration){
    CountManager.numberTimer(start,end,duration);
  }
  
render() {
    return <Count {...this.props} onChange={this.props.onFinish}/>;
  }
}


