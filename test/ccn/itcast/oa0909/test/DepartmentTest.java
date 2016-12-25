package ccn.itcast.oa0909.test;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Service;

import cn.bdqn.oa.domain.AccessoryFile;
import cn.bdqn.oa.domain.Department;
import cn.bdqn.oa.service.AccessoryFileService;
import cn.bdqn.oa.service.DepartmentService;
import cn.bdqn.oa.service.impl.DepartmentServiceImpl;

@Service("testService")
public class DepartmentTest extends BaseSpring {
	@Test
	public void testDepartment() {
		AccessoryFileService departmentService = (AccessoryFileService) context
				.getBean("accessoryFileService");
		Collection<AccessoryFile> departmentList = departmentService.findAcfById(1L);
		for (AccessoryFile accessoryFile : departmentList) {
			System.out.println(accessoryFile.getAccessoryName());
		}
	}
}
