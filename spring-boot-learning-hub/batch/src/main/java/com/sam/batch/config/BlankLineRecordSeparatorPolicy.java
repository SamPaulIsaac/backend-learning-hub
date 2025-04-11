package com.sam.batch.config;

import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;

public class BlankLineRecordSeparatorPolicy extends SimpleRecordSeparatorPolicy {

    @Override
    public boolean isEndOfRecord(final String line) {
        return !line.trim().isEmpty();
    }

    @Override
    public String postProcess(final String record) {
        if (record.trim().isEmpty()) {
            return null;
        }
        return super.postProcess(record);
    }
}
