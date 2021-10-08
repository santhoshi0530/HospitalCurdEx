package in.nit.hospital.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class MyCollectionUtil {

	public Map<Long, String> converToMap(List<Object[]> list) {
		// java8 stream api
		  Map<Long,String> map =
		  list.stream().collect(Collectors.toMap(obj->Long.valueOf(obj[0].toString()),
							obj -> {
								if (obj.length >= 3) {
									return obj[1].toString() + obj[2].toString();
								} else {
									return obj[1].toString();
								}
							}));
		 
/*		// Normal java code
		Map<Long, String> map = new HashMap<Long, String>();
		for (Object[] obj : list) {
			map.put(Long.valueOf(obj[0].toString()), obj[1].toString());
			}
*/
		return map;

}

}
