package com.goldengrain.bean;

import com.github.xingshuangs.iot.common.enums.EDataType;
import com.github.xingshuangs.iot.common.serializer.ByteArrayVariable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @ClassName: TaskRecordBean
 * @author: 刘旸
 * @Date: 2024年01月18日 09:46:11
 */
@Data
public class TaskRecordBean {

    @ByteArrayVariable(byteOffset = 0, bitOffset = 0, count = 10, type = EDataType.FLOAT32)
    private List<Float> operatingData;
    private List<SendInfo> sendInfoList;
    private List<RecInfo> recInfoList;
    private List<LocalDateTime> localDateTimeList;
    private List<Float> totalList;
    private List<String> stringList;
    private byte state;
    private boolean sqlDone;
}