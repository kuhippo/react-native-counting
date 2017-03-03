//
//  Counting.h
//  nodeforum
//
//  Created by mubin on 2/3/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "UICountingLabel.h"
#import <React/RCTComponent.h>
@interface Counting : UIView



@property (nonatomic,strong)UICountingLabel *countLabel;

//文字
@property (nonatomic,copy)NSString *text;

//完成回调的方法
@property (nonatomic,copy)RCTBubblingEventBlock onCompletionBlock;

//label属性
@property (nonatomic,copy)NSDictionary *fontProperty;

//textColor
@property (nonatomic,copy)UIColor *textColor;

@property (nonatomic, copy) RCTBubblingEventBlock onFinish;


@end
