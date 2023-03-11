package org.example.repository;

import org.example.model.device.view.DeviceView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceViewRepository extends JpaRepository<DeviceView,Long> {
}
