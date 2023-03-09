package org.example.repository;

import org.example.model.record.DeviceUseRecord;
import org.example.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRecordRepository extends JpaRepository<DeviceUseRecord,Long> {


}
