package web.com.springweb.b01_basic.a02_space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_CelestialService {
	
	@Autowired(required=false)
	private A03_CelestialDao dao;
	
}
