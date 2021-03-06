package com.shijingfeng.module_event_dispatcher.auto_generate;

import androidx.annotation.NonNull;
import com.shijingfeng.module_event_dispatcher.data.entity.ModuleEventReceiverData;
import com.shijingfeng.module_event_dispatcher.data.interfaces.IModuleEventDataLoader;
import java.lang.Override;
import java.util.List;

/**
 * Function: 用于加载当前模块中所有的 Application生命周期监听类 数据
 * Date: 2021/04/25 18:41
 * Description:
 *
 * @author ShiJingFeng
 */
public class ModuleDataLoader$$tencent_x5 implements IModuleEventDataLoader {
  @Override
  public void load(@NonNull List<ModuleEventReceiverData> dataList) {
    dataList.add(new ModuleEventReceiverData("tencent_x5", "com.shijingfeng.tencent_x5.TencentX5ModuleApplication", "application", 1, 0));
  }
}
