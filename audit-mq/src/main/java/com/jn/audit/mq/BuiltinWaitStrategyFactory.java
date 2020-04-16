package com.jn.audit.mq;

import com.jn.audit.mq.utils.MQs;
import com.jn.langx.factory.Factory;
import com.lmax.disruptor.WaitStrategy;

public class BuiltinWaitStrategyFactory implements Factory<String, WaitStrategy> {
    @Override
    public WaitStrategy get(String name) {
        return MQs.builtinWaitStrategyMap.get(name);
    }

    public boolean isBuiltin(String name) {
        return get(name) != null;
    }
}
