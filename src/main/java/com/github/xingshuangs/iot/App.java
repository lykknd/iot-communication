/*
 * MIT License
 *
 * Copyright (c) 2021-2099 Oscura (xingshuang) <xingshuang_cool@163.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.xingshuangs.iot;

import com.github.xingshuangs.iot.common.serializer.ByteArraySerializer;
import com.github.xingshuangs.iot.protocol.s7.enums.EPlcType;
import com.github.xingshuangs.iot.protocol.s7.service.S7PLC;
import com.goldengrain.bean.RecInfo;
import com.goldengrain.bean.SendInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Hello world!
 *
 * @author xingshuang
 */
@Slf4j
public class App 
{
    public static void main(String[] args) {
        S7PLC s7PLC = new S7PLC(EPlcType.S1500, "192.168.31.162");
        System.out.println(s7PLC.getRack());
        System.out.println(s7PLC.getSlot());
        System.out.println(s7PLC.getPlcType());
        try {
            //地址格式 DB**.偏移量(.读取长度)
            System.out.println(s7PLC.readFloat32("DB8000"));
            //s7PLC.writeFloat32("DB8000", 233.0f);
            System.out.println(s7PLC.readDTL("DB8000.1992"));
            System.out.println(s7PLC.readFloat32("DB8000.4"));
            System.out.println(s7PLC.readBoolean("DB100.0.0"));
            System.out.println(s7PLC.readInt16("DB100.2"));
            System.out.println(s7PLC.readUInt16("DB100.4"));
            System.out.println(Arrays.toString(s7PLC.readByte("DB100.6", 2)));
            System.out.println(Arrays.toString(s7PLC.readByte("DB100.8", 4)));
            System.out.println(s7PLC.readFloat32("DB100.12"));
            System.out.println(s7PLC.readByte("DB100.16"));
            System.out.println(s7PLC.readByte("DB100.17"));
            System.out.println("===============MMM==================");
            System.out.println(s7PLC.readBoolean("M1000.0"));
            //s7PLC.writeBoolean("M1000.0", true);

            System.out.println(s7PLC.readBoolean("M1000.1"));
            //s7PLC.writeBoolean("M1000.1", true);

            System.out.println(s7PLC.readBoolean("M1000.2"));
            //s7PLC.writeBoolean("M1000.2", true);

            System.out.println(s7PLC.readBoolean("M1000.3"));
            //s7PLC.writeBoolean("M1000.3", true);

            System.out.println(s7PLC.readBoolean("M1000.4"));
            //s7PLC.writeBoolean("M1000.4", true);

            System.out.println(s7PLC.readInt16("MW1002"));
            //s7PLC.writeInt16("M1002", (short) 12);

            System.out.println(s7PLC.readInt32("MW1004"));
            //s7PLC.writeInt32("MW1004", 1004);

            System.out.println(s7PLC.readFloat32("MW1008"));
            //s7PLC.writeFloat32("MW1008", 42.0f);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s7PLC.checkConnected());
        s7PLC.close();
        ByteArraySerializer serializer = ByteArraySerializer.newInstance();
        byte[] expect = s7PLC.readByte("DB8000.40", 66);
        SendInfo bean = serializer.toObject(SendInfo.class, expect);
        System.out.println(bean);
        expect = s7PLC.readByte("DB8000.832", 58);
        RecInfo beanA = serializer.toObject(RecInfo.class, expect);
        System.out.println(beanA);

    }
}
