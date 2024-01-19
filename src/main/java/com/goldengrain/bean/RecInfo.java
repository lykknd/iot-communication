package com.goldengrain.bean;

import com.github.xingshuangs.iot.common.enums.EDataType;
import com.github.xingshuangs.iot.common.serializer.ByteArrayVariable;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 * @Description:
 * @ClassName: RecInfo
 * @author: 刘旸
 * @Date: 2024年01月18日 09:53:26
 */
@Data
public class RecInfo {
    @ByteArrayVariable(byteOffset = 0, bitOffset = 0,  type = EDataType.INT16)
    private Integer id;
    @ByteArrayVariable(byteOffset = 2, bitOffset = 0,  type = EDataType.FLOAT32)
    private BigDecimal totalTime;
    @ByteArrayVariable(byteOffset = 6, bitOffset = 0,  type = EDataType.FLOAT32)
    private BigDecimal totalWeight;
    @ByteArrayVariable(byteOffset = 10, bitOffset = 0,  type = EDataType.FLOAT32)
    private BigDecimal readingStart;
    @ByteArrayVariable(byteOffset = 14, bitOffset = 0,  type = EDataType.FLOAT32)
    private BigDecimal readingEnd;
    @ByteArrayVariable(byteOffset = 18, bitOffset = 0,  type = EDataType.DTL)
    private LocalDateTime timeStart;
    @ByteArrayVariable(byteOffset = 30, bitOffset = 0,  type = EDataType.DTL)
    private LocalDateTime timeEnd;
    @ByteArrayVariable(byteOffset = 42, bitOffset = 0, type = EDataType.STRING, count = 14)
    private String code;

    public void setId(short id) {
        this.id = (int) id;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = new BigDecimal(totalTime).setScale(3, RoundingMode.HALF_UP);
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = new BigDecimal(totalWeight).setScale(3, RoundingMode.HALF_UP);
    }

    public void setReadingStart(float readingStart) {
        this.readingStart = new BigDecimal(readingStart).setScale(3, RoundingMode.HALF_UP);
    }

    public void setReadingEnd(float readingEnd) {
        this.readingEnd = new BigDecimal(readingEnd).setScale(3, RoundingMode.HALF_UP);
    }

}