create view device_view(id, manufacture, model, osVersion, sdkVersion, country) as
select dnp.id, b.manufacture, b.model, b.os_version, b.androidsdkversion, s.country
from device_new_param as dnp, build as b, system as s
where dnp.build = b.id and dnp.system = s.id;