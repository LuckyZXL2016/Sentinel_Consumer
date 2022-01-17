package com.zxl.sentinel.consumer.slot;

import com.alibaba.csp.sentinel.context.Context;
import com.alibaba.csp.sentinel.node.DefaultNode;
import com.alibaba.csp.sentinel.slotchain.AbstractLinkedProcessorSlot;
import com.alibaba.csp.sentinel.slotchain.ResourceWrapper;
import com.alibaba.csp.sentinel.spi.SpiOrder;

/**
 * @author zxl
 * @date 2021/9/29.
 */
@SpiOrder(-1500)
public class DemoSlot extends AbstractLinkedProcessorSlot<DefaultNode> {

    @Override
    public void entry(Context context, ResourceWrapper resourceWrapper, DefaultNode node, int count, boolean prioritized, Object... args)
            throws Throwable {
        System.out.println("------Entering for entry on DemoSlot------");
        System.out.println("Current context: " + context.getName());
        System.out.println("Current entry resource: " + context.getCurEntry().getResourceWrapper().getName());

        fireEntry(context, resourceWrapper, node, count, prioritized, args);
    }

    @Override
    public void exit(Context context, ResourceWrapper resourceWrapper, int count, Object... args) {
        System.out.println("------Exiting for entry on DemoSlot------");
        System.out.println("Current context: " + context.getName());
        System.out.println("Current entry resource: " + context.getCurEntry().getResourceWrapper().getName());

        fireExit(context, resourceWrapper, count, args);
    }
}
