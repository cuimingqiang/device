package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class AppList
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public long firstInstallTime;

    public String appVersion;

    public String appName;

    public String packageName;

    public int appVersionCode;


}