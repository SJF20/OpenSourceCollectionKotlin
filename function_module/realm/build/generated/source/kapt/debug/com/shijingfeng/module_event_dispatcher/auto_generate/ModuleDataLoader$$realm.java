package com.shijingfeng.module_event_dispatcher.auto_generate;

import androidx.annotation.NonNull;
import com.shijingfeng.apt_data.entity.ModuleEventReceiverData;
import com.shijingfeng.apt_data.interfaces.IModuleEventDataLoader;
import java.lang.Override;
import java.util.List;

/**
 * Function: 用于加载当前模块中所有的 Application生命周期监听类 数据
 * Date: 2021/01/19 17:56
 * Description:
 *
 * @author ShiJingFeng
 */
public class ModuleDataLoader$$realm implements IModuleEventDataLoader {
  @Override
  public void load(@NonNull List<ModuleEventReceiverData> dataList) {
    dataList.add(new ModuleEventReceiverData("realm", "com.shijingfeng.realm.RealmModuleApplication", "application", 0, 0));
  }
}
