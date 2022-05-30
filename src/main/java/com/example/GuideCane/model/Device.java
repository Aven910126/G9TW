package com.example.GuideCane.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Data
@Table(name = "device")
public class Device {
    @Id
    @Column(name="devicecode")
    private long deviceCode;
    @Column(name="bind")
    private boolean bind;

    public void setBind(boolean bind) {
        this.bind = bind;//使用自己的方法Lod1
    }

    public long getDeviceCode() {
        return deviceCode;
    }

    public Device(long deviceCode, boolean bind) {
        this.deviceCode = deviceCode;
        this.bind = bind;
    }

}
