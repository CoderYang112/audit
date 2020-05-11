package com.jn.audit.core.resource.parser;

import com.jn.audit.core.resource.ResourceSupplier;
import com.jn.langx.Parser;

/**
 * 用于创建 ResourceSupplier
 */
public interface ResourceSupplierParser<I, O extends ResourceSupplier> extends Parser<I, O> {

}
