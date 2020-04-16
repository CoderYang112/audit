package com.jn.audit.mq.consumer;

import com.jn.audit.mq.Consumer;
import com.jn.langx.util.struct.Holder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugConsumer<M> implements Consumer<M> {
    private static final Logger logger = LoggerFactory.getLogger(DebugConsumer.class);

    @Override
    public String getName() {
        return "mq debugger";
    }

    @Override
    public void onEvent(Holder<M> event, long sequence, boolean endOfBatch) throws Exception {
        logger.info("handling sequence:{}, endOfBatch:{}, message:{}", sequence, endOfBatch, event.get());
    }

    @Override
    public void handleEventException(Throwable ex, long sequence, Holder<M> event) {
        logger.warn("error when handle sequence: {}, message: {}, error:{} ", sequence, event.get().toString(), ex);
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        logger.error("error on start the DEBUG consumer, error message: {}, stack:{}", ex.getMessage(), ex);
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        logger.error("error on shutdown the DEBUG consumer, error message: {}, stack:{}", ex.getMessage(), ex);
    }

    @Override
    public void onTimeout(long sequence) throws Exception {
        logger.warn("Timeout when handle sequence {} message ", sequence);
    }
}
