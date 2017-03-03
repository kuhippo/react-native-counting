//
//  CountingManager.m
//  nodeforum
//
//  Created by mubin on 2/3/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import "CountingManager.h"
#import <React/RCTViewManager.h>
#import "Counting.h"

@interface CountingManager()
@property(nonatomic,weak)Counting *count;

@end

@implementation CountingManager


//导出
RCT_EXPORT_MODULE()
//输入
RCT_EXPORT_VIEW_PROPERTY(text, NSString)

RCT_EXPORT_VIEW_PROPERTY(fontProperty, NSDictionary)

RCT_EXPORT_VIEW_PROPERTY(textColor, UIColor)

// 完成回调的方法
RCT_EXPORT_VIEW_PROPERTY(onCompletionBlock, RCTBubblingEventBlock)
// 动画时隔自动处理
RCT_EXPORT_VIEW_PROPERTY(animationDuration, NSTimeInterval)
//表格样式
RCT_EXPORT_VIEW_PROPERTY(positiveFormat, NSString)
// 完成
RCT_EXPORT_VIEW_PROPERTY(onFinish, RCTBubblingEventBlock)



//js调用原生
RCT_EXPORT_METHOD(startValue:(CGFloat)startValue endValue:(CGFloat)endValue duration:(NSTimeInterval)duration)
{
    __weak CountingManager *weakSelf = self;
    weakSelf.count.countLabel.completionBlock = ^(){
            weakSelf.count.onFinish(@{});
    };
  [_count.countLabel countFrom:startValue to:endValue withDuration:duration];
}

-(UIView *)view{
  Counting *count = [Counting new];
  _count = count;
  return count;
}

@end
