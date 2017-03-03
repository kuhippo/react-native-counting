//
//  Counting.m
//  nodeforum
//
//  Created by mubin on 2/3/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import "Counting.h"

@interface Counting()
{
  CGFloat fontSize;
}
@end


@implementation Counting

- (instancetype)init{
  if (self=[super init]) {
    _countLabel = [UICountingLabel new];
    _countLabel.text = @"";
    _countLabel.backgroundColor = [UIColor clearColor];
    _countLabel.textAlignment = NSTextAlignmentCenter;
    _countLabel.numberOfLines = 0;
    [self addSubview:_countLabel];
    

  }
  return self;
}

- (void)layoutSubviews{
  [super layoutSubviews];
  if (!CGRectEqualToRect(self.bounds, _countLabel.bounds)) {
    [self initPieView];
  }
}

//跟新View
- (void)initPieView{
  _countLabel.frame = self.bounds;
  
}

- (void)setText:(NSString *)text{
  _countLabel.text = text;
}



- (void)setTextColor:(UIColor *)textColor{
  _countLabel.textColor = textColor;
}



- (void)setFontProperty:(NSDictionary *)fontProperty{
  //font-size
  for (NSString *key in fontProperty.allKeys) {
    if ([key isEqualToString:@"fontSize"]){
      fontSize = [[fontProperty valueForKey:@"fontSize"] floatValue];
      _countLabel.font = [UIFont systemFontOfSize:fontSize];
    }
    
    if ([key isEqualToString:@"boldSystem"]){
      
      BOOL boldSysten = [[fontProperty valueForKey:@"boldSystem"] boolValue];
      if (fontSize) {
        if (boldSysten == YES) {
          _countLabel.font = [UIFont boldSystemFontOfSize:fontSize];
        }else{
          _countLabel.font = [UIFont systemFontOfSize:fontSize];
        }
      }
    }
    if ([key isEqualToString:@"textAlignment"]){
      
      NSString *type = [fontProperty valueForKey:@"textAlignment"];
      if (type) {
        if ([type isEqualToString:@"left"]) {
          _countLabel.textAlignment = NSTextAlignmentLeft;
        }else if ([type isEqualToString:@"center"]) {
          _countLabel.textAlignment = NSTextAlignmentCenter;
        }else if ([type isEqualToString:@"right"]) {
          _countLabel.textAlignment = NSTextAlignmentRight;
        }else{
          _countLabel.textAlignment = NSTextAlignmentCenter;
        }
      }
    }
    if ([key isEqualToString:@"numberOfLines"]){
      NSInteger num = [[fontProperty valueForKey:@"numberOfLines"] integerValue];
      _countLabel.numberOfLines = num;
      
    }
    
    if ([key isEqualToString:@"method"]) {
      NSString *method = [fontProperty valueForKey:@"method"];
      if (method) {
        if ([method isEqualToString:@"EaseInOut"]) {
          _countLabel.method = UILabelCountingMethodEaseInOut;
        }else if([method isEqualToString:@"EaseIn"]) {
          _countLabel.method = UILabelCountingMethodEaseIn;
        }
        else if([method isEqualToString:@"EaseOut"]) {
          _countLabel.method = UILabelCountingMethodEaseOut;
        }
        else if([method isEqualToString:@"Linear"]) {
          _countLabel.method = UILabelCountingMethodLinear;
        }else{ //配置默认的
          _countLabel.method = UILabelCountingMethodLinear;
        }
      }
    }
  
  }
  
  
//  [_countLabel setFont:[UIFont systemFontOfSize:[fontSize floatValue]]];
  
  
  
}

@end
