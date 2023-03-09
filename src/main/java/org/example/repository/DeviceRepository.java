package org.example.repository;

import org.example.model.device.DeviceNewParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<DeviceNewParam,Long> {


    @Query("SELECT dnp.id FROM DeviceNewParam AS dnp, System AS s, Build AS b" +
            " WHERE (dnp.system = s.id AND (s.country = :country OR :country IS NULL)) AND "+
            "(dnp.build = b.id AND (:osVersion IS NULL OR b.osVersion = :osVersion))"
    )
    List<Long> getDeviceIdByHql(String country, Integer osVersion);

    @Query("SELECT id FROM DeviceNewParam")
    List<Long> getAllDeviceId();
}
